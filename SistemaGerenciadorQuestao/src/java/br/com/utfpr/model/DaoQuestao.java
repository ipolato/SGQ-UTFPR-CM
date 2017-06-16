/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.model;

import br.edu.utfpr.beans.Questao;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class DaoQuestao {

    private Questao questao;
    private Dao<Questao> dao;

    public DaoQuestao() {
        this.dao = new Dao(Questao.class);
        this.questao = new Questao();
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Dao getQuestaoDao() {
        return dao;
    }

    public void setQuestaoDao(Dao dao) {
        this.dao = dao;
    }

    public Questao buscarPorId(int id) {
        return this.dao.buscaPorId(id);
    }

    public Questao buscandoId(int id) {
        return this.dao.buscandoId(id);
    }

    public List buscaTodosDaDisciplina(int id) {
        return this.dao.buscaTodosDaDisciplina(id);
    }

    public List listaTodos() {
        return this.dao.listaTodos();
    }

    public void adiciona(Questao questao) {
        this.dao.adiciona(questao);
    }

    public void update(Questao questao) {
        this.dao.update(questao);
    }

    public void remove(Questao questao) {
        this.dao.remove(questao);
    }

    public void removePorId(int id) {
        this.dao.removePorId(id);
    }
}