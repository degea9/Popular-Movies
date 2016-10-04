/**
 * Created by tuandang on 9/20/2016.
 */
package degea9.movies.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import degea9.movie.utils.LogUtil;
import degea9.movies.R;
import degea9.movies.data.api.ApiUtils;
import degea9.movies.model.MovieViewModel;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private static final String TAG = MovieListAdapter.class.getSimpleName();
    private final Context context;
    private OnItemClickListener onItemClickListener;
    private List<MovieViewModel> moviesCollection;
    private final LayoutInflater layoutInflater;

    @Inject
    public MovieListAdapter(Context context) {
        this.context = context;
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.moviesCollection = Collections.emptyList();
    }

    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position) {
        final MovieViewModel movieViewModel = this.moviesCollection.get(position);
        LogUtil.d(TAG,"onBindViewHolder "+movieViewModel.getPosterPath());
        Picasso.with(context).load(ApiUtils.buildPosterPath(movieViewModel.getPosterPath())).into( holder.moviePoster);
        holder.movieTitle.setText(movieViewModel.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (MovieListAdapter.this.onItemClickListener != null) {
                    MovieListAdapter.this.onItemClickListener.onUserItemClicked(movieViewModel);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (this.moviesCollection != null) ? this.moviesCollection.size() : 0;
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setMoviesCollection(Collection<MovieViewModel> moviesCollection) {
        this.moviesCollection = (List<MovieViewModel>) moviesCollection;
        this.notifyDataSetChanged();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_movie_title)
        TextView movieTitle;
        @Bind(R.id.iv_movie_poster)
        ImageView moviePoster;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onUserItemClicked(MovieViewModel movieViewModel);
    }
}
