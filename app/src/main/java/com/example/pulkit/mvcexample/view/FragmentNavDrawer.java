package com.example.pulkit.mvcexample.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.pulkit.mvcexample.R;
import com.shipdream.lib.android.mvc.view.MvcActivity;
import com.shipdream.lib.android.mvc.view.MvcFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pulkit on 9/29/15.
 */
public class FragmentNavDrawer extends MvcFragment {


    @Bind(R.id.ivHeader)
    ImageView imageView;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_nav_drawer;
    }

    

    @Override
    public void onViewReady(View view, Bundle savedInstanceState, Reason reason) {
        super.onViewReady(view, savedInstanceState, reason);
        ButterKnife.bind(this, view);

    }


}
