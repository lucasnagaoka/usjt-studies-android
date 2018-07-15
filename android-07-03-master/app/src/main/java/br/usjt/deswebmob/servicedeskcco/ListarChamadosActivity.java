package br.usjt.deswebmob.servicedeskcco;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class ListarChamadosActivity extends Activity {
    public static final String CHAMADO = "br.usjt.deswebmob.servicedeskcco.chamado";

    ArrayList<Chamado> lista;
    ListView listView;
    Activity contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        final Intent intent = getIntent();
        String nomeFila = intent.getStringExtra(MainActivity.FILA);
        lista = buscarChamados(nomeFila);
        listView = findViewById(R.id.lista_chamados);
        //ArrayAdapter<Chamado> adapter = new ArrayAdapter<Chamado>(this, android.R.layout.simple_list_item_1, lista);
        ChamadoAdapter<Chamado> adapter = new ChamadoAdapter<>(this, lista);
        listView.setAdapter(adapter);
        contexto = this;

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Chamado chamado = lista.get(position);
                        Intent intent1 = new Intent(contexto, DetalheChamadoActivity.class);
                        intent1.putExtra(CHAMADO, chamado);
                        startActivity(intent1);
                    }
                });
    }

    private ArrayList<Chamado> buscarChamados(String chave) {
        ArrayList<Chamado> lista = geraListaChamados();
        if (chave == null || chave.length() == 0) return lista;

        ArrayList<Chamado> resultado = new ArrayList<>();

        for (Chamado chamado : lista) {
            if (chamado.getDescricao().toUpperCase().contains(chave.toUpperCase())) {
                resultado.add(chamado);
            }
        }

        return resultado;
    }

    public ArrayList<Chamado> geraListaChamados() {
        ArrayList<Chamado> lista = new ArrayList<>();
        Chamado c1 = new Chamado(1, new Date(), null, "Aberto", "Desktops: Computador da secretária quebrado.", new Fila(FilaId.DESKTOP.numero, FilaId.DESKTOP.icone, FilaId.DESKTOP.nome));
        lista.add(c1);

        Chamado c2 = new Chamado(2, new Date(), null, "Aberto", "Telefonia: Telefone não funciona.", new Fila(FilaId.TELEFONIA.numero, FilaId.TELEFONIA.icone, FilaId.TELEFONIA.nome));
        lista.add(c2);
//        lista.add("Redes: Manutenção no proxy.");
//        lista.add("Servidores: Lentidão generalizada.");
//        lista.add("Novos Projetos: CRM");
//        lista.add("Manutenção Sistema ERP: atualizar versão.");
//        lista.add("Novos Projetos: Rede MPLS");
//        lista.add("Manutenção Sistema de Vendas: incluir pipeline.");
//        lista.add("Manutenção Sistema ERP: erro contábil");
//        lista.add("Novos Projetos: Gestão de Orçamento");
//        lista.add("Novos Projetos: Big Data");
//        lista.add("Manoel de Barros");
//        lista.add("Redes: Internet com lentidão");
//        lista.add("Novos Projetos: Chatbot");
//        lista.add("Desktops: troca de senha");
//        lista.add("Desktops: falha no Windows");
//        lista.add("Novos Projetos: ITIL V3");
//        lista.add("Telefonia: liberar celular");
//        lista.add("Telefonia: mover ramal");
//        lista.add("Redes: ponto com defeito");
//        lista.add("Novos Projetos: ferramenta EMM");
        return lista;
    }
}
