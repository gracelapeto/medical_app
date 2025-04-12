package org.example.daos;

import org.example.config.HibernateUtils;
import org.example.entities.Appointment;
import org.example.static_data.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AppointmentDao {

    private final Session session;

    public AppointmentDao() {
        this.session = new HibernateUtils().getSessionFactory().openSession();
    }

    public Appointment save(Appointment appointment) {
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(appointment);
            transaction.commit();
            return appointment;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Nuk u regjistrua takimi: " + e.getMessage());
        }
    }

    public List<Appointment> findAll() {
        return session.createQuery("FROM Appointment", Appointment.class).getResultList();
    }

    public List<Appointment> findByPatientId(Long patientId) {
        String hql = "FROM Appointment a WHERE a.patient.id = :pid";
        return session.createQuery(hql, Appointment.class)
                .setParameter("pid", patientId)
                .getResultList();
    }

    public List<Appointment> findByDoctorId(Long doctorId) {
        String hql = "FROM Appointment a WHERE a.doctor.id = :did";
        return session.createQuery(hql, Appointment.class)
                .setParameter("did", doctorId)
                .getResultList();
    }

    public void updateStatus(Long appointmentId, Status newStatus) {
        Transaction tx = session.beginTransaction();
        try {
            Appointment appointment = session.find(Appointment.class, appointmentId);
            if (appointment == null) throw new RuntimeException("Takimi nuk u gjet.");
            appointment.setStatus(newStatus);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new RuntimeException("Nuk u përditësua statusi: " + e.getMessage());
        }
    }

    public void cancelAppointment(Long appointmentId) {
        Transaction tx = session.beginTransaction();
        try {
            Appointment appointment = session.find(Appointment.class, appointmentId);
            if (appointment == null) throw new RuntimeException("Takimi nuk u gjet.");
            appointment.setStatus(Status.ANULLUAR);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new RuntimeException("Nuk u anulua takimi: " + e.getMessage());
        }
    }

    public void delete(Long id) {
        Transaction tx = session.beginTransaction();
        try {
            Appointment appointment = session.find(Appointment.class, id);
            if (appointment != null) session.remove(appointment);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new RuntimeException("Nuk u fshi takimi: " + e.getMessage());
        }
    }

    public List<Appointment> findByStatus(Status status) {
        String hql = "FROM Appointment a WHERE a.status = :status";
        return session.createQuery(hql, Appointment.class)
                .setParameter("status", status)
                .getResultList();
    }

    public List<Appointment> listAppointmentsByPatientId(Long patientId) {
        String hql = "FROM Appointment a WHERE a.patient.id = :patientId";
        return session.createQuery(hql, Appointment.class)
                .setParameter("patientId", patientId)
                .getResultList();
    }

    public List<Appointment> listAppointmentsByDoctorId(Long doctorId) {
        String hql = "FROM Appointment a WHERE a.doctor.id = :doctorId";
        return session.createQuery(hql, Appointment.class)
                .setParameter("doctorId", doctorId)
                .getResultList();
    }
    }
