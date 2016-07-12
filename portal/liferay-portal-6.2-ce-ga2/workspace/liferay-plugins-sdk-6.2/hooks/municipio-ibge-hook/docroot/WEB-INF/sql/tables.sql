create table Municipio (
	codigo LONG not null primary key,
	uf VARCHAR(2) null,
	cidade VARCHAR(75) null,
	bairro VARCHAR(75) null,
	logradouro VARCHAR(75) null,
	cep VARCHAR(8) null
);