package com.example.pulkit.mvcexample.view;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.pulkit.mvcexample.R;
import com.example.pulkit.mvcexample.event.ChangeTitleEvent;
import com.shipdream.lib.android.mvc.controller.NavigationController;
import com.shipdream.lib.android.mvc.view.MvcActivity;
import com.shipdream.lib.android.mvc.view.MvcFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends MvcActivity {

    @Override
    protected Class<? extends MvcFragment> mapNavigationFragment(String s) {
        switch (s) {
            case "LocationA":
                return FragmentA.class;
            case "LocationB":
                return FragmentB.class;
            default:
                return null;
        }
    }

    @Override
    protected Class<? extends DelegateFragment> getDelegateFragmentClass() {
        return ContainerFragment.class;

    }

    public static class ContainerFragment extends DelegateFragment {

        @Inject
        private NavigationController navigationController;

        @Bind(R.id.drawer_layout)
        DrawerLayout drawerLayout;

        @Bind(R.id.tbMainActionbar)
        Toolbar toolbar;

        @Override
        protected int getLayoutResId() {
            return R.layout.my_delegate_fragment;
        }

        @Override
        protected int getContentLayoutResId() {
            return R.id.mvc_delegate_fragment_content;
        }

        @Override
        public void onViewReady(View view, Bundle savedInstanceState, Reason reason) {
            super.onViewReady(view, savedInstanceState, reason);
            ButterKnife.bind(this, view);
            toolbar.setTitle(R.string.app_custom_name);
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawerLayout.setDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
            actionBarDrawerToggle.syncState();
        }

        @Override
        protected void onStartUp() {
            getNavigationController().navigateTo(this, "LocationA");
        }

        public void onEvent(ChangeTitleEvent event) {
            toolbar.setTitle(navigationController.getModel().getCurrentLocation().getLocationId());
        }
    }

}
