package com.iche.jpa.repository;

import com.iche.jpa.model.Course;
import com.iche.jpa.model.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("SpringBootAZ")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("https://springboot.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }



}