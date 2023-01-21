
create sequence hibernate_sequence start with 1 increment by 1;
create table users(
    id bigserial not null primary key,
    name varchar(50),
    password varchar(255),
    telegram_id bigserial,
    usersetting_id bigserial

);

create table usersettings(
    id bigserial not null primary key,
    mapwebsites_id bigserial ,
    listfindstring bigserial

);

create table user_setting_mapwebsites(
user_setting_id bigserial,
map_web_sites varchar(50),
map_web_sites_key varchar(50)
);

create table user_setting_list_find_string(
  user_setting_id bigserial not null primary key,
  list_find_string varchar(255)
);



