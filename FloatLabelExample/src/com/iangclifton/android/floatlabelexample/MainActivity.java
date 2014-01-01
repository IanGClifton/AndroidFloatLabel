package com.iangclifton.android.floatlabelexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.iangclifton.android.floatlabel.FloatLabel;

public class MainActivity extends Activity {

    private int mTheme = android.R.style.Theme_Holo_Light_DarkActionBar;
    private static final String BUNDLE_KEY_THEME = MainActivity.class.getPackage() + ".theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mTheme = savedInstanceState.getInt(BUNDLE_KEY_THEME, mTheme);
        }
        setTheme(mTheme);
        setContentView(R.layout.activity_main);

        // This is how you add a custom animator
        final FloatLabel floatLabel = (FloatLabel) findViewById(R.id.float_label_custom_animation_1);
        floatLabel.setLabelAnimator(new CustomLabelAnimator());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_toggle_theme) {
            if (mTheme == android.R.style.Theme_Holo_Light_DarkActionBar) {
                mTheme = android.R.style.Theme_Holo;
            } else {
                mTheme = android.R.style.Theme_Holo_Light_DarkActionBar;
            }
            recreate();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_KEY_THEME, mTheme);
    }

    /**
     * LabelAnimator that uses a custom X shift and fade.
     *
     * @author Ian G. Clifton
     */
    private static class CustomLabelAnimator implements FloatLabel.LabelAnimator {
        /*package*/ static final float SCALE_X_SHOWN = 1f;
        /*package*/ static final float SCALE_X_HIDDEN = 2f;
        /*package*/ static final float SCALE_Y_SHOWN = 1f;
        /*package*/ static final float SCALE_Y_HIDDEN = 0f;

        @Override
        public void onDisplayLabel(View label) {
            final float shift = label.getWidth() / 2;
            label.setScaleX(SCALE_X_HIDDEN);
            label.setScaleY(SCALE_Y_HIDDEN);
            label.setX(shift);
            label.animate().alpha(1).scaleX(SCALE_X_SHOWN).scaleY(SCALE_Y_SHOWN).x(0f);
        }

        @Override
        public void onHideLabel(View label) {
            final float shift = label.getWidth() / 2;
            label.setScaleX(SCALE_X_SHOWN);
            label.setScaleY(SCALE_Y_SHOWN);
            label.setX(0f);
            label.animate().alpha(0).scaleX(SCALE_X_HIDDEN).scaleY(SCALE_Y_HIDDEN).x(shift);
        }
    }
}
