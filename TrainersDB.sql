create database bootcampdb;

-- create table trainers
CREATE TABLE trainers (
tid INT AUTO_INCREMENT PRIMARY KEY,
tname VARCHAR(30) NOT NULL,
tlname VARCHAR(30) NOT NULL,
tsubject VARCHAR(30) NOT NULL
);

-- insert into trainers
INSERT INTO trainers (tname, tlname, tsubject)
values ('Konstantinos', 'Katakouzinos', 'Java Developer'),
('Giorgos', 'Papadopoulos', 'Java Developer'),
('Stylianos', 'Papadeas', 'C# Developer'),
('Nick', 'Nikolaou', 'C# Developer');

select * from trainers;