package com.college.collegedb.service.impl;

import com.college.collegedb.dto.StudentDTO;
import com.college.collegedb.entity.Student;
import com.college.collegedb.exception.DuplicateResourceException;
import com.college.collegedb.exception.ResourceNotFoundException;
import com.college.collegedb.mapper.StudentMapper;
import com.college.collegedb.repository.StudentRepository;
import com.college.collegedb.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        if (studentRepository.findByRollNumber(studentDTO.getRollNumber()).isPresent()) {
            throw new DuplicateResourceException("Student already exists with roll_number: " + studentDTO.getRollNumber());
        }
        if (studentDTO.getEmail() != null && studentRepository.findByEmail(studentDTO.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Student already exists with email: " + studentDTO.getEmail());
        }
        Student student = studentMapper.toEntity(studentDTO);
        student.setStudentId(null); // ensure DB generates the ID on create
        Student saved = studentRepository.save(student);
        return studentMapper.toDTO(saved);
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "student_id", id));
        return studentMapper.toDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department)
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "student_id", id));

        studentRepository.findByRollNumber(studentDTO.getRollNumber()).ifPresent(s -> {
            if (!s.getStudentId().equals(id)) {
                throw new DuplicateResourceException("Another student already uses roll_number: " + studentDTO.getRollNumber());
            }
        });

        studentMapper.updateEntityFromDTO(studentDTO, existing);
        Student updated = studentRepository.save(existing);
        return studentMapper.toDTO(updated);
    }

    @Override
    public void deleteStudent(Integer id) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "student_id", id));
        studentRepository.delete(existing);
    }
}
