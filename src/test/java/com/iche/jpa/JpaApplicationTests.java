package com.iche.jpa;

import com.iche.jpa.model.Guardian;
import com.iche.jpa.model.Student;
import com.iche.jpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaApplicationTests {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void saveStudent(){
        Guardian guardians = Guardian.builder()
                .email("dian@gmail.com")
                .name("gadian1")
                .mobile("09054039534")
                .build();


        Student student = Student.builder()
                .emailId("cuwu.iche@gmail.com")
                .firstName("che")
                .lastName("cuu")
                .guardian(guardians)
                .build();
        Student students = studentRepository.save(student);
        System.out.println(" saveStudent()  +   >>>>>>>>>>>>>>>>>>>>>"+ students);
    }
    @Test
    public void printAllStudent(){
        List<Student> student = studentRepository.findAll();
        System.out.println(" printAllStudent() +list of student : " + student);
    }
    @Test
    public void printStudentFirstName(){
        List<Student> firstName = studentRepository.findByFirstName("ichebadu");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>" +firstName);
    }
    @Test
    public void printStudentFirstNameContaining(){
        List<Student> firstName = studentRepository.findByFirstNameContaining("iche");
        System.out.println(" printStudentFirstNameContaining() >>>>>>>>>>>>>>> " + firstName);
    }
    @Test
    public void  findByGuardianName(){
        List<Student> guardianName = studentRepository.findByGuardianName("guardian1");
        System.out.println(" printStudentFirstNameContaining() >>>>>>>>>>>>>>> " + guardianName);

    }

    @Test
    public void  findByFirstNameAndAndLastName(){
        Student firstNameAndAndLastName = studentRepository.findByFirstNameAndAndLastName("ichebadu","chukwu");
        System.out.println(" printStudentFirstNameContaining() >>>>>>>>>>>>>>> " + firstNameAndAndLastName);

    }
    @Test
    public void  getStudentByEmailAddress(){
        Student getEmailAddress = studentRepository.getStudentByEmailAddress("chukwu.iche@gmail.com");
        System.out.println(" getStudentByEmailAddress() >>>>>>>>>>>>>>> " + getEmailAddress);
    }
    @Test
    public void  getFirstNameByEmailAddress(){
        String firstNameByEmailAddress = studentRepository.getFirstNameByEmailAddress("chukwu.iche@gmail.com");
        System.out.println(" getFirstNameByEmailAddress() >>>>>>>>>>>>>>> " + firstNameByEmailAddress);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student studentByEmailAddressNative = studentRepository.getStudentByEmailAddressNative("chukwu.iche@gmail.com");
        System.out.println(" studentByEmailAddressNative() >>>>>>>>>>>>>>> " + studentByEmailAddressNative);
    }
    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
        Student studentByEmailAddressNativeNamedParam = studentRepository.getStudentByEmailAddressNativeNamedParam("chukwu.iche@gmail.com");
        System.out.println(" studentByEmailAddressNativeNamedParam() >>>>>>>>>>>>>>> " + studentByEmailAddressNativeNamedParam);
    }

    @Test
    public void updateFirstNameAndEmailAddress(){
        studentRepository.updateFirstNameAndEmailAddress("ichebadu", "chukwu.iche@gmail.com");

        System.out.println(">>>>>>>>>  getFirstNameAndEmailAddress  >>>>>>>>>>");
    }

}

