package com.protosstechnology.train.bootexamine.impl.UserServiceByJpqlImpl;

import com.protosstechnology.train.bootexamine.Entity.Document;
import com.protosstechnology.train.bootexamine.service.DocumentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DocumentServiceByJpqlImpl implements DocumentService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Document user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public Document read(Long id) {

        return (Document) entityManager.createQuery("SELECT u FROM Document u WHERE u.id = :id")
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public Document update(Document user) {
        entityManager.createQuery("UPDATE User u SET u.Description =: description ,"+
                "u.DocumentNumber = :documentNumber" +
                "WHERE u.id = :id")
                .setParameter("Description",user.getDescription())
                .setParameter("DocumentNumber",user.getDocumentNumber())
                .setParameter("id",user.getId())
                .executeUpdate();
        return read(user.getId());
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("DELETE Document u"+
                "WHERE u.id = :id")
                .setParameter("id",id)
                .executeUpdate();
    }
}
