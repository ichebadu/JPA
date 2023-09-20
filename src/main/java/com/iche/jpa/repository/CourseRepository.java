package com.iche.jpa.repository;

import com.iche.jpa.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findByTitleContaining(
            String title,
            Pageable pageable);
}
