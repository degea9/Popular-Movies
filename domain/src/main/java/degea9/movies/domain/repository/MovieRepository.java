/**
 * Created by tuandang on 9/10/2016.
 */
package degea9.movies.domain.repository;

import java.util.List;

import degea9.movies.domain.model.MovieModel;
import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link MovieModel} related data.
 */
public interface MovieRepository {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link MovieModel}.
     */
    Observable<List<MovieModel>> movies();

    /**
     * Get an {@link rx.Observable} which will emit a {@link MovieModel}.
     *
     * @param movieId The movie id used to retrieve movie data.
     */
    Observable<MovieModel> movie(final int movieId);
}
