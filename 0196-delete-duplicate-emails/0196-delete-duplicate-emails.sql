DELETE u1 
FROM person u1
INNER JOIN person u2 
ON u1.email = u2.email            
AND u1.id > u2.id;                
