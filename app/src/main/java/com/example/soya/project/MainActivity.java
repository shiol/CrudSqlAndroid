package com.example.soya.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showListagem(View view) {
        Intent intent = new Intent(this, LivrosConsultar.class);
        Log.d(LOG_TAG, "Button clicked!");
        startActivity(intent);
    }

    public void showCadastrarLivros(View view) {
        Intent intent = new Intent(this, LivrosCadastrar.class);
        startActivity(intent);
    }
}
