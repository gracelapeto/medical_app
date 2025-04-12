package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(unique = true)//nuk mund te ket dy pacient me te njejtin Nid
    private Long nid;
    @Column(name = "contact_info")
    private Long contactInfo;
    @Column(name = "medical_history")
    private String medicalHistory;
}
