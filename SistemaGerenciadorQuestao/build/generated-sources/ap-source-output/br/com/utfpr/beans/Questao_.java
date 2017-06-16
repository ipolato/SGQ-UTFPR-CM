package br.com.utfpr.beans;

import br.com.utfpr.beans.Comentario;
import br.com.utfpr.beans.Disciplina;
import br.com.utfpr.beans.Resposta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2017-05-28T01:17:44")
@StaticMetamodel(Questao.class)
public class Questao_ { 

    public static volatile SingularAttribute<Questao, Integer> id;
    public static volatile SingularAttribute<Questao, Disciplina> disciplina;
    public static volatile SingularAttribute<Questao, String> titulo;
    public static volatile ListAttribute<Questao, Resposta> respostas;
    public static volatile SingularAttribute<Questao, String> status;
    public static volatile ListAttribute<Questao, Comentario> comentarios;
    public static volatile SingularAttribute<Questao, String> conteudo;
    public static volatile SingularAttribute<Questao, Date> data_inicio;
    public static volatile SingularAttribute<Questao, Date> data_final;
    public static volatile SingularAttribute<Questao, Boolean> aberta;

}