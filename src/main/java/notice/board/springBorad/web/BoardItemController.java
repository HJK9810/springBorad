package notice.board.springBorad.web;

import notice.board.springBorad.doamin.BoardItem;
import notice.board.springBorad.repository.BoardItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardItemController {

    @Autowired
    private BoardItemRepository boardItemRepository;

    @GetMapping("")
    public String showList(Model model) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<5;i++){
            list.add(i+1);
        }

        model.addAttribute("list", list);
        return "main";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<BoardItem> List(Model model) {
        return boardItemRepository.findAll();
    }
}
