package org.example.daos;

import org.hibernate.Session;

import java.util.List;

public class PrescriptionStatisticDao {

        private final Session session;

    public PrescriptionStatisticDao(Session session) {
        this.session = session;
    }
        public List<Object[]> getMostPrescribedMedicines() {
            String hql = "SELECT p.medicines, COUNT(p) " +
                    "FROM Prescription p " +
                    "GROUP BY p.medicines " +
                    "ORDER BY COUNT(p) DESC";
            return session.createQuery(hql, Object[].class).getResultList();
        }
    }

