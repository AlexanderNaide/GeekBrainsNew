# create table roles
# (
#     id   bigint auto_increment
#         primary key,
#     name varchar(255) null
# );
#
# INSERT INTO users.roles (id, name) VALUES (1, 'ROLE_USER');
# INSERT INTO users.roles (id, name) VALUES (2, 'ROLE_ADMIN');
#
#
# create table users
# (
#     id       bigint auto_increment
#         primary key,
#     email    varchar(255) null,
#     password varchar(255) null,
#     username varchar(255) null
# );
#
# INSERT INTO users.users (id, email, password, username) VALUES (1, 'us@us.ru', '100', 'user');
# INSERT INTO users.users (id, email, password, username) VALUES (2, 'ad@ad.ru', '200', 'admin');
#
#
# create table users_roles
# (
#     user_id bigint not null,
#     role_id bigint not null,
#     constraint FK2o0jvgh89lemvvo17cbqvdxaa
#         foreign key (user_id) references users (id),
#     constraint FKj6m8fwv7oqv74fcehir1a9ffy
#         foreign key (role_id) references roles (id)
# );
#
# INSERT INTO users.users_roles (user_id, role_id) VALUES (1, 1);
# INSERT INTO users.users_roles (user_id, role_id) VALUES (2, 1);
# INSERT INTO users.users_roles (user_id, role_id) VALUES (2, 2);
#
