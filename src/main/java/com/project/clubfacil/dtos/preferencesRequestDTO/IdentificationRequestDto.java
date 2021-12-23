package com.project.clubfacil.dtos.preferencesRequestDTO;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class IdentificationRequestDto {
    String type;
    String number;

}