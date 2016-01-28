package com.saulmm.material.activities;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import com.saulmm.material.R;

/**
 * Created by lanna on 10/27/15.
 */
public class CustomizeTransitionsActivity2 extends Activity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_transitions2);
        initTransition();
        initView();
    }

    private void initTransition() {
        // inside your activity (if you did not enable transitions in your theme) // must have ???
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // set an enter transition // also for exit transition ???
        getWindow().setEnterTransition(new Slide(Gravity.END));
//        getWindow().setEnterTransition(new Explode());

        // set an exit transition // is not effect, but belong to enter transition ???
//        getWindow().setExitTransition(new Explode());
//        getWindow().setExitTransition(new Slide(Gravity.END));
    }

    private void initView() {
        findViewById(R.id.image).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finishAfterTransition();
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
    }
}
