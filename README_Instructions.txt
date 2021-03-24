1)Total Lines Of Code ~ 8000

2)The Following features have been implemented:

2.1 User Account/Profile/Transaction management & MySQL - Implemented and Functional

2.2 Recommender - Implemented and Functional

2.3 Twitter matches - Implemented and Functional

2.4 Analytics & Visual Reports - Implemented and Functional                                  

2.5 Reviews & Trending & MongoDB - Implemented and Functional

2.6 Auto-Complete Search feature - Implemented and Functional

2.7 Google MAPS - Near ME search feature - Implemented and Functional

2.8 Knowledge Graph Searches & Neo4J - Implemented and Functional

3)All the 5 Assignment features have been Implemented along with Bonus Assignment#1 feature,
whereas Bonus Assignments 2,3 & 4 features have not been implemented. 


Inorder to run the Project Grocery Hub, please follow the following steps:

*Install Apache Tomcat Server, Neo4j, MySQL and MongoDB and also download MYSQL Workbench, MongoDB Compass, Neo4j Desktop and Anaconda Navigator

*The default Port Numbers are as follows:
Tomcat-8080, Mysql-3306, MongoDB-27017, Neo4j-7474 please make sure no other application is using these port numbers.

*Download the following JAR files from "https://mvnrepository.com/" and place them in the CLASSPATH in the Environment Variables:
servlet-api.jar,jsp-api,el-api.jar,commons-beanutils-1.9.3.jar,mysql-connector-java-8.0.21.jar,mongo-java-driver-3.2.2.jar,gson-2.6.2.jar,java-json.jar,jstl-1.2.jar

*Place the Grocery Hub folder inside Tomcat Installation default directory as follows:
"C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\Grocery Hub"

*Create a database named gorceryhub in MYSQL Workbench and run the Following Queries for the tables to be created.

1)registration:

CREATE TABLE `registration` (
  `Index` int NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `usertype` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `zipcode` bigint DEFAULT NULL,
  `storeid` int DEFAULT NULL,
  PRIMARY KEY (`Index`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


2)customerfeedback:

CREATE TABLE `customerfeedback` (
  `feedbackId` varchar(100) NOT NULL,
  `customerName` varchar(100) NOT NULL,
  `emailid` varchar(100) NOT NULL,
  `cproblem` varchar(10000) NOT NULL,
  PRIMARY KEY (`feedbackId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

3)customerorders:
CREATE TABLE `customerorders` (
  `OrderId` int NOT NULL,
  `username` varchar(150) NOT NULL,
  `emailid` varchar(150) NOT NULL,
  `firstname` varchar(150) NOT NULL,
  `lastname` varchar(150) NOT NULL,
  `customerAddress` varchar(150) NOT NULL,
  `customerZip` bigint NOT NULL,
  `customerPhoneNo` bigint NOT NULL,
  `orderNotes` varchar(150) NOT NULL,
  `creditCardNo` bigint NOT NULL,
  `productId` varchar(150) NOT NULL,
  `productName` varchar(150) NOT NULL,
  `pricePerItem` double NOT NULL,
  `no_of_items` int NOT NULL,
  `category` varchar(150) NOT NULL,
  `productSubTotal` double NOT NULL,
  `productWeight` varchar(150) NOT NULL,
  `orderTotal` double NOT NULL,
  `prodImg` varchar(45) NOT NULL,
  `StoreId` varchar(150) NOT NULL,
  `StoreAddress` varchar(150) NOT NULL,
  `StoreZip` bigint NOT NULL,
  `deliveryType` varchar(150) NOT NULL,
  `purchaseDate` date NOT NULL,
  `expectedDeliveryDate` date NOT NULL,
  PRIMARY KEY (`OrderId`,`username`,`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

4)product_details:
CREATE TABLE `product_details` (
  `Index` int NOT NULL AUTO_INCREMENT,
  `ProductId` varchar(50) NOT NULL,
  `ProductName` varchar(50) NOT NULL,
  `Image` varchar(50) NOT NULL,
  `Price` double NOT NULL,
  `Discount` double NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Number_Of_Items` int NOT NULL,
  `Weight` varchar(50) NOT NULL,
  `s1` varchar(3) NOT NULL DEFAULT '',
  `s2` varchar(3) NOT NULL DEFAULT '',
  `s3` varchar(3) NOT NULL DEFAULT '',
  `s4` varchar(3) NOT NULL DEFAULT '',
  `s5` varchar(3) NOT NULL DEFAULT '',
  PRIMARY KEY (`Index`,`ProductId`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

5)storelist: 

CREATE TABLE `storelist` (
  `StoreID` int NOT NULL,
  `StoreName` varchar(45) DEFAULT NULL,
  `StoreAddress` varchar(45) DEFAULT NULL,
  `StoreZip` int DEFAULT NULL,
  `StoreLatLang` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`StoreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


Import the respective csv files from the "DATA" folder inside Grocery Hub Zip to populate the tables. 

*Open Neo4j.txt inside the "DATA" folder and run the load CSV Cypher code to generate Knowledge Graph in the Neo4j Browser.

* Open jupyter notebook from the Anaconda Navigator and run the two python ipynb scripts(BestBuyDealMatches_Script,ProductRecommender) inside "Python" folder in the Grocery Hub Zip
*The Twitter API Credentials have also been provided in the "PYTHON" folder with the name "credentials.txt" inside the "Python" folder in the Grocery Hub Zip
*The Google Maps Javascript API key is "AIzaSyDpTAqOF1ddrDp_AierJmhi2tF297FkEi4"

*Open Command Prompt and go to the following directory
"C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\Grocery Hub\WEB-INF\classes",
To compile all the java class files enter the command :javac *.java, 
before compiling please change the username and password from the the jdbc connection String in the Code.

*Open a web browser and type the URL: http://localhost:8080/Grocery%20Hub



