package ru.itpark.repository;

import ru.itpark.model.House;

import java.util.List;

public interface HouseRepository {
    House save(House house);
    House update(House house);
    List<House> getAll();
    List<House> searchByDistrict(String district);
    List<House> sortByPriceASC();
    List<House> sortByPriceDESC();
}
