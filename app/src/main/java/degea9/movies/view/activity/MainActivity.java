package degea9.movies.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import degea9.movies.R;
import degea9.movies.di.components.DaggerMovieComponent;
import degea9.movies.di.components.MovieComponent;
import degea9.movies.view.adapter.ViewPagerAdapter;
import degea9.movies.view.fragment.PopularMovieFragment;

public class MainActivity extends BaseActivity {
    private MovieComponent movieComponent;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.tabs)
    TabLayout mTabs;

    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initializeInjector();
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        setupViewPager();
        mTabs.setupWithViewPager(mViewPager);
    }

    private void initializeInjector() {
        this.movieComponent = DaggerMovieComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    public MovieComponent getComponent() {
        return movieComponent;
    }


    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PopularMovieFragment(), "ONE");
        //adapter.addFragment(new PopularMovieFragment(), "TWO");
        mViewPager.setAdapter(adapter);
    }

}
