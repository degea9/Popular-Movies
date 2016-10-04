/**
 * Created by tuandang on 9/25/2016.
 */
package degea9.movies.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import degea9.movies.R;

public class CastFragment extends  BaseFragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_movie_cast, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }
}
