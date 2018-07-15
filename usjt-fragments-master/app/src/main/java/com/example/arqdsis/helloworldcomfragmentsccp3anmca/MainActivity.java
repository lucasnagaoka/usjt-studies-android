package com.example.arqdsis.helloworldcomfragmentsccp3anmca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
            HelloWorldFragment hwf = new HelloWorldFragment();
            android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();

            ft.add(R.id.layoutFragment, hwf, "helloWorldFragment");
            ft.commit();
        }
    }
}
