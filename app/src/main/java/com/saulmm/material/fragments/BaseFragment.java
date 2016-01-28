package com.saulmm.material.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.saulmm.material.R;

/**
 * Created by lanna on 10/9/15.
 */
public abstract class BaseFragment extends Fragment {

    public static final String TRANSITION_PREFIX = "transition";

    protected ImageView imgAnimTemp;
    protected FrameLayout.LayoutParams params;

    private int duration;

    protected View findViewById(@IdRes int viewId) {
        return getView() == null ? null : getView().findViewById(viewId);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        duration = getResources().getInteger(R.integer.anim_duration_long);
    }

    public void initImageTemp(View view) {
        imgAnimTemp = (ImageView) view.findViewById(R.id.img_anim_temp);
        imgAnimTemp.setTransitionName(TRANSITION_PREFIX);
        imgAnimTemp.setImageResource(R.color.light_grey);
        if (params != null) {
            imgAnimTemp.setLayoutParams(params);
            imgAnimTemp.setVisibility(View.VISIBLE);
        } else {
            imgAnimTemp.setVisibility(View.GONE);
        }
    }

    abstract protected void makeAnimOverlay(View v);

    protected void gotoNextScreen(View v, String transition, Transition.TransitionListener listener) {
//        ChangeBounds imageTransform = new ChangeBounds();
        Transition imageTransform = TransitionInflater.from(getActivity())
                .inflateTransition(R.transition.change_image_bounds);
        imageTransform.setDuration(duration);
        if (listener != null) {
            imageTransform.addListener(listener);
        }

        // fragment A
//        setSharedElementReturnTransition(imageTransform);
//        setExitTransition(new Fade().setDuration(duration));

        // fragment B
        Fragment fragmentB = TransitionBDetailImageFragment.newInstance(transition);
        fragmentB.setSharedElementEnterTransition(imageTransform);
//        fragmentB.setSharedElementReturnTransition(imageTransform);

        // start switch fragment
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragmentB)
                .addToBackStack(null)
                .addSharedElement(v, transition)
                .commit();
    }

}
