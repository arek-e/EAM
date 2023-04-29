alter table users
    add password varchar(500) not null,
    add enabled boolean not null default false;

create table authorities (
    id varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(id) references users(id)
);
create unique index ix_auth_username on authorities (id,authority);