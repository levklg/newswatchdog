
create table users
(
    id bigserial not null primary key,
    username varchar(50),
    password varchar(50),
    usersetting_id bigserial

);
create table usersettings
(
    id bigserial not null primary key,
    mapWebSites varchar(255),
    listFindString varchar(255),
    userSetting varchar(255)

);