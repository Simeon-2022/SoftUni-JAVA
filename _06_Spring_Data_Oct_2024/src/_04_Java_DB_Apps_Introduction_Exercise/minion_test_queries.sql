use minions_db;

select concat(v.name,' ',count(mv.villain_id)) as Output 
from villains as v 
join minions_villains as mv on v.id = mv.villain_id
group by v.name
having count(mv.villain_id) > 15
order by count(mv.villain_id) desc;

