package org.example.daos;

import org.example.entities.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import java.time.LocalDate;

public class PaymentDao extends GenericDao<Payment, Long>{

    private final Session session;
    private Transaction transaction;

    public PaymentDao(Session session) {
        super(session, Payment.class);
        this.session = session;
    }

    public Payment save(Payment payment) {
       return super.save(payment);
    }
    public List<Payment> findAll() {
        return super.findAll();
    }
    public  Payment findById(Long id) {
        return super.findById(id);
    }

    public List<Payment> findByPatientId(Long patientId) {
        String hql = "FROM Payment p WHERE p.patient.id = :pid";
        return session.createQuery(hql, Payment.class)
                .setParameter("pid", patientId)
                .getResultList();
    }

    public List<Payment> findPaymentsForInvoice(Long patientId, LocalDate startDate, LocalDate endDate) {
        String hql = "FROM Payment p WHERE p.patient.id = :pid AND p.paymentDate BETWEEN " +
                ":startDate AND :endDate";
        return session.createQuery(hql, Payment.class)
                .setParameter("pid", patientId)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    public List<Payment> findByDateRange(LocalDate startDate, LocalDate endDate) {
        String hql = "FROM Payment p WHERE p.paymentDate BETWEEN :startDate AND :endDate";
        return session.createQuery(hql, Payment.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

}