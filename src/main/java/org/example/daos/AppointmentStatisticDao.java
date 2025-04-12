package org.example.daos;

import org.hibernate.Session;

import java.time.LocalDateTime;

public class AppointmentStatisticDao {

        private final Session session;

        public AppointmentStatisticDao(Session session) {
            this.session = session;
        }

        public long countVisitsInPeriod(LocalDateTime startDate, LocalDateTime endDate) {
            String hql = "SELECT COUNT(a) FROM Appointment a WHERE a.appointmentTime" +
                    " BETWEEN :startDate AND :endDate";
            return (Long) session.createQuery(hql)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .uniqueResult();
        }
    }

