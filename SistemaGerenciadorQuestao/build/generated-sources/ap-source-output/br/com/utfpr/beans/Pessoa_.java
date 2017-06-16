package br.com.utfpr.beans;

import br.com.utfpr.beans.Curtir;
import br.com.utfpr.beans.Imagem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2017-05-28T01:17:44")
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, Integer> id;
    public static volatile ListAttribute<Pessoa, Curtir> quantDecurtidas;
    public static volatile SingularAttribute<Pessoa, Imagem> imagem;
    public static volatile SingularAttribute<Pessoa, String> email;
    public static volatile SingularAttribute<Pessoa, String> tipo;
    public static volatile SingularAttribute<Pessoa, String> RA;
    public static volatile SingularAttribute<Pessoa, Boolean> sexo;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Date> dtNascimento;
    public static volatile SingularAttribute<Pessoa, String> senha;

}