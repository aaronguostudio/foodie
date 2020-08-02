select
	f.id as id,
    f.`name` as `name`,
    f.`type` as `type`,
    f.`father_id` as fatherId,
    c.id as subId,
    c.`name` as `name`,
    c.`type` as `type`,
    c.`father_id` as fatherId
from foodie.category f
left join foodie.category c
on f.id = c.father_id
where f.father_id = 2;