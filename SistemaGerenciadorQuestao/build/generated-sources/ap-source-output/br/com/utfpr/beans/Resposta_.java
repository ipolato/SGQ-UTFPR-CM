package br.com.utfpr.beans;

import br.com.utfpr.beans.Aluno;
import br.com.utfpr.beans.Questao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2017-05-28T01:17:44")
@StaticMetamodel(Resposta.class)
public class Resposta_ { 

    public static volatile SingularAttribute<Resposta, Integer> id;
    public static volatile SingularAttribute<Resposta, Boolean> certa;
    public static volatile SingularAttribute<Resposta, String> status;
    public static volatile SingularAttribute<Resposta, Aluno> aluno;
    public static volatile SingularAttribute<Resposta, String> conteudo;
    public static volatile SingularAttribute<Resposta, Questao> questao;
    public static volatile SingularAttribute<Resposta, Integer> quantidadeDeCurtida;

}