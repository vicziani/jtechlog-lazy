delete from phone;
delete from employee;

insert into employee (id, emp_name, cv) values (1, 'John Doe', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.');
insert into employee (id, emp_name, cv) values (2, 'Jane Poe', 'Vestibulum vulputate vulputate lobortis.');
insert into phone (id, phone_type, phone_number, employee_id) values (1, 'home', '111111', 1);
insert into phone (id, phone_type, phone_number, employee_id) values (2, 'office', '222222', 1);
insert into phone (id, phone_type, phone_number, employee_id) values (3, 'home', '333333', 2);
insert into phone (id, phone_type, phone_number, employee_id) values (4, 'office', '444444', 2);