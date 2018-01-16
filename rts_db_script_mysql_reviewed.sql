drop database if exists cmc_recruitment;

create database if not exists cmc_recruitment;
use cmc_recruitment;

create table department(
	id bigint primary key auto_increment,
    title varchar(255),
    description varchar(255)
);
create table role(
	id bigint primary key auto_increment,
    role_name varchar(255)
);

create table user(
	id bigint primary key auto_increment,
    username varchar(255) unique not null,
    password varchar(255) not null,
    email varchar(255) unique not null,
    full_name varchar(255),
    avatar_url varchar(255),
    department_id bigint,
    isActive bit,
    constraint fk_user_department foreign key(department_id) references department(id)
);
create table user_role(
	user_id bigint,
    role_id bigint,
    constraint pk_user_role primary key(user_id, role_id),
    constraint fk_user_role_user foreign key(user_id) references user(id),
    constraint fk_user_role_role foreign key(role_id) references role(id)
);
CREATE TABLE `position`(
 id bigint PRIMARY KEY AUTO_INCREMENT,
 title varchar(255) NOT NULL,
 description varchar(255)
);
CREATE TABLE skill(
 id bigint PRIMARY KEY AUTO_INCREMENT,
 title varchar(255) NOT NULL,
 description varchar(255)
);
CREATE TABLE request_status(
 id bigint PRIMARY KEY AUTO_INCREMENT,
 title varchar(255) NOT NULL,
 description varchar(255)
);
create table request (
	id bigint AUTO_INCREMENT primary key,
    title varchar(255) not null,
    position_id bigint not null,
    deadline date,
    number integer(10) not null,
    description varchar(255) not null,
    major varchar(255),
    others varchar(255),
    salary varchar(50),
    benefit varchar(255),
    created_date date,
    edited_date date,
    published_date date,
    education varchar(255),
    priority integer(10),
    year_of_experience varchar(50),
    cv_deadline date,
    request_status_id bigint(10),
    created_by bigint(10),
    edited_by bigint(10),
    assignee_id bigint(10),
    constraint fk_request_request_status foreign key(request_status_id) references request_status(id),
    constraint fk_request_user_created_by foreign key(created_by) references `user`(id),
    constraint fk_request_user_edited_by foreign key(edited_by) references `user`(id),
    constraint fk_request_user_assigned_by foreign key(assignee_id) references `user`(id),
    constraint fk_request_position foreign key(position_id) references `position`(id)
);
CREATE TABLE request_skill(
 request_id bigint NOT NULL,
 skill_id bigint NOT NULL,
 CONSTRAINT pk_request_skill PRIMARY KEY(request_id, skill_id),
 CONSTRAINT fk_request_skill_request FOREIGN KEY(request_id) REFERENCES request(id),
 CONSTRAINT fk_request_skill_skill FOREIGN KEY(skill_id) REFERENCES skill(id)
);

CREATE TABLE candidate_status (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    description varchar(255)
);

CREATE TABLE interview_status (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    description varchar(255)
);

create table cv_status(
	id bigint primary key auto_increment,
    title varchar(255) unique not null,
    description varchar(255)
);

CREATE TABLE cv (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(255),
    last_name varchar(255),
    dob date,
    gender bit,
    phone varchar(15),
    email varchar(100),
    profile_img varchar(255),
    address varchar(255),
    education varchar(255),
    skills varchar(255) NOT NULL,
    work_experience text,
    cv_url varchar(255),
    status_id bigint,
    CONSTRAINT fk_cv_status FOREIGN KEY (status_id)
    REFERENCES cv_status(id)
);
create table cv_skill(
	cv_id bigint,
    skill_id bigint,
    primary key(cv_id, skill_id),
    constraint fk_cv_skill_cv foreign key(cv_id) references cv(id),
    constraint fk_cv_skill_skill foreign key(skill_id) references skill(id)
);
CREATE TABLE candidate (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    cv_id bigint NOT NULL,
    request_id bigint NOT NULL,
    status_id bigint NOT NULL,
    evaluate_point float,
    CONSTRAINT fk_candidate_cv FOREIGN KEY (cv_id)
    REFERENCES cv(id),
    CONSTRAINT fk_candidate_request FOREIGN KEY (request_id)
    REFERENCES request(id),
    CONSTRAINT fk_candidate_status FOREIGN KEY (status_id)
    REFERENCES candidate_status(id)
);

CREATE TABLE `comment` (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    candidate_id bigint NOT NULL,
    user_id bigint NOT NULL,
    comment_detail varchar(255) NOT NULL,
    create_date date,
    CONSTRAINT fk_comment_candidate FOREIGN KEY (candidate_id)
    REFERENCES candidate(id),
    CONSTRAINT fk_comment_user FOREIGN KEY (user_id)
    REFERENCES user(id)
);

CREATE TABLE interview (
    id bigint primary key AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    candidate_id bigint,
    time date,
    location varchar(255),
    note varchar(255),
    status_id bigint,
	CONSTRAINT fk_interview_candidate FOREIGN KEY (candidate_id)
    REFERENCES candidate(id),
    constraint fk_interview_interview_status foreign key(status_id) references interview_status(id)
);

CREATE TABLE assignee_interview (
    user_id bigint NOT NULL,
    interview_id bigint NOT NULL,
    primary key(user_id, interview_id),
    CONSTRAINT fk_assignee_user FOREIGN KEY (user_id)
    REFERENCES user(id),
    CONSTRAINT fk_assignee_interview FOREIGN KEY (interview_id)
    REFERENCES interview(id)
);

