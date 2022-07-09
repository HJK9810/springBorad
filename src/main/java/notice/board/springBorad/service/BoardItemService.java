package notice.board.springBorad.service;

import notice.board.springBorad.doamin.Pagination;

import java.util.List;

public interface BoardItemService {
    // 주어지는 값 : 현제 페이지 & 한 페이지에 보여줄 아이템수 & 한번에 보여줄 페이지 그룹수
    Pagination getPagination(int nowPage, int pageSize, int countPerPage);

    // 반복문을 돌리기 위해 from 으로 넘길 parameter arraylist로 묶기
    List<Integer> getPageGroup(Pagination pages);
}
