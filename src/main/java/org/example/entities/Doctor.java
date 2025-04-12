package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Table(name = "doctors")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String specialization;
    @Column(name = "contact_info")
    private Long contactInfo;
    @Column(name = "start_work_at")
    private LocalTime startWorkAt;
    @Column(name = "end_work_at")
    private LocalTime endWorkAt;
}
