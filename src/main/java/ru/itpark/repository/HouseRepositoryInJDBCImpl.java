package ru.itpark.repository;

import lombok.AllArgsConstructor;
import ru.itpark.model.House;
import ru.itpark.util.JdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class HouseRepositoryInJDBCImpl implements HouseRepository {
    private final String url;

    @Override
    public House save(House house) {
        return house.getId() == 0 ? insert(house) : update(house);
    }

    @Override
    public List<House> getAll() {
        String sql = "SELECT * FROM houses";
        return JdbcTemplate.executeQuery(url, sql, stmt -> {
        }, rs -> new House(
                rs.getInt("id"),
                rs.getInt("price"),
                rs.getInt("room"),
                rs.getString("underground"),
                rs.getString("district")
        ));
    }

    @Override
    public List<House> searchByDistrict(String district) {
        String sql = "SELECT id, price, room, underground, district FROM houses WHERE district=?";
        return JdbcTemplate.executeQuery(url, sql, stmt -> stmt.setString(1, district), rs -> new House(
                rs.getInt("id"),
                rs.getInt("price"),
                rs.getInt("room"),
                rs.getString("underground"),
                rs.getString("district")
        ));
    }

    @Override
    public List<House> sortByPriceASC() {
        String sql = "SELECT id, price, room, underground, district FROM houses ORDER BY price";
        return JdbcTemplate.executeQuery(url, sql, stmt -> {
        }, rs -> new House(
                rs.getInt("id"),
                rs.getInt("price"),
                rs.getInt("room"),
                rs.getString("underground"),
                rs.getString("district")
        ));
    }

    @Override
    public List<House> sortByPriceDESC() {
        String sql = "SELECT id, price, room, underground, district FROM houses ORDER BY price DESC";
        return JdbcTemplate.executeQuery(url, sql, stmt -> {
        }, rs -> new House(
                rs.getInt("id"),
                rs.getInt("price"),
                rs.getInt("room"),
                rs.getString("underground"),
                rs.getString("district")
        ));
    }

    private House insert(House house) {
        String sql = "INSERT INTO houses (price, room, underground, district) VALUES(?, ?, ?, ?);";
        int id = JdbcTemplate.executeInsert(url, sql, stmt -> {
            int index = 1;
            stmt.setInt(index++, house.getPrice());
            stmt.setInt(index++, house.getRoom());
            stmt.setString(index++, house.getUnderground());
            stmt.setString(index++, house.getDistrict());
        });
        house.setId(id);
        return house;
    }

    @Override
    public House update(House house) {
        String sql = "UPDATE houses SET price = ?, room = ?,  underground = ?, district = ? WHERE id = ?;";
        JdbcTemplate.executeUpdate(url, sql, stmt -> {
            int index = 1;
            stmt.setInt(index++, house.getPrice());
            stmt.setInt(index++, house.getRoom());
            stmt.setString(index++, house.getUnderground());
            stmt.setString(index++, house.getDistrict());
            stmt.setInt(index++, house.getId());
        });
        return house;
    }
}
