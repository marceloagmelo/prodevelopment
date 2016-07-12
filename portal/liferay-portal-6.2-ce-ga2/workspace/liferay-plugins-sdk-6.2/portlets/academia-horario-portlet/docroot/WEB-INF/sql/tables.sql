create table AcademiaHorario (
	uuid_ VARCHAR(75) null,
	academiaHorarioId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	diaSemana INTEGER,
	horaInicial VARCHAR(75) null,
	HoraFinal VARCHAR(75) null,
	atividadeId LONG,
	atividadeNome STRING null,
	versao DOUBLE
);