package com.college.collegedb.repository;

import com.college.collegedb.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    Optional<Faculty> findByEmail(String email);

    List<Faculty> findByDepartment(String department);
}
