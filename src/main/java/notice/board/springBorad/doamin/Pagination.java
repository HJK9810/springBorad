package notice.board.springBorad.doamin;

public class Pagination {
    private int ppPage; // 제일 첫 페이지 이동
    private int pPage; // 이전 페이지그룹 이동
    private int nPage; // 다음 페이지그룹 이동
    private int nnPage; // 제일 마지막 페이지 이동
    private int cPage; // 지금 페이지
    private int pagePerPage; // 한줄에 보여줄 페이지들 수
    private int pageSize; // 페이지당 보여줄 글수
    private Long totalCount; // 모든 아이템 갯수

    private int itemStart; // 한 페이지에서 처음 보여주는 아이템의 순서(가장 처음부터 시작)
    private int itemEnd; // 한 페이지에 보여주는 아이템중 가장 마지막것
    private int lineStart; // 한 줄에 보여줄 페이지그룹의 첫번째 값
    private int lineEnd; // 한 줄에 보여줄 페이지 그룹의 마지막값

    public int getPpPage() {
        return ppPage;
    }
    public void setPpPage(int ppPage) {
        this.ppPage = ppPage;
    }
    public int getpPage() {
        return pPage;
    }
    public void setpPage(int pPage) {
        this.pPage = pPage;
    }
    public int getnPage() {
        return nPage;
    }
    public void setnPage(int nPage) {
        this.nPage = nPage;
    }
    public int getNnPage() {
        return nnPage;
    }
    public void setNnPage(int nnPage) {
        this.nnPage = nnPage;
    }
    public int getcPage() {
        return cPage;
    }
    public void setcPage(int cPage) {
        this.cPage = cPage;
    }
    public int getPagePerPage() {
        return pagePerPage;
    }
    public void setPagePerPage(int pagePerPage) {
        this.pagePerPage = pagePerPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public Long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
    public int getItemStart() {
        return itemStart;
    }
    public void setItemStart(int itemStart) {
        this.itemStart = itemStart;
    }
    public int getItemEnd() {
        return itemEnd;
    }
    public void setItemEnd(int itemEnd) {
        this.itemEnd = itemEnd;
    }
    public int getLineStart() {
        return lineStart;
    }
    public void setLineStart(int lineStart) {
        this.lineStart = lineStart;
    }
    public int getLineEnd() {
        return lineEnd;
    }
    public void setLineEnd(int lineEnd) {
        this.lineEnd = lineEnd;
    }
}
