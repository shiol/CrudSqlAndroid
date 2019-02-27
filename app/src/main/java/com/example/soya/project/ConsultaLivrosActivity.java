package com.example.soya.project;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ConsultaLivrosActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);


        LivrosController crud = new LivrosController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[]{"id", "titulo"};
        int[] idViews = new int[]{R.id.idLivro, R.id.nomeLivro};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.livros_layout, cursor, nomeCampos, idViews, 0);

        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adaptador);

    }

    public void showListagem(View view) {
        Intent intent = new Intent(this, ConsultaLivrosActivity.class);
        intent.putExtra("nameTest", "messageTest");
        startActivity(intent);
    }

}

