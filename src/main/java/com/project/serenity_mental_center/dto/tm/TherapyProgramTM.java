package com.project.serenity_mental_center.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TherapyProgramTM {
    String id;
    String name;
    String duration;
    double cost;
    String description;
}
