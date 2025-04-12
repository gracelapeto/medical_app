package org.example.daos;

import org.example.entities.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import java.time.LocalDate;

public class PaymentDao {

    private final Session session;

    public PaymentDao(Session session) {
        this.session = session;
    }

    public Payment save(Payment payment) {
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(payment);
            transaction.commit();
            return payment;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Nuk u regjistrua pagesa: " + e.getMessage(), e);
        } finally {
            session.close();
        }
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

    public List<Payment> findAll() {
        return session.createQuery("FROM Payment", Payment.class)
                .getResultList();
    }
}