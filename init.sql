delete from USERS;
delete from TYPES;
delete from STREET;
delete from DISTRICT;
insert into DISTRICT (ID, NAME)
values (1001, '����');
insert into DISTRICT (ID, NAME)
values (1002, '����');
insert into DISTRICT (ID, NAME)
values (1003, 'ʯ��ɽ');
insert into DISTRICT (ID, NAME)
values (1006, '����');
insert into DISTRICT (ID, NAME)
values (1000, '��̨');
insert into DISTRICT (ID, NAME)
values (1004, '����');

insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '֪��·', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '�йش���', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, 'ѧԺ·', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '����·', 1006);

insert into TYPES (ID, NAME)
values (1000, 'һ��һ��');
insert into TYPES (ID, NAME)
values (1001, 'һ������');
insert into TYPES (ID, NAME)
values (1002, '����һ��');
insert into TYPES (ID, NAME)
values (1003, '��������');
insert into TYPES (ID, NAME)
values (1004, '����һ��');
insert into TYPES (ID, NAME)
values (1005, '��������');
insert into TYPES (ID, NAME)
values (1006, '����һ��');
insert into TYPES (ID, NAME)
values (1007, '��������');
insert into TYPES (ID, NAME)
values (1008, '��ʮ����');

insert into USERS (ID, NAME,PASSWORD)
values (1001, 'test1','123');
insert into USERS (ID, NAME,PASSWORD)
values (1002, 'jbit','123');
insert into USERS (ID, NAME,PASSWORD)
values (1000, 'admin','123');
insert into USERS (ID, NAME,PASSWORD)
values (60, 'test2','123');
insert into USERS (ID, NAME,PASSWORD)
values (77, 'test3','123');
commit;

select * from house;


insert into HOUSE (ID, USER_ID, TYPE_ID, TITLE, DESCRIPTION, PRICE, PUBDATE, FLOORAGE, CONTACT, STREET_ID)
values (seq_id.nextval, 1000, 1000, 'ѧԺ·����', '����', 4000, to_date('10-04-2017 18:43:11', 'dd-mm-yyyy hh24:mi:ss'), 200, '13309126025', 1002);
insert into HOUSE (ID, USER_ID, TYPE_ID, TITLE, DESCRIPTION, PRICE, PUBDATE, FLOORAGE, CONTACT, STREET_ID)
values (seq_id.nextval, 1000, 1008, '����·�ľ�', '��������', 10000, to_date('03-02-2017 15:42:45', 'dd-mm-yyyy hh24:mi:ss'), 500, '13309126025', 1003);
insert into HOUSE (ID, USER_ID, TYPE_ID, TITLE, DESCRIPTION, PRICE, PUBDATE, FLOORAGE, CONTACT, STREET_ID)
values (seq_id.nextval, 1000, 1008, '����·����', '��������', 6000, to_date('03-02-2017 15:43:59', 'dd-mm-yyyy hh24:mi:ss'), 500, '13309126025', 1003);
insert into HOUSE (ID, USER_ID, TYPE_ID, TITLE, DESCRIPTION, PRICE, PUBDATE, FLOORAGE, CONTACT, STREET_ID)
values (seq_id.nextval, 1000, 1008, '����·����', '��������', 4000, to_date('03-02-2017 15:43:59', 'dd-mm-yyyy hh24:mi:ss'), 500, '13309126025', 1003);
commit;
update house set street_id=1001 where id=2;
commit;


