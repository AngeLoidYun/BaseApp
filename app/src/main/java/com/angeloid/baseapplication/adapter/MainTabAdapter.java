package com.angeloid.baseapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.angeloid.baseapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author yunjw
 *         Created at 2018/1/27.
 *         Time is 17:46 now.
 *         (#^.^#)
 */

public class MainTabAdapter extends RecyclerView.Adapter<MainTabAdapter.MainTabAdapterVH> {
    private Context mContext;

    public MainTabAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public MainTabAdapterVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.tab_item, parent, false);
        return new MainTabAdapterVH(v);
    }

    @Override
    public void onBindViewHolder(MainTabAdapterVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class MainTabAdapterVH extends RecyclerView.ViewHolder {
        @BindView(R.id.tab_item_iv)
        public ImageView itemIv;
        @BindView(R.id.tab_item_title)
        public TextView itemTitle;
        @BindView(R.id.tab_item_rating)
        public RatingBar itemRatingBar;
        @BindView(R.id.tab_item_type)
        public TextView itemType;
        @BindView(R.id.tab_item_size)
        public TextView itemSize;

        public MainTabAdapterVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
