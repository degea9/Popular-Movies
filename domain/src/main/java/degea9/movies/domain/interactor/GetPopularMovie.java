/**
 * Created by tuandang on 9/10/2016.
 */
package degea9.movies.domain.interactor;

import javax.inject.Inject;

import degea9.movies.domain.executor.PostExecutionThread;
import degea9.movies.domain.repository.MovieRepository;
import rx.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link degea9.movies.domain.model.MovieModel}.
 */
public class GetPopularMovie extends UseCase {
    private final MovieRepository movieRepository;

    @Inject
    public GetPopularMovie(MovieRepository movieRepository,PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.movieRepository = movieRepository;
    }

    @Override public Observable buildUseCaseObservable() {
        return this.movieRepository.movies();
    }
}
