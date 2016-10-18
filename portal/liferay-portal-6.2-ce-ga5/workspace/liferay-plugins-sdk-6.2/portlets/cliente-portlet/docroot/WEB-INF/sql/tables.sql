create table Cliente (
	uuid_ VARCHAR(75) null,
	clienteId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	nome VARCHAR(100) null,
	rgInscricaoMun VARCHAR(20) null,
	rgOrgaoEmissor VARCHAR(20) null,
	rgDataEmissao DATE null,
	tipoPessoa VARCHAR(2) null,
	cpfCnpj VARCHAR(20) null,
	sexo VARCHAR(1) null,
	estadoCivil VARCHAR(20) null,
	dataNascimento DATE null,
	endComLogradouro VARCHAR(100) null,
	endComNumero VARCHAR(10) null,
	endComComplemento VARCHAR(50) null,
	endComCep VARCHAR(10) null,
	endComBairro VARCHAR(80) null,
	endComCidade LONG,
	endComUf VARCHAR(2) null,
	endComPais VARCHAR(80) null,
	endResLogradouro VARCHAR(100) null,
	endResNumero VARCHAR(10) null,
	endResComplemento VARCHAR(50) null,
	endResCep VARCHAR(10) null,
	endResBairro VARCHAR(80) null,
	endResCidade LONG,
	endResUf VARCHAR(2) null,
	endResPais VARCHAR(80) null,
	telComDdd VARCHAR(10) null,
	versao DOUBLE,
	logoTipoId LONG,
	observacao VARCHAR(2000) null
);

create table ClienteLimCredito (
	clienteLimCreditoId LONG not null primary key,
	valorLimiteMaximoCredito DOUBLE,
	dataLimiteMaximoCredito DATE null,
	valorLimiteMaximoCheque DOUBLE,
	qtdeLimiteMaximoCheque INTEGER,
	clienteId LONG
);

create table ClienteUsuario (
	clienteUsuarioId LONG not null primary key,
	userId LONG,
	clienteId LONG
);