-- public.alert definition

-- Drop table

-- DROP TABLE public.alert;

CREATE TABLE public.alert (
	alert_id bigserial NOT NULL,
	user_id int8 NOT NULL,
	"content" varchar NOT NULL,
	create_time timetz NOT NULL,
	CONSTRAINT alert_pkey PRIMARY KEY (alert_id)
);