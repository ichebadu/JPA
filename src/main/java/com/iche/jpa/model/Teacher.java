package com.iche.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name="tbl_teachers",
        uniqueConstraints = @UniqueConstraint(
                name = "emailId",
                columnNames= "email_address"
        )
)
public class Teacher {
    @Id
    @SequenceGenerator(
            name= "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    @Column(name="first_name", nullable = false)
    private String firstName;
    private String lastName;
    @Column(name="email_address", nullable = false)
    private String emailId;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private List<Course> course;
}
