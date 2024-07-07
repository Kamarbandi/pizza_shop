select * from pizzas;

drop table pizzas;

insert into pizzas (image_url, title, price, category, rating)
values
    ('https://media.dodostatic.net/image/r:292x292/11EF02823DBA2CB09EE4F90CBC5E227A.jpg', 'Dodo Pizza', 15, 1, 2),
    ('https://media.dodostatic.net/image/r:292x292/11EF0286069492BA911C4D3B3376436C.jpg', 'Mexican', 26, 1, 3);

*******************

drop table sizes;

select * from sizes;

insert into sizes (size, pizza_id)
values
    (12, 3),
    (15, 3),
    (25, 3);

*******************

select * from pizza_types;

insert into pizza_types (type, pizza_id)
values
    (0, 3), (1, 3);

