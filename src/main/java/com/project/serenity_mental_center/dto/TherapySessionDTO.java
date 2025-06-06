package com.project.serenity_mental_center.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TherapySessionDTO {
    String id;
    Date date;
    Time startTime;
    Time endTime;
    String therapistId;
    String patientId;
    String therapyProgramID;
}
