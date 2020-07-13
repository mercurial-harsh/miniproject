


CREATE TABLE Customer (name varchar2(10),address VARCHAR2(15),password VARCHAR2(10),username VARCHAR2(10),adhaar varchar2(12) ,pan VARCHAR2(11),email VARCHAR2(15),mobile varchar2(10),accnum varchar2(15) primary key,active number(1));
desc Customer
Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 NAME                                               VARCHAR2(10)
 ADDRESS                                            VARCHAR2(15)
 PASSWORD                                           VARCHAR2(10)
 USERNAME                                           VARCHAR2(10)
 ADHAAR                                             VARCHAR2(12)
 PAN                                                VARCHAR2(11)
 EMAIL                                              VARCHAR2(15)
 MOBILE                                             VARCHAR2(10)
 ACCNUM                                    NOT NULL VARCHAR2(15)
 ACTIVE                                             NUMBER(1)
 
 
SQL> insert into Customer values('h','kp','harsh','harsh',50838485198,'BVHPG8430R','h@gmail.com',7275459565,'LT508384845198',0);
insert into Customer values('h','kp','harsh','harsh',50838485198,'BVHPG8430R','h@gmail.com',7275459565,'LT508384845198',0)
                                                                              *
ERROR at line 1:
ORA-12899: value too large for column "SYSTEM"."CUSTOMER"."EMAIL" (actual: 11,
maximum: 10)


SQL> insert into Customer values('h','kp','harsh','harsh',50838485198,'BVHPG8430R','h@h.com',7275459565,'LT508384845198',0);

1 row created.



commit is important if you are inserting from database because dml is not auto-commit
