insert into users (id, username, password) values (0, 'admin', '{bcrypt}$2a$10$j9Fsd5rz6uYzrmpzBu/mDuRvpz5RdLP5reZc9HJ7r89dNYO29ZYXO');
insert into users (id, username, password) values (1, 'alex', '{bcrypt}$2a$10$j9Fsd5rz6uYzrmpzBu/mDuRvpz5RdLP5reZc9HJ7r89dNYO29ZYXO');

insert into authorities (id, authority) values (0, 'ROLE_ADMIN');
insert into authorities (id, authority) values (0, 'ROLE_USER');
insert into authorities (id, authority) values (1, 'ROLE_USER');
