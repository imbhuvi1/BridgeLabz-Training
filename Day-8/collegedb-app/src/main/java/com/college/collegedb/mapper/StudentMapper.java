package com.college.collegedb.mapper;

import com.college.collegedb.dto.StudentDTO;
import com.college.collegedb.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDTO toDTO(Student student) {
        if (student == null) {
            return null;
        }
        StudentDTO dto = new StudentDTO();
        dto.setStudentId(student.getStudentId());
        dto.setRollNumber(student.getRollNumber());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setGender(student.getGender());
        dto.setEmail(student.getEmail());
        dto.setAddress(student.getAddress());
        dto.setCity(student.getCity());
        dto.setState(student.getState());
        dto.setCourse(student.getCourse());
        dto.setDepartment(student.getDepartment());
        dto.setAdmissionYear(student.getAdmissionYear());
        return dto;
    }

    public Student toEntity(StudentDTO dto) {
        if (dto == null) {
            return null;
        }
        Student student = new Student();
        student.setStudentId(dto.getStudentId());
        student.setRollNumber(dto.getRollNumber());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setGender(dto.getGender());
        student.setEmail(dto.getEmail());
        student.setAddress(dto.getAddress());
        student.setCity(dto.getCity());
        student.setState(dto.getState());
        student.setCourse(dto.getCourse());
        student.setDepartment(dto.getDepartment());
        student.setAdmissionYear(dto.getAdmissionYear());
        return student;
    }

    // Updates an existing entity from a DTO (used for PUT/PATCH), keeps the ID intact
    public void updateEntityFromDTO(StudentDTO dto, Student student) {
        student.setRollNumber(dto.getRollNumber());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setGender(dto.getGender());
        student.setEmail(dto.getEmail());
        student.setAddress(dto.getAddress());
        student.setCity(dto.getCity());
        student.setState(dto.getState());
        student.setCourse(dto.getCourse());
        student.setDepartment(dto.getDepartment());
        student.setAdmissionYear(dto.getAdmissionYear());
    }
}
