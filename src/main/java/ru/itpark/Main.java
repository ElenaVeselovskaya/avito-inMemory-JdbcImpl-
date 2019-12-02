package ru.itpark;

import ru.itpark.connection.DBConnection;
import ru.itpark.model.House;
import ru.itpark.repository.HouseRepositoryInJDBCImpl;
import ru.itpark.repository.HouseRepositoryInMemoryImpl;
import ru.itpark.service.AvitoService;

public class Main {
    public static void main(String[] args) {

        // from House repository in JDBC
        AvitoService avitoService = new AvitoService(new HouseRepositoryInJDBCImpl(DBConnection.SQLITE.getValue()));
        avitoService.register(new House(4_000_000, 2, "Яшлек", "Московский"));
        avitoService.register(new House(5_000_000, 3, "Площадь Тукая", "Площадь Тукая"));
        avitoService.register(new House(2_500_000, 1, "Северный вокзал", "Авиастроительный"));

        avitoService.update(new House(1, 4_500_000, 2, "Яшлек", "Московский"));

        System.out.println("Список всех домов: ");
        avitoService.getAll().forEach(o -> System.out.println(o));

        System.out.println("Список домов, найденных по району: ");
        avitoService.searchByDistrict("Московский").forEach(o -> System.out.println(o));

        System.out.println("Список домов, отсортированных по возрастанию цены: ");
        avitoService.sortByPriceAsc().forEach(o -> System.out.println(o));

        System.out.println("Список домов, отсортированных по убыванию цены: ");
        avitoService.sortByPriceDesc().forEach(o -> System.out.println(o));

        //from House repository in memory
        avitoService = new AvitoService(new HouseRepositoryInMemoryImpl());
        avitoService.register(new House(4_000_000, 2, "Козья слобода", "Кировский"));
        avitoService.register(new House(5_000_000, 3, "Суконная слобода", "Вахитовский"));
        avitoService.register(new House(2_500_000, 1, "Проспект Победы", "Азино"));

        avitoService.update(new House(3, 3_000_000, 1, "Проспект Победы", "Азино"));

        System.out.println("Список всех домов: ");
        avitoService.getAll().forEach(o -> System.out.println(o));

        System.out.println("Список домов, найденных по району: ");
        avitoService.searchByDistrict("Кировский").forEach(o -> System.out.println(o));

        System.out.println("Список домов, отсортированных по возрастанию цены: ");
        avitoService.sortByPriceAsc().forEach(o -> System.out.println(o));

        System.out.println("Список домов, отсортированных по убыванию цены: ");
        avitoService.sortByPriceDesc().forEach(o -> System.out.println(o));
    }
}

