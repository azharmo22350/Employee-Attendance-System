CREATE TABLE employmentstatus(
                                 id INT PRIMARY KEY AUTO_INCREMENT,
                                 status VARCHAR(30) NOT NULL
);



CREATE TABLE branch(
                       id_branch INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
                       name VARCHAR(20) NOT NULL

);

CREATE TABLE profilepic(
                           id_employee VARCHAR(20) PRIMARY KEY ,
                           picture BLOB

);
-- exicute after employee is creater
ALTER TABLE profilepic ADD CONSTRAINT fk_profilepic FOREIGN KEY (id_employee) REFERENCES employee(id) ON UPDATE CASCADE ;



CREATE TABLE employee(
                         id VARCHAR(20)  NOT NULL ,
                         branch_id INT NOT NULL ,
                         employment_status INT NOT NULL,
                         CONSTRAINT pk_employee PRIMARY KEY (id,branch_id,employment_status),
                         username VARCHAR(50) NOT NULL ,
                         password VARCHAR(300) NOT NULL ,
                         name VARCHAR(150) NOT NULL ,
                         nic VARCHAR(15) NOT NULL ,
                         contact VARCHAR(15) NOT NULL ,
                         role VARCHAR(10) CHECK ( role in ('ADMIN','HR','IT','REGULER')),
                         CONSTRAINT fk_branch FOREIGN KEY (branch_id) REFERENCES branch(id_branch) ON UPDATE CASCADE ,
                         CONSTRAINT fk_employmentstatus FOREIGN KEY (employment_status) REFERENCES employmentstatus(id) ON UPDATE CASCADE
);
