package com.robsonmm.alunoagenda.dao;

import com.robsonmm.alunoagenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listAll() {
        return new ArrayList<>(alunos);
    }
}
