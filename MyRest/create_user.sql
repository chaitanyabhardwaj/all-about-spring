DROP USER IF EXISTS 'myrestappuser'@'localhost';

CREATE USER 'myrestappuser'@'localhost' IDENTIFIED BY 'pass12345';

GRANT ALL PRIVILEGES ON * . * TO 'myrestappuser'@'localhost';