package com.angeloid.baseapplication.customview;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.angeloid.baseapplication.R;

/**
 * @author yunjw
 *         Created at 2018/2/1.
 *         Time is 15:42 now.
 *         (#^.^#)
 */

public class StarBar extends LinearLayout {
    private int backgroundDefault;
    private int backgroundFull;
    private float starMargin;
    private boolean canSwipe;
    private int starCount;
    private ImageView imageView;
    private ImageView[] imageViewList;
    private int starNum;

    public StarBar(Context context) {
        super(context);
    }

    public StarBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StarBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StarBar);
        backgroundDefault = ta.getResourceId(R.styleable.StarBar_background_default, -1);
        backgroundFull = ta.getResourceId(R.styleable.StarBar_background_full, -1);
        starMargin = ta.getDimension(R.styleable.StarBar_starMargin, 5);
        canSwipe = ta.getBoolean(R.styleable.StarBar_canSwipe, false);
        starCount = ta.getInteger(R.styleable.StarBar_starCount, 5);
        starNum = ta.getInteger(R.styleable.StarBar_starNum, 0);
        ta.recycle();
        initView(context);
    }

    private void initView(Context context) {
        imageViewList = new ImageView[starCount];
        for (int i = 0; i < starCount; i++) {
            imageView = new ImageView(context);
            if (i != starCount - 1) {
                LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutparams.setMargins(0, 0, (int) starMargin, 0);
                imageView.setLayoutParams(layoutparams);
            }
            imageView.setImageResource(backgroundDefault);
            addView(imageView);
            imageViewList[i] = imageView;
        }
        requestLayout();
    }



    public StarBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context, attrs, defStyleAttr);
    }

    public int getStarNum() {
        return starNum;
    }

    public void setStarNum(int starNum) {
        this.starNum = starNum;
        for (int i = 0; i < starCount; i++) {
            if (i < starNum) {
                imageViewList[i].setImageResource(backgroundFull);
            } else {
                imageViewList[i].setImageResource(backgroundDefault);
            }
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        return new StarBar.SavedState(superState, starNum);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        StarBar.SavedState ss = (StarBar.SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        if (starNum != ss.starNumber) {
            setStarNum(ss.starNumber);
        }
        starNum = ss.starNumber;
    }

    static class SavedState extends BaseSavedState {
        private int starNumber;

        public SavedState(Parcel source) {
            super(source);
            starNumber = source.readInt();
        }

        public SavedState(Parcelable superState, int starNumber) {
            super(superState);
            this.starNumber = starNumber;
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(starNumber);
        }

        public static final Creator<SelectBar.SavedState> CREATOR = new Creator<SelectBar.SavedState>() {
            @Override
            public SelectBar.SavedState createFromParcel(Parcel in) {
                return new SelectBar.SavedState(in);
            }

            @Override
            public SelectBar.SavedState[] newArray(int size) {
                return new SelectBar.SavedState[size];
            }
        };
    }
}
