create index IX_2AD370C5 on AcademiaHorario (companyId);
create index IX_FE829F8D on AcademiaHorario (companyId, atividadeId);
create index IX_13141185 on AcademiaHorario (companyId, groupId);
create index IX_829D36CD on AcademiaHorario (companyId, groupId, atividadeId);
create unique index IX_797A831D on AcademiaHorario (companyId, groupId, diaSemana, atividadeId, horaInicial);
create index IX_3B7E6CD1 on AcademiaHorario (uuid_);
create index IX_61081AB7 on AcademiaHorario (uuid_, companyId);
create unique index IX_E075E2F9 on AcademiaHorario (uuid_, groupId);