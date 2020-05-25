package com.poly.api.repository.repositoryImpl;

import com.poly.api.entities.Desicion;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class DesicionRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Desicion desicion){
        Session session = entityManager.unwrap(Session.class);
        session.save(desicion);
    }
}
