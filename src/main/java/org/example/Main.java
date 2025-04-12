package org.example;

import org.example.config.HibernateUtils;
import org.example.daos.AppointmentDao;
import org.example.daos.DoctorDao;
import org.example.daos.PaymentDao;
import org.example.entities.*;
import org.example.static_data.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HibernateUtils hibernateUtils=new HibernateUtils();
        SessionFactory sessionFactory= hibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();

//      try {
//        DoctorDao doctorDao = new DoctorDao(session);
//        Patient patient = new Patient();
//        patient.setFirstName("Ardit");
//        patient.setLastName("Hoxha");
//        patient.setBirthDate(LocalDate.of(1995, 4, 10));
//        patient.setNid(123456789L);
//        patient.setContactInfo(355682345678L);
//        patient.setMedicalHistory("Asnjë alergji");
//
//        Doctor doctor = new Doctor();
//        doctor.setFirstName("Elira");
//        doctor.setLastName("Shehu");
//        doctor.setSpecialization("Kardiolog");
//        doctor.setContactInfo(355682345123L);
//        doctor.setStartWorkAt(LocalTime.of(8, 0));
//        doctor.setEndWorkAt(LocalTime.of(16, 0));
//
//        session.beginTransaction();
//        session.persist(patient);
//        session.persist(doctor);
//        session.getTransaction().commit();
//
//        Appointment appointment = new Appointment();
//        appointment.setAppointmentTime(LocalDateTime.now().plusDays(1));
//        appointment.setPurpose("Kontroll zemre");
//        appointment.setStatus(Status.AKTIV);
//        appointment.setPatient(patient);
//        appointment.setDoctor(doctor);
//
//        AppointmentDao appointmentDao = new AppointmentDao();
//        appointmentDao.save(appointment);
//
//        Payment payment = new Payment();
//        payment.setPatient(patient);
//        payment.setAmount(50.0);
//        payment.setPaymentDate(LocalDate.now());
//        payment.setDescription("Pagesë për vizitë");
//
//        PaymentDao paymentDao = new PaymentDao(session);
//        paymentDao.save(payment);
//
//        System.out.println("Të dhënat u regjistruan me sukses!");
//
//
//        PatientDao patientDao = new PatientDao(session);
//
//
//        Patient patient = new Patient();
//        patient.setFirstName("Miri");
//        patient.setLastName("Zace");
//        patient.setBirthDate(LocalDate.of(1990, 5, 15));
//        patient.setNid(123456789L);
//        patient.setContactInfo(9876543210L);
//        patient.setMedicalHistory("No medical history");
//
//        patientDao.save(patient);
//
//        List<Patient> allPatients = patientDao.findAll();
//        for (Patient p : allPatients) {
//            System.out.println(p.getFirstName() + " " + p.getLastName());
//        }
//
//        PrescriptionDao prescriptionDao = new PrescriptionDao();
//
//
//        Prescription prescription = new Prescription();
//        prescription.setPrescriptionDate(LocalDate.now());
//        prescription.setMedicines("Ibuprofen");
//
//        prescriptionDao.issuePrescription(prescription);
//
//        List<Prescription> prescriptions = prescriptionDao.getPrescriptionsByPatient(patient.getId());
//        for (Prescription presc : prescriptions) {
//            System.out.println(presc.getMedicines());
//        }

    }
}
