package com.robsonmm.alunoagenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.robsonmm.alunoagenda.R;
import com.robsonmm.alunoagenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = criaView(parent);
        Aluno aluno = alunos.get(position);
        vincula(viewCriada, aluno);
        return viewCriada;
    }

    private void vincula(View view, Aluno aluno) {
        TextView nome = view.findViewById(R.id.item_aluno_nome);
        nome.setText(aluno.getNome());
        TextView telefone = view.findViewById(R.id.item_aluno_telefone);
        telefone.setText(aluno.getTelefone());
    }

    private View criaView(ViewGroup parent) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, parent, false);
    }

    private void clear() {
        alunos.clear();
        notifyDataSetChanged();
    }

    private void addAll(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }

    public void atualiza(List<Aluno> alunos){
        clear();
        addAll(alunos);
    }
    public void remove(Aluno alunoSelecionado) {
        this.alunos.remove(alunoSelecionado);
        notifyDataSetChanged();
    }
}
