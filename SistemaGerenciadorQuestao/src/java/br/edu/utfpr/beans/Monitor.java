/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.beans;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author popovicz
 */
@Entity
public class Monitor extends Pessoa {

    @ManyToOne
    private Professor professor;
    @OneToOne
    private Disciplina disciplina;
    @OneToMany
    private List<Questao> questoes;
    @OneToMany(mappedBy = "monitor")
    private List<Aluno> alunos;

    public Monitor() {
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
        return "Monitor{" + "professor=" + professor + ", disciplina=" + disciplina + ", alunos=" + alunos + ", questoes=" + questoes + '}';
    }
}
