package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "presciptions")
@Data
public class Presciption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "prescription_date")
    private LocalDate prescriptionDate;
    private String medicines;
    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}
