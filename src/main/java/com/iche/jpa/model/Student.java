package com.iche.jpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name="tbl_students",
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unique",
                columnNames= "email_address"
        )
)
@Data
@ToString
public class Student {

    @Id
    @SequenceGenerator(
            name= "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    @Column(name="first_name", nullable = false)
    private String firstName;
    private String lastName;
    @Column(name="email_address", nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;
}
