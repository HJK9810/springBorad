package notice.board.springBorad.service;

import notice.board.springBorad.doamin.BoardItem;
import notice.board.springBorad.doamin.Pagination;
import notice.board.springBorad.repository.BoardItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

public class BoardItemServiceImpl implements BoardItemService {

    @Autowired
    BoardItemRepository boardItemRepository;

    @Override
    public Pagination getPagination(int nowPage, int pageSize, int countPerPage) {
        // 주어지는 값 : 현제 페이지 & 한 페이지에 보여줄 아이템수 & 한번에 보여줄 페이지 그룹수
        Pagination page = new Pagination();

        // 현재페이지 설정 조건 : 1보다 작으면 1
        if (nowPage < 1) page.setcPage(1);
        else page.setcPage(nowPage);

        PageRequest pageable = PageRequest.of(page.getcPage(), pageSize);
        Page<BoardItem> setPage = boardItemRepository.findAll(pageable);

        // 계산 없이 집어넣기
        page.setPpPage(1); // 가장 첫 페이지는 무조건 1
        page.setNnPage(setPage.getTotalPages()); // 전체 페이지수
        page.setTotalCount(setPage.getTotalElements()); // 전체 총 아이템수

        page.setPageSize(pageSize); // 한 페이지에 보여줄 아이템수
        // 현재 페이지가 한계 페이지를 넘을경우 정정
        if (nowPage > page.getNnPage()) page.setcPage(page.getNnPage());

        int start = (nowPage - 1) * pageSize; // 현 페이지에서 보여줄 첫번째 아이템
        page.setItemStart(start); // 한 페이지에서 보여주는 첫번째 아이템
        page.setItemEnd(start + pageSize - 1); // 한 페이지에서 보여주는 마지막 아이템

        // 페이지 그룹
        page.setPagePerPage(countPerPage); // 한번에 보여줄 페이지수

        int startPage = 1; // 현 페이지가 있는 그룹의 가장 첫 번째 값
        int nextpage = 0; // 현 페이지가 있는 다음 그룹의 가장 첫 번째 값
        int linecount = 1;  // 보여줄 페이지 그룹중 첫 시작점
        if(page.getPagePerPage() > 0) { // 0이거나 음수이면 만들수 없으니까 0처리
            startPage = ((page.getcPage() - 1) / page.getPagePerPage()) * page.getPagePerPage() + 1;
            nextpage = ((page.getcPage() - 1) / page.getPagePerPage() + 1) * page.getPagePerPage() + 1;
            linecount = ((page.getcPage() - 1) / page.getPagePerPage()) * page.getPagePerPage();
        }

        page.setLineStart(linecount);
        page.setLineEnd(linecount + page.getPagePerPage() - 1);

        if (startPage == 1) page.setpPage(startPage); // 이게 1이면 첫 페이지 그룹이기에 값은 1
        else page.setpPage(startPage - page.getPagePerPage()); // 아니면 이동용

        if (nextpage > page.getNnPage()) page.setnPage(page.getNnPage()); // 다음 넘어가야 할 페이지가 마지막 페이지보다 클 경우
        else page.setnPage(nextpage); // 작거나 같을경우는 지정 페이지로 이동

        return page;
    }

    @Override
    public List<Integer> getPageGroup(Pagination pages) {
        int linecount = pages.getLineStart(); // 보여줄 페이지 그룹중 첫 시작점
        List<Integer> pageGroup = new ArrayList<>();

        pageGroup.add(pages.getPpPage());
        pageGroup.add(pages.getpPage());
        for (int i = 0; i < pages.getPagePerPage(); i++) {
            if (linecount == pages.getNnPage()) break; // 마지막 페이지 도달시 반복문 탈출
            pageGroup.add(linecount + 1);
            linecount++;
        }
        pageGroup.add(pages.getnPage());
        pageGroup.add(pages.getNnPage());

        return pageGroup;
    }
}
