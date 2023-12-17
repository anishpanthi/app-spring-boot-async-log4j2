create table if not exists user_tbl (
    id int auto_increment primary key,
    full_name varchar(50) not null,
    email varchar(50) not null
);

create table if not exists member (
    id int auto_increment primary key,
    type varchar(50) not null,
    full_name varchar(50) not null,
    words varchar(1000) not null,
    updated_name varchar(50) not null,
    updated_date_time datetime not null
);
