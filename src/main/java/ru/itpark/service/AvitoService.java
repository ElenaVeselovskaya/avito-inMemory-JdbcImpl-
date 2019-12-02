package ru.itpark.service;

import ru.itpark.model.House;
import ru.itpark.repository.HouseRepository;

import java.util.List;

public class AvitoService {

    private HouseRepository houseRepository;

    public AvitoService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public House register(House house) {
        if (house.getId() != 0) {
            throw new IllegalArgumentException("House id must be 0 for registration");
        }
        return houseRepository.save(house);
    }

    public House update(House house) {
        return houseRepository.update(house);

    }

    public List<House> getAll() {
        return houseRepository.getAll();
    }

    public List<House> searchByDistrict(String district) {
        return houseRepository.searchByDistrict(district);
    }

    public List<House> sortByPriceAsc() {
        List<House> houses = houseRepository.sortByPriceASC();
        return houses;
    }

    public List<House> sortByPriceDesc() {
        List<House> houses = houseRepository.sortByPriceDESC();
        return houses;
    }
}


