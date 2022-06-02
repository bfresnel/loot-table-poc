CREATE TABLE t_character(
    id int,
    name varchar(255),
    rarity integer);

CREATE UNIQUE INDEX t_character_id_index
ON t_character(id);

CREATE TABLE t_drop(
    rarity varchar(255),
    chance integer);
