package com.saulmm.material.activities;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;

import com.saulmm.material.R;

/**
 * Created by lanna on 10/27/15.
 */
public class CustomizeTransitionsActivity3 extends Activity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTransition();
        setContentView(R.layout.activity_customize_transitions3);
        initView();
    }

    private void initTransition() {
        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // set an enter transition
        getWindow().setEnterTransition(new Explode());

        // set an exit transition
//        getWindow().setExitTransition(new Explode());
    }

    private void initView() {
        findViewById(R.id.image1).setOnClickListener(this);
        findViewById(R.id.image2).setOnClickListener(this);
        findViewById(R.id.image3).setOnClickListener(this);
        findViewById(R.id.image4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finishAfterTransition();
    }
}
