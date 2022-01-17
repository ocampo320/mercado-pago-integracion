package com.project.clubfacil.model;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Currency {
    public String id;
    public String name;
    public String locale;
    public String currency_id;
}
