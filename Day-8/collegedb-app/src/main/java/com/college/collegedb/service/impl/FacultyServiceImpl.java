package com.college.collegedb.service.impl;

import com.college.collegedb.dto.FacultyDTO;
import com.college.collegedb.entity.Faculty;
import com.college.collegedb.exception.DuplicateResourceException;
import com.college.collegedb.exception.ResourceNotFoundException;
import com.college.collegedb.mapper.FacultyMapper;
import com.college.collegedb.repository.FacultyRepository;
import com.college.collegedb.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    public FacultyServiceImpl(FacultyRepository facultyRepository, FacultyMapper facultyMapper) {
        this.facultyRepository = facultyRepository;
        this.facultyMapper = facultyMapper;
    }

    @Override
    public FacultyDTO createFaculty(FacultyDTO facultyDTO) {
        if (facultyDTO.getEmail() != null && facultyRepository.findByEmail(facultyDTO.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Faculty already exists with email: " + facultyDTO.getEmail());
        }
        Faculty faculty = facultyMapper.toEntity(facultyDTO);
        faculty.setFacultyId(null); // ensure DB generates the ID on create
        Faculty saved = facultyRepository.save(faculty);
        return facultyMapper.toDTO(saved);
    }

    @Override
    public FacultyDTO getFacultyById(Integer id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", "faculty_id", id));
        return facultyMapper.toDTO(faculty);
    }

    @Override
    public List<FacultyDTO> getAllFaculty() {
        return facultyRepository.findAll()
                .stream()
                .map(facultyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FacultyDTO> getFacultyByDepartment(String department) {
        return facultyRepository.findByDepartment(department)
                .stream()
                .map(facultyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyDTO updateFaculty(Integer id, FacultyDTO facultyDTO) {
        Faculty existing = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", "faculty_id", id));

        facultyRepository.findByEmail(facultyDTO.getEmail()).ifPresent(f -> {
            if (!f.getFacultyId().equals(id)) {
                throw new DuplicateResourceException("Another faculty already uses email: " + facultyDTO.getEmail());
            }
        });

        facultyMapper.updateEntityFromDTO(facultyDTO, existing);
        Faculty updated = facultyRepository.save(existing);
        return facultyMapper.toDTO(updated);
    }

    @Override
    public void deleteFaculty(Integer id) {
        Faculty existing = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty", "faculty_id", id));
        facultyRepository.delete(existing);
    }
}
