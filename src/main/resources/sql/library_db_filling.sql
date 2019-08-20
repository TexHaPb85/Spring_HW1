
-- Створити таблицю Author(id, firstName, lastName, country, age)
CREATE TABLE public.authors
(
  id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(100) NOT NULL,
  surname VARCHAR(100) NOT NULL,
  country VARCHAR(100) NOT NULL,
  age INT NOT NULL
);
CREATE UNIQUE INDEX authors_id_uindex ON public.authors (id);

-- Створити таблицю Book(id, title,genre, description, rate)
CREATE TABLE books (
  id SERIAL PRIMARY KEY,
  title varchar(100) NOT NULL,
  genre varchar(100) NOT NULL,
  description varchar(255),
  rate int,
  authorId int
);
CREATE UNIQUE INDEX books_id_uindex ON public.books (id);

-- Додати по 20 рекордів в кожну табличку
INSERT INTO books (title,genre,description, rate) VALUES ('title1','genre1','description1', 1);
INSERT INTO books (title,genre,description, rate) VALUES ('title2','genre2','description2', 2);
INSERT INTO books (title,genre,description, rate) VALUES ('title3','genre3','description3', 3);
INSERT INTO books (title,genre,description, rate) VALUES ('title4','genre4','description4', 4);
INSERT INTO books (title,genre,description, rate) VALUES ('title5','genre5','description5', 5);
INSERT INTO books (title,genre,description, rate) VALUES ('title6','genre6','description6', 6);
INSERT INTO books (title,genre,description, rate) VALUES ('title7','genre7','description7', 7);
INSERT INTO books (title,genre,description, rate) VALUES ('title8','genre8','description8', 8);
INSERT INTO books (title,genre,description, rate) VALUES ('title9','genre9','description9', 9);
INSERT INTO books (title,genre,description, rate) VALUES ('title10','drama','description10', 10);
INSERT INTO books (title,genre,description, rate) VALUES ('title11','drama','description11', 11);
INSERT INTO books (title,genre,description, rate) VALUES ('title12','drama','description12', 12);
INSERT INTO books (title,genre,description, rate) VALUES ('title13','drama','description13', 13);
INSERT INTO books (title,genre,description, rate) VALUES ('title14','drama','description14', 14);
INSERT INTO books (title,genre,description, rate) VALUES ('title15','comedy','description15', 15);
INSERT INTO books (title,genre,description, rate) VALUES ('title16','drama','description16', 16);
INSERT INTO books (title,genre,description, rate) VALUES ('title17','drama','description17', 17);
INSERT INTO books (title,genre,description, rate) VALUES ('title18','fantastic','description18', 18);
INSERT INTO books (title,genre,description, rate) VALUES ('title19','prose','description19', 19);
INSERT INTO books (title,genre,description, rate) VALUES ('title20','genre11','description20', 20);

-- Додати по 20 рекордів в кожну табличку
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn1','fn1','counry_random',25);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn2','fn2','counry_random',25);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn3','fn3','counry_random',25);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn4','fn4','counry_random',25);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn5','fn5','counry_random',25);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn6','fn6','counry_random',25);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn7','fn7','counry_random',25);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn8','fn8','counry_random',25);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn9','fn9','counry_random',25);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn10','fn10','counry_random',26);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn11','fn11','counry_random',26);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn12','fn12','counry_random',26);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn13','fn13','counry_random',26);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn14','fn14','counry_random',26);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn15','fn15','counry_random',26);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn16','fn16','counry_random',26);
INSERT INTO authors (first_name,last_name, country, age) VALUES ('fn17','fn17','counry_random',26);


-- Вивести всі книги одного жанру
SELECT * FROM books
WHERE genre='genre11';

-- Вивести всі книги (лише title & genre) відсортувавши за rate
SELECT title, genre FROM books
ORDER BY rate;

-- Знайти найпопулярнішу книгу (за rate)
SELECT * FROM books
where rate=(SELECT MAX(rate) FROM books);

-- Вивести всі книги одного автора
SELECT books.id, books.title, books.genre, books.description, books.rate FROM books
  INNER JOIN authors_own ON books.id=authors_own.book_id AND authors_own.author_id=1;

-- Вивести всіх авторів, відсортованих за віком
SELECT * FROM authors ORDER BY age;

-- Вивести всіх авторів, в кого більше виданих книг
SELECT authors.id, authors.first_name, authors.last_name, authors.country, authors.age, COUNT(authors_own.author_id) AS count_books FROM authors
  INNER JOIN authors_own ON authors.id=authors_own.author_id
GROUP BY authors.id
ORDER BY count_books DESC
LIMIT 1;