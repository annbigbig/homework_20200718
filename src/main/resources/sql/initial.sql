use db_spring;

CREATE TABLE IF NOT EXISTS TB_YOAN_USER (
    id_bin binary(16) not null,
    id_text varchar(36) generated always as
 (insert(
    insert(
      insert(
        insert(hex(id_bin),9,0,'-'),
        14,0,'-'),
      19,0,'-'),
    24,0,'-')
 ) virtual,
    name varchar(100) not null,
    account varchar(12) not null,
    password varchar(32) not null,
    CONSTRAINT login_unique UNIQUE (account),
    PRIMARY KEY ( id_bin )
)  ENGINE=INNODB;

insert into TB_YOAN_USER (id_bin,name,account,password) values(unhex(replace(uuid(),'-','')), 'Admin','admin','a05f9d34b9ca3dcc93bdee7bc37b7e0e');
insert into TB_YOAN_USER (id_bin,name,account,password) values(unhex(replace(uuid(),'-','')), 'Tony','tony','ac61a6ff1d90274772c37ad74758877c');
insert into TB_YOAN_USER (id_bin,name,account,password) values(unhex(replace(uuid(),'-','')), 'Lisa','lisa','f5971d79c9d7fa030a7b4652ba6bc7a9');
