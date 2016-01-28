package com.saulmm.material.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.saulmm.material.R;

/**
 * Created by lanna on 10/6/15.
 */
public class CustomizeTouchFeedbackFragment extends Fragment {
    private static final int SCALE_DELAY = 60;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customize_touch_feedback, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.container);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View rowView = layout.getChildAt(i);
            rowView.setScaleX(0);
            rowView.setScaleY(0);
            rowView.animate().setStartDelay(300 + i * SCALE_DELAY)
                    .scaleX(1).scaleY(1);
        }
    }
}
