package org.example.daos;

import org.example.entities.Patient;
import org.hibernate.SessionFactory;

public class PatientDao {
    private SessionFactory sessionFactory;

    public PatientDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }


}
