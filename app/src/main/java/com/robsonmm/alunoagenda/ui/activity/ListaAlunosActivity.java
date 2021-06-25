package com.robsonmm.alunoagenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.robsonmm.alunoagenda.R;
import com.robsonmm.alunoagenda.model.Aluno;
import com.robsonmm.alunoagenda.ui.ListaAlunosView;

import static com.robsonmm.alunoagenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    private final ListaAlunosView listaAlunosView = new ListaAlunosView(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        configurarFabNovoAluno();
        configurarLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater()
                .inflate(R.menu.activity_lista_alunos_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.activity_lista_alunos_menu_remover) {
            listaAlunosView.confirmaRemocao(item);
        }

        return super.onContextItemSelected(item);
    }

    private void configurarFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(v -> abreFormularioModoInsereAluno());
    }

    private void abreFormularioModoInsereAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAlunosView.atualizaAlunos();
    }

    private void configurarLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listview);
        listaAlunosView.configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener((adapterView, view, position, id) -> {
            Aluno alunoSelecionado = (Aluno) adapterView.getItemAtPosition(position);
            Log.i("Posicao aluno", "" + alunoSelecionado);
            abreFormularioEditaAluno(alunoSelecionado);
        });
    }

    private void abreFormularioEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioActivify = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        vaiParaFormularioActivify.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivify);
    }

}

