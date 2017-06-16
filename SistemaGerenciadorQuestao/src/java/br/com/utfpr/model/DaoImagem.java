/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.model;

import br.edu.utfpr.beans.Imagem;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class DaoImagem {

    private Imagem imagem;
    private Dao<Imagem> dao;

    public DaoImagem() {
        this.dao = new Dao(Imagem.class);
        this.imagem = new Imagem();
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }

    public Dao getImagemDao() {
        return dao;
    }

    public void setImagemDao(Dao dao) {
        this.dao = dao;
    }

    public Imagem buscarPorId(int id) {
        return this.dao.buscaPorId(id);
    }

    public Imagem recuperaImagem(int id) throws SQLException {
        return this.dao.recuperaImagem(id);
    }

    public List listaTodos() {
        return this.dao.listaTodos();
    }

    public List buscaPorNomeDoArquivo(String nomeArquivo) {
        return this.dao.buscaPorNomeDoArquivo(nomeArquivo);
    }

    public List listaPorId(int parametro) {
        return this.dao.listaPorId(parametro);
    }

    public void adiciona(Imagem imagem) {
        this.dao.adiciona(imagem);
    }

    public void update(Imagem imagem) {
        this.dao.update(imagem);
    }

    public void remove(Imagem imagem) {
        this.dao.remove(imagem);
    }

    public void removePorId(int id) {
        this.dao.removePorId(id);
    }

    public void retornaUltimoId() {
        this.dao.buscaUltimoId();
    }
}