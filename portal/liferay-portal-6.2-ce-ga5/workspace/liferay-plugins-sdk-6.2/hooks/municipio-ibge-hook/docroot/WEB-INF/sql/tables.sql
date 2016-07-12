create table Municipio (
	codigo LONG not null primary key,
	uf VARCHAR(2) null,
	cidade VARCHAR(75) null,
	bairro VARCHAR(75) null,
	logradouro VARCHAR(200) null,
	cep VARCHAR(75) null
);