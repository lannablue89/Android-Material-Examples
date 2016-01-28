package com.saulmm.material.activities;

import android.app.Activity;
import android.os.Bundle;

import com.saulmm.material.R;
import com.saulmm.material.fragments.SharedElementFragment1;

/**
 * Created by lanna on 10/6/15.
 */
public class MaterialResourcesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marterial_resources);

        getFragmentManager().beginTransaction()
                .replace(R.id.container, SharedElementFragment1.newInstance(new Sample(R.color.green, "lanna")))
//                .replace(R.id.container, new TransitionALinearImagesFragment())
//                .replace(R.id.container, new TransitionAListImagesFragment())
                .commit();
    }
}
