package com.example.pulkit.mvcexample.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.pulkit.mvcexample.R;
import com.shipdream.lib.android.mvc.view.MvcFragment;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FragmentAppBar extends MvcFragment {

    @Bind(R.id.mvcAppBar)
    Toolbar toolbar;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_app_bar;
    }

    @Override
    public void onViewReady(View view, Bundle savedInstanceState, Reason reason) {
        super.onViewReady(view, savedInstanceState, reason);
        ButterKnife.bind(this, view);
        toolbar.setTitle(R.string.app_custom_name);
    }
}
