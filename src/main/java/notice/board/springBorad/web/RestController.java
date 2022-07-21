package notice.board.springBorad.web;

import notice.board.springBorad.doamin.BoardItem;
import notice.board.springBorad.doamin.CommentItem;
import notice.board.springBorad.repository.BoardItemRepository;
import notice.board.springBorad.repository.CommentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/postApi")
@CrossOrigin(origins = "http://localhost:3000")
public class RestController {
    @Autowired
    private BoardItemRepository boardItemRepository;
    @Autowired
    private CommentItemRepository commentItemRepository;

    @GetMapping("/list")
    public ResponseEntity<Page<BoardItem>> getList(Pageable pageable) {
        Page<BoardItem> list = boardItemRepository.findAll(pageable);

        return new ResponseEntity<Page<BoardItem>>(list, HttpStatus.OK);
    }

    @GetMapping("/One/{id}")
    public ResponseEntity<BoardItem> getOne(@PathVariable("id") String id) {
        boardItemRepository.findById(Long.parseLong(id)).ifPresent((element) -> {
            if(element.getText() != null && !element.getText().isEmpty()) {
                element.setViewCnt(element.getViewCnt() + 1);
            }
            boardItemRepository.save(element);
        });
        BoardItem item = boardItemRepository.findById(Long.parseLong(id)).get();

        return new ResponseEntity<BoardItem>(item, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BoardItem> postItem(@RequestBody BoardItem boardItem) {
        Date date = new Date();
        boardItem.setDate(date);
        boardItem.setViewCnt(0);

        BoardItem saveItem = boardItemRepository.save(boardItem);
        return new ResponseEntity<BoardItem>(saveItem, HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<BoardItem> getForEdit(@PathVariable("id") Long id) {
        BoardItem item = boardItemRepository.findById(id).get();

        return new ResponseEntity<BoardItem>(item, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<BoardItem> postEdit(@PathVariable("id") Long id, @RequestBody BoardItem boardItem) {
        boardItemRepository.findById(id).ifPresent((element) -> {
            element.setTitle(boardItem.getTitle());
            element.setText(boardItem.getText());
            element.setEditer(boardItem.getEditer());
            element.setViewCnt(element.getViewCnt() - 2);

            boardItemRepository.save(element);
        });
        BoardItem item = boardItemRepository.findById(id).get();

        return new ResponseEntity<BoardItem>(item, HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public  ResponseEntity<List<BoardItem>> delete(@PathVariable("id") Long id) {
        boardItemRepository.deleteById(id);

        List<BoardItem> list = boardItemRepository.findAll();
        return new ResponseEntity<List<BoardItem>>(list, HttpStatus.OK);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Page<CommentItem>> commentsList(@PathVariable("id") Long id, Pageable pageable) {
        Collection<CommentItem> list = boardItemRepository.findById(id).get().getCommentList();
        List<CommentItem> commentList = new ArrayList<CommentItem>(list);
        Collections.reverse(commentList);

        int start = (int)pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), commentList.size());
        Page<CommentItem> page = new PageImpl<>(commentList.subList(start, end), pageable, commentList.size());
        return new ResponseEntity<Page<CommentItem>>(page, HttpStatus.OK);
    }

    @PostMapping("/comment/{id}")
    public ResponseEntity<BoardItem> addComment(@PathVariable("id") Long id, @RequestBody CommentItem comentItem) {
        boardItemRepository.findById(id).ifPresent(
                element -> {
                    element.setViewCnt(element.getViewCnt() - 1); // 호출시 +1, 이후 다시 view로 넘어갈때 +1
                    boardItemRepository.save(element);

                    CommentItem comment = new CommentItem(comentItem.getEditer(), comentItem.getComment(), element);
                    element.addItemList(comment);
                    boardItemRepository.save(element);
                });

        BoardItem item = boardItemRepository.findById(id).get();
        return new ResponseEntity<BoardItem>(item, HttpStatus.OK);
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<BoardItem> deleteComment(@PathVariable("id") Long id, HttpServletRequest req) {
        BoardItem item = boardItemRepository.findById(id).get();
        Long commentID = Long.parseLong(req.getParameter("id"));
        CommentItem comment = commentItemRepository.findById(commentID).get();

        comment.setBordItem(null);

        item.getCommentList().remove(comment);
        item.setViewCnt(item.getViewCnt() - 1);
        item.setComentCnt(item.getComentCnt() - 1);

        boardItemRepository.save(item);
        item = boardItemRepository.findById(id).get();
        return new ResponseEntity<BoardItem>(item, HttpStatus.OK);
    }
}
