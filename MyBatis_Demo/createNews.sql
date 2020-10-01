create database mybatis;
use mybatis;




CREATE TABLE news_inf
(
  news_id      int       NOT NULL AUTO_INCREMENT,
  news_title          varchar(255)  ,
  news_content    varchar(255)  ,
  PRIMARY KEY (news_id)
) ENGINE=InnoDB;
