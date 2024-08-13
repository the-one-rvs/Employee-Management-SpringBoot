package com.quasarcelestio.springBootDemo.Spring.Boot.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private boolean isActive;

}
