package com.iche.jpa.repository;

import com.iche.jpa.model.Course;
import com.iche.jpa.model.Student;
import com.iche.jpa.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse(){
        Course course = Course.builder()
                .title("SpringBootAZ")
                .credit(6)
                .build();
        courseRepository.save(course);
    }
    @Test
    public void printCourse(){
        List<Course> courses= courseRepository.findAll();
        System.out.println("course  = + course" + courses);
    }
    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("ekaw")
                .lastName("plea")
                .emailId("some@gmail.com")
                .build();

        Course course = Course.builder()
                .title("css")
                .credit(5)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
    @Test
    public void findAllPagination(){
        PageRequest firstPageWithThreeRecords = PageRequest.of(0,3);
        PageRequest secondPageWithTwoRecord = PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        System.out.println(">>>>>>>>>>>>>>  TotalElements   >>>>>>>>courses" + totalElements);

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println(">>>>  TotalPages >>>>>>>>" + totalPages);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByCredit =
                PageRequest.of(
                        1,
                        2,
                        Sort.by("credit")
                        .descending()
                );

        Pageable sortByTitle = PageRequest.of(2,
                3,
                Sort.by("title")
        );

        Pageable sortByTitleAndCredit = PageRequest.of(
                3,
                3,
                Sort.by("title")
                .descending()
                .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository.findAll(sortByCredit).getContent();

        System.out.println("sortByTitle >>>>>> " + courses);

    }

    @Test
    public void  findByTitleContaining(){
        Pageable firstPageTenRecord = PageRequest.of(
                0, 10
        );

        List<Course> courses = courseRepository
                .findByTitleContaining
                        ("py",firstPageTenRecord).getContent();

        System.out.println("course: " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .emailId("nami@gmail.com")
                .firstName("kenna")
                .lastName("nwakwala")
                .build();

        Student student = Student.builder()
                .emailId("en@gmail.com")
                .firstName("jmms")
                .lastName("ned")
                .build();

        Course course = Course
                .builder()
                .title("Java")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student);
        courseRepository.save(course);
    }

}