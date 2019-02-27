package com.example.soya.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LivrosController {

    SQLiteDatabase db;
    Conexao conexao;

    public LivrosController(Context context) {

        conexao = new Conexao(context);
    }


    public String insereDado(String titulo, String autor, String editora) {
        ContentValues valores;
        long resultado;
        db = conexao.getWritableDatabase();

        valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("autor", autor);
        valores.put("editora", editora);

        resultado = db.insert("livros", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }


    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {"id", "titulo"};
        db = conexao.getReadableDatabase();

        cursor = db.query("livros", campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}
