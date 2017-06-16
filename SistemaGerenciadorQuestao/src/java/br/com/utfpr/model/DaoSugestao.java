/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.model;

import br.edu.utfpr.beans.Sugestao;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class DaoSugestao {

    private Sugestao sugestao;
    private Dao<Sugestao> dao;

    public DaoSugestao() {
        this.dao = new Dao(Sugestao.class);
        this.sugestao = new Sugestao();
    }

    public Sugestao getSugestao() {
        return sugestao;
    }

    public void setSugestao(Sugestao sugestao) {
        this.sugestao = sugestao;
    }

    public Dao getSugestaoDao() {
        return dao;
    }

    public void setSugestaoDao(Dao dao) {
        this.dao = dao;
    }

    public Sugestao buscarPorId(int id) {
        return this.dao.buscaPorId(id);
    }

    public List listaTodos() {
        return this.dao.listaTodos();
    }

    public void adiciona(Sugestao sugestao) {
        this.dao.adiciona(sugestao);
    }

    public void update(Sugestao sugestao) {
        this.dao.update(sugestao);
    }

    public void remove(Sugestao sugestao) {
        this.dao.remove(sugestao);
    }

    public void removePorId(int id) {
        this.dao.removePorId(id);
    }
}
