package com.example.soya.project;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LivrosAlterar extends AppCompatActivity {
    EditText livro;
    EditText autor;
    EditText editora;
    Button alterar;
    Button deletar;
    Cursor cursor;
    LivrosController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_livros);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new LivrosController(getBaseContext());

        livro = (EditText) findViewById(R.id.editText4);
        autor = (EditText) findViewById(R.id.editText5);
        editora = (EditText) findViewById(R.id.editText6);

        alterar = (Button) findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow("autor")));
        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow("editora")));


        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo),
                        livro.getText().toString(), autor.getText().toString(),
                        editora.getText().toString());
                Intent intent = new Intent(LivrosAlterar.this, LivrosConsultar.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button) findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(LivrosAlterar.this, LivrosConsultar.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
