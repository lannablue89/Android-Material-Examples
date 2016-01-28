package com.saulmm.material.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.saulmm.material.R;

/**
 * Created by lanna on 10/27/15.
 */
public class CustomDialogColorActivity extends Activity
        implements View.OnClickListener {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_color);
        findViewById(R.id.btn_show_default_dialog).setOnClickListener(this);
        findViewById(R.id.btn_show_default_progress).setOnClickListener(this);
        findViewById(R.id.btn_show_dialog).setOnClickListener(this);
        findViewById(R.id.btn_show_progress).setOnClickListener(this);
        findViewById(R.id.btn_apply_theme).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_default_progress:
                showDefaultProgress();
                break;
            case R.id.btn_show_default_dialog:
                showDefaultDialog();
                break;
            case R.id.btn_show_progress:
                showProgress();
                break;
            case R.id.btn_show_dialog:
                showDialog();
                break;
            case R.id.btn_apply_theme:
                applyTheme();
                break;
        }
    }

    private void showDefaultProgress() {
        if (progressDialog != null) {
            progressDialog.cancel();
        }
        progressDialog = new ProgressDialog(this, R.style.ProgressBarDefault);
        progressDialog.setMessage("Default Progress");
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    private void showDefaultDialog() {
        new AlertDialog.Builder(this, R.style.AlertDialogDefault)
                .setTitle("Default Dialog")
                .setMessage("Content")
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .create().show();
    }

    private void showProgress() {
        if (progressDialog != null) {
            progressDialog.cancel();
        }
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Progress");
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    private void showDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Dialog")
                .setMessage("Content")
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .create().show();
    }

    private void applyTheme() {
        finish();
    }
}
