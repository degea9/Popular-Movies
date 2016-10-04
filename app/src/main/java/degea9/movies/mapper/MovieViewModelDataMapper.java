/**
 * Created by tuandang on 9/11/2016.
 */
package degea9.movies.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import degea9.movies.di.scope.PerActivity;
import degea9.movies.domain.model.MovieModel;
import degea9.movies.model.MovieViewModel;

/**
 * Mapper class used to transform {@link MovieModel} (in the domain layer) to {@link MovieViewModel} in the
 * presentation layer.
 */
@PerActivity
public class MovieViewModelDataMapper {
    @Inject
    public MovieViewModelDataMapper() {
    }

    /**
     * Transform a {@link MovieModel} into an {@link MovieViewModel}.
     *
     * @param movie Object to be transformed.
     * @return {@link MovieViewModel}.
     */
    public MovieViewModel transform(MovieModel movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        MovieViewModel movieViewModel = new MovieViewModel(movie.getId());
        movieViewModel.setAdult(movie.isAdult());
        movieViewModel.setBackdropPath(movie.getBackdropPath());
        movieViewModel.setGenreIds(movie.getGenreIds());
        movieViewModel.setOriginalLanguage(movie.getOriginalLanguage());
        movieViewModel.setOverview(movie.getOverview());
        movieViewModel.setOriginalTitle(movie.getOriginalTitle());
        movieViewModel.setTitle(movie.getTitle());
        movieViewModel.setPopularity(movie.getPopularity());
        movieViewModel.setPosterPath(movie.getPosterPath());
        movieViewModel.setReleaseDate(movie.getReleaseDate());
        movieViewModel.setReviewResponse(movie.getReviewResponse());
        movieViewModel.setGenreIds(movie.getGenreIds());
        movieViewModel.setVideo(movie.getVideo());
        movieViewModel.setVoteAverage(movie.getVoteAverage());
        movieViewModel.setVoteCount(movie.getVoteCount());

        return movieViewModel;
    }

    /**
     * Transform a Collection of {@link MovieModel} into a Collection of {@link MovieViewModel}.
     *
     * @param movieModelsCollection Objects to be transformed.
     * @return List of {@link MovieViewModel}.
     */
    public Collection<MovieViewModel> transform(Collection<MovieModel> movieModelsCollection) {
        Collection<MovieViewModel> movieViewModelsCollection;

        if (movieModelsCollection != null && !movieModelsCollection.isEmpty()) {
            movieViewModelsCollection = new ArrayList<>();
            for (MovieModel movie : movieModelsCollection) {
                movieViewModelsCollection.add(transform(movie));
            }
        } else {
            movieViewModelsCollection = Collections.emptyList();
        }

        return movieViewModelsCollection;
    }
}
