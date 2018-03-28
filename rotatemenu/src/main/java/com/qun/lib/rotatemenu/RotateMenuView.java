package com.qun.lib.rotatemenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class RotateMenuView extends LinearLayout implements View.OnClickListener {

    private RelativeLayout mRlRevel1;
    private RelativeLayout mRlRevel2;
    private RelativeLayout mRlRevel3;
    private ImageButton mIbChannel1;
    private ImageButton mIbChannel2;
    private ImageButton mIbChannel3;
    private ImageButton mIbChannel4;
    private ImageButton mIbChannel5;
    private ImageButton mIbChannel6;
    private ImageButton mIbChannel7;
    private OnChannelClickListener mOnChannelClickListener;
    private ImageButton mIbSearch;
    private ImageView mIbMyYouKu;
    private Context mContext;
    private ImageButton mIbMenu;
    private ImageButton mIbHome;


    public interface OnChannelClickListener {
        void onClick(int channelId);
    }

    public void setOnChannelClickListener(OnChannelClickListener onChannelClickListener) {
        this.mOnChannelClickListener = onChannelClickListener;
    }

    public RotateMenuView(Context context) {
        this(context, null);
    }

    public RotateMenuView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotateMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.rotate_menu_view, this, true);
        mRlRevel1 = view.findViewById(R.id.rl_level_1);
        mRlRevel2 = view.findViewById(R.id.rl_level_2);
        mRlRevel2.setTag(AnimState.SHOW);
        mRlRevel3 = view.findViewById(R.id.rl_level_3);
        mRlRevel3.setTag(AnimState.SHOW);
        mIbChannel1 = view.findViewById(R.id.btn_channel1);
        mIbChannel2 = view.findViewById(R.id.btn_channel2);
        mIbChannel3 = view.findViewById(R.id.btn_channel3);
        mIbChannel4 = view.findViewById(R.id.btn_channel4);
        mIbChannel5 = view.findViewById(R.id.btn_channel5);
        mIbChannel6 = view.findViewById(R.id.btn_channel6);
        mIbChannel7 = view.findViewById(R.id.btn_channel7);
        mIbSearch = view.findViewById(R.id.btn_search);
        mIbMyYouKu = view.findViewById(R.id.btn_myyouku);
        mIbMenu = view.findViewById(R.id.btn_menu);
        mIbHome = view.findViewById(R.id.btn_home);
        mIbMyYouKu.setOnClickListener(this);
        mIbSearch.setOnClickListener(this);
        mIbChannel1.setOnClickListener(this);
        mIbChannel2.setOnClickListener(this);
        mIbChannel3.setOnClickListener(this);
        mIbChannel4.setOnClickListener(this);
        mIbChannel5.setOnClickListener(this);
        mIbChannel6.setOnClickListener(this);
        mIbChannel7.setOnClickListener(this);
        mIbMenu.setOnClickListener(this);
        mIbHome.setOnClickListener(this);


    }

    private void startAnimOut(final View view, long delay) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1.0f);
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(delay);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setTag(AnimState.START_HIDDEN);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setTag(AnimState.HIDDEN);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(rotateAnimation);
    }

    private void startAnimOut(View view) {
        startAnimOut(view, 0);
    }

    private enum AnimState {
        START_SHOW, SHOW, START_HIDDEN, HIDDEN
    }

    private void startAnimIn(final View view, long delay) {
        RotateAnimation rotateAnimation = new RotateAnimation(-180.0f, 0f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1.0f);
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(delay);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setTag(AnimState.START_SHOW);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setTag(AnimState.SHOW);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(rotateAnimation);
    }

    private void startAnimIn(View view) {
        startAnimIn(view, 0);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_menu) {
            if (AnimState.SHOW == mRlRevel3.getTag()) {
                startAnimOut(mRlRevel3);
                mIbChannel1.setEnabled(false);
                mIbChannel2.setEnabled(false);
                mIbChannel3.setEnabled(false);
                mIbChannel4.setEnabled(false);
                mIbChannel5.setEnabled(false);
                mIbChannel6.setEnabled(false);
                mIbChannel7.setEnabled(false);
            } else if (AnimState.HIDDEN == mRlRevel3.getTag()) {
                startAnimIn(mRlRevel3);
                mIbChannel1.setEnabled(true);
                mIbChannel2.setEnabled(true);
                mIbChannel3.setEnabled(true);
                mIbChannel4.setEnabled(true);
                mIbChannel5.setEnabled(true);
                mIbChannel6.setEnabled(true);
                mIbChannel7.setEnabled(true);

            }

        } else if (i == R.id.btn_home) {
            if (AnimState.SHOW == mRlRevel2.getTag()) {
                if (AnimState.SHOW == mRlRevel3.getTag()) {
                    startAnimOut(mRlRevel3);
                    startAnimOut(mRlRevel2, 300);
                    mIbChannel1.setEnabled(false);
                    mIbChannel2.setEnabled(false);
                    mIbChannel3.setEnabled(false);
                    mIbChannel4.setEnabled(false);
                    mIbChannel5.setEnabled(false);
                    mIbChannel6.setEnabled(false);
                    mIbChannel7.setEnabled(false);
                    mIbSearch.setEnabled(false);
                    mIbMyYouKu.setEnabled(false);
                } else if (mRlRevel3.getTag() == AnimState.HIDDEN) {
                    startAnimOut(mRlRevel2);
                    mIbSearch.setEnabled(false);
                    mIbMyYouKu.setEnabled(false);
                }
            } else if (AnimState.HIDDEN == mRlRevel2.getTag()) {
                startAnimIn(mRlRevel2);
                startAnimIn(mRlRevel3, 300);
                mIbChannel1.setEnabled(true);
                mIbChannel2.setEnabled(true);
                mIbChannel3.setEnabled(true);
                mIbChannel4.setEnabled(true);
                mIbChannel5.setEnabled(true);
                mIbChannel6.setEnabled(true);
                mIbChannel7.setEnabled(true);
                mIbSearch.setEnabled(true);
                mIbMyYouKu.setEnabled(true);
            }

        }

        if (mOnChannelClickListener != null) {
            int i1 = v.getId();
            if (i1 == R.id.btn_channel1) {
                mOnChannelClickListener.onClick(1);

            } else if (i1 == R.id.btn_channel2) {
                mOnChannelClickListener.onClick(2);

            } else if (i1 == R.id.btn_channel3) {
                mOnChannelClickListener.onClick(3);

            } else if (i1 == R.id.btn_channel4) {
                mOnChannelClickListener.onClick(4);

            } else if (i1 == R.id.btn_channel5) {
                mOnChannelClickListener.onClick(5);

            } else if (i1 == R.id.btn_channel6) {
                mOnChannelClickListener.onClick(6);

            } else if (i1 == R.id.btn_channel7) {
                mOnChannelClickListener.onClick(7);

            } else if (i1 == R.id.btn_search) {
                mOnChannelClickListener.onClick(8);

            } else if (i1 == R.id.btn_myyouku) {
                mOnChannelClickListener.onClick(9);

            }
        }
    }

}
