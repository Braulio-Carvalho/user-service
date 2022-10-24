CREATE TABLE public.cliente (
	id uuid NOT NULL,
	cpf varchar(255) NULL,
	email varchar(255) NULL,
	endereco varchar(255) NULL,
	nome varchar(255) NULL,
	telefone varchar(255) NULL,
	tipo varchar(255) NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (id)
);