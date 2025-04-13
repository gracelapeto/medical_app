package org.example.daos;

import org.example.entities.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PatientDao extends GenericDao<Patient,Long> {
    private Session session;
    private Transaction transaction;

    public PatientDao(Session session) {
        super(session,Patient.class);
        this.session=session;


    }
    public Patient save(Patient patient){

        return super.save(patient);
    }
    public List<Patient> findAll(){

        return super.findAll();
    }
    public Patient findById(Long id){
        return super.findById(id);

    }
    public Patient update(Patient patient){
        Patient existingPatient = super.findById(patient.getId());
        if(existingPatient!=null){
            existingPatient.setBirthDate(patient.getBirthDate());
            existingPatient.setContactInfo(patient.getContactInfo());
            existingPatient.setMedicalHistory(patient.getMedicalHistory());
            existingPatient.setFirstName(patient.getFirstName());
            existingPatient.setLastName(patient.getLastName());
            return super.save(existingPatient);
        }else {
            throw new RuntimeException("Patient not found");
        }
    }
    public void delete(Long id){
        super.delete(id);
    }
    public List<Patient> findByFirstName(String firstName){
        String findByName = "from Patient p where lower(p.firstName) like" +
                " :name ";
        return session.createQuery(findByName, Patient.class).setParameter
                ("name", "%"+firstName.toLowerCase()+"%").getResultList();
    }
    public List<Patient> findBySurname(String surname){
        String findBySurname = "from Patient p where p.lastName like :surname";
        return session.createQuery(findBySurname, Patient.class)
                .setParameter("surname" , "%" +surname + "%").getResultList();
    }
    public List<Patient> findByContact(String contact){
        String findByContact = "from Patient p where p.contactInfo like :contact";
        return session.createQuery(findByContact, Patient.class)
                .setParameter("contact", "%" + contact + "%")
                .getResultList();
    }

}
