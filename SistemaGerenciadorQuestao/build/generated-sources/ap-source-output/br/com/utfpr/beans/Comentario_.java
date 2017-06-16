package br.com.utfpr.beans;

import br.com.utfpr.beans.Aluno;
import br.com.utfpr.beans.Monitor;
import br.com.utfpr.beans.Professor;
import br.com.utfpr.beans.Questao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2017-05-28T01:17:45")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, Integer> id;
    public static volatile SingularAttribute<Comentario, Boolean> certa;
    public static volatile SingularAttribute<Comentario, Monitor> monitor;
    public static volatile SingularAttribute<Comentario, Aluno> aluno;
    public static volatile SingularAttribute<Comentario, String> conteudo;
    public static volatile SingularAttribute<Comentario, String> tipo;
    public static volatile SingularAttribute<Comentario, Professor> professor;
    public static volatile SingularAttribute<Comentario, Questao> questao;
    public static volatile SingularAttribute<Comentario, Integer> quantidadeDeCurtida;

}