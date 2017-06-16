/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import br.edu.utfpr.beans.Comentario;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class DaoComentario {

    private Comentario comentario;
    private Dao<Comentario> dao;

    public DaoComentario() {
        this.dao = new Dao(Comentario.class);
        this.comentario = new Comentario();
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void Comentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Dao getComentarioDao() {
        return dao;
    }

    public void setComentarioDao(Dao dao) {
        this.dao = dao;
    }

    public Comentario buscarPorId(int id) {
        return this.dao.buscaPorId(id);
    }

    public List listaTodos() {
        return this.dao.listaTodos();
    }

    public void adiciona(Comentario comentario) {
        this.dao.adiciona(comentario);
    }

    public void update(Comentario comentario) {
        this.dao.update(comentario);
    }

    public void remove(Comentario comentario) {
        this.dao.remove(comentario);
    }

    public void removePorId(int id) {
        this.dao.removePorId(id);
    }
}
