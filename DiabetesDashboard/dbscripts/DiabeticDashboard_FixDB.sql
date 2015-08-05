use diabetic_dashboard_data;

drop table A1c(
);

create table A1c(
	UserID varchar(50) not null,
    LabValue decimal (2,1),
    
    foreign key(UserID) references UserDB(UserID)
);
