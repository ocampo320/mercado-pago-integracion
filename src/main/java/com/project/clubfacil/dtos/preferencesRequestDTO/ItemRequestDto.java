package com.project.clubfacil.dtos.preferencesRequestDTO;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class ItemRequestDto {
    public String title;
    public String description;
    public int quantity;
    public String currency_id;
    public int unit_price;
}
