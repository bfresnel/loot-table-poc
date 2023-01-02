CREATE TABLE public.t_character (
	id int8 NOT NULL,
	"name" varchar(255) NULL,
	rarity int4 NULL,
	CONSTRAINT t_character_pkey PRIMARY KEY (id)
);

CREATE TABLE public.t_drop (
	rarity int4 NOT NULL,
	chance int4 NULL,
	CONSTRAINT t_drop_pkey PRIMARY KEY (rarity)
);
