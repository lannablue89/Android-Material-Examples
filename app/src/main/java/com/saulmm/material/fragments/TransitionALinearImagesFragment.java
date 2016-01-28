package com.saulmm.material.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.saulmm.material.R;

/**
 * Created by lanna on 10/7/15.
 */
public class TransitionALinearImagesFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout imagesBounder;
    private FrameLayout.LayoutParams params;
    private int currentViewIndex = -1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transition_a_linear_images, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagesBounder = (LinearLayout) view.findViewById(R.id.images_bounder);
        for (int i = 0; i < imagesBounder.getChildCount(); i++) {
            final ImageView child = (ImageView) imagesBounder.getChildAt(i);
            child.setTag(i);
            child.setOnClickListener(this);
            if (i == currentViewIndex) {
                imgAnimTemp.setImageDrawable(child.getDrawable());
            }
        }

        initImageTemp(view);
    }

    @Override
    public void onClick(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            makeAnimOverlay(v);
            gotoNextScreen(imgAnimTemp, imgAnimTemp.getTransitionName(), null);
        }
    }

    @Override
    public void makeAnimOverlay(View v) {
        params = (FrameLayout.LayoutParams) imgAnimTemp.getLayoutParams();
        params.width = v.getWidth();
        params.height = v.getHeight();
        params.setMargins(
                imagesBounder.getPaddingLeft(),
                v.getTop(),
                imagesBounder.getPaddingRight(),
                0
        );
        imgAnimTemp.setImageDrawable(((ImageView) v).getDrawable());
        imgAnimTemp.setLayoutParams(params);
        imgAnimTemp.setVisibility(View.VISIBLE);
        currentViewIndex = (Integer) v.getTag();
//        Log.i("lanna", "imgTemp: " + currentViewIndex + ", " + params.height + ", " + params.topMargin);
    }

}
