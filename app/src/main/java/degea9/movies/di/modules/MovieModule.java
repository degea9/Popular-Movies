/**
 * Created by tuandang on 9/13/2016.
 */
package degea9.movies.di.modules;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import degea9.movies.di.scope.PerActivity;
import degea9.movies.domain.executor.PostExecutionThread;
import degea9.movies.domain.interactor.GetMovieDetails;
import degea9.movies.domain.interactor.GetPopularMovie;
import degea9.movies.domain.interactor.UseCase;
import degea9.movies.domain.repository.MovieRepository;

/**
 * Dagger module that provides movie related collaborators.
 */
@Module
public class MovieModule {

    private int movieId = -1;

    public MovieModule() {}

    public MovieModule(int movieId) {
        this.movieId = movieId;
    }

    @Provides
    @PerActivity
    @Named("movieList")
    UseCase provideGetPopularMovieUseCase(
            GetPopularMovie getMovieList) {
        return getMovieList;
    }

    @Provides @PerActivity @Named("movieDetails") UseCase provideGetMovieDetailsUseCase(
            MovieRepository movieRepository, PostExecutionThread postExecutionThread) {
        return new GetMovieDetails(movieId, movieRepository, postExecutionThread);
    }
}
