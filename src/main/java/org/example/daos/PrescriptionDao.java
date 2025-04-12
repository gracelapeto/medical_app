package org.example.daos;

import org.example.entities.Appointment;

import org.example.entities.Prescription;
import org.example.static_data.Status;
import org.hibernate.Session;

import java.util.List;

public class PrescriptionDao extends GenericDao<Prescription,Long> {

    private final Session session;
    private final AppointmentDao appointmentDao;

    public PrescriptionDao(Session session, AppointmentDao appointmentDao) {
        super(session, Prescription.class);
        this.session = session;
        this.appointmentDao = appointmentDao;
    }

    public Prescription issuePrescription(Prescription prescription, Long appointmentId)  {
        Appointment appointment = appointmentDao.findById(appointmentId);
        appointment.setStatus(Status.PERFUNDUAR);
        appointmentDao.save(appointment);
        prescription.setAppointment(appointment);
        return super.save(prescription);

        }
    public List<Prescription> getPrescriptionsByPatient(Long patientId) {
            List<Prescription> presciptions= session.createQuery(
                    "FROM Prescription p WHERE p.appointment.patient.id = :pid", Prescription.class)
                    .setParameter("pid", patientId)
                    .list();
            return presciptions;

    }



    }


