package br.com.utfpr.beans;

import br.com.utfpr.beans.Aluno;
import br.com.utfpr.beans.Disciplina;
import br.com.utfpr.beans.Monitor;
import br.com.utfpr.beans.Questao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2017-05-28T01:17:44")
@StaticMetamodel(Professor.class)
public class Professor_ extends Pessoa_ {

    public static volatile ListAttribute<Professor, Monitor> monitores;
    public static volatile ListAttribute<Professor, Aluno> alunos;
    public static volatile ListAttribute<Professor, Disciplina> Diciplinas;
    public static volatile ListAttribute<Professor, Questao> questoes;
    public static volatile SingularAttribute<Professor, Integer> SIAPE;

}