-- DROP TABLE IF EXISTS tourist_trip;
-- DROP TABLE IF EXISTS trip;
-- DROP TABLE IF EXISTS instructor;
-- DROP TABLE IF EXISTS route_place;
-- DROP TABLE IF EXISTS route;
-- DROP TABLE IF EXISTS place;
-- DROP TABLE IF EXISTS attendance;
-- DROP TABLE IF EXISTS activity;
-- DROP TABLE IF EXISTS schedule;
-- DROP TABLE IF EXISTS tourist_group;
-- DROP TABLE IF EXISTS section_group;
-- DROP TABLE IF EXISTS amateur;
-- DROP TABLE IF EXISTS sportsman;
-- DROP TABLE IF EXISTS trainer;
-- DROP TABLE IF EXISTS tourist_competition;
-- DROP TABLE IF EXISTS competition;
-- DROP TABLE IF EXISTS tourist;
-- DROP TABLE IF EXISTS section;
-- DROP TABLE IF EXISTS section_manager;

CREATE TABLE IF NOT EXISTS section_manager (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name varchar(32) NOT NULL,
    second_name varchar(32) NOT NULL,
    birth_year int CHECK (birth_year > 0),
    employment_year int CHECK (birth_year > 0),
    salary int CHECK (salary > 0) NOT NULL
);

CREATE TABLE IF NOT EXISTS section (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(50) NOT NULL UNIQUE,
    manager_id int REFERENCES section_manager(id)
);

CREATE TABLE IF NOT EXISTS tourist (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name varchar(32) NOT NULL,
    second_name varchar(32) NOT NULL,
    gender varchar(1) CHECK(gender ='m' OR gender='f'),
    birth_year int CHECK (birth_year > 0),
    skill_category varchar(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS competition (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(50) NOT NULL,
    date date NOT NULL
);

CREATE TABLE IF NOT EXISTS tourist_competition (
    tourist_id int REFERENCES tourist(id),
    competition_id int REFERENCES competition(id)
);

CREATE TABLE IF NOT EXISTS trainer (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tourist_id int REFERENCES tourist(id) UNIQUE,
    section_id int REFERENCES section(id),
    salary int CHECK (salary > 0) NOT NULL
);

CREATE TABLE IF NOT EXISTS sportsman (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tourist_id int REFERENCES tourist(id) UNIQUE
);

CREATE TABLE IF NOT EXISTS amateur (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tourist_id int REFERENCES tourist(id) UNIQUE
);

CREATE TABLE IF NOT EXISTS section_group (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(40) NOT NULL UNIQUE,
    trainer_id int REFERENCES trainer(id),
    section_id int REFERENCES section(id)
);

CREATE TABLE IF NOT EXISTS tourist_group (
    tourist_id int REFERENCES tourist(id),
    group_id int REFERENCES section_group(id)
);

CREATE TABLE IF NOT EXISTS schedule (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    section_id int REFERENCES section(id),
    group_id int REFERENCES section_group(id),
    trainer_id int REFERENCES trainer(id),
    day_of_week varchar(12) NOT NULL,
    duration_mins int NOT NULL,
    time_of_day time NOT NULL,
    UNIQUE(group_id, day_of_week, time_of_day)
);

CREATE TABLE IF NOT EXISTS activity (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    schedule_id int REFERENCES schedule(id),
    date date NOT NULL,
    UNIQUE(schedule_id, date)
);

CREATE TABLE IF NOT EXISTS attendance (
    activity_id int REFERENCES activity(id),
    student_id int REFERENCES tourist(id)
);

CREATE TABLE IF NOT EXISTS route (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(100) NOT NULL UNIQUE,
    length_km int NOT NUll,
    route_type varchar(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS place (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(100) NOT NULL UNIQUE,
    address varchar(250) NOT NULL,
    latitude double precision NOT NULL,
    longitude double precision NOT NULL,
    UNIQUE(latitude, longitude)
);

CREATE TABLE IF NOT EXISTS route_place (
    route_id bigint REFERENCES route(id),
    place_id bigint REFERENCES place(id)
);

CREATE TABLE IF NOT EXISTS trip (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    route_id int REFERENCES route(id),
    instructor_id int REFERENCES tourist(id),
    start_date date NOT NULL,
    end_date date NOT NULL,
    duration_days int NOT NULL,
    required_skill_category varchar(32) NOT NULL,
    UNIQUE(route_id, start_date)
);

CREATE TABLE IF NOT EXISTS tourist_trip (
    tourist_id int REFERENCES tourist(id),
    trip_id int REFERENCES trip(id)
);
