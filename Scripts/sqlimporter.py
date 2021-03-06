import pymysql


class sqlimporter:
    def __init__(self):
        self.run()

    def run(self):
        self.is_not_used()

        # # INSERT DATABASE CONN INFO
        db_conn = pymysql.connect(host='globalhack.il1.rdbs.ctl.io', user='devlopers', password='Eightspaces8', db='globalhack', port=49423)
        print("Connection Successful...")
        cursor = db_conn.cursor()

        # Makes sure that there isn't already a table in the database
        cursor.execute("DROP TABLE IF EXISTS Client")
        cursor.execute("DROP TABLE IF EXISTS Shelter")

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
                                 Current_shelter INT(10),
                                 PRIMARY KEY(ClientId),
                                 FOREIGN KEY (Current_shelter) REFERENCES Shelter(ShelterId))"""

        create_shelter_table = """CREATE TABLE Shelter (
                                  ShelterId INT NOT NULL AUTO_INCREMENT,
                                  Gender CHAR(20),
                                  Abused BOOLEAN,
                                  Age_limit INT(5),
                                  Vet_Status BOOLEAN,
                                  Unknown_Occupants CHAR(30),
                                  PRIMARY KEY(ShelterId))"""

        # Executes the Creation query then closes the connection
        cursor.execute(create_shelter_table)
        cursor.execute(create_client_table)
        cursor.close()

        # INSERT DATABASE CONN INFO
        db_conn = pymysql.connect(host='GlobalHack2.il1.rdbs.ctl.io', user='devlopers', password='Eightspaces8', db='globalhack', port=49428)
        cursor = db_conn.cursor()
        cursor.execute("DROP TABLE IF EXISTS IncomingClient")

        create_incoming_clients = """CREATE TABLE IncomingClient (
                                     IncomingClientId INT NOT NULL AUTO_INCREMENT,
                                     Phone_num INT(10),
                                     Time TIME NOT NULL,
                                     Gender CHAR(10),
                                     Age INT(5),
                                     Vet_status CHAR(20),
                                     Abused CHAR(20),
                                     Recommended_location CHAR(20),
                                     Record_creation_date DATETIME,
                                     PRIMARY KEY(IncomingClientId))"""

        cursor.execute(create_incoming_clients)
        cursor.close()

    def is_not_used(self):
        pass
sqlimporter()
