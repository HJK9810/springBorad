package notice.board.springBorad.doamin;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class BoardItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;
    @Column(length = 20)
    private String editer;
    @Column(columnDefinition = "date")
    private Date date;
    @Column
    @ColumnDefault("0")
    private Integer viewCnt;
    @Column(columnDefinition = "text")
    private String text;
    @Column
    @ColumnDefault("0")
    private Integer comentCnt;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="bordItem", orphanRemoval = true)
    private Collection<CommentItem> commentList;

    public BoardItem() {}

    public BoardItem(String title, String text, Date date) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.viewCnt = 0;
        this.comentCnt = 0;
    }

    public Collection<CommentItem> getCommentList() {
        if(commentList == null) commentList = new ArrayList<CommentItem>();

        return commentList;
    }

    public void setCommentList(Collection<CommentItem> commentList) {
        this.commentList = commentList;
    }

    public void addItemList(CommentItem item) {
        Collection<CommentItem> items = getCommentList();
        items.add(item);
        this.comentCnt += 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditer() {
        return editer;
    }

    public void setEditer(String editer) {
        this.editer = editer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(Integer viewCnt) {
        this.viewCnt = viewCnt;
    }

    public Integer getComentCnt() {
        return comentCnt;
    }

    public void setComentCnt(Integer comentCnt) {
        this.comentCnt = comentCnt;
    }
}
