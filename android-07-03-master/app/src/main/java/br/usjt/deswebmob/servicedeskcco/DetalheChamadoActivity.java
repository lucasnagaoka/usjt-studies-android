package br.usjt.deswebmob.servicedeskcco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheChamadoActivity extends Activity {
    TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_chamado);
        TextView chamadoSelecionadoTextView = findViewById(R.id.chamado_nome);
        Intent origemIntent = getIntent();
        chamadoSelecionadoTextView.setText(origemIntent.getStringExtra(ListarChamadosActivity.CHAMADO));
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detalhe_chamado);
//        txtNome = (TextView)findViewById(R.id.chamado_nome);
//        Intent intent = getIntent();
//        String nome = intent.getStringExtra(ListarChamadosActivity.CHAMADO);
//        txtNome.setText(nome);
//    }
}
