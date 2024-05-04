CREATE TABLE IF NOT EXISTS items
(
    id integer NOT NULL,
    title VARCHAR (128) NOT NULL,
    creation_date timestamp without time zone NOT NULL,
    price numeric,
    CONSTRAINT check_positive CHECK ((price >= (0)::numeric))
);

CREATE TABLE IF NOT EXISTS orders
(
    id integer NOT NULL,
    order_date timestamp without time zone NOT NULL,
    item_id integer NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
	id SERIAL PRIMARY KEY,
	login VARCHAR (32) UNIQUE NOT NULL,
	pass VARCHAR (128) NOT NULL
);
