create index IX_67FDC788 on Type (companyId);
create index IX_C51BA622 on Type (companyId, groupId);
create index IX_FA755461 on Type (companyId, groupId, name);
create index IX_2D365147 on Type (companyId, name);
create index IX_29909D14 on Type (uuid_);
create index IX_A6363294 on Type (uuid_, companyId);
create unique index IX_5B124E16 on Type (uuid_, groupId);

create index IX_EF49833D on TypeUsers (typeId);
create index IX_8B437869 on TypeUsers (typeTicketId);
create unique index IX_A61A57A3 on TypeUsers (typeTicketId, userId);
create index IX_7B72F4E on TypeUsers (userId);
create unique index IX_2F41AD77 on TypeUsers (userId, typeId);

create index IX_873AE932 on tkt_Type (uuid_);
create index IX_9E35C7B6 on tkt_Type (uuid_, companyId);
create unique index IX_2AD8C3B8 on tkt_Type (uuid_, groupId);

create index IX_7205C0DB on tkt_TypeUsers (typeId);
create index IX_8A736CEC on tkt_TypeUsers (userId);
create unique index IX_6AD6D15 on tkt_TypeUsers (userId, typeId);