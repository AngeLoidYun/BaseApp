package com.angeloid.baseapplication.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.angeloid.baseapplication.R;
import com.angeloid.baseapplication.bean.RobotType;
import com.angeloid.baseapplication.bean.base.HttpResponse;
import com.angeloid.baseapplication.bean.response.CategoryBean;
import com.angeloid.baseapplication.net.HttpUtils;
import com.angeloid.netlibrary.callback.AbsRxCallback;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author yunjw
 *         Created at 2018/2/1.
 *         Time is 17:51 now.
 *         (#^.^#)
 */

public class RobotTypeSelectFragment extends SupportFragment {
    @BindView(R.id.robotf_topvp)
    ViewPager topViewPager;
//    @BindView(R.id.robotf_btnvp)
//    ViewPager botViewPager;
    @BindView(R.id.robotf_container)
    LinearLayout robotfContainer;
//    @BindView(R.id.robotf_mask)
//    LinearLayout robotfMask;

    private List<CategoryBean> categoryBeanList;

    public static RobotTypeSelectFragment newInstance() {
        Bundle args = new Bundle();
        RobotTypeSelectFragment fragment = new RobotTypeSelectFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_robot_select, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initView() {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) topViewPager.getLayoutParams();
        params.width = ScreenUtils.getScreenWidth() / 3;
        params.gravity = Gravity.CENTER_HORIZONTAL;
        topViewPager.setOffscreenPageLimit(5);
//        botViewPager.setOffscreenPageLimit(5);
        topViewPager.setPageMargin(0);
        topViewPager.setLayoutParams(params);
        topViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        robotfContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return topViewPager.dispatchTouchEvent(event);
            }
        });
//        robotfMask.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Logger.i(event.toString());
//                return topViewPager.dispatchTouchEvent(event) | botViewPager.dispatchTouchEvent(event);
//            }
//        });
        topViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                botViewPager.setCurrentItem(position, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        botViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                topViewPager.setCurrentItem(position, true);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        topViewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
//        botViewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
    }
    private OnItemClickListener onItemClickListener = new OnItemClickListener() {
        @Override
        public void onClick(View view, int position) {
            Logger.i("itemPosition"+position+"");
        }

        @Override
        public void onLongClick(View view, int position) {

        }
    };

    private void initData() {
        AbsRxCallback<HttpResponse<List<CategoryBean>>> appCallback = new AbsRxCallback<HttpResponse<List<CategoryBean>>>() {
            @Override
            public void onSuccess(HttpResponse<List<CategoryBean>> model) {
                for (int i = 0; i < model.getData().size(); i++) {
                    Logger.i(model.getData().get(i).toString());
                }
                categoryBeanList = model.getData();
                topViewPager.setAdapter(new RobotSelectTopPagerAdapter(_mActivity, categoryBeanList));
//                botViewPager.setAdapter(new RobotSelectBottomPagerAdapter(_mActivity,categoryBeanList,onItemClickListener));
            }

            @Override
            public void onFailure(String errorCode, String errorMsg) {
            }

            @Override
            public void onFinish() {

            }
        };
        HttpUtils.getAppData(appCallback);
//        addDisposable(appCallback);
    }


    class RobotSelectTopPagerAdapter extends PagerAdapter {
        private List<CategoryBean> categoryBeanList;
        private Context mContext;

        private RobotSelectTopPagerAdapter(Context context, List<CategoryBean> categoryBeanList) {
            this.categoryBeanList = categoryBeanList;
            mContext = context;
        }

        @Override
        public int getCount() {
            return categoryBeanList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.robot_select_item_top, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.robot_top_iv);
            TextView textView = (TextView) view.findViewById(R.id.robot_top_tv);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.robot_bot_rv);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) topViewPager.getLayoutParams();
//            params.width = ScreenUtils.getScreenWidth();
//            params.gravity = Gravity.CENTER_HORIZONTAL;
            CategoryBean categoryBean = categoryBeanList.get(position);
//            recyclerView.setLayoutParams(params);
            recyclerView.setAdapter(new RobotRecyclerViewAdapter(mContext,categoryBean,onItemClickListener));

            textView.setText(TextUtils.isEmpty(categoryBean.getName()) ? "unknown" : categoryBean.getName());
            switch (categoryBean.getModel_id()) {
                case RobotType.C:
                    Glide.with(mContext).load(R.drawable.crobot_img_true).into(imageView);
                    break;
                case RobotType.M:
                    Glide.with(mContext).load(R.drawable.mrobot_img_true).into(imageView);
                    break;
                case RobotType.H:
                    Glide.with(mContext).load(R.drawable.hrobot_img_true).into(imageView);
                    break;
                case RobotType.F:
                    Glide.with(mContext).load(R.drawable.frobot_img_true).into(imageView);
                    break;
                case RobotType.S:
                    Glide.with(mContext).load(R.drawable.srobot_img_true).into(imageView);
                    break;
                case RobotType.AF:
                    break;
                case RobotType.TY:
                    break;
                default:
                    break;
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /**
     * 实现的原理是，在当前显示页面放大至原来的MAX_SCALE
     * 其他页面才是正常的的大小MIN_SCALE
     */
    class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MAX_SCALE = 1.0f;
        private static final float MIN_SCALE = 0.85f;//0.85f

        @Override
        public void transformPage(View view, float position) {
            //setScaleY只支持api11以上
            if (position < -1) {
                view.setScaleX(MIN_SCALE);
                view.setScaleY(MIN_SCALE);
            } else if (position <= 1) //a页滑动至b页 ； a页从 0.0 -1 ；b页从1 ~ 0.0
            { // [-1,1]
//				Log.e("TAG", view + " , " + position + "");
                float scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);
                view.setScaleX(scaleFactor);
                //每次滑动后进行微小的移动目的是为了防止在三星的某些手机上出现两边的页面为显示的情况
                if (position > 0) {
                    view.setTranslationX(-scaleFactor * 2);
                } else if (position < 0) {
                    view.setTranslationX(scaleFactor * 2);
                }
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]

                view.setScaleX(MIN_SCALE);
                view.setScaleY(MIN_SCALE);

            }
        }

    }

    class RobotSelectBottomPagerAdapter extends PagerAdapter {
        private List<CategoryBean> categoryBeanList;
        private Context mContext;
        private OnItemClickListener onItemClickListener;
        private RobotSelectBottomPagerAdapter(Context context, List<CategoryBean> categoryBeanList,OnItemClickListener onItemClickListener) {
            this.categoryBeanList = categoryBeanList;
            mContext = context;
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public int getCount() {
            return categoryBeanList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.robot_select_item_bot, null);
            CategoryBean categoryBean = categoryBeanList.get(position);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.robot_bot_rv);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            recyclerView.setAdapter(new RobotRecyclerViewAdapter(mContext, categoryBean,onItemClickListener));
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    class RobotRecyclerViewAdapter extends RecyclerView.Adapter<RobotRecyclerViewAdapter.MyVH> {
        private Context mContext;
        private CategoryBean categoryBean;
        private OnItemClickListener onItemClickListener;

        public RobotRecyclerViewAdapter(Context mContext, CategoryBean categoryBean,OnItemClickListener onItemClickListener) {
            this.mContext = mContext;
            this.categoryBean = categoryBean;
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.robot_select_rv_item, parent, false);
            return new MyVH(v);
        }

        @Override
        public void onBindViewHolder(final MyVH holder, int position) {
            holder.itemTv.setText(categoryBean.getMenu_list().get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(v,holder.getAdapterPosition());
                }
            });
        }

        @Override
        public int getItemCount() {
            return categoryBean.getMenu_list().size();
        }

        class MyVH extends RecyclerView.ViewHolder {
            @BindView(R.id.robot_bot_rv_tv)
            TextView itemTv;

            public MyVH(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }

    public interface OnItemClickListener{
        void onClick(View view,int position);
        void onLongClick(View view,int position);
    }
}
