create index IX_71C24E86 on Cargo (companyId);
create index IX_49EC1CE4 on Cargo (companyId, groupId);
create index IX_D9D37AB1 on Cargo (companyId, groupId, nome);
create index IX_D4326AD3 on Cargo (companyId, nome);
create index IX_7C3C5312 on Cargo (uuid_);
create index IX_C6D971D6 on Cargo (uuid_, companyId);
create unique index IX_26A075D8 on Cargo (uuid_, groupId);

create index IX_AB1E41C6 on Funcionario (cargoId);
create index IX_D5F0AAC7 on Funcionario (companyId);
create index IX_24CAF9C3 on Funcionario (companyId, groupId);
create index IX_85AAF450 on Funcionario (companyId, groupId, nome);
create index IX_D52B8EEE on Funcionario (companyId, groupId, nomeReduzido);
create index IX_9A0D254 on Funcionario (companyId, nome);
create index IX_3D7528F2 on Funcionario (companyId, nomeReduzido);
create index IX_9BEB2768 on Funcionario (cpf);
create index IX_8C5F114A on Funcionario (dataNascimento);
create index IX_99B367AA on Funcionario (rg);
create index IX_58FE4DFB on Funcionario (userId);
create index IX_EBCF7D3 on Funcionario (uuid_);
create index IX_3F37FA75 on Funcionario (uuid_, companyId);
create unique index IX_9BF69A37 on Funcionario (uuid_, groupId);