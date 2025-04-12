package org.example.daos;

import org.example.entities.Doctor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalTime;
import java.util.List;

public class DoctorDao extends GenericDao<Doctor, Long> {

    private final Session session;
    private Transaction transaction;

    public DoctorDao(Session session) {
        super(session, Doctor.class);
        this.session = session;
    }

    public Doctor saveDoctor(String firstName, String lastName, String specialization, String contactInfo) {
        transaction = session.beginTransaction();
        try {
            Doctor doctor = new Doctor();
            doctor.setFirstName(firstName);
            doctor.setLastName(lastName);
            doctor.setSpecialization(specialization);
            doctor.setContactInfo(Long.valueOf(contactInfo));
            session.persist(doctor);
            transaction.commit();
            Doctor savedDoctor = session.merge(doctor);
            transaction.commit();
            return savedDoctor;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }
    public void setOrUpdateWorkSchedule(Long doctorId, String startWorkAt) {
        try {
            session.getTransaction().begin();
            Doctor doctor = session.find(Doctor.class, doctorId);
            if (doctor == null) throw new RuntimeException("Mjeku nuk u gjet.");
            doctor.setStartWorkAt(LocalTime.parse(startWorkAt));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
    public Doctor update(Doctor doctor) {
        transaction = session.beginTransaction();
        try {
            Doctor updatedDoctor = session.merge(doctor);
            transaction.commit();
            return updatedDoctor;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }
    public List<Doctor> findBySpecialization(String specialization) {
        String hql = "FROM Doctor d WHERE d.specialization LIKE :spec";
        return session.createQuery(hql, Doctor.class)
                .setParameter("spec", "%" + specialization + "%")
                .getResultList();
    }

    public void delete(Long id) {
        super.delete(id);
    }
    public List<Doctor> findAll() {
        return super.findAll();
    }
    public Doctor findById(Long id) {
        return super.findById(id);
    }
}