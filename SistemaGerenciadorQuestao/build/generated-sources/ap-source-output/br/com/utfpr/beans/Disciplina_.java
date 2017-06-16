package br.com.utfpr.beans;

import br.com.utfpr.beans.Aluno;
import br.com.utfpr.beans.Monitor;
import br.com.utfpr.beans.Professor;
import br.com.utfpr.beans.Questao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2017-05-28T01:17:44")
@StaticMetamodel(Disciplina.class)
public class Disciplina_ { 

    public static volatile SingularAttribute<Disciplina, Integer> id;
    public static volatile SingularAttribute<Disciplina, Monitor> monitor;
    public static volatile ListAttribute<Disciplina, Aluno> alunos;
    public static volatile SingularAttribute<Disciplina, Professor> professor;
    public static volatile ListAttribute<Disciplina, Questao> questoes;
    public static volatile SingularAttribute<Disciplina, String> nome;

}