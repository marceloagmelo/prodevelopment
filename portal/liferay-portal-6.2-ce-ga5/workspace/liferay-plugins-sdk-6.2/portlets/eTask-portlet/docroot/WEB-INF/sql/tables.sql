create table etsk_TypeTask (
	uuid_ VARCHAR(75) null,
	typeTaskId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userIdCreate LONG,
	userIdModified LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	DDMStructureId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	customFieldsActive BOOLEAN,
	classNameId LONG,
	classPK LONG
);

create table etsk_TypeTaskUsers (
	typeTaskUsersId LONG not null primary key,
	userIdCreate LONG,
	createDate DATE null,
	typeTaskId LONG,
	userId LONG,
	typeUser VARCHAR(2) null
);