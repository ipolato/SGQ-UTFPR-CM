/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author popovicz
 */
@Entity
public class Aluno extends Pessoa {

    private int pontosDeExperiencia;
    private int possuiLevel;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tempoPermanecido;
    @ManyToOne
    private Monitor monitor;
    @ManyToOne
    private Disciplina disciplina;
    @OneToMany
    private List<Resposta> respostas;
    @OneToMany
    private List<Comentario> comentarios;
    private String game;
    private int umaEst;
    private int duaEst;
    private int treEst;
    private int medal;
    private int medCom;
    private int medLiv;

    public Aluno() {
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getPontosDeExperiencia() {
        return pontosDeExperiencia;
    }

    public void setPontosDeExperiencia(int pontosDeExperiencia) {
        this.pontosDeExperiencia = pontosDeExperiencia;
    }

    public Date getTempoPermanecido() {
        return tempoPermanecido;
    }

    public void setTempoPermanecido(Date tempoPermanecido) {
        this.tempoPermanecido = tempoPermanecido;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public int getPossuiLevel() {
        return possuiLevel;
    }

    public void setPossuiLevel(int possuiLevel) {
        this.possuiLevel = possuiLevel;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getUmaEst() {
        return umaEst;
    }

    public void setUmaEst(int umaEst) {
        this.umaEst = umaEst;
    }

    public int getDuaEst() {
        return duaEst;
    }

    public void setDuaEst(int duaEst) {
        this.duaEst = duaEst;
    }

    public int getTreEst() {
        return treEst;
    }

    public void setTreEst(int treEst) {
        this.treEst = treEst;
    }

    public int getMedal() {
        return medal;
    }

    public void setMedal(int medal) {
        this.medal = medal;
    }

    public int getMedCom() {
        return medCom;
    }

    public void setMedCom(int medCom) {
        this.medCom = medCom;
    }

    public int getMedLiv() {
        return medLiv;
    }

    public void setMedLiv(int medLiv) {
        this.medLiv = medLiv;
    }
}
