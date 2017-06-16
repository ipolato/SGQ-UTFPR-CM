package br.edu.utfpr.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Dao<T> {

    private Class<T> classe;

    public Dao(Class classe) {
        this.classe = classe;
    }

    public void adiciona(T entity) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public void edit(T entity) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public T get(int id) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        T entity = (T) em.find(classe, id);
        em.flush();
        em.close();
        return entity;
    }

    public void removePorId(int id) {
        EntityManager em = new JPAUtil().getEntityManager();
        T entity = get(id);
        if (entity == null) {
            return;
        }
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
        em.flush();
        em.close();
    }

    public void remove(T entity) {
        EntityManager em = new JPAUtil().getEntityManager();
        if (entity == null) {
            return;
        }
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.flush();
        em.close();
    }

    public List<T> listaTodos() {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        List<T> lista = em.createQuery("FROM " + classe.getSimpleName()).getResultList();
        em.flush();
        em.close();
        
        return lista;
    }

    public List<T> listaOsDezMelhor() {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        List<T> lista = em.createQuery("FROM " + classe.getSimpleName() + " where game like 'S' order by pontosDeExperiencia desc limit 10").getResultList();
        em.flush();
        em.close();
        return lista;
    }

    public T recuperaImagem(int codigo) throws SQLException {
        String sql = "FROM " + classe.getSimpleName() + " where cd_imagem = '" + codigo + "'";
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        T entity = (T) em.createQuery(sql).getResultList().get(0);
        em.flush();
        em.close();
        return entity;
    }

//    public List<T> listaTodosDoComentario(int id) {
//        EntityManager em = new JPAUtil().getEntityManager();
//        return em.createQuery("FROM " + classe.getSimpleName() + " c WHERE c.comentario = '" + id + "'").getResultList();
//    }
//    
//    public List<T> listaTodosQueCurtiu(int id) {
//        EntityManager em = new JPAUtil().getEntityManager();
//        return em.createQuery("FROM " + classe.getSimpleName() + " c WHERE c.aluno = '" + id + "'").getResultList();
//    }
    public T buscaPorId(int id) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        T entity = get(id);
        em.flush();
        em.close();
        return entity;
    }

    public List<T> buscaPorLogin(String login) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("FROM " + classe.getSimpleName() + " WHERE RA LIKE '%" + login + "%'");
        em.flush();
        em.close();
        return q.getResultList();
    }

    public List<T> buscaTodosDaDisciplina(int id) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("FROM " + classe.getSimpleName() + " WHERE disciplina_id = '" + id + "'");
        em.flush();
        em.close();
        return q.getResultList();
    }

    public T buscandoId(int id) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        T entity = (T) em.createQuery("FROM " + classe.getSimpleName() + " WHERE id = '" + id + "'").getResultList().get(0);
        em.flush();
        em.close();
        return entity;
    }

    public T buscandoPorQuestao(int id_aluno, int id_questao) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        try {
            T entity = (T) em.createQuery("FROM " + classe.getSimpleName() + " WHERE aluno_id = '" + id_aluno + "' AND questao_id = '" + id_questao + "'").getResultList().get(0);
            em.flush();
            em.close();
            return entity;
        } catch (Exception e) {
            e.getMessage();
        }
        em.flush();
        em.close();
        return null;
    }

    public List<T> buscaPorNomeDoArquivo(String nomeArquivo) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("FROM imagem WHERE ds_arquivo LIKE '%" + nomeArquivo + "%'");
        em.flush();
        em.close();
        return q.getResultList();
    }

    public T buscaUltimoId() {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("FROM " + classe.getSimpleName() + " ORDER BY data DESC limit 1");
        T instancia = (T) q.getResultList().get(0);
        em.flush();
        em.close();
        return instancia;
    }

    public List<T> listaPorId(int parametro) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("FROM " + classe.getSimpleName() + " WHERE id = " + parametro);
        em.flush();
        em.close();
        return q.getResultList();
    }

    public List<T> listNome(String nome) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("FROM " + classe.getSimpleName() + " WHERE nome LIKE '%" + nome + "%'");
        em.flush();
        em.close();
        return q.getResultList();
    }

    public List<T> listFila(String condicao) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("FROM cliente inner join instalacao \n"
                + "on instalacao.id = cliente.instalacao_id and instalacao.situação LIKE '%" + condicao + "%'");
        em.flush();
        em.close();
        return q.getResultList();
    }

    public void update(T entity) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public void Metodo() {
    }
}
