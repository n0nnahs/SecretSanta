BEGIN TRANSACTION;

DROP TABLE IF EXISTS pairs;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
	id serial,
	discord_name varchar(64) not null,
	address varchar(225) not null,
    wishlist varchar(255) null,

    constraint pk_userId primary key (id)
);

CREATE TABLE pairs
(
	pairId serial,
	fromId int not null,
    toId int not null,

	constraint pk_pairs primary key (pairId),
    constraint fk_from foreign key (fromId) references users (id),
    constraint fk_to foreign key (toId) references users (id)

);


COMMIT TRANSACTION;