alter table users
drop column street;

alter table addresses
    add state varchar(255) not null;

