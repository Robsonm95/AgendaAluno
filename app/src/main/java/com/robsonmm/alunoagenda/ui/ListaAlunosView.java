package com.robsonmm.alunoagenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.robsonmm.alunoagenda.dao.AlunoDAO;
import com.robsonmm.alunoagenda.model.Aluno;
import com.robsonmm.alunoagenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {

    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListaAlunosAdapter(this.context);
        dao = new AlunoDAO();
    }

    public void confirmaRemocao(final @NonNull MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo aluno")
                .setMessage("Tem certeza que quer remover o aluno?")
                .setPositiveButton("Sim", (dialog, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno aluno = adapter.getItem(menuInfo.position);
                    remove(aluno);
                })
                .setNegativeButton("Não", null)
                .show();
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.listAll());
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }
}
