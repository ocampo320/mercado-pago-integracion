package com.project.clubfacil.dtos.preferencesRequestDTO;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RootRequestDto {
    public List<ItemRequestDto> items;
    public PayerRequestDto payer;

}
