/**
 * Created by tuandang on 9/10/2016.
 */
package degea9.movies.domain.interactor;

import javax.inject.Inject;

import degea9.movies.domain.executor.PostExecutionThread;
import degea9.movies.domain.repository.MovieRepository;
import rx.Observable;

public class GetMovieDetails extends UseCase {
    private final int movieId;
    private final MovieRepository movieRepository;

    @Inject
    public GetMovieDetails(int movieId, MovieRepository movieRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.movieId = movieId;
        this.movieRepository = movieRepository;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return this.movieRepository.movie(movieId);
    }
}
