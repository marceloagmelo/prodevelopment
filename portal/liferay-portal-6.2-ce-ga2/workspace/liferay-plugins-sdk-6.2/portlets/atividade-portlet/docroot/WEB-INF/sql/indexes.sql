create index IX_61A93B1B on Atividade (companyId);
create index IX_7FD2B5BE on Atividade (companyId, descricao);
create index IX_BFCD87EF on Atividade (companyId, groupId);
create index IX_BF63DC6A on Atividade (companyId, groupId, descricao);
create index IX_239D317C on Atividade (companyId, groupId, nome);
create index IX_C838D3A8 on Atividade (companyId, nome);
create index IX_6852D227 on Atividade (uuid_);
create index IX_53A023A1 on Atividade (uuid_, companyId);
create unique index IX_EC6F1E63 on Atividade (uuid_, groupId);