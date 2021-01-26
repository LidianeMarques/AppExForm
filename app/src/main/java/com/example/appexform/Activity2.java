package com.example.appexform;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Programação para Dispositivos Móveis I.
 * INTERFACE DO USUÁRIO
 * Crie um form para receber dados de um pessoa com as seguintes informações abaixo.
 * <p>
 * Nome:
 * idade
 * Sexo:
 * Estilo musicais favorito: Rock, Sertanejo, Pagode, Forró, Outro.
 * <p>
 * NOTA: para o sexo, utilize RadioButton e para o estilo musical utilize Checkbox.
 * <p>
 * Por fim, apresente os dados inseridos em um TextView.
 */

public class Activity2 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle paramers;
        TextView textViewResultado = findViewById(R.id.textViewResultado);

        Intent intent = getIntent();
        if (intent != null) {
            paramers = intent.getExtras();

            if (paramers != null) {
                Pessoa pessoa = (Pessoa) paramers.get("pessoa");
                textViewResultado.setText(pessoa.toString());
            }
        }

    }

    //Metódo para voltar para tela anterior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //identificar a ação de voltar a tela
            case android.R.id.home:
                //encerra a activity
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}