package com.iangclifton.android.floatlabelexample;

import com.iangclifton.android.floatlabel.FloatLabel;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        final FloatLabel floatLabel = (FloatLabel) findViewById(R.id.float_label_1);
//        floatLabel.setLabel("Example label");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
