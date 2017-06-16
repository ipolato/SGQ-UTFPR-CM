/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.model;

import br.edu.utfpr.beans.Professor;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class DaoProfessor {

    private Professor professor;
    private Dao<Professor> dao;

    public DaoProfessor() {
        this.dao = new Dao(Professor.class);
        this.professor = new Professor();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Dao getProfessorDao() {
        return dao;
    }

    public void setProfessorDao(Dao dao) {
        this.dao = dao;
    }

    public List buscarPorLogin(String login) {
        return this.dao.buscaPorLogin(login);
    }

    public Professor buscarPorId(int id) {
        return this.dao.buscaPorId(id);
    }

    public Professor buscandoId(int id) {
        return this.dao.buscandoId(id);
    }

    public List listaTodos() {
        return this.dao.listaTodos();
    }

    public void adiciona(Professor professor) {
        this.dao.adiciona(professor);
    }

    public void update(Professor professor) {
        this.dao.update(professor);
    }

    public void remove(Professor professor) {
        this.dao.remove(professor);
    }

    public void removePorId(int id) {
        this.dao.removePorId(id);
    }
}