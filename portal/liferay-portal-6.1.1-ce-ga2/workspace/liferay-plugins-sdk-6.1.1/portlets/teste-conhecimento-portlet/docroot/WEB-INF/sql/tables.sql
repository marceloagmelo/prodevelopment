create table TC_Pergunta (
	id_ LONG not null primary key,
	descricao STRING null,
	justificativaResposta STRING null,
	pontuacao DOUBLE,
	dataInclusao DATE null,
	dataAlteracao DATE null,
	testeId LONG,
	userIdInclusao LONG,
	userIdAlteracao LONG
);

create table TC_Resposta (
	id_ LONG not null primary key,
	descricao STRING null,
	correta BOOLEAN,
	dataInclusao DATE null,
	dataAlteracao DATE null,
	perguntaId LONG,
	userIdInclusao LONG,
	userIdAlteracao LONG
);

create table TC_Resposta_Usuario (
	id_ LONG not null primary key,
	correta BOOLEAN,
	dataInclusao DATE null,
	testeUsuarioId LONG,
	respostaId LONG
);

create table TC_Teste (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	titulo STRING null,
	descricao STRING null,
	dataInclusao DATE null,
	dataAlteracao DATE null,
	ativo BOOLEAN,
	companyId LONG,
	groupId LONG,
	userIdInclusao LONG,
	userIdAlteracao LONG
);

create table TC_Teste_Usuario (
	id_ LONG not null primary key,
	nome VARCHAR(75) null,
	email VARCHAR(100) null,
	dataInclusao DATE null,
	dataFinalizacao DATE null,
	totalRespostaCorreta INTEGER,
	totalRespostaErrada INTEGER,
	totalPontuacao DOUBLE,
	testeId LONG,
	userId LONG
);