-- public.category definition

-- Drop table

-- DROP TABLE public.category;

CREATE TABLE public.category (
	category_id bigserial NOT NULL,
	user_id int8 NOT NULL,
	category_name varchar(20) NOT NULL,
	parent_category int8 NULL,
	CONSTRAINT category_pkey PRIMARY KEY (category_id)
);