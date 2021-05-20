package com.robsonmm.alunoagenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.robsonmm.alunoagenda.R;
import com.robsonmm.alunoagenda.dao.AlunoDAO;
import com.robsonmm.alunoagenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        AlunoDAO dao = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);


        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = campoNome.getText().toString();
                String email = campoEmail.getText().toString();
                String telefone = campoTelefone.getText().toString();

                Aluno aluno = new Aluno(nome, telefone, email);
                dao.salva(aluno);

                finish();
            }
        });
    }
}