package br.com.utfpr.beans;

import br.com.utfpr.beans.Aluno;
import br.com.utfpr.beans.Comentario;
import br.com.utfpr.beans.Monitor;
import br.com.utfpr.beans.Professor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2017-05-28T01:17:44")
@StaticMetamodel(Curtir.class)
public class Curtir_ { 

    public static volatile SingularAttribute<Curtir, Integer> id;
    public static volatile SingularAttribute<Curtir, Monitor> monitor;
    public static volatile SingularAttribute<Curtir, Aluno> aluno;
    public static volatile SingularAttribute<Curtir, Professor> professor;
    public static volatile SingularAttribute<Curtir, Comentario> comentario;

}