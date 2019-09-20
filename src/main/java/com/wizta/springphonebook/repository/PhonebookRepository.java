package com.wizta.springphonebook.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wizta.springphonebook.model.Phonebook;

@Repository
public class PhonebookRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Phonebook get(int PersonID) {
        Phonebook phonebook = entityManager.getReference(Phonebook.class, PersonID);
        return phonebook;
    }


    public List<Phonebook> getAll() {
        Query query = entityManager.createQuery("select p from Phonebook p",
                Phonebook.class);
        return query.getResultList();
    }


    public void add(Phonebook phonebook) {
        entityManager.persist(phonebook);
    }


    public void remove(Phonebook phonebook) {
        entityManager.remove(phonebook);
    }
}
