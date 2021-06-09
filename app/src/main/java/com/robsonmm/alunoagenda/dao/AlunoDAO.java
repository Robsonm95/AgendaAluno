package com.robsonmm.alunoagenda.dao;

import androidx.annotation.Nullable;

import com.robsonmm.alunoagenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void save(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        IncrementaId();
    }

    private void IncrementaId() {
        contadorDeIds++;
    }

    public void edit(Aluno aluno){
        Aluno alunoEncontrado = buscaPorId(aluno);
        if (alunoEncontrado != null){
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno, aluno);
        }
    }

    @Nullable
    public Aluno buscaPorId(Aluno aluno) {
        for (Aluno a: alunos){
            if(a.getId() == aluno.getId()){
                return a;
            }
        }
        return null;
    }

    public List<Aluno> listAll() {
        return new ArrayList<>(alunos);
    }

    public void remove(Aluno aluno) {
        Aluno alunoEncontrado = buscaPorId(aluno);
        if (alunoEncontrado != null){
            alunos.remove(alunoEncontrado);
        }
    }
}
