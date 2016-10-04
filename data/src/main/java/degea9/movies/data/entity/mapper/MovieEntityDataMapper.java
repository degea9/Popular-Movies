/**
 * Created by tuandang on 9/20/2016.
 */
package degea9.movies.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import degea9.movies.data.entity.MovieEntity;
import degea9.movies.domain.model.MovieModel;

@Singleton
public class MovieEntityDataMapper {
    @Inject
    public MovieEntityDataMapper() {}

    /**
     * Transform a {@link MovieEntity} into an {@link MovieModel}.
     *
     * @param movie Object to be transformed.
     * @return {@link MovieModel}.
     */
    public MovieModel transform(MovieEntity movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        MovieModel movieModel = new MovieModel(movie.getId());
        movieModel.setAdult(movie.isAdult());
        movieModel.setBackdropPath(movie.getBackdropPath());
        movieModel.setGenreIds(movie.getGenreIds());
        movieModel.setOriginalLanguage(movie.getOriginalLanguage());
        movieModel.setOverview(movie.getOverview());
        movieModel.setOriginalTitle(movie.getOriginalTitle());
        movieModel.setTitle(movie.getTitle());
        movieModel.setPopularity(movie.getPopularity());
        movieModel.setPosterPath(movie.getPosterPath());
        movieModel.setReleaseDate(movie.getReleaseDate());
        //movieModel.setReviewResponse(movie.getReviewResponse());
        movieModel.setGenreIds(movie.getGenreIds());
        movieModel.setVideo(movie.getVideo());
        movieModel.setVoteAverage(movie.getVoteAverage());
        movieModel.setVoteCount(movie.getVoteCount());

        return movieModel;
    }

    /**
     * Transform a Collection of {@link MovieEntity} into a Collection of {@link MovieModel}.
     *
     * @param movieEntitiesCollection Objects to be transformed.
     * @return List of {@link MovieModel}.
     */
    public List<MovieModel> transform(List<MovieEntity> movieEntitiesCollection) {
        List<MovieModel> movieModelsCollection;

        if (movieEntitiesCollection != null && !movieEntitiesCollection.isEmpty()) {
            movieModelsCollection = new ArrayList<>();
            for (MovieEntity movie : movieEntitiesCollection) {
                movieModelsCollection.add(transform(movie));
            }
        } else {
            movieModelsCollection = Collections.emptyList();
        }

        return movieModelsCollection;
    }
}
