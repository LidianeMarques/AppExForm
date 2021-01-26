package com.example.appexform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

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

public class MainActivity extends AppCompatActivity {


    EditText editTextNome, editTextIdade;
    RadioButton radioButtonFeminino, radioButtonMasculino;
    CheckBox checkBoxPisadinha, checkBoxPagode, checkBoxForro, checkBoxRock, checkBoxSertanejo, checkBoxOutros;
    Button buttonEnviar;
    RadioGroup radioGroup;

    String valorradioButton = null;
    List<String> valorCheckBox = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextTIdade);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonFeminino = findViewById(R.id.radioButtonFeminino);
        radioButtonMasculino = findViewById(R.id.radioButtonMaculino);

        checkBoxForro = findViewById(R.id.checkBoxForro);
        checkBoxOutros = findViewById(R.id.checkBoxOutros);
        checkBoxPagode = findViewById(R.id.checkBoxPagode);
        checkBoxPisadinha = findViewById(R.id.checkBoxPisadinha);
        checkBoxRock = findViewById(R.id.checkBoxRock);
        checkBoxSertanejo = findViewById(R.id.checkBoxSertanejo);

        buttonEnviar = findViewById(R.id.buttonEnviar);
        valorCheckBox = new ArrayList<String>();


    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        valorCheckBox.add(((CheckBox) view).getText().toString());
    }

    public void radioButtonchecked(View view) {

        //     Is the button now checked?
        boolean radioButtonchecked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButtonFeminino:
                if (radioButtonchecked)
                    valorradioButton = radioButtonFeminino.getText().toString();
                break;
            case R.id.radioButtonMaculino:
                if (radioButtonchecked)
                    valorradioButton = radioButtonMasculino.getText().toString();
                break;

        }
    }

    public void botaoEnviar(View view) {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(editTextNome.getText().toString());
        try {
            pessoa.setIdade(Integer.parseInt(editTextIdade.getText().toString()));
        } catch (Exception e) {
        }
        pessoa.setSexo(valorradioButton);
        pessoa.setEstiloMusical(valorCheckBox);

        Intent intent = new Intent(MainActivity.this, Activity2.class);
        intent.putExtra("pessoa", pessoa);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "Itens inseridos", Toast.LENGTH_SHORT).show();

    }

}

