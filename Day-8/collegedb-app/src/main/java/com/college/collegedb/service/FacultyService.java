package com.college.collegedb.service;

import com.college.collegedb.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {

    FacultyDTO createFaculty(FacultyDTO facultyDTO);

    FacultyDTO getFacultyById(Integer id);

    List<FacultyDTO> getAllFaculty();

    List<FacultyDTO> getFacultyByDepartment(String department);

    FacultyDTO updateFaculty(Integer id, FacultyDTO facultyDTO);

    void deleteFaculty(Integer id);
}
