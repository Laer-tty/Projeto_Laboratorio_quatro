package com.repository;

import com.model.Aluguel;
import com.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AluguelRepository {

    public void save(Aluguel aluguel) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(aluguel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void update(Aluguel aluguel) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(aluguel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Aluguel findById(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(Aluguel.class, id);
        } finally {
            em.close();
        }
    }

    public List<Aluguel> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("FROM Aluguel", Aluguel.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Aluguel> findByInquilino(String nomeInquilino) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            String queryStr = "SELECT a FROM Aluguel a JOIN a.locacao l JOIN l.cliente c WHERE c.nome = :nome";
            TypedQuery<Aluguel> query = em.createQuery(queryStr, Aluguel.class);
            query.setParameter("nome", nomeInquilino);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Aluguel> findByPrecoLimite(BigDecimal limitePreco) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            String queryStr = "SELECT a FROM Aluguel a JOIN a.locacao l JOIN l.imovel i WHERE i.valorAlugelSugerido <= :limitePreco AND a.locacao.ativo = TRUE";
            TypedQuery<Aluguel> query = em.createQuery(queryStr, Aluguel.class);
            query.setParameter("limitePreco", limitePreco);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Aluguel> findAluguelAtrasado() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            String queryStr = "SELECT a FROM Aluguel a WHERE a.dataPagamento IS NOT NULL AND a.dataPagamento > a.dataVencimento";
            TypedQuery<Aluguel> query = em.createQuery(queryStr, Aluguel.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
