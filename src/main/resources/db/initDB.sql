CREATE TABLE IF NOT EXISTS section_manager (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name varchar(32) NOT NULL,
    second_name varchar(32) NOT NULL,
    birth_year int CHECK (birth_year > 0),
    employment_year int CHECK (birth_year > 0)
);

CREATE TABLE IF NOT EXISTS section (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(50) NOT NULL,
    manager_id int REFERENCES section_manager(id)
);

CREATE TABLE IF NOT EXISTS tourist (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name varchar(32) NOT NULL,
    second_name varchar(32) NOT NULL,
    gender varchar(1) CHECK(gender ='m' OR gender='f'),
    birth_year int CHECK (birth_year > 0)
);

CREATE TABLE IF NOT EXISTS competition (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(50) NOT NULL,
    date timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS tourist_competition (
    tourist_id int REFERENCES tourist(id),
    competition_id int REFERENCES competition(id)
);

CREATE TABLE IF NOT EXISTS trainer (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tourist_id int REFERENCES tourist(id),
    section_id int REFERENCES section(id)
);

CREATE TABLE IF NOT EXISTS section_group (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(40) NOT NULL UNIQUE,
    trainer_id int REFERENCES tourist(id),
    section_id int REFERENCES section(id)
);

CREATE TABLE IF NOT EXISTS tourist_group (
    tourist_id int REFERENCES tourist(id),
    group_id int REFERENCES section_group(id)
);