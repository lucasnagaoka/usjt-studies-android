package br.usjt.deswebmob.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;

public class ActivityB extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }
}
