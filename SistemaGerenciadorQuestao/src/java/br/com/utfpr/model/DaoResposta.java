/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.model;

import br.edu.utfpr.beans.Resposta;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class DaoResposta {

    private Resposta resposta;
    private Dao<Resposta> dao;

    public DaoResposta() {
        this.dao = new Dao(Resposta.class);
        this.resposta = new Resposta();
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public Dao getRespostaDao() {
        return dao;
    }

    public void setRespostaDao(Dao dao) {
        this.dao = dao;
    }

    public Resposta buscarPorId(int id) {
        return this.dao.buscaPorId(id);
    }

    public Resposta busbuscandoPorQuestaocarPorId(int id_aluno, int id_questao) {
        return this.dao.buscandoPorQuestao(id_aluno, id_questao);
    }

    public List listaTodos() {
        return this.dao.listaTodos();
    }

    public List buscaTodosDaDisciplina(int id) {
        return this.dao.buscaTodosDaDisciplina(id);
    }

    public void adiciona(Resposta resposta) {
        this.dao.adiciona(resposta);
    }

    public void update(Resposta resposta) {
        this.dao.update(resposta);
    }

    public void remove(Resposta resposta) {
        this.dao.remove(resposta);
    }

    public void removePorId(int id) {
        this.dao.removePorId(id);
    }
}
