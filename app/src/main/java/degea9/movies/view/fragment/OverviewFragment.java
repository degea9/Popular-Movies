/**
 * Created by tuandang on 9/25/2016.
 */
package degea9.movies.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import degea9.movies.R;
import degea9.movies.model.MovieViewModel;
import degea9.movies.view.activity.MovieDetailActivity;

public class OverviewFragment extends BaseFragment {
    @Bind(R.id.tv_movieOverview)
    TextView tvOverView;

    public static OverviewFragment newInstance(MovieViewModel movieViewModel){
        OverviewFragment fragment = new OverviewFragment();
        Bundle args = new Bundle();
        args.putSerializable(MovieDetailActivity.EXTRA_MOVIE_OBJECT, movieViewModel);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_movie_overview, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MovieViewModel movieViewModel = (MovieViewModel)getArguments().getSerializable(MovieDetailActivity.EXTRA_MOVIE_OBJECT);
        tvOverView.setText(movieViewModel.getOverview());
    }
}
