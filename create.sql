alter table HOUSE
   drop constraint FK_HOU_ST;

alter table HOUSE
   drop constraint FK_HOU_US;

alter table HOUSE
   drop constraint FK_HOU_TY;

alter table STREET
   drop constraint FK_STR_DI;

drop table DISTRICT cascade constraints;

drop table HOUSE cascade constraints;

drop table STREET cascade constraints;

drop table TYPES cascade constraints;

drop table USERS cascade constraints;

drop sequence SEQ_ID;

create sequence SEQ_ID;

create table DISTRICT  (
   ID                   NUMBER(4)                       not null,
   NAME                 NVARCHAR2(50)                   not null,
   constraint PK_DISTRICT primary key (ID)
);

create table HOUSE  (
   ID                   NUMBER(6)                       not null,
   USER_ID              NUMBER(4),
   TYPE_ID              NUMBER(4),
   TITLE                NVARCHAR2(50),
   DESCRIPTION          NVARCHAR2(2000),
   PRICE                NUMBER(6),
   PUBDATE              DATE,
   FLOORAGE             NUMBER(4),
   CONTACT              NVARCHAR2(100),
   STREET_ID            NUMBER(4),
   constraint PK_HOUSE primary key (ID)
);

create table STREET  (
   ID                   NUMBER(4)                       not null,
   NAME                 NVARCHAR2(50)                   not null,
   DISTRICT_ID          NUMBER(4),
   constraint PK_STREET primary key (ID)
);

create table TYPES  (
   ID                   NUMBER(4)                       not null,
   NAME                 NVARCHAR2(50)                   not null,
   constraint PK_TYPES primary key (ID)
);

create table USERS  (
   ID                   NUMBER(4)                       not null,
   NAME                 NVARCHAR2(50)                   not null,
   PASSWORD             NVARCHAR2(50)                   not null,
   TELEPHONE            NVARCHAR2(15),
   USERNAME             NVARCHAR2(50),
   ISADMIN              NVARCHAR2(5),
   constraint PK_USERS primary key (ID)
);

alter table HOUSE
   add constraint FK_HOU_ST foreign key (STREET_ID)
      references STREET (ID);

alter table HOUSE
   add constraint FK_HOU_US foreign key (USER_ID)
      references USERS (ID);

alter table HOUSE
   add constraint FK_HOU_TY foreign key (TYPE_ID)
      references TYPES (ID);

alter table STREET
   add constraint FK_STR_DI foreign key (DISTRICT_ID)
      references DISTRICT (ID);

