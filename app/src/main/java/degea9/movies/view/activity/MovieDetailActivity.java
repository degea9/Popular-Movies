package degea9.movies.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import degea9.movies.R;
import degea9.movies.model.MovieViewModel;
import degea9.movies.view.fragment.MovieDetailFragment;

public class MovieDetailActivity extends BaseActivity {
    public static final String EXTRA_MOVIE_OBJECT = "extra_movie_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        MovieViewModel movieViewModel = (MovieViewModel) getIntent().getSerializableExtra(EXTRA_MOVIE_OBJECT);
        addFragment(R.id.fragment_container, MovieDetailFragment.newInstance(movieViewModel));
    }


}
