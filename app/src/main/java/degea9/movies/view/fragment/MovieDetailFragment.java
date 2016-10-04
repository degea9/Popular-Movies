/**
 * Created by tuandang on 9/25/2016.
 */
package degea9.movies.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import degea9.movies.R;
import degea9.movies.data.api.ApiUtils;
import degea9.movies.model.MovieViewModel;
import degea9.movies.view.activity.MovieDetailActivity;
import degea9.movies.view.adapter.ViewPagerAdapter;

public class MovieDetailFragment extends BaseFragment {
    @Bind(R.id.iv_movie_poster)
    ImageView ivPoster;

    @Bind(R.id.tabLayout)
    TabLayout mTabs;

    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    private MovieViewModel movieViewModel;
    public static MovieDetailFragment newInstance(MovieViewModel movieViewModel){
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(MovieDetailActivity.EXTRA_MOVIE_OBJECT, movieViewModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movieViewModel = (MovieViewModel)getArguments().getSerializable(MovieDetailActivity.EXTRA_MOVIE_OBJECT);
        Picasso.with(getContext()).load(ApiUtils.buildPosterPath(movieViewModel.getPosterPath())).into(ivPoster);
        setupViewPager();
        mTabs.setupWithViewPager(mViewPager);
    }


    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(OverviewFragment.newInstance(movieViewModel), getString(R.string.overview));
        adapter.addFragment(new CastFragment(), getString(R.string.cast));
        adapter.addFragment(new ReviewFragment(), getString(R.string.review));
        mViewPager.setAdapter(adapter);
    }


}
