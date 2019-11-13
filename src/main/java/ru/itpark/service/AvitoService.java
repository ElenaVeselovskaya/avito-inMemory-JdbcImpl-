package ru.itpark.service;

import ru.itpark.model.House;
import ru.itpark.util.JdbcTemplate;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AvitoService {

    List<House> houses;

    public List<House> getListOfHouses() throws SQLException {
        houses = JdbcTemplate.executeQuery(
                "jdbc:sqlite:db.sqlite",
                "SELECT id, price, room, underground, district FROM houses",
                resultSet -> new House(
                        resultSet.getInt("id"),
                        resultSet.getInt("price"),
                        resultSet.getInt("room"),
                        resultSet.getString("underground"),
                        resultSet.getString("district")));
        return (houses);
    }

    public List<House> searchByDistrict(String district) throws SQLException {
        houses = getListOfHouses();
        List<House> result = new LinkedList<>();
        for (House house : houses) {
            if (house.getDistrict().toUpperCase().contains(district.toUpperCase())) {
                result.add(house);
            }
        }
        result.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
        return result;
    }

    public List<House> searchByPrice(int min, int max) throws SQLException {
        houses = getListOfHouses();
        List<House> result = new LinkedList<>();
        for (House house : houses) {
            if (house.getPrice() >= min && house.getPrice() <= max) {
                result.add(house);
            }
        }
        result.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
        return result;
    }

    public List<House> searchByUnderground(String underground) throws SQLException {
        houses = getListOfHouses();
        List<House> result = new LinkedList<>();
        for (House house : houses) {
            if (house.getUnderground().toUpperCase().contains(underground.toUpperCase())) {
                result.add(house);
            }
        }
        result.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
        return result;
    }

    public List<House> searchByRooms(int quantityOfRooms) throws SQLException {
        houses = getListOfHouses();
        List<House> result = new LinkedList<>();
        for (House house : houses) {
            if (house.getRoom() == quantityOfRooms) {
                result.add(house);
            }
        }
        result.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
        return result;
    }

    public List<House> sortByPriceAsc() throws SQLException {
        houses = getListOfHouses();
        houses.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
        return houses;
    }

    public List<House> sortByPriceDesc() throws SQLException {
        houses = getListOfHouses();
        houses.sort((o1, o2) -> -(o1.getPrice() - o2.getPrice()));
        return houses;
    }

    public List<House> sortByDistrict() throws SQLException {
        houses = getListOfHouses();
        houses.sort((o1, o2) -> o1.getDistrict().compareTo(o2.getDistrict()));
        return houses;
    }

    public List<House> sortByUnderground() throws SQLException {
        houses = getListOfHouses();
        houses.sort((o1, o2) -> o1.getUnderground().compareTo(o2.getUnderground()));
        return houses;
    }

    public List<House> sortByRooms() throws SQLException {
        houses = getListOfHouses();
        houses.sort((o1, o2) -> o1.getRoom() - o2.getRoom());
        return houses;
    }
}


