delete from USERS;
delete from TYPES;
delete from STREET;
delete from DISTRICT;
insert into DISTRICT (ID, NAME)
values (1001, '东城');
insert into DISTRICT (ID, NAME)
values (1002, '西城');
insert into DISTRICT (ID, NAME)
values (1003, '石景山');
insert into DISTRICT (ID, NAME)
values (1006, '朝阳');
insert into DISTRICT (ID, NAME)
values (1000, '丰台');
insert into DISTRICT (ID, NAME)
values (1004, '海淀');

insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '知春路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '中关村大街', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, '学院路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '朝阳路', 1006);

insert into TYPES (ID, NAME)
values (1000, '一室一厅');
insert into TYPES (ID, NAME)
values (1001, '一室两厅');
insert into TYPES (ID, NAME)
values (1002, '两室一厅');
insert into TYPES (ID, NAME)
values (1003, '两室两厅');
insert into TYPES (ID, NAME)
values (1004, '三室一厅');
insert into TYPES (ID, NAME)
values (1005, '三室两厅');
insert into TYPES (ID, NAME)
values (1006, '四室一厅');
insert into TYPES (ID, NAME)
values (1007, '四室两厅');
insert into TYPES (ID, NAME)
values (1008, '四十三厅');

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
values (seq_id.nextval, 1000, 1000, '学院路二居', '大房子', 4000, to_date('10-04-2017 18:43:11', 'dd-mm-yyyy hh24:mi:ss'), 200, '13309126025', 1002);
insert into HOUSE (ID, USER_ID, TYPE_ID, TITLE, DESCRIPTION, PRICE, PUBDATE, FLOORAGE, CONTACT, STREET_ID)
values (seq_id.nextval, 1000, 1008, '朝阳路四居', '超级大房子', 10000, to_date('03-02-2017 15:42:45', 'dd-mm-yyyy hh24:mi:ss'), 500, '13309126025', 1003);
insert into HOUSE (ID, USER_ID, TYPE_ID, TITLE, DESCRIPTION, PRICE, PUBDATE, FLOORAGE, CONTACT, STREET_ID)
values (seq_id.nextval, 1000, 1008, '朝阳路三居', '超级大房子', 6000, to_date('03-02-2017 15:43:59', 'dd-mm-yyyy hh24:mi:ss'), 500, '13309126025', 1003);
insert into HOUSE (ID, USER_ID, TYPE_ID, TITLE, DESCRIPTION, PRICE, PUBDATE, FLOORAGE, CONTACT, STREET_ID)
values (seq_id.nextval, 1000, 1008, '朝阳路二居', '超级大房子', 4000, to_date('03-02-2017 15:43:59', 'dd-mm-yyyy hh24:mi:ss'), 500, '13309126025', 1003);
commit;
update house set street_id=1001 where id=2;
commit;


