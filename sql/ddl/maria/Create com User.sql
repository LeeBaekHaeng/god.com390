-- MariaDB 10.5.8 Stable 2020-11-11

CREATE USER 'com'@'127.0.0.1';
ALTER USER 'com'@'127.0.0.1'
IDENTIFIED BY 'com01' ;
GRANT Delete ON com.* TO 'com'@'127.0.0.1';
GRANT Insert ON com.* TO 'com'@'127.0.0.1';
GRANT Select ON com.* TO 'com'@'127.0.0.1';
GRANT Update ON com.* TO 'com'@'127.0.0.1';
