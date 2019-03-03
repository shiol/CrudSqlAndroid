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
        String[] campos = {"_id", "titulo"};
        db = conexao.getReadableDatabase();

        cursor = db.query("livros", campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public Cursor carregaDadoById(int id) {
        Cursor cursor;
        String[] campos = {"_id", "titulo", "autor", "editora"};
        String where = "_id" + "=" + id;
        db = conexao.getReadableDatabase();
        cursor = db.query("livros", campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String titulo, String autor, String editora) {
        ContentValues valores;
        String where;

        db = conexao.getWritableDatabase();

        where = "_id" + "=" + id;

        valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("autor", autor);
        valores.put("editora", editora);

        db.update("livros", valores, where, null);
        db.close();
    }

    public void deletaRegistro(int id){
        String where = "_id" + "=" + id;
        db = conexao.getReadableDatabase();
        db.delete("livros",where,null);
        db.close();
    }

}
