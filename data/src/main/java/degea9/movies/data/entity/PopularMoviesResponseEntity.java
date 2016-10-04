/**
 * Created by tuandang on 8/8/2016.
 */
package degea9.movies.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMoviesResponseEntity {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<MovieEntity> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieEntity> getResults() {
        return results;
    }

    public void setResults(List<MovieEntity> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
