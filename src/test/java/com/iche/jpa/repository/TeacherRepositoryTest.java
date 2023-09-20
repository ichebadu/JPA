package com.iche.jpa.repository;

import com.iche.jpa.model.Course;
import com.iche.jpa.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseJava = Course.builder()
                .title("DSA")
                .credit(5)
                .build();

        Course courseJavaEE = Course.builder()
                .title("JavaEE")
                .credit(5)
                .build();

        Course courseFX  = Course.builder()
                .title("courseJava")
                .credit(5)
                .build();

        Course courseSpringBoot = Course.builder()
                .title("DSA")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .emailId("teach@gmail.com")
                .firstName("jazz")
                .lastName("maniche")
     //           .course(List.of(courseJava,courseJavaEE,courseSpringBoot,courseFX))
                .build();
        teacherRepository.save(teacher);
    }


}