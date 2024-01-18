alter table if exists losses drop constraint if exists FKkv9n2335uc35akmhey7tm4go3;
alter table if exists losses drop constraint if exists FK6xlt75yjb7h85mt4fx2v2jhi3;
alter table if exists losses drop constraint if exists FK4mrkn0rxbvwcd4yvmjbc9f6su;
alter table if exists matches drop constraint if exists FKjqepgamspeqo5q36vffq2h593;
alter table if exists matches_players drop constraint if exists FKnr3am0sit640lj2anyi8l6do1;
alter table if exists matches_players drop constraint if exists FKtcp74to6ylu32ibfuo1c4rvqv;
alter table if exists matches_teams drop constraint if exists FKkwfna9ve2e5njqqexc1naca2y;
alter table if exists matches_teams drop constraint if exists FK6v7dfuey9c4ekvfm8kegi8i4c;
alter table if exists rounds drop constraint if exists FKlbene8twdhl7tqe4qyryx9yn9;
alter table if exists rounds drop constraint if exists FKmpt307dasls8sg6w3288a0a1t;
alter table if exists scores drop constraint if exists FKmhr6nu0xje0kgubcx0j405gwq;
alter table if exists scores drop constraint if exists FK4akpbasxcjp3h2uind72q1gqm;
alter table if exists scores drop constraint if exists FKs3t291q06nrji21wr6m8n9gvs;
alter table if exists teams_players drop constraint if exists FK8iqa3ynvxof4qecf8nlpfsiy5;
alter table if exists teams_players drop constraint if exists FK5sgep6k6ofdca2f3qjt9o34gg;
alter table if exists wins drop constraint if exists FKr08ev1nsa6ve7mqccee0m6lwi;
alter table if exists wins drop constraint if exists FK9ibuqdsn0db7pqadj02bpw23i;
alter table if exists wins drop constraint if exists FK6wd0kd6cat72krn1jrhp26d6h;
drop table if exists courses cascade;
drop table if exists events cascade;
drop table if exists losses cascade;
drop table if exists matches cascade;
drop table if exists matches_players cascade;
drop table if exists matches_teams cascade;
drop table if exists players cascade;
drop table if exists rounds cascade;
drop table if exists scores cascade;
drop table if exists teams cascade;
drop table if exists teams_players cascade;
drop table if exists wins cascade;
create table courses (course_name varchar(255) not null, course_city varchar(255), course_state varchar(255), primary key (course_name));
create table events (event_name varchar(255) not null, event_end_date date, event_location varchar(255), event_start_date date, primary key (event_name));
create table losses (loss_id uuid not null, result varchar(255), match_id uuid, player_id varchar(255), team_name varchar(255), primary key (loss_id));
create table matches (match_id uuid not null, match_name varchar(255), round_id uuid, primary key (match_id));
create table matches_players (singles_matches_match_id uuid not null, players_player_id varchar(255) not null);
create table matches_teams (matches_match_id uuid not null, teams_team_name varchar(255) not null);
create table players (player_id varchar(255) not null, password_hash varchar(255), player_age int4 not null, player_city varchar(255), player_first_name varchar(255), player_handicap int4 not null, player_last_name varchar(255), player_nickname varchar(255), player_state varchar(255), role varchar(255), primary key (player_id));
create table rounds (round_id uuid not null, round_name varchar(255), course_name varchar(255), event_name varchar(255), primary key (round_id));
create table scores (score_id uuid not null, score int4, match_id uuid, player_id varchar(255), round_id uuid, primary key (score_id));
create table teams (team_name varchar(255) not null, primary key (team_name));
create table teams_players (teams_team_name varchar(255) not null, players_player_id varchar(255) not null);
create table wins (win_id uuid not null, result varchar(255), match_id uuid, player_id varchar(255), team_name varchar(255), primary key (win_id));
alter table if exists losses add constraint FKkv9n2335uc35akmhey7tm4go3 foreign key (match_id) references matches;
alter table if exists losses add constraint FK6xlt75yjb7h85mt4fx2v2jhi3 foreign key (player_id) references players;
alter table if exists losses add constraint FK4mrkn0rxbvwcd4yvmjbc9f6su foreign key (team_name) references teams;
alter table if exists matches add constraint FKjqepgamspeqo5q36vffq2h593 foreign key (round_id) references rounds;
alter table if exists matches_players add constraint FKnr3am0sit640lj2anyi8l6do1 foreign key (players_player_id) references players;
alter table if exists matches_players add constraint FKtcp74to6ylu32ibfuo1c4rvqv foreign key (singles_matches_match_id) references matches;
alter table if exists matches_teams add constraint FKkwfna9ve2e5njqqexc1naca2y foreign key (teams_team_name) references teams;
alter table if exists matches_teams add constraint FK6v7dfuey9c4ekvfm8kegi8i4c foreign key (matches_match_id) references matches;
alter table if exists rounds add constraint FKlbene8twdhl7tqe4qyryx9yn9 foreign key (course_name) references courses;
alter table if exists rounds add constraint FKmpt307dasls8sg6w3288a0a1t foreign key (event_name) references events;
alter table if exists scores add constraint FKmhr6nu0xje0kgubcx0j405gwq foreign key (match_id) references matches;
alter table if exists scores add constraint FK4akpbasxcjp3h2uind72q1gqm foreign key (player_id) references players;
alter table if exists scores add constraint FKs3t291q06nrji21wr6m8n9gvs foreign key (round_id) references rounds;
alter table if exists teams_players add constraint FK8iqa3ynvxof4qecf8nlpfsiy5 foreign key (players_player_id) references players;
alter table if exists teams_players add constraint FK5sgep6k6ofdca2f3qjt9o34gg foreign key (teams_team_name) references teams;
alter table if exists wins add constraint FKr08ev1nsa6ve7mqccee0m6lwi foreign key (match_id) references matches;
alter table if exists wins add constraint FK9ibuqdsn0db7pqadj02bpw23i foreign key (player_id) references players;
alter table if exists wins add constraint FK6wd0kd6cat72krn1jrhp26d6h foreign key (team_name) references teams;
