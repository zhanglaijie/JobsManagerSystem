

create database laijie; 

use laijie;
drop table Job;
create table Job(
jobId INT NOT NULL PRIMARY KEY,
jobTitle VARCHAR(20),
minSalary decimal(10,2),
maxSalary decimal(10,2));

drop  table login;
create table login
(
loginid varchar(20),
passwd varchar(20),
birth varchar(20),
sex int default 1,
mail varchar(20),
tel varchar(20),
salary decimal(10,2),
jobid int default 0,
level int  DEFAULT 1,
  PRIMARY KEY (loginid) ,
foreign key(jobid) references job(jobid)
);
set names gb2312;
insert into job values(1,'主管',1992.80,8000);
insert into job values (2,'经理',5000,12000);

insert into login values('people','123456','19920803',1,'laijie100@qq.com','15542556006',2000.25,1,1);
insert into login values('admin','123456','19920803',1,'laijie100@qq.com','15542556006',2000.25,1,0);


