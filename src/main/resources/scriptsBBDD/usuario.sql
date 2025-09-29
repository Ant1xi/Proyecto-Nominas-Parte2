CREATE USER 'nominas_user'@'localhost' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON gestor_nominas.* TO 'nominas_user'@'localhost';

FLUSH PRIVILEGES;
