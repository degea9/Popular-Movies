/**
 * Created by tuandang on 9/10/2016.
 */
package degea9.movies.domain.model;

import java.util.List;

public class ReviewResponseModel {
    private int page;

    private List<ReviewModel> listReview;

    private int totalResults;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<ReviewModel> getListReview() {
        return listReview;
    }

    public void setListReview(List<ReviewModel> listReview) {
        this.listReview = listReview;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }


    private int totalPages;
}
