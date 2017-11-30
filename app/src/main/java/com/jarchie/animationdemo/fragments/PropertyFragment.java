package com.jarchie.animationdemo.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.jarchie.animationdemo.R;

/**
 * Created by Jarchie on 2017\11\29.
 */

public class PropertyFragment extends Fragment {
    private TextView tvTranslate, tvScale, tvAlpha, tvRotate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_property, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        //平移---操作的控件，平移方向，起始位置，结束位置
        ObjectAnimator trnaslateAnimator = ObjectAnimator.ofFloat(tvTranslate, "translationX", 0f, 300f);
        trnaslateAnimator.setDuration(2000); //完成一次完整动画的执行时间
        trnaslateAnimator.setRepeatCount(-1); //无限次循环
        trnaslateAnimator.setRepeatMode(ValueAnimator.REVERSE); //重复模式为反向
        trnaslateAnimator.start();
        //缩放，沿着X轴方向放大为原来的1.2倍之后恢复原样
        ObjectAnimator scaleAnimatorX = ObjectAnimator.ofFloat(tvScale, "scaleX", 1f, 1.2f, 1f);
        scaleAnimatorX.setDuration(2000);
        scaleAnimatorX.setRepeatMode(ValueAnimator.RESTART);
        scaleAnimatorX.setRepeatCount(-1);
        scaleAnimatorX.start();
//        //沿着X,Y轴同时缩小然后回到原状，再沿着X轴右移300再回到原来的位置
//        ObjectAnimator scaleAnimatorX = ObjectAnimator.ofFloat(tvScale, "scaleX", 1f, 0f, 1f);
//        ObjectAnimator scaleAnimatorY = ObjectAnimator.ofFloat(tvScale, "scaleY", 1f, 0f, 1f);
//        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(tvScale, "translationX", 0f, 300f, 0f);
//        AnimatorSet set = new AnimatorSet();
//        set.setDuration(3000);
//        set.setInterpolator(new LinearInterpolator());
//        //set.playTogether()同时执行
//        set.play(scaleAnimatorX).with(scaleAnimatorY).before(translationXAnimator);
//        set.start();
        //透明度 将透明度由1变为0，再反向由0变为1，并重复执行
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(tvAlpha, "alpha", 1f, 0f);
        alphaAnimator.setDuration(1000);//时间1s
        alphaAnimator.setRepeatCount(-1);
        alphaAnimator.setRepeatMode(ValueAnimator.REVERSE);
        alphaAnimator.start();
        //旋转 沿着顺时针方向旋转1周，再反向执行一遍，并将整个过程循环执行
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(tvRotate, "rotation", 0f, 360f, 0f);
        rotateAnimator.setDuration(2000);
        rotateAnimator.setRepeatCount(-1);
        rotateAnimator.setRepeatMode(ValueAnimator.REVERSE);
        rotateAnimator.start();
    }

    private void initView(View view) {
        tvTranslate = view.findViewById(R.id.tv_translate);
        tvScale = view.findViewById(R.id.tv_scale);
        tvAlpha = view.findViewById(R.id.tv_alpha);
        tvRotate = view.findViewById(R.id.tv_rotate);
    }

}
