package com.example.pulkit.mvcexample.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.pulkit.mvcexample.R;
import com.shipdream.lib.android.mvc.view.MvcFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pulkit on 9/28/15.
 */
public class FragmentA extends MvcFragment {



    @Override
    public void onViewReady(View view, Bundle savedInstanceState, Reason reason) {
        super.onViewReady(view, savedInstanceState, reason);

        if (reason == Reason.FIRST_TIME) {
            FragmentAppBar fragmentAppBar = new FragmentAppBar();
            getChildFragmentManager().beginTransaction().replace(R.id.fragment_appBarContainer, fragmentAppBar).commit();

        }


    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_a;
    }
}
