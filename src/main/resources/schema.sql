CREATE TABLE IF NOT EXISTS Customer(
    id INTEGER AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
    primary key(id)
);

INSERT INTO Customer(firstName, last_name, email)
VALUES ('NameFIrst', 'NamelAst', 'first.last@test.com') 