package notice.board.springBorad.web;

import notice.board.springBorad.doamin.BoardItem;
import notice.board.springBorad.repository.BoardItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardItemController {

    @Autowired
    private BoardItemRepository boardItemRepository;

    @GetMapping("/")
    public String showList(Model model) {
        List<BoardItem> list = boardItemRepository.findAll();

        model.addAttribute("list", list);
        return "main";
    }

    @GetMapping("/{id}")
    public String showItem(Model model, @PathVariable("id") String id) {
        BoardItem item = boardItemRepository.findById(Long.parseLong(id)).get();

        model.addAttribute("item", item);
        return "read";
    }

    @GetMapping("/back")
    public String reset() {
        return "redirect:/";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<BoardItem> List(Model model) {
        return boardItemRepository.findAll();
    }
}
