package com.repository;

import com.model.ServicoImovel;
import com.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ServicoImovelRepository {

    public void save(ServicoImovel servicoImovel) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(servicoImovel);
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

    public void update(ServicoImovel servicoImovel) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(servicoImovel);
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

    public ServicoImovel findById(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(ServicoImovel.class, id);
        } finally {
            em.close();
        }
    }

    public List<ServicoImovel> findByImovel(int imovelId) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT s FROM ServicoImovel s WHERE s.imovel.id = :imovelId", ServicoImovel.class)
                    .setParameter("imovelId", imovelId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<ServicoImovel> findByProfissional(int profissionalId) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT s FROM ServicoImovel s WHERE s.profissional.id = :profissionalId", ServicoImovel.class)
                    .setParameter("profissionalId", profissionalId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<ServicoImovel> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("FROM ServicoImovel", ServicoImovel.class).getResultList();
        } finally {
            em.close();
        }
    }
}
