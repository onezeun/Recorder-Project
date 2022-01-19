-- public.post_like definition

-- Drop table

-- DROP TABLE public.post_like;

CREATE TABLE public.post_like (
	post_id int8 NOT NULL,
	user_id int8 NOT NULL,
	CONSTRAINT post_like_pkey PRIMARY KEY (post_id, user_id)
);