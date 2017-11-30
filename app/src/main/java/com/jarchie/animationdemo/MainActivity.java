package com.jarchie.animationdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jarchie.animationdemo.fragments.FrameFragment;
import com.jarchie.animationdemo.fragments.PropertyFragment;
import com.jarchie.animationdemo.fragments.ViewFragment;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;

public class MainActivity extends AppCompatActivity implements OnBottomNavigationItemClickListener {
    private BottomNavigationView mBottomNavigationView;
    private Fragment frameFgt, viewFgt, propertyFgt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initData();
    }

    //初始化数据
    private void initData() {
        initBottomNavigationView();
        setSelect(0);
    }

    //初始化监听事件
    private void initListener() {
        mBottomNavigationView.setOnBottomNavigationItemClickListener(this);
    }

    //初始化View
    private void initView() {
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation_view);
    }

    @Override
    public void onNavigationItemClick(int index) {
        switch (index) {
            case 0:
                setSelect(0);
                break;
            case 1:
                setSelect(1);
                break;
            case 2:
                setSelect(2);
                break;
        }
    }

    //Fragment的选中事件
    private void setSelect(int pos) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (pos) {
            case 0:
                if (frameFgt == null) {
                    frameFgt = new FrameFragment();
                    transaction.add(R.id.id_content, frameFgt);
                } else {
                    transaction.show(frameFgt);
                }
                break;
            case 1:
                if (viewFgt == null) {
                    viewFgt = new ViewFragment();
                    transaction.add(R.id.id_content, viewFgt);
                } else {
                    transaction.show(viewFgt);
                }
                break;
            case 2:
                if (propertyFgt == null) {
                    propertyFgt = new PropertyFragment();
                    transaction.add(R.id.id_content, propertyFgt);
                } else {
                    transaction.show(propertyFgt);
                }
                break;
        }
        transaction.commit();
    }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (frameFgt != null) {
            transaction.hide(frameFgt);
        }
        if (viewFgt != null) {
            transaction.hide(viewFgt);
        }
        if (propertyFgt != null) {
            transaction.hide(propertyFgt);
        }
    }

    //初始化底部Tab
    private void initBottomNavigationView() {
        if (mBottomNavigationView != null) {
            //设置汉字是否一直显示
            mBottomNavigationView.isWithText(true);
            //整体背景色，false是icon和文字显示颜色能用,此时是默认的颜色
            mBottomNavigationView.isColoredBackground(false);
            //设置选中时的颜色
            mBottomNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.colorPrimary));
        }
        BottomNavigationItem frameItem = new BottomNavigationItem("帧动画", ContextCompat.getColor(this, R.color.colorPrimary), R.drawable.frame_animation);
        BottomNavigationItem viewItem = new BottomNavigationItem("视图动画", ContextCompat.getColor(this, R.color.colorPrimary), R.drawable.view);
        BottomNavigationItem propertyItem = new BottomNavigationItem("属性动画", ContextCompat.getColor(this, R.color.colorPrimary), R.drawable.property);
        mBottomNavigationView.addTab(frameItem);
        mBottomNavigationView.addTab(viewItem);
        mBottomNavigationView.addTab(propertyItem);
    }

}
