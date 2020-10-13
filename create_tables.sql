
use mybatis_3_3_8;



drop procedure if exists p_get_address_person;
drop procedure if exists p_get_person_address;

delimiter $$ 

CREATE procedure  p_get_address_person (in id int )
begin
	select * from address_inf where addr_id = id;
               select * from person_inf where person_id    in
	(select owner_id from address_inf where addr_id = id);

end $$


CREATE procedure  p_get_person_address (in id int )
begin
	select * from person_inf where person_id = id;
               select * from address_inf where owner_id in 
	(select  person_id     from person_inf where person_id = id);

end $$

delimiter ;

