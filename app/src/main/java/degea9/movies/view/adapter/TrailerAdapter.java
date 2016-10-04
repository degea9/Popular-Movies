/**
 * Created by tuandang on 9/27/2016.
 */
package degea9.movies.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import degea9.movie.utils.LogUtil;
import degea9.movies.R;
import degea9.movies.model.TrailerViewModel;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {
    private static final String TAG = CastAdapter.class.getSimpleName();
    private final Context context;
    private OnItemClickListener onItemClickListener;
    private List<TrailerViewModel> trailerViewModelList;
    private final LayoutInflater layoutInflater;

    @Inject
    public TrailerAdapter(Context context) {
        this.context = context;
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.trailerViewModelList = Collections.emptyList();
    }

    @Override
    public TrailerAdapter.TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_trailer, parent, false);
        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrailerAdapter.TrailerViewHolder  holder, int position) {
        final TrailerViewModel trailerViewModel = this.trailerViewModelList.get(position);
        LogUtil.d(TAG,"onBindViewHolder "+trailerViewModel.getSource());
        //holder.castName.setText(castViewModel.getName());
        //holder.characterName.setText(castViewModel.getCharacter());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (TrailerAdapter.this.onItemClickListener != null) {
                    TrailerAdapter.this.onItemClickListener.onUserItemClicked(trailerViewModel);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (this.trailerViewModelList != null) ? this.trailerViewModelList.size() : 0;
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setCasts(Collection<TrailerViewModel> trailerViewModels) {
        this.trailerViewModelList = (List<TrailerViewModel>) trailerViewModels;
        this.notifyDataSetChanged();
    }

    static class TrailerViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_castName)
        TextView castName;
        @Bind(R.id.tv_characterName)
        TextView characterName;
        @Bind(R.id.iv_castThumbnail)
        ImageView castThumbnail;

        public TrailerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onUserItemClicked(TrailerViewModel trailerViewModel);
    }
}


