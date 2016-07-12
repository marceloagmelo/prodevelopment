create table Contato (
	contatoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	accountId LONG,
	endEmail VARCHAR(75) null,
	nome VARCHAR(75) null,
	sexo VARCHAR(75) null,
	dataNascimento DATE null,
	cargoId LONG,
	skype VARCHAR(75) null,
	facebook VARCHAR(75) null,
	twitter VARCHAR(75) null
);

create table Endereco (
	uuid_ VARCHAR(75) null,
	enderecoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	logradouro VARCHAR(75) null,
	numero VARCHAR(75) null,
	complemento VARCHAR(75) null,
	cep VARCHAR(75) null,
	bairro VARCHAR(75) null,
	cidadeId LONG,
	uf VARCHAR(75) null,
	paisId LONG,
	principal BOOLEAN,
	tipo INTEGER
);

create table EnderecoEmail (
	uuid_ VARCHAR(75) null,
	enderecoEmailId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	endereco VARCHAR(75) null,
	tipo INTEGER,
	principal BOOLEAN
);

create table Telefone (
	uuid_ VARCHAR(75) null,
	telefoneId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	ddi VARCHAR(75) null,
	ddd VARCHAR(75) null,
	numero VARCHAR(75) null,
	ramal VARCHAR(75) null,
	tipo INTEGER,
	principal BOOLEAN
);