package org.example.config;

import org.example.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private SessionFactory sessionFactory;
    public  SessionFactory getSessionFactory(){
        if (sessionFactory==null){
            Configuration configuration=new Configuration();//perdorimi i single tonit ne kte bllok  lidhja me datbasen
            configuration.addAnnotatedClass(Appointment.class);
            configuration.addAnnotatedClass(Doctor.class);
            configuration.addAnnotatedClass(Patient.class);
            configuration.addAnnotatedClass(Payment.class);
            configuration.addAnnotatedClass(Prescription.class);
            sessionFactory =configuration.buildSessionFactory();

        }
        return this.sessionFactory;
    }
}
