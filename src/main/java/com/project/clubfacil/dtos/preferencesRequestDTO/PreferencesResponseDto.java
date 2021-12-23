package com.project.clubfacil.dtos.preferencesRequestDTO;

import com.project.clubfacil.model.preferences.Item;
import com.project.clubfacil.model.preferences.Payer;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PreferencesResponseDto {

    private Payer payer;

    private List<Item> items;

    private String urlInit;

}
