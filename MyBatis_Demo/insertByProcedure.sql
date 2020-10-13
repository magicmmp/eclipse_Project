use mybatis;

drop procedure if exists p_insert_news;

delimiter $$ 

CREATE procedure  p_insert_news
(out v_id int ,v_title  varchar(255)  ,   v_content  varchar(255)     )
begin
	INSERT INTO news_inf
	VALUES(null ,v_title,v_content);
	set v_id = last_insert_id();
end
$$
delimiter ;

