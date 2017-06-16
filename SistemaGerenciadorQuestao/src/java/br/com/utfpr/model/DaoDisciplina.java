/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.model;

import br.edu.utfpr.beans.Disciplina;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class DaoDisciplina {

    private Disciplina disciplina;
    private Dao<Disciplina> dao;

    public DaoDisciplina() {
        this.dao = new Dao(Disciplina.class);
        this.disciplina = new Disciplina();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Dao getDisciplinaDao() {
        return dao;
    }

    public void setDisciplinaDao(Dao dao) {
        this.dao = dao;
    }

    public Disciplina buscandoId(int id) {
        return this.dao.buscandoId(id);
    }

    public List listaTodos() {
        return this.dao.listaTodos();
    }

    public void adiciona(Disciplina disciplina) {
        this.dao.adiciona(disciplina);
    }

    public void update(Disciplina disciplina) {
        this.dao.update(disciplina);
    }

    public void remove(Disciplina disciplina) {
        this.dao.remove(disciplina);
    }

    public void removePorId(int id) {
        this.dao.removePorId(id);
    }
}