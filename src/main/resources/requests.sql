create table houses
(
    id          integer primary key autoincrement,
    price       integer check (price > 0),
    room       integer check (room > 0),
    underground text not null,
    district    text not null
);

insert into houses (id, price, room, underground, district)
values (1, 2000000, 1, 'Яшлек', 'Московский'),
       (2, 5000000, 2, 'Площадь Тукая', 'Вахитовский'),
       (3, 2500000, 1, 'Северный вокзал', 'Авиастроительный'),
       (4, 4000000, 3, 'Козья слобода', 'Кировский'),
       (5, 3000000, 1, 'Суконная слобода', 'Вахитовский'),
       (6, 4500000, 2, 'Альметьево', 'Вахитовский'),
       (7, 4200000, 2, 'Проспект Победы', 'Азино');

drop table houses;