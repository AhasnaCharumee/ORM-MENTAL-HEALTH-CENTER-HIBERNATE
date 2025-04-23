package com.project.serenity_mental_center.bo.custom;

import com.project.serenity_mental_center.bo.SuperBO;
import com.project.serenity_mental_center.dto.PatientDto;
import com.project.serenity_mental_center.dto.TherapySessionDTO;

import java.util.ArrayList;

public interface PatientBO extends SuperBO {
    public boolean savePatient(PatientDto patientDto);
    public ArrayList<PatientDto> getAllPatient();
    public String getNextId();
    public boolean updatePatient(PatientDto patientDto);
    public boolean deletePatient(String patientId);
    public ArrayList<String> getAllPatientId();
    public ArrayList<TherapySessionDTO> getAllById(String patientId);
}
