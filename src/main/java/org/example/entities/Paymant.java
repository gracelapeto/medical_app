package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paymants")
@Data

public class Paymant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "paymant_date")
    private LocalDate paymantDate;
    private Double amount;
    private String description;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
