CREATE TABLE IF NOT EXISTS items (
    id integer NOT NULL,
    title character varying(128) NOT NULL,
    creation_date timestamp without time zone NOT NULL,
    price numeric,
    CONSTRAINT check_positive CHECK ((price >= (0)::numeric))
);

CREATE TABLE IF NOT EXISTS public.orders (
    id integer NOT NULL,
    order_date timestamp without time zone NOT NULL,
    item_id integer NOT NULL
);