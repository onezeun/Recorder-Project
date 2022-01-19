-- public."user" definition

-- Drop table

-- DROP TABLE public."user";

CREATE TABLE public."user" (
	user_id serial NOT NULL,
	email varchar(50) NOT NULL,
	"password" varchar(20) NOT NULL,
	"name" varchar(20) NOT NULL,
	nickname varchar(20) NOT NULL,
	"domain" varchar(20) NOT NULL,
	profile_photo varchar(20) NOT NULL,
	introduce varchar(50) NOT NULL,
	created_time timestamptz NOT NULL,
	CONSTRAINT user_pkey PRIMARY KEY (user_id)
);