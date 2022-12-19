CREATE TABLE IF NOT EXISTS public.book
(
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    status character varying(255) NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.book
    OWNER to postgres;