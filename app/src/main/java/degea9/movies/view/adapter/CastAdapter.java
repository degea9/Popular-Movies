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
import degea9.movies.model.CastViewModel;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {
    private static final String TAG = CastAdapter.class.getSimpleName();
    private final Context context;
    private OnItemClickListener onItemClickListener;
    private List<CastViewModel> castViewModelList;
    private final LayoutInflater layoutInflater;

    @Inject
    public CastAdapter(Context context) {
        this.context = context;
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.castViewModelList = Collections.emptyList();
    }

    @Override
    public CastAdapter.CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_cast, parent, false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CastAdapter.CastViewHolder holder, int position) {
        final CastViewModel castViewModel = this.castViewModelList.get(position);
        LogUtil.d(TAG,"onBindViewHolder "+castViewModel.getProfilePath());
        Picasso.with(context).load(ApiUtils.buildPosterPath(castViewModel.getProfilePath())).into( holder.castThumbnail);
        holder.castName.setText(castViewModel.getName());
        holder.characterName.setText(castViewModel.getCharacter());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (CastAdapter.this.onItemClickListener != null) {
                    CastAdapter.this.onItemClickListener.onUserItemClicked(castViewModel);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (this.castViewModelList != null) ? this.castViewModelList.size() : 0;
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setCasts(Collection<CastViewModel> castViewModelCollection) {
        this.castViewModelList = (List<CastViewModel>) castViewModelCollection;
        this.notifyDataSetChanged();
    }

    static class CastViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_castName)
        TextView castName;
        @Bind(R.id.tv_characterName)
        TextView characterName;
        @Bind(R.id.iv_castThumbnail)
        ImageView castThumbnail;

        public CastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onUserItemClicked(CastViewModel castViewModel);
    }
}

