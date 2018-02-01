package com.angeloid.baseapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.angeloid.baseapplication.R;
import com.angeloid.baseapplication.bean.TabType;
import com.angeloid.baseapplication.bean.response.SearchResponseDetail;
import com.bumptech.glide.Glide;
import com.hedgehog.ratingbar.RatingBar;

import java.util.ArrayList;
import java.util.List;

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
    private TabType tabType;

    public MainTabAdapter(Context mContext,TabType tabType) {
        this.mContext = mContext;
        this.tabType = tabType;
    }
    private List<SearchResponseDetail> searchResponseDetails = new ArrayList<>();

    public void setData(List<SearchResponseDetail> searchResponseDetailList){
        clearData();
        searchResponseDetails.addAll(searchResponseDetailList);
        notifyDataSetChanged();
    }

    public void addData(List<SearchResponseDetail> searchResponseDetailList){
        searchResponseDetails.addAll(searchResponseDetailList);
        notifyDataSetChanged();
    }
    public void clearData(){
        searchResponseDetails.clear();
        notifyDataSetChanged();
    }

    @Override
    public MainTabAdapterVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.tab_item, parent, false);
        return new MainTabAdapterVH(v);
    }

    @Override
    public void onBindViewHolder(MainTabAdapterVH holder, int position) {
        holder.itemTitle.setText(searchResponseDetails.get(position).getApp_name());
        holder.itemStarBar.setStar((int) searchResponseDetails.get(position).getStar());
        Glide.with(mContext).load(searchResponseDetails.get(position).getIcon_url()).into(holder.itemIv);
        holder.itemType.setText(tabType.getTypeNumString());
        holder.itemSize.setText(searchResponseDetails.get(position).getFile_size());
    }

    @Override
    public int getItemCount() {
        return searchResponseDetails.size();
    }

    static class MainTabAdapterVH extends RecyclerView.ViewHolder {
        @BindView(R.id.tab_item_iv)
        public ImageView itemIv;
        @BindView(R.id.tab_item_title)
        public TextView itemTitle;
        @BindView(R.id.tab_item_rating)
        public RatingBar itemStarBar;
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
