package org.example.daos;
import org.hibernate.Session;
import java.util.List;

public class DoctorPerformancDao {

        private final Session session;

    public DoctorPerformancDao(Session session) {
        this.session = session;
    }

    public List<Object[]> getDoctorPatientCount() {
            String query= "SELECT d.firstName, d.lastName, COUNT(apointment.patient.id) " +
                    "FROM Appointment apointment " +
                    "JOIN apointment.doctor d " +
                    "GROUP BY d.id";
            return session.createQuery(query, Object[].class).getResultList();
        }
    }
