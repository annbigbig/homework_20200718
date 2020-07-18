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

insert into TB_YOAN_USER (id_bin,name,account,password) values(unhex(replace(uuid(),'-','')), 'Admin','admin','25E4EE4E9229397B6B17776BFCEAF8E7');
insert into TB_YOAN_USER (id_bin,name,account,password) values(unhex(replace(uuid(),'-','')), 'Tony','tony','0D87EB66F2EEE68840F9C694F9B1C881');
insert into TB_YOAN_USER (id_bin,name,account,password) values(unhex(replace(uuid(),'-','')), 'Lisa','lisa','53E466776EE87CD925AD74D64EAEAB92');
