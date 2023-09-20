package com.iche.jpa.repository;

import com.iche.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String name);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardian1);
    Student findByFirstNameAndAndLastName(String firstName, String lastName);

    // Jpa Query , it uses the class not the table
    @Query(" select p from Student p where p.emailId = ?1")
    Student getStudentByEmailAddress(String email);
    @Query(" select p.firstName from Student p where p.emailId = ?1")
    String getFirstNameByEmailAddress(String email);

    //native sql query
    @Query(
            value = "SELECT * FROM tbl_students s where s.email_address = ?1",
            nativeQuery = true )
    Student getStudentByEmailAddressNative(String emailId);

    //Native Named param
    @Query(
            value = "SELECT * FROM tbl_students s where s.email_address = :emailId",
            nativeQuery = true )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId")String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_students set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateFirstNameAndEmailAddress(String firstName, String email_address);
}
