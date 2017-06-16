DELETE FROM user_roles;
DELETE FROM votes;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('User2', 'user2@yandex.ru', 'password2');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_ADMIN', 100000),
  ('ROLE_USER', 100000),
  ('ROLE_USER', 100001),
  ('ROLE_USER', 100002);

INSERT INTO restaurants (name) VALUES
  ('name1'),
  ('name2');

INSERT INTO dishes (name, price, restaurant_id) VALUES
  ('dish1', 1000, 100003),
  ('dish2', 2000, 100003),
  ('dish3', 3000, 100004),
  ('dish4', 4000, 100004);

INSERT INTO votes (id, restaurant_id) VALUES
  (100000, 100003),
  (100001, 100003),
  (100002, 100004);