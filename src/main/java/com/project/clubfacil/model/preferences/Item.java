package com.project.clubfacil.model.preferences;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Item{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    private String title;
    private String description;
    private int quantity;
    private String currency_id;
    private int unit_price;

    public Item() {

    }
}
