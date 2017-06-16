/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import br.edu.utfpr.beans.Aluno;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class DaoAluno {

    private Aluno aluno;
    private Dao<Aluno> dao;

    public DaoAluno() {
        this.dao = new Dao(Aluno.class);
        this.aluno = new Aluno();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void Aluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Dao getAlunoDao() {
        return dao;
    }

    public void setAlunoDao(Dao dao) {
        this.dao = dao;
    }

    public Aluno buscarPorId(int id) {
        return this.dao.buscaPorId(id);
    }

    public List buscarPorLogin(String login) {
        return this.dao.buscaPorLogin(login);
    }

    public List listaTodos() {
        return this.dao.listaTodos();
    }

    public List listaOsDezMelhor() {
        return this.dao.listaOsDezMelhor();
    }

    public void adiciona(Aluno aluno) {
        this.dao.adiciona(aluno);
    }

    public void update(Aluno aluno) {
        this.dao.update(aluno);
    }

    public void remove(Aluno aluno) {
        this.dao.remove(aluno);
    }

    public void removePorId(int id) {
        this.dao.removePorId(id);
    }

    public void retornaUltimoId() {
        this.dao.buscaUltimoId();
    }
}