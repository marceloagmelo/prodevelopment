create index IX_947E6886 on etsk_TypeTask (classPK);
create index IX_848CFC0B on etsk_TypeTask (companyId);
create index IX_45FBD4FF on etsk_TypeTask (companyId, groupId);
create index IX_1B817AAF on etsk_TypeTask (companyId, groupId, classNameId);
create index IX_5CBC297E on etsk_TypeTask (companyId, groupId, name);
create index IX_FF50A4E5 on etsk_TypeTask (companyId, groupId, status);
create index IX_6DF83089 on etsk_TypeTask (companyId, groupId, status, classNameId);
create index IX_77D2F4E4 on etsk_TypeTask (companyId, groupId, status, name);
create index IX_C5DA16EA on etsk_TypeTask (companyId, groupId, status, name, classNameId);
create index IX_299C8B17 on etsk_TypeTask (uuid_);
create index IX_1E74B1 on etsk_TypeTask (uuid_, companyId);
create unique index IX_5B6E7373 on etsk_TypeTask (uuid_, groupId);

create index IX_C05C10A5 on etsk_TypeTaskUsers (typeTaskId);
create index IX_516E2E3E on etsk_TypeTaskUsers (typeTaskId, typeUser);
create index IX_A524F3DF on etsk_TypeTaskUsers (typeTaskId, userId);
create unique index IX_6287D0F8 on etsk_TypeTaskUsers (typeTaskId, userId, typeUser);
create index IX_3D4B4F11 on etsk_TypeTaskUsers (userId);
create index IX_E36355AA on etsk_TypeTaskUsers (userId, typeUser);