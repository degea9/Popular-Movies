/**
 * Created by tuandang on 8/8/2016.
 */
package degea9.movies.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewResponseEntity {
    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<ReviewEntity> listReview;

    @SerializedName("total_results")
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

    public List<ReviewEntity> getListReview() {
        return listReview;
    }

    public void setListReview(List<ReviewEntity> listReview) {
        this.listReview = listReview;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    @SerializedName("total_pages")

    private int totalPages;
}
