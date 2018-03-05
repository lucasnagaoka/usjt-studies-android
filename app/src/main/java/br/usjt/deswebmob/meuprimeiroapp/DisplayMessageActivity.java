package br.usjt.deswebmob.meuprimeiroapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String mensagem = intent.getStringExtra(MainActivity.MENSAGEM);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(mensagem);
        ViewGroup layout = (ViewGroup)
                findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }
}
