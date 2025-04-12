package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    private Double amount;
    private String description;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
