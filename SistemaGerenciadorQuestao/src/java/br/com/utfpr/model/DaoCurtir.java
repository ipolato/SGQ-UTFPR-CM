/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.model;

import br.edu.utfpr.beans.Curtir;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class DaoCurtir {

    private Curtir curtir;
    private Dao<Curtir> dao;

    public DaoCurtir() {
        this.dao = new Dao(Curtir.class);
        this.curtir = new Curtir();
    }

    public Curtir getCurtir() {
        return curtir;
    }

    public void setCurtir(Curtir curtir) {
        this.curtir = curtir;
    }

    public Dao getCurtirDao() {
        return dao;
    }

    public void setCurtirDao(Dao dao) {
        this.dao = dao;
    }

    public Curtir buscarPorId(int id) {
        return this.dao.buscaPorId(id);
    }

    public List listaTodos() {
        return this.dao.listaTodos();
    }

//    public List listaTodosQueCurtiu(int id) {
//        return this.dao.listaTodosQueCurtiu(id);
//    }
//    
//    public List listaTodosDoComentario(int id) {
//        return this.dao.listaTodosDoComentario(id);
//    }
    public void adiciona(Curtir curtir) {
        this.dao.adiciona(curtir);
    }

    public void update(Curtir curtir) {
        this.dao.update(curtir);
    }

    public void remove(Curtir curtir) {
        this.dao.remove(curtir);
    }

    public void removePorId(int id) {
        this.dao.removePorId(id);
    }
}
