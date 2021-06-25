package com.robsonmm.alunoagenda;

import android.app.Application;

import com.robsonmm.alunoagenda.dao.AlunoDAO;
import com.robsonmm.alunoagenda.model.Aluno;

public class AgendaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CriaAlunosDeTeste();
    }

    private void CriaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.save(new Aluno("Alex","1123223","alex@hotmail.com"));
        dao.save(new Aluno("Robson","9999999","robson@hotmail.com"));
    }
}
