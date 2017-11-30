package com.jarchie.animationdemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.jarchie.animationdemo.R;

/**
 * Created by Jarchie on 2017\11\29.
 */

public class ViewFragment extends Fragment {
    private TextView tvTranslate,tvScale,tvAlpha,tvRotate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view,container,false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Animation translateAni = AnimationUtils.loadAnimation(getContext(),R.anim.translate_anim);
        Animation scaleAni = AnimationUtils.loadAnimation(getContext(),R.anim.scale_anim);
        Animation alphaAni = AnimationUtils.loadAnimation(getContext(),R.anim.alpha_anim);
        Animation rotateAni = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_anim);
        tvTranslate.startAnimation(translateAni);
        tvScale.startAnimation(scaleAni);
        tvAlpha.startAnimation(alphaAni);
        tvRotate.startAnimation(rotateAni);
    }

    private void initView(View view) {
        tvTranslate = view.findViewById(R.id.tv_translate);
        tvScale = view.findViewById(R.id.tv_scale);
        tvAlpha = view.findViewById(R.id.tv_alpha);
        tvRotate = view.findViewById(R.id.tv_rotate);
    }
}
