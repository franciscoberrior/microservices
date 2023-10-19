CREATE TABLE IF NOT EXISTS PERSON (
  document_id varchar(255) PRIMARY KEY,
  name varchar(255) NOT NULL,
  gender varchar(255) NOT NULL,
  age int NOT NULL,
  address varchar(255) NOT NULL,
  phone varchar(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS CLIENT (
  id bigserial PRIMARY KEY,
  password varchar(100) NOT NULL,
  status boolean NOT NULL,
  client_id varchar(255) NOT NULL,
  CONSTRAINT fk_person_id FOREIGN KEY (client_id) REFERENCES PERSON(document_id),
  CONSTRAINT client_un UNIQUE (client_id)
);

CREATE TABLE IF NOT EXISTS ACCOUNT (
  number varchar(255) PRIMARY KEY,
  type varchar(255) NOT NULL,
  initial_balance bigint NOT NULL,
  status boolean NOT NULL,
  client_id bigserial NOT NULL,
  CONSTRAINT fk_account_id FOREIGN KEY (client_id) REFERENCES CLIENT(id)
);

CREATE TABLE IF NOT EXISTS MOVEMENT (
  id bigserial PRIMARY KEY,
  date_movement timestamp NOT NULL,
  type varchar(255) NOT NULL,
  value bigint NOT NULL,
  balance bigint NOT NULL,
  account_number varchar(255) NOT NULL,
  CONSTRAINT fk_movement_id FOREIGN KEY (account_number) REFERENCES ACCOUNT(number)
);