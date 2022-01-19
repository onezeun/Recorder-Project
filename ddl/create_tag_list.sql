-- public.tag_list definition

-- Drop table

-- DROP TABLE public.tag_list;

CREATE TABLE public.tag_list (
	id bigserial NOT NULL,
	tag_name varchar(10) NOT NULL,
	CONSTRAINT tag_list_pkey PRIMARY KEY (id)
);