create table PO_Pergunta (
	id_ LONG not null primary key,
	descricao STRING null,
	dataInclusao DATE null,
	dataAlteracao DATE null,
	pesquisaId LONG,
	userIdInclusao LONG,
	userIdAlteracao LONG
);

create table PO_Pesquisa (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	titulo STRING null,
	descricao STRING null,
	dataInclusao DATE null,
	dataAlteracao DATE null,
	ativa BOOLEAN,
	companyId LONG,
	groupId LONG,
	userIdInclusao LONG,
	userIdAlteracao LONG
);

create table PO_Pesquisa_Usuario (
	id_ LONG not null primary key,
	nome VARCHAR(75) null,
	email VARCHAR(75) null,
	dataInclusao DATE null,
	pesquisaId LONG,
	userId LONG
);

create table PO_Resposta (
	id_ LONG not null primary key,
	descricao STRING null,
	dataInclusao DATE null,
	dataAlteracao DATE null,
	perguntaId LONG,
	userIdInclusao LONG,
	userIdAlteracao LONG
);

create table PO_Resposta_Usuario (
	id_ LONG not null primary key,
	dataInclusao DATE null,
	pesquisaUsuarioId LONG,
	respostaId LONG
);