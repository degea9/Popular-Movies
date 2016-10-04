package degea9.movies.view.contract;

/**
 * Created by tuandang on 8/7/2016.
 */

import java.util.List;

import degea9.movies.domain.model.ReviewModel;
import degea9.movies.model.CastViewModel;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a movie detail information.
 */
public interface MovieDetailView extends LoadDataView {
    /**
     * Render cast in the UI.
     *
     * @param castViewModels The collection of {@link CastViewModel} that will be shown.
     */
    void renderCast(List<CastViewModel> castViewModels);

    /**
     * Render reviews in the UI.
     *
     * @param reviewModels The collection of {@link ReviewModel} that will be shown.
     */
    void renderReviews(List<ReviewModel> reviewModels);
}
