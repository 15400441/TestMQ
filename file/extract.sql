select distinct * from fix_account_tbl where bs_client_id in

(select bs_client_id from

(select target_comp_id, bs_client_id, handlinst, '''' || substr(ac_2go_9_digits, 8,2) as sub_ac, trim(string_agg(' ' || exchange || ' - ' || ac_2go_9_digits, ',')) as ac_2go_and_mkt
from
(
	select distinct c.target_comp_id, ac.bs_client_id, substr(ac.ss_account,1,9) as ac_2go_9_digits, exchange, handlinst
	from fix_account_tbl ac, fix_client_tbl c
	where c.client_id = ac.bs_client_id and c.client_sub_id = 1
	and ac.status = 'A'
	order by target_comp_id, bs_client_id, handlinst, ac_2go_9_digits
) a
group by target_comp_id, bs_client_id, handlinst, '''' || substr(ac_2go_9_digits, 8,2)
order by target_comp_id, bs_client_id, handlinst, '''' || substr(ac_2go_9_digits, 8,2)
) b
 
where handlinst='DMA' and sub_ac like '%00%'  or handlinst='MANUAL' and sub_ac like '%01%')  order by ss_account




-------------------------------------------------------------
update fix_account_tbl set ss_account=substr(ss_account,1,7)||'01'||substr(ss_account,10) 
where  handlinst='DMA' and substr(ss_account,8,2) like '%00%' and status='A'


update fix_account_tbl set ss_account=substr(ss_account,1,7)||'00'||substr(ss_account,10) 
where  handlinst='MANUAL' and substr(ss_account,8,2) like '%01%' and status='A'


select substr(ss_account,1,7)||'01'||substr(ss_account,10) as new, bs_client_id, substr(ss_account,8,2) as sub_ac,ss_account,currency,status,exchange,handlinst,ss_handlinst from fix_account_tbl  
where  handlinst='DMA' and substr(ss_account,8,2) like '%00%'  
order by bs_client_id, ss_account,handlinst


select substr(ss_account,1,7)||'00'||substr(ss_account,10) as new, bs_client_id, substr(ss_account,8,2) as sub_ac,ss_account,currency,status,exchange,handlinst,ss_handlinst from fix_account_tbl  
where  handlinst='MANUAL' and substr(ss_account,8,2) like '%01%'  
order by bs_client_id, ss_account,handlinst