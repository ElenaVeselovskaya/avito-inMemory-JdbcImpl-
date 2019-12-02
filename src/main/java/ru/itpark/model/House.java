package ru.itpark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private int id;
    private int price;
    private int room;
    private String underground;
    private String district;

    public House(int price, int room, String underground, String district) {
        this.price = price;
        this.room = room;
        this.underground = underground;
        this.district = district;
    }
}

