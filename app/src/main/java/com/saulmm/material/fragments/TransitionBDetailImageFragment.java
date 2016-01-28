package com.saulmm.material.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saulmm.material.R;

/**
 * Created by lanna on 10/7/15.
 */
public class TransitionBDetailImageFragment extends Fragment implements View.OnClickListener {

    static final String TRANSITION_NAME = "TRANSITION_NAME";

    public static Fragment newInstance(String transitionName) {
        Bundle bundle = new Bundle();
        bundle.putString(TRANSITION_NAME, transitionName);
        TransitionBDetailImageFragment fragment = new TransitionBDetailImageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transition_b_image, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String transitionName = getArguments().getString(TRANSITION_NAME);
        getView().setOnClickListener(this);
        getView().findViewById(R.id.product_detail_image).setTransitionName(transitionName);
    }

    @Override
    public void onClick(View v) {
        getActivity().onBackPressed();
    }
}
