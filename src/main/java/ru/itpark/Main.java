package ru.itpark;

import ru.itpark.service.AvitoService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        AvitoService avitoService = new AvitoService();

        System.out.println("Список домов, найденных по району: ");
        avitoService.searchByDistrict("кировский").forEach(o -> System.out.println(o));

        System.out.println("Список домов, найденных по цене: ");
        avitoService.searchByPrice(2500000, 4000000).forEach(o -> System.out.println(o));

        System.out.println("Список домов, найденных по метро: ");
        avitoService.searchByUnderground("слобода").forEach(o -> System.out.println(o));

        System.out.println("Список домов, найденных по количеству комнат: ");
        avitoService.searchByRooms(2).forEach(o -> System.out.println(o));

        System.out.println("Список домов, отсортированных по возрастанию цены: ");
        avitoService.sortByPriceAsc().forEach(o -> System.out.println(o));

        System.out.println("Список домов, отсортированных по убыванию цены: ");
        avitoService.sortByPriceDesc().forEach(o -> System.out.println(o));

        System.out.println("Список домов, отсортированных по району: ");
        avitoService.sortByDistrict().forEach(o -> System.out.println(o));

        System.out.println("Список домов, отсортированных по метро: ");
        avitoService.sortByUnderground().forEach(o -> System.out.println(o));

        System.out.println("Список домов, отсортированных по количеству комнат: ");
        avitoService.sortByRooms().forEach(o -> System.out.println(o));
    }
}

