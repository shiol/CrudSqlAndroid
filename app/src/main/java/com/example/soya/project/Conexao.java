package com.example.soya.project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

public class Conexao extends SQLiteOpenHelper {


    public Conexao(Context context) {
        super(context, "banco.db", null, 3);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table livros (_id integer primary key autoincrement, titulo text, autor text, editora text)";
        String sql2 = "create table ativos (_id integer primary key autoincrement, descricao text, valor decimal)";
        db.execSQL(sql);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists livros");
        db.execSQL("drop table if exists ativos");
        onCreate(db);
    }


}

