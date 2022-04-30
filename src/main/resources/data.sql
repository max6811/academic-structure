--insert into university(code, created_date, modified_date, name, uuid, id)
--ahora borramos los created_date and modified_date porque en la validacion de entity ya se genera automatico
insert into university(code, name, uuid, id)
values ('UMSS', 'Universidad Mayor de san simon', 'e276f484-3731-48fb-84e9-a1cb6e504f66', 1000);
insert into university(code, name, uuid, id)
values ('UMSA', 'Universidad Mayor de san Andres', 'e276f484-3731-48fb-84e9-a1cb6e504f88', 1001);
insert into university(code, name, uuid, id)
values ('UGRAM', 'Universidad G rene moreno', 'e276f484-3731-48fb-84e9-a1cb6e504f77', 1002);

--for Faculties
insert into faculty(code, name, university_id, uuid, id)
values ('FCYT', 'facultad de ciencias y tecnologia', 1000, 'e276f484-3731-48fb-84e9-a1cb6e504f34', 2000);
insert into faculty(code, name, university_id, uuid, id)
values ('FCE', 'facultad de ciencias economicas', 1000, 'e276f484-3731-48fb-84e9-a1cb6e504f35', 2001);
insert into faculty(code, name, university_id, uuid, id)
values ('FCH', 'facultad de ciencias humanitarias', 1000, 'e276f484-3731-48fb-84e9-a1cb6e504f36', 2002);