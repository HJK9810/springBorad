package notice.board.springBorad.doamin;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class CommentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String editer;
    @Column(columnDefinition = "text")
    private String comment;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "item_id")
    private BoardItem bordItem;

    public CommentItem() {}

    public CommentItem(String editer, String comment, BoardItem boardItem) {
        this.editer = editer;
        this.comment = comment;
        this.bordItem = boardItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEditer() {
        return editer;
    }

    public void setEditer(String editer) {
        this.editer = editer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BoardItem getBordItem() {
        return bordItem;
    }

    public void setBordItem(BoardItem bordItem) {
        this.bordItem = bordItem;
    }
}