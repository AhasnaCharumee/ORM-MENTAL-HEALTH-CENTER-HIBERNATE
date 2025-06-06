package com.project.serenity_mental_center.bo.custom;

import com.project.serenity_mental_center.bo.SuperBO;
import com.project.serenity_mental_center.dto.TherapistDto;

import java.util.ArrayList;

public interface TherapistBO extends SuperBO {
    public ArrayList<TherapistDto> getAllTherapist();
    public boolean saveTherapist(TherapistDto therapistDto);
    public boolean updateTherapist(TherapistDto therapistDto);
    public boolean deletePatient(String id);
    public String getNextId();
    public ArrayList<String> getAllTherapistId();
    public TherapistDto getAllById(String therapistId);
}
