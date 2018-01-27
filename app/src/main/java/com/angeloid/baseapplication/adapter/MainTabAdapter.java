package com.angeloid.baseapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        LayoutInflater.from(mContext).inflate()
        return new MainTabAdapterVH();
    }

    @Override
    public void onBindViewHolder(MainTabAdapterVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class MainTabAdapterVH extends RecyclerView.ViewHolder {

        public MainTabAdapterVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
