package com.repository;

import com.model.Locacao;
import com.model.Imovel;
import com.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;

public class LocacaoRepository {

    public void save(Locacao locacao) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;
        try {
            if (!imovelAtivo(locacao.getImovel())) {
                throw new IllegalStateException("Imóvel não está disponível para locação.");
            }
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(locacao);
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

    public void update(Locacao locacao) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(locacao);
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

    public List<Locacao> findByCliente(int clienteId) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT l FROM Locacao l WHERE l.cliente.id = :clienteId", Locacao.class)
                    .setParameter("clienteId", clienteId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public boolean imovelAtivo(Imovel imovel) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery(
                    "SELECT COUNT(l) FROM Locacao l WHERE l.imovel.id = :imovelId AND l.dataFim >= CURRENT_DATE AND l.ativo = true");
            query.setParameter("imovelId", imovel.getId());
            Long count = (Long) query.getSingleResult();
            return count == 0;
        } finally {
            em.close();
        }
    }
}

