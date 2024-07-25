-- Create the pizzas table
CREATE TABLE pizzas (
                        id INT PRIMARY KEY,
                        image_url VARCHAR(255) NOT NULL,
                        title VARCHAR(255) NOT NULL,
                        price DECIMAL(10, 2) NOT NULL,
                        category INT NOT NULL,
                        rating INT NOT NULL
);

-- Create the sizes table
CREATE TABLE sizes (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       size INT NOT NULL,
                       pizza_id INT,
                       FOREIGN KEY (pizza_id) REFERENCES pizzas(id)
);

-- Create the pizza_types table
CREATE TABLE pizza_types (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             type INT NOT NULL,
                             pizza_id INT,
                             FOREIGN KEY (pizza_id) REFERENCES pizzas(id)
);


INSERT INTO pizzas (id, image_url, title, price, category, rating) VALUES
                                                                       (1, 'https://media.dodostatic.net/image/r:292x292/11EF02823DBA2CB09EE4F90CBC5E227A.jpg', 'Dodo Pizza', 15, 1, 2),
                                                                       (2, 'https://media.dodostatic.net/image/r:292x292/11EF0286069492BA911C4D3B3376436C.jpg', 'Mexican', 26, 1, 3),
                                                                       (3, 'https://media.dodostatic.net/image/r:292x292/11EF0286349B277780CB97A8544A6AEC.jpg', 'Pizza Cheeseburger', 33, 1, 5),
                                                                       (4, 'https://media.dodostatic.net/image/r:292x292/11EF028659F4831082FB3FF274D0B999.jpg', 'Grill Veggie', 17, 1, 6),
                                                                       (5, 'https://media.dodostatic.net/image/r:292x292/11EF0C83F6699307BDCD7F4E443D87F8.jpg', 'Halb & Halb Pizza', 13, 2, 4),
                                                                       (6, 'https://media.dodostatic.net/image/r:292x292/11EF0286ED2F2E68B144144A261D5037.jpg', 'L.O.V.E. Pizza', 29, 2, 5),
                                                                       (7, 'https://media.dodostatic.net/image/r:292x292/11EF0287297E8D2FAA3C75AC74F8D486.jpg', 'Kinder Pizza', 10, 2, 6),
                                                                       (8, 'https://media.dodostatic.net/image/r:292x292/11EF0283DFE3970BA555B0D85E5C8302.jpg', 'Deine Pizza', 13, 3, 11),
                                                                       (9, 'https://media.dodostatic.net/image/r:292x292/11EE7D5D9D0E5599A408FCE95255CBC0.jpg', 'Salami', 29, 3, 23),
                                                                       (10, 'https://media.dodostatic.net/image/r:292x292/11EF0286B65F8F12A823048748DDE33D.jpg', 'München', 45, 4, 6),
                                                                       (11, 'https://media.dodostatic.net/image/r:292x292/11EE7D5DA07719C9B2AE7FDF4E95727B.jpg', '4 Cheeses', 45, 4, 6),
                                                                       (12, 'https://media.dodostatic.net/image/r:292x292/11EF0285D9A4B265A7A78E39D98840B3.jpg', 'Fiesta', 45, 5, 7),
                                                                       (13, 'https://media.dodostatic.net/image/r:292x292/11EF02846D3C184A867D674626FF4837.jpg', 'Carbonara', 33, 6, 7),
                                                                       (14, 'https://media.dodostatic.net/image/r:292x292/11EF028428DF5AAD9D50171778670692.jpg', 'Pepperoni Fresh', 44, 6, 8),
                                                                       (15, 'https://media.dodostatic.net/image/r:292x292/11EF028428DF5AAD9D50171778670692.jpg', 'Keçi əmcəyi', 34, 7, 8);



INSERT INTO sizes (id, size, pizza_id) VALUES
                                           (1, 26, 1), (2, 30, 1), (3, 40, 1),
                                           (4, 26, 2), (5, 30, 2), (6, 40, 2),
                                           (7, 26, 3), (8, 40, 3),
                                           (9, 30, 4), (10, 40, 4),
                                           (11, 30, 5), (12, 40, 5),
                                           (13, 26, 6), (14, 30, 6), (15, 40, 6),
                                           (16, 26, 7), (17, 30, 7), (18, 40, 7),
                                           (19, 30, 8), (20, 40, 8),
                                           (21, 26, 9), (22, 30, 9), (23, 40, 9),
                                           (24, 26, 10), (25, 30, 10), (26, 40, 10),
                                           (27, 26, 11), (28, 30, 11), (29, 40, 11),
                                           (30, 26, 12), (31, 30, 12), (32, 40, 12),
                                           (33, 26, 13), (34, 30, 13), (35, 40, 13),
                                           (36, 26, 14), (37, 30, 14), (38, 40, 14),
                                           (39, 26, 15), (40, 30, 15), (41, 40, 15);


INSERT INTO pizza_types (id, type, pizza_id) VALUES
                                                 (1, 0, 1), (2, 1, 1),
                                                 (3, 0, 2), (4, 1, 2),
                                                 (5, 0, 3), (6, 1, 3),
                                                 (7, 0, 4), (8, 1, 4),
                                                 (9, 0, 5), (10, 1, 5),
                                                 (11, 0, 6), (12, 1, 6),
                                                 (13, 0, 7), (14, 1, 7),
                                                 (15, 0, 8), (16, 1, 8),
                                                 (17, 0, 9), (18, 1, 9),
                                                 (19, 0, 10), (20, 1, 10),
                                                 (21, 0, 11), (22, 1, 11),
                                                 (23, 0, 12), (24, 1, 12),
                                                 (25, 0, 13), (26, 1, 13),
                                                 (27, 0, 14), (28, 1, 14),
                                                 (29, 0, 15), (30, 1, 15);
