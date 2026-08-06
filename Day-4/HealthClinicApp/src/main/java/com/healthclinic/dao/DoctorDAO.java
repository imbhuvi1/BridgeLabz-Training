package com.healthclinic.dao;

import com.healthclinic.dto.Doctor;
import java.util.List;

public interface DoctorDAO {
    boolean addDoctor(Doctor doctor);
    boolean updateDoctor(Doctor doctor);
    boolean deleteDoctorById(int doctor_id);
    Doctor getDoctorById(int doctor_id);
    List<Doctor> getAllDoctors();
}
