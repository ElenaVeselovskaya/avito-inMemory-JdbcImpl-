create table houses
(
    id          integer primary key autoincrement,
    price       integer check (price > 0),
    room        integer check (room > 0),
    underground text not null,
    district    text not null
);

