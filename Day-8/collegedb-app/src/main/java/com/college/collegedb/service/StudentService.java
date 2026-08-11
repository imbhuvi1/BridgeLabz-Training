package com.college.collegedb.service;

import com.college.collegedb.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Integer id);

    List<StudentDTO> getAllStudents();

    List<StudentDTO> getStudentsByDepartment(String department);

    StudentDTO updateStudent(Integer id, StudentDTO studentDTO);

    void deleteStudent(Integer id);
}
