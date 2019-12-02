package ru.itpark.repository;

import ru.itpark.model.House;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HouseRepositoryInMemoryImpl implements HouseRepository {

    private final List<House> houses = new LinkedList<>();
    private int nextId = 1;

    @Override
    public House save(House house) {
        if (house.getId() == 0) {
            house.setId(nextId++);
            houses.add(house);
            return house;
        }
        boolean removed = houses.removeIf(o -> o.getId() == house.getId());
        if (!removed) {
            throw new IllegalArgumentException("Id not exists: " + house.getId());
        }
        houses.add(house);
        return house;
    }

    @Override
    public House update(House house) {
        int index = house.getId() - 1;
        houses.get(index).setPrice(house.getPrice());
        houses.get(index).setRoom(house.getRoom());
        houses.get(index).setUnderground(house.getUnderground());
        houses.get(index).setDistrict(house.getDistrict());
        return house;
    }

    @Override
    public List<House> getAll() {
        return this.houses;
    }

    @Override
    public List<House> searchByDistrict(String district) {
        return houses.stream()
                .filter(o -> o.getDistrict().toUpperCase().equals(district.toUpperCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<House> sortByPriceASC() {
        return houses.stream()
                .sorted((o1, o2) -> o1.getPrice() - o2.getPrice())
                .collect(Collectors.toList());
    }

    @Override
    public List<House> sortByPriceDESC() {
        return houses.stream()
                .sorted((o1, o2) -> -(o1.getPrice() - o2.getPrice()))
                .collect(Collectors.toList());
    }
}
