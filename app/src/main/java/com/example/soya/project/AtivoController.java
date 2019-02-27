package com.example.soya.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AtivoController {

    private Conexao conexao;
    private SQLiteDatabase banco;


    public AtivoController(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Ativo ativo) {
        ContentValues values = new ContentValues();

        values.put("descricao", ativo.getDescricao());
        values.put("valor", ativo.getValor());

        long result = banco.insert("ativos", null, values);
        return result;
    }

    public List<Ativo> getAtivos() {
        List<Ativo> ativos = new ArrayList<>();

        Cursor cursor = banco.query("ativos", new String[]{"id", "descricao", "valor"}, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Ativo ativo = new Ativo();
            ativo.setId(cursor.getInt(0));
            ativo.setDescricao(cursor.getString(1));
            ativo.setValor(cursor.getString(2));
            ativos.add(ativo);
        }

        banco.close();
        return ativos;
    }

}
