# Simple Java/JSP Login Example


**Note:** all of codes in this repository were only for my personal practice purposes, some design patterns maybe not so correct, DO NOT use it as your tutorial

**注意:** 這裡的所有代碼只是我拿來自我練習，裡面許多設計模式也許不那麼正確，請勿拿來當你的編程教材



## Requirements
The user will fill in account and password infomation  
there are three posible reactions  
用戶會填入帳號和密碼，系統會有三種反應 

 - Login Succcessfully （登入成功）
 - Login Failed （登入失敗）
 - User not existed （用戶不存在）

![Requirements Description](images/Requirements.jpg?raw=true "Title")  


## How to build this project ?

Via Maven command:

``` bash
$ mvn clean
$ mvn package
```
then you will find My-project-01.war in target sub-directory  


## Database Structure
this project's need one table for its persistence entity (User) ,   
and here is the SQL you could use it to generate table,   
and create 3 users for you,  password column were hashed by MD5 algorithm,  
their login id and passoword are :  
 - admin : adminpass
 - tony : tonypass
 - lisa : lisapass

此專案需要一個資料表來存儲它的持久化資料（User），
這裡的SQL可以讓你產生表，還有三個預設的用戶  
密碼是被md5加密過的，三人的帳號和密碼分別是  
 - admin : adminpass 
 - tony : tonypass
 - lisa : lisapass

``` php
create database db_spring;
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

```

## System Design (roughly UML models)

Please see 
![UMLmodels](images/UMLmodels.jpg?raw=true "Title")

## Play it on dq5rocks.com  
click [here](https://www.dq5rocks.com/My-project-01/ "Title") try it out  
this link probobaly may become unavailable in someday future,   
if i could not pay for domain name or vps payment

在 [這裡](https://www.dq5rocks.com/My-project-01/ "Title") 直接玩  
連結可能在未來有天會失效，如果我繳不出域名或VPS主機的錢  

## Contributing

only me ... (ಥ﹏ಥ)

## Donate me

可以捐錢給我喔，i need your support  

- [國泰世華銀行收款帳號](#CathayBank) **銀行代碼 013 帳號 001-50-235346-9 戶名 KUN AN HSU 館前分行**  

- [Alipay(支付寶)](#alipay) **annbigbig@gmail.com**  

- [BitCoin](#Bitcoin)  ![BitcoinIcon](images/Bitcoin.png?raw=true "Thank you")

  **1FGEtWkZpo3WHzQqDw6aJvsaDyxNmX4H9**

- [Ethereum](#Ethereum)  ![EthereeumIcon](images/Ethereum.png?raw=true "Thank you")  
  **0x36077A217819cf747F938EbFad26Ec50e44cDC48**

## Contact me

- **annbigbig@gmail.com**   
2020年7月，又開始寫扣，祝我好運

## License

None. 無

