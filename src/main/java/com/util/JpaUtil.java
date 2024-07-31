package com.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("lab_jpa");

    public static EntityManager getEntityManager() {
        return em.createEntityManager();
    }

    public static void close() {
        em.close();
    }
}
