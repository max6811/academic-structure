drop table if exists public.university_test;

create table if not exists public.university_test (
    id integer not null,
    code character varying(255) collate pg_catalog."default",
    created_date timestamp without time zone,
    modified_date timestamp without time zone,
    uuid character varying(255) collate pg_catalog."default" not null,
    constraint university_test_pkey PRIMARY KEY (id)
    )

   TABLESPACE pg_default;

   ALTER TABLE IF EXISTS public.university_test
   OWNER to postgres;