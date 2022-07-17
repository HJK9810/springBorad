package notice.board.springBorad.web;

import notice.board.springBorad.doamin.BoardItem;
import notice.board.springBorad.repository.BoardItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/postApi")
public class PostController {
    @Autowired
    private BoardItemRepository boardItemRepository;

    @GetMapping("/list")
    public ResponseEntity<Page<BoardItem>> getList(Pageable pageable) {
        Page<BoardItem> list = boardItemRepository.findAll(pageable);

        return new ResponseEntity<Page<BoardItem>>(list, HttpStatus.OK);
    }

    @GetMapping("/One/{id}")
    public ResponseEntity<BoardItem> getOne(@PathVariable("id") String id) {
        boardItemRepository.findById(Long.parseLong(id)).ifPresent((element) -> {
            element.setViewCnt(element.getViewCnt() + 1);
            boardItemRepository.save(element);
        });
        BoardItem item = boardItemRepository.findById(Long.parseLong(id)).get();

        return new ResponseEntity<BoardItem>(item, HttpStatus.OK);
    }

    @PostMapping("/add")
    public BoardItem postItem(@RequestBody BoardItem boardItem) {
        Date date = new Date();
        boardItem.setDate(date);
        boardItem.setViewCnt(0);

        BoardItem saveItem = boardItemRepository.save(boardItem);
        return saveItem;
    }
}
