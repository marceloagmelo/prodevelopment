create table Atividade (
	uuid_ VARCHAR(75) null,
	atividadeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	nome STRING null,
	descricao STRING null,
	imagemId LONG,
	existeImagem BOOLEAN,
	versao DOUBLE
);