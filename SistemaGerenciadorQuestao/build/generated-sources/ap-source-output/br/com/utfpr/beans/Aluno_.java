package br.com.utfpr.beans;

import br.com.utfpr.beans.Comentario;
import br.com.utfpr.beans.Disciplina;
import br.com.utfpr.beans.Monitor;
import br.com.utfpr.beans.Resposta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2017-05-28T01:17:44")
@StaticMetamodel(Aluno.class)
public class Aluno_ extends Pessoa_ {

    public static volatile SingularAttribute<Aluno, Disciplina> disciplina;
    public static volatile SingularAttribute<Aluno, Monitor> monitor;
    public static volatile ListAttribute<Aluno, Resposta> respostas;
    public static volatile SingularAttribute<Aluno, Integer> medLiv;
    public static volatile ListAttribute<Aluno, Comentario> comentarios;
    public static volatile SingularAttribute<Aluno, String> game;
    public static volatile SingularAttribute<Aluno, Integer> medCom;
    public static volatile SingularAttribute<Aluno, Integer> pontosDeExperiencia;
    public static volatile SingularAttribute<Aluno, Integer> treEst;
    public static volatile SingularAttribute<Aluno, Integer> umaEst;
    public static volatile SingularAttribute<Aluno, Integer> possuiLevel;
    public static volatile SingularAttribute<Aluno, Integer> duaEst;
    public static volatile SingularAttribute<Aluno, Integer> medal;
    public static volatile SingularAttribute<Aluno, Date> tempoPermanecido;

}