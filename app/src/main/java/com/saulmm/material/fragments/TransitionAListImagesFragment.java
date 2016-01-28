package com.saulmm.material.fragments;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.saulmm.material.R;

/**
 * Created by lanna on 10/7/15.
 */
public class TransitionAListImagesFragment extends BaseFragment implements View.OnClickListener {

    private RecyclerView rv;
    private ImageAdapter adapter;
    private int currentViewIndex = -1;
    private Drawable drawable;

    interface OnItemClick {
        void onItemClick(View view, int position, Object data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transition_a_list_images, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(lm);
        if (adapter == null) {
            adapter = new ImageAdapter(new OnItemClick() {
                @Override
                public void onItemClick(View view, int position, Object data) {
                    onClick(view);
                }
            });
        }
        rv.setAdapter(adapter);
        if (currentViewIndex > 0) {
            rv.scrollToPosition(currentViewIndex);
        }

        initImageTemp(view);
    }

    @Override
    public void initImageTemp(View view) {
        super.initImageTemp(view);
        imgAnimTemp.setImageDrawable(drawable);
    }

    @Override
    public void onClick(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            makeAnimOverlay(v);
            gotoNextScreen(imgAnimTemp, imgAnimTemp.getTransitionName(),
                    new Transition.TransitionListener() {
                        @Override
                        public void onTransitionStart(Transition transition) {
                        }

                        @Override
                        public void onTransitionEnd(Transition transition) {
                            imgAnimTemp.setVisibility(View.GONE);
                        }

                        @Override
                        public void onTransitionCancel(Transition transition) {
                            imgAnimTemp.setVisibility(View.GONE);
                        }

                        @Override
                        public void onTransitionPause(Transition transition) {
                            imgAnimTemp.setVisibility(View.GONE);
                        }

                        @Override
                        public void onTransitionResume(Transition transition) {
                            imgAnimTemp.setVisibility(View.VISIBLE);
                        }
                    });
        }
    }

    @Override
    protected void makeAnimOverlay(View v) {
        params = (FrameLayout.LayoutParams) imgAnimTemp.getLayoutParams();
        params.width = v.getWidth();
        params.height = v.getHeight();
        params.setMargins(
                rv.getPaddingLeft(),
                v.getTop(),
                rv.getPaddingRight(),
                0
        );
        drawable = ((ImageView) v).getDrawable();
        imgAnimTemp.setImageDrawable(drawable);
        imgAnimTemp.setLayoutParams(params);
        imgAnimTemp.setVisibility(View.VISIBLE);
        currentViewIndex = (Integer) v.getTag();
//        Log.i("lanna", "imgTemp: " + currentViewIndex + ", " + params.height + ", " + params.topMargin);
    }

    /*
        Adapter
     */
    static class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

        private OnItemClick onItemClick;

        public ImageAdapter(OnItemClick onItemClick) {
            this.onItemClick = onItemClick;
        }

        @Override
        public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ImageViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_item_image, parent, false), onItemClick);
        }

        @Override
        public void onBindViewHolder(ImageViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    /*
        View Holder
     */
    static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private OnItemClick onItemClick;

        public ImageViewHolder(View itemView, OnItemClick onItemClick) {
            super(itemView);
            this.onItemClick = onItemClick;
            itemView.setOnClickListener(this);
        }

        public void bind(int position) {
            itemView.setTag(position);
//            itemView.setTransitionName(TRANSITION_PREFIX + position);
        }

        @Override
        public void onClick(View v) {
            if (onItemClick != null) {
                onItemClick.onItemClick(v, getPosition(), null);
            }
        }
    }

}
