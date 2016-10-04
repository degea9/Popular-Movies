package degea9.movies.view.contract;

/**
 * Created by tuandang on 8/7/2016.
 */

import java.util.Collection;

import degea9.movies.model.MovieViewModel;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link MovieViewModel}.
 */
public interface MovieListView extends LoadDataView {
    /**
     * Render a movie list in the UI.
     *
     * @param movieViewModelCollection The collection of {@link MovieViewModel} that will be shown.
     */
    void renderMovieList(Collection<MovieViewModel> movieViewModelCollection);

    /**
     * View a {@link MovieViewModel} profile/details.
     *
     * @param movieViewModel The movie that will be shown.
     */
    void viewMovieDetails(MovieViewModel movieViewModel);
}
