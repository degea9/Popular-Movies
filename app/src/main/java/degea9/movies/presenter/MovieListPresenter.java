/**
 * Created by tuandang on 9/11/2016.
 */
package degea9.movies.presenter;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import degea9.movies.di.scope.PerActivity;
import degea9.movies.domain.exception.DefaultErrorBundle;
import degea9.movies.domain.exception.ErrorBundle;
import degea9.movies.domain.interactor.DefaultSubscriber;
import degea9.movies.domain.interactor.UseCase;
import degea9.movies.domain.model.MovieModel;
import degea9.movies.exception.ErrorMessageFactory;
import degea9.movies.mapper.MovieViewModelDataMapper;
import degea9.movies.model.MovieViewModel;
import degea9.movies.view.contract.MovieListView;

@PerActivity
public class MovieListPresenter implements Presenter {
    private static final String TAG = MovieListPresenter.class.getSimpleName();
    private MovieListView movieListView;
    private MovieViewModelDataMapper movieViewModelDataMapper;
    private final UseCase getMovieListUseCase;

    @Inject
    public MovieListPresenter(@Named("movieList") UseCase getMovieListUseCase,
                             MovieViewModelDataMapper movieViewModelDataMapper) {
        this.getMovieListUseCase = getMovieListUseCase;
        this.movieViewModelDataMapper = movieViewModelDataMapper;
    }

    public void setView(@NonNull MovieListView view) {
        this.movieListView = view;
    }

    /**
     * Initializes the presenter by start retrieving the user list.
     */
    public void initialize() {
        this.loadMovieList();
    }

    /**
     * Loads all  movies.
     */
    private void loadMovieList() {
        this.showViewLoading();
        this.getMovieList();
    }
    private void showViewLoading() {
        this.movieListView.showLoading();
    }
    private void hideViewLoading() {
        this.movieListView.hideLoading();
    }

    private void getMovieList() {
        this.getMovieListUseCase.execute(new UserListSubscriber());
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.movieListView.context(),
                errorBundle.getException());
        this.movieListView.showError(errorMessage);
    }

    /**
     * transform movieModels to movieViewModel and display on the list
     * @param movieModels
     */
    private void showMovieList(Collection<MovieModel> movieModels) {
        final Collection<MovieViewModel> movieViewModels =
                this.movieViewModelDataMapper.transform(movieModels);
        this.movieListView.renderMovieList(movieViewModels);
    }
    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getMovieListUseCase.unsubscribe();
        this.movieListView = null;
    }

    public void onUserClicked(MovieViewModel movieViewModel) {
        this.movieListView.viewMovieDetails(movieViewModel);
    }
    private final class UserListSubscriber extends DefaultSubscriber<List<MovieModel>> {

        @Override public void onCompleted() {
            MovieListPresenter.this.hideViewLoading();
        }

        @Override public void onError(Throwable e) {
            MovieListPresenter.this.hideViewLoading();
            MovieListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override public void onNext(List<MovieModel> movieModels) {
            MovieListPresenter.this.showMovieList(movieModels);
        }
    }
}
