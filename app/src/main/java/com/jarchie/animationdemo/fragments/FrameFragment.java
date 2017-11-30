package com.jarchie.animationdemo.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jarchie.animationdemo.R;

/**
 * Created by Jarchie on 2017\11\29.
 */

public class FrameFragment extends Fragment {
    private boolean state = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frame, container, false);
        ImageView imageView = view.findViewById(R.id.frame_animation);
        TextView btnState = view.findViewById(R.id.btn_state);
        imageView.setImageResource(R.drawable.frame_animation);
        final AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
        btnState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state){
                    animationDrawable.start();
                    state = false;
                }else {
                    animationDrawable.stop();
                    state = true;
                }

            }
        });
        return view;
    }

}
