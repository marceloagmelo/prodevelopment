create table Type (
	uuid_ VARCHAR(75) null,
	typeTicketId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userIdCreate LONG,
	userIdModified LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	xsd TEXT null
);

create table TypeUsers (
	typeTicketUsersId LONG not null primary key,
	userIdCreate LONG,
	userIdModified LONG,
	createDate DATE null,
	modifiedDate DATE null,
	typeTicketId LONG,
	userId LONG
);

create table tkt_Type (
	uuid_ VARCHAR(75) null,
	typeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userIdCreate LONG,
	userIdModified LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	xsd TEXT null
);

create table tkt_TypeUsers (
	typeUsersId LONG not null primary key,
	userIdCreate LONG,
	userIdModified LONG,
	createDate DATE null,
	modifiedDate DATE null,
	typeId LONG,
	userId LONG
);