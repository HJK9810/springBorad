package notice.board.springBorad.repository;

import notice.board.springBorad.doamin.BoardItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Long> {
    Optional<BoardItem> findById(Long id);

    Page<BoardItem> findAll(Pageable pageable);

    List<BoardItem> findAllById(Long id);

    List<BoardItem> findByRootid(Long rootid);
}
