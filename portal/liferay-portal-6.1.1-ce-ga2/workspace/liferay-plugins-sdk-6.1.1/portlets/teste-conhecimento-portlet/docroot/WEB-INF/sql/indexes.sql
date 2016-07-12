create index IX_83567898 on TC_Pergunta (testeId);

create index IX_BA86A1B6 on TC_Resposta (perguntaId);

create index IX_BA2283B0 on TC_Resposta_Usuario (testeUsuarioId);

create index IX_74EC1D5F on TC_Teste (companyId);
create index IX_F02AF22B on TC_Teste (companyId, groupId);
create index IX_574A6FA1 on TC_Teste (groupId);
create index IX_1BC9766B on TC_Teste (uuid_);
create unique index IX_ADB3069F on TC_Teste (uuid_, groupId);

create index IX_BFF7706 on TC_Teste_Usuario (testeId);