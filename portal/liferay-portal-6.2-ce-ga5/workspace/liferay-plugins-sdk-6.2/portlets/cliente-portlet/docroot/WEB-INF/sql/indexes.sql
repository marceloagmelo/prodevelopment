create index IX_7C80BD08 on Cliente (companyId);
create index IX_10D4E0A2 on Cliente (companyId, groupId);
create index IX_74BDF7EF on Cliente (companyId, groupId, nome);
create index IX_22D06FD5 on Cliente (companyId, nome);
create index IX_B95C0D6E on Cliente (cpfCnpj);
create index IX_A5F53FA9 on Cliente (dataNascimento);
create index IX_346FD64A on Cliente (rgInscricaoMun);
create index IX_94EA5294 on Cliente (uuid_);
create index IX_4BFC0D14 on Cliente (uuid_, companyId);
create unique index IX_B58CC896 on Cliente (uuid_, groupId);

create index IX_16C9EE3F on ClienteLimCredito (clienteId);

create unique index IX_5D840DB1 on ClienteUsuario (userId, clienteId);