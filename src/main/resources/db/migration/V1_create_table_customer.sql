CREATE TABLE IF NOT EXISTS public.customer
(
    id integer NOT NULL ,
    email character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (id),
    CONSTRAINT uk_dwk6cx0afu8bs9o4t536v1j5v UNIQUE (email)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer
    OWNER to postgres;