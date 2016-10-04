/**
 * Created by tuandang on 8/7/2016.
 */
package degea9.movies.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import degea9.movies.R;
import degea9.movies.model.MovieViewModel;
import degea9.movies.presenter.MovieListPresenter;
import degea9.movies.view.activity.MainActivity;
import degea9.movies.view.activity.MovieDetailActivity;
import degea9.movies.view.adapter.MovieListAdapter;
import degea9.movies.view.adapter.MoviesLayoutManager;
import degea9.movies.view.contract.MovieListView;

public class PopularMovieFragment extends BaseFragment implements MovieListView {
    private static final String TAG = PopularMovieFragment.class.getSimpleName();

    @Inject
    MovieListPresenter movieListPresenter;
    @Inject
    MovieListAdapter movieListAdapter;

    @Bind(R.id.rv_movies)
    RecyclerView rv_movies;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainActivity)getActivity()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View fragmentView = inflater.inflate(R.layout.fragment_popular_movie, container, false);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG,"onViewCreated");
        this.movieListPresenter.setView(this);
        if (savedInstanceState == null) {
            Log.d(TAG,"loadMovieList");
            this.loadMovieList();
        }
    }

    /**
     * Loads all movies.
     */
    private void loadMovieList() {
        this.movieListPresenter.initialize();
    }

    private void setupRecyclerView() {
        this.movieListAdapter.setOnItemClickListener(onItemClickListener);
        this.rv_movies.setLayoutManager(new GridLayoutManager(context(),2));
        this.rv_movies.setAdapter(movieListAdapter);
    }

    private MovieListAdapter.OnItemClickListener onItemClickListener =
            new MovieListAdapter.OnItemClickListener() {
                @Override
                public void onUserItemClicked(MovieViewModel movieViewModel) {
                    if (PopularMovieFragment.this.movieListPresenter != null && movieViewModel != null) {
                        PopularMovieFragment.this.movieListPresenter.onUserClicked(movieViewModel);
                    }
                }
            };

    @Override
    public void renderMovieList(Collection<MovieViewModel> movieViewModelCollection) {
        Log.d(TAG,"renderMovieList");
        if (movieViewModelCollection != null) {
            this.movieListAdapter.setMoviesCollection(movieViewModelCollection);
        }
    }

    @Override
    public void viewMovieDetails(MovieViewModel movieViewModel) {
        Intent intent = new Intent(getActivity(),MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.EXTRA_MOVIE_OBJECT,movieViewModel);
        startActivity(intent);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String message) {
        Log.d(TAG,message);
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }
}
