package com.example.pulkit.mvcexample.view;

import android.os.Bundle;
import android.view.View;

import com.example.pulkit.mvcexample.R;
import com.example.pulkit.mvcexample.event.ChangeTitleEvent;
import com.shipdream.lib.android.mvc.view.MvcFragment;

/**
 * Created by pulkit on 10/1/15.
 */
public class FragmentPost extends MvcFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_post;
    }

    @Override
    public void onViewReady(View view, Bundle savedInstanceState, Reason reason) {
        super.onViewReady(view, savedInstanceState, reason);
        postEventV2V(new ChangeTitleEvent(this));
    }
}
