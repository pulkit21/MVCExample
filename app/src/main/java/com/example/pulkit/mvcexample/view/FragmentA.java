package com.example.pulkit.mvcexample.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pulkit.mvcexample.R;
import com.example.pulkit.mvcexample.event.ChangeTitleEvent;
import com.shipdream.lib.android.mvc.NavLocation;
import com.shipdream.lib.android.mvc.controller.NavigationController;
import com.shipdream.lib.android.mvc.controller.internal.NavigationControllerImpl;
import com.shipdream.lib.android.mvc.view.MvcFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pulkit on 9/28/15.
 */
public class FragmentA extends MvcFragment {

    @Bind(R.id.buttonGoToUber)
    Button buttonGoToUber;

    @Bind(R.id.buttonGoToPost)
    Button buttonGoToPost;

    @Inject
    private NavigationController navigationController;

    @Override
    public void onViewReady(View view, Bundle savedInstanceState, Reason reason) {
        super.onViewReady(view, savedInstanceState, reason);
        postEventV2V(new ChangeTitleEvent(this));
        ButterKnife.bind(this, view);
        buttonGoToUber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationController.navigateTo(this, "Uber");

            }
        });

        buttonGoToPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationController.navigateTo(this, "Posts");
            }
        });

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_a;
    }
}
