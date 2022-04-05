drop table if exists transaction;
create table IF NOT EXISTS transaction (
id BIGINT,
user_name VARCHAR,
merchant VARCHAR,
amount FLOAT,
discount FLOAT,
created_on TIMESTAMP DEFAULT now(),
updated_on TIMESTAMP DEFAULT current_timestamp,
PRIMARY KEY (id)
);
create index if not exists transactionindex on transaction (user_name);

drop table if exists user_table;
create table IF NOT EXISTS user_table (
email VARCHAR,
name VARCHAR,
credit_limit FLOAT,
dues FLOAT,
created_on TIMESTAMP DEFAULT now(),
updated_on TIMESTAMP DEFAULT current_timestamp,
PRIMARY KEY (email),
UNIQUE(name)
);
create index if not exists userindex on user_table (name);

drop table if exists merchant;
create table IF NOT EXISTS merchant (
email VARCHAR,
name VARCHAR,
discount_percentage FLOAT,
total_discount_amount FLOAT,
created_on TIMESTAMP DEFAULT now(),
updated_on TIMESTAMP DEFAULT current_timestamp,
PRIMARY KEY (email),
UNIQUE(name)
);
create index if not exists merchantindex on merchant (name);
