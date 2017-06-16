package br.com.utfpr.beans;

import br.com.utfpr.beans.Aluno;
import br.com.utfpr.beans.Disciplina;
import br.com.utfpr.beans.Professor;
import br.com.utfpr.beans.Questao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2017-05-28T01:17:44")
@StaticMetamodel(Monitor.class)
public class Monitor_ extends Pessoa_ {

    public static volatile SingularAttribute<Monitor, Disciplina> disciplina;
    public static volatile ListAttribute<Monitor, Aluno> alunos;
    public static volatile SingularAttribute<Monitor, Professor> professor;
    public static volatile ListAttribute<Monitor, Questao> questoes;

}