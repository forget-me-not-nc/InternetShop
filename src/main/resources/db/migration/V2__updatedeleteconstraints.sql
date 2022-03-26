alter table accounts drop constraint fkgymog7firrf8bnoiig61666ob;

alter table accounts
	add constraint fkgymog7firrf8bnoiig61666ob
		foreign key (client_id) references clients
			on update cascade on delete cascade;


alter table accounts drop constraint fknjuop33mo69pd79ctplkck40n;

alter table accounts
    add constraint fknjuop33mo69pd79ctplkck40n
        foreign key (user_id) references users
            on update cascade on delete cascade;

alter table book_has_author drop constraint fkq7t4b1gg1eqpjo0kom4t8vktl;

alter table book_has_author
    add constraint fkq7t4b1gg1eqpjo0kom4t8vktl
        foreign key (book_id) references books
            on update cascade on delete cascade;

alter table book_has_author drop constraint fk8oktfipod4dby36a7wj285yn8;

alter table book_has_author
    add constraint fk8oktfipod4dby36a7wj285yn8
        foreign key (author_id) references authors
            on update cascade on delete cascade;

alter table book_has_category drop constraint fktoynsl1vx9orlcuol20u48si8;

alter table book_has_category
    add constraint fktoynsl1vx9orlcuol20u48si8
        foreign key (book_id) references books
            on update cascade on delete cascade;

alter table book_has_category drop constraint fk5cs1uc6w5jhddv9p4e6kro5hd;

alter table book_has_category
    add constraint fk5cs1uc6w5jhddv9p4e6kro5hd
        foreign key (category_id) references categories
            on update cascade on delete cascade;