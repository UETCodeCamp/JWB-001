create database if not exists `my_wallet_systems`;
use `my_wallet_systems`;

drop table if exists `customers`;
create table `customers` (
	`id` int(11) auto_increment,
    `name` varchar(100) not null,
    `email` varchar(100) not null,
    `phone` varchar(50) not null,
    `balance` double not null,
    `created_date` datetime not null,
    `updated_date` datetime,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- insert into `customers`(`name`, `email`, `phone`, `balance`, `created_date`) values
-- ("Vũ Văn Học", "hocvanvu1999@gmail.com", "0343847478", 1000000, "2019-05-19"),
-- ("Nguyen Van An", "hocvanvu1999@gmail.com", "0963245801", 500000, "2019-05-19");