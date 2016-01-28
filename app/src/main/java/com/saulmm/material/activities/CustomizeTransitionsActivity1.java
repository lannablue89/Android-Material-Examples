package com.saulmm.material.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;

import com.saulmm.material.R;

/**
 * Created by lanna on 10/27/15.
 */
public class CustomizeTransitionsActivity1 extends Activity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTransition();
        setContentView(R.layout.activity_customize_transitions1);
        initView();
    }

    private void initTransition() {
        // inside your activity (if you did not enable transitions in your theme)
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // set an enter transition
        getWindow().setEnterTransition(new Fade());
//        getWindow().setEnterTransition(new Explode());

        // set an exit transition // also for enter transition ???
        // first effect one is also apply to other???
//        getWindow().setExitTransition(new Fade());
        getWindow().setExitTransition(new Explode());
    }

    private void initView() {
        findViewById(R.id.image1).setOnClickListener(this);
        findViewById(R.id.image2).setOnClickListener(this);
        findViewById(R.id.image3).setOnClickListener(this);
        findViewById(R.id.image4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image1:
            case R.id.image3:
                startActivity(new Intent(this, CustomizeTransitionsActivity2.class));
                break;
            default:
                startActivity(new Intent(this, CustomizeTransitionsActivity3.class));
                break;
        }
    }

    @Override
    public void startActivity(Intent intent) {
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
