/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.beans;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author popovicz
 */
@Entity
public class Professor extends Pessoa {

    private int SIAPE;
    @OneToMany(mappedBy = "professor")
    private List<Disciplina> Diciplinas;
    @OneToMany(mappedBy = "professor")
    private List<Monitor> monitores;
    @OneToMany
    private List<Aluno> alunos;
    @OneToMany
    private List<Questao> questoes;

    public Professor() {
    }

    public int getSIAPE() {
        return SIAPE;
    }

    public void setSIAPE(int SIAPE) {
        this.SIAPE = SIAPE;
    }

    public List<Disciplina> getDiciplinas() {
        return Diciplinas;
    }

    public void setDiciplinas(List<Disciplina> Diciplinas) {
        this.Diciplinas = Diciplinas;
    }

    public List<Monitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<Monitor> monitores) {
        this.monitores = monitores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    @Override
    public String toString() {
        return "Professor{" + "SIAPE=" + SIAPE + ", Diciplinas=" + Diciplinas + ", monitores=" + monitores + ", alunos=" + alunos + ", questoes=" + questoes + '}';
    }
}
