package com.transitionwork;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

/**
 * Created by mwg on 16-3-11.
 */
public class TransitionActivity extends AppCompatActivity {

    private static final String TAG = "TransitionActivity";
    private ImageView bigView;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_transition);
        bigView = (ImageView) findViewById(R.id.big_circle);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(bigView, "scaleX", 1f, 2f, 1.5f),
                ObjectAnimator.ofFloat(bigView, "scaleY", 1f, 2f, 1.5f));
        set.setDuration(1300).start();

        //  setupWindowAnimations();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = (Explode) TransitionInflater.from(this).inflateTransition(R.transition.activity_explore);
            getWindow().setEnterTransition(explode);
            Log.d(TAG, " activity slide");
        }
    }

}
