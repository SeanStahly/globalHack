import PyMySQL


class sqlimporter:
    def __init__(self):
        self.run()

    def run(self):
        self.is_not_used()

        # INSERT DATABASE CONN INFO
        db_conn = PyMySQL.connect()
        cursor = db_conn.cursor()

        cursor.execute("DROP TABLE IF EXISTS EMPLOYEE")

        create_client_table = """CREATE TABLE Client (
                                 ClientId INT NOT NULL AUTO_INCREMENT,
                                 First_name CHAR(20),
                                 Last_name CHAR(20),
                                 Dob DATE,
                                 Gender CHAR(10),
                                 Nationality CHAR(20),
                                 Vet_status CHAR(20),
                                 Med_status CHAR(20),
                                 Phone_num INT(10),
                                 Abuse CHAR(20),
                                 Current_shelter CHAR(20),
                                 PRIMARY KEY(ClientId),
                                 FOREIGN KEY (ShelterId) REFERENCES Shelter(ShelterId))"""

        create_shelter_table = """CREATE TABLE Shelter (
                                  ShelterId INT NOT NULL AUTO_INCREMENT,
                                  Gender BOOLEAN,
                                  Abused BOOLEAN,
                                  Age_limit INT(5),
                                  Vet_Status BOOLEAN,
                                  Unknown_Occupants, CHAR(30),
                                  PRIMARY KEY(ShelterId))"""

        create_incoming_clients = """CREATE TABLE Incoming_client (
                                     IncomingClientId INT NOT NULL AUTO_INCREMENT,
                                     Phone_num INT(10),
                                     Time TIME NOT NULL,
                                     Gender CHAR(10),
                                     Age INT(5),
                                     Vet_status CHAR(20),
                                     Abused CHAR(20),
                                     Recommended_location CHAR(20),
                                     PRIMARY KEY(ClientId))"""

        cursor.execute(create_shelter_table)
        cursor.execute(create_client_table)
        cursor.close()

        # INSERT DATABASE CONN INFO
        db_conn = PyMySQL.connect()
        cursor = db_conn.cursor()
        cursor.execute("DROP TABLE IF EXISTS EMPLOYEE")
        cursor.execute(create_incoming_clients)
        cursor.close()

    def is_not_used(self):
        pass
sqlimporter()