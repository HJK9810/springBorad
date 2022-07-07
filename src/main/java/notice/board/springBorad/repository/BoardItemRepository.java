package notice.board.springBorad.repository;

import notice.board.springBorad.doamin.BoardItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Long> {
}
