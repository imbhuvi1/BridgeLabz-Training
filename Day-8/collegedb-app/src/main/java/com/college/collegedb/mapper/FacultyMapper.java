package com.college.collegedb.mapper;

import com.college.collegedb.dto.FacultyDTO;
import com.college.collegedb.entity.Faculty;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapper {

    public FacultyDTO toDTO(Faculty faculty) {
        if (faculty == null) {
            return null;
        }
        FacultyDTO dto = new FacultyDTO();
        dto.setFacultyId(faculty.getFacultyId());
        dto.setFirstName(faculty.getFirstName());
        dto.setLastName(faculty.getLastName());
        dto.setGender(faculty.getGender());
        dto.setEmail(faculty.getEmail());
        dto.setAddress(faculty.getAddress());
        dto.setCity(faculty.getCity());
        dto.setState(faculty.getState());
        dto.setDepartment(faculty.getDepartment());
        dto.setDesignation(faculty.getDesignation());
        dto.setJoiningYear(faculty.getJoiningYear());
        dto.setSalary(faculty.getSalary());
        return dto;
    }

    public Faculty toEntity(FacultyDTO dto) {
        if (dto == null) {
            return null;
        }
        Faculty faculty = new Faculty();
        faculty.setFacultyId(dto.getFacultyId());
        faculty.setFirstName(dto.getFirstName());
        faculty.setLastName(dto.getLastName());
        faculty.setGender(dto.getGender());
        faculty.setEmail(dto.getEmail());
        faculty.setAddress(dto.getAddress());
        faculty.setCity(dto.getCity());
        faculty.setState(dto.getState());
        faculty.setDepartment(dto.getDepartment());
        faculty.setDesignation(dto.getDesignation());
        faculty.setJoiningYear(dto.getJoiningYear());
        faculty.setSalary(dto.getSalary());
        return faculty;
    }

    // Updates an existing entity from a DTO (used for PUT/PATCH), keeps the ID intact
    public void updateEntityFromDTO(FacultyDTO dto, Faculty faculty) {
        faculty.setFirstName(dto.getFirstName());
        faculty.setLastName(dto.getLastName());
        faculty.setGender(dto.getGender());
        faculty.setEmail(dto.getEmail());
        faculty.setAddress(dto.getAddress());
        faculty.setCity(dto.getCity());
        faculty.setState(dto.getState());
        faculty.setDepartment(dto.getDepartment());
        faculty.setDesignation(dto.getDesignation());
        faculty.setJoiningYear(dto.getJoiningYear());
        faculty.setSalary(dto.getSalary());
    }
}
