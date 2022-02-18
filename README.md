# Adidas Coding Challenge


### Run the project
In order to run the project you need to execute the next commands in the master branch repository
```sh
cd docker
docker network create my_network --subnet=10.11.0.0/16
docker run --name mysql_acc -p 3306:3306 -e MYSQL_ROOT_PASSWORD=toor --network my_network --ip 10.11.0.10 -d mysql:latest
docker build -t acc_servs .
docker exec -i mysql_acc mysql -ptoor mysql < User_Data.sql
docker run --name subscriptionservices -p 8081:8081 -p 8082:8082 -p 8083:8083 --network my_network --ip 10.11.0.11 acc_servs
```
This commands start two docker containers. One starts a mysql database and the other one the three services required in the statement; and connect them to the same network.
### Test the services
The endpoints are divided in two projects. 

### PUBLIC SERVICES
The first project is the public services projects that exposes two endpoints that can be used to create a new subscription or delete an existing one.
##### CREATE SUBSCRIPTION
Endpoint: http://localhost:8002/subscription/create
Method: POST
Response: The ID of the subscription just created
Example Request:
```json
{
    "campaignId":1,
    "firstName":"Javier",
    "email":"javiercalatayudginer@gmail.com",
    "gender": "M",
    "consent": true,
    "birthDate": "1997-07-18"
}
```
##### DELETE SUBSCRIPTION
Endpoint: http://localhost:8002/subscription/delete?email=<email to delete>
Method: GET
Response: Boolean True
Example Request: http://localhost:8002/subscription/delete?email=javiercalatayudginer@gmail.com

### MAIL SERVICES
The second project is the mail artifact that exposes endpoints to send messages automately. It also has two endpoints that can be used to send a message to every user or to the users subscribed to an specific campaign.

##### SEND TO EVERYONE
Endpoint: http://localhost:8083/email/send
Method: POST
Response: Boolean True
Example Request:
```json
{
    "message":"Hello World!"
}
```
##### SEND TO USERS FROM SPECIFIC CAMPAIGN
Endpoint: http://localhost:8083/email/send/<campignId>
Method: POST
Response: Boolean True
Example Request:http://localhost:8083/email/send/1
```json
{
    "message":"Hello World!"
}
```

### CRUD SERVICES
The projects exposed before don't access the database directly. They use the sping REST tools to call the endpoints of the main project. This main project is the responsible of executing the queries that retrieve and store information in the database. It expose four endpoints that cover the main CRUD operation of creating, deleting and searching. In a production enviorement, these endpoints shouldn't be called directly.

##### CREATE SUBSCRIPTION
Endpoint: http://localhost:8001/subscription/create
Method: POST
Response: The object just created
Example Request:
```json
{
    "campaignId":1,
    "firstName":"Javier",
    "email":"javiercalatayudginer@gmail.com",
    "gender": "M",
    "consent": true,
    "birthDate": "1997-07-18"
}
```
##### DELETE SUBSCRIPTION
Endpoint: http://localhost:8001/subscription/delete/<subscriptionId>
Method: GET
Response: Boolean True
Example Request: http://localhost:8001/subscription/delete/1

##### FIND ALL
Endpoint: http://localhost:8001/subscription/findall
Method: GET
Response: A list with all the objects in the database
Example Request: http://localhost:8001/subscription/findall

##### FIND BY FILTERS
Endpoint: http://localhost:8001/subscription/find
Method: POST
Description: This endpoint allows you to search using any of the parameters of the subscription table(except birthdate)
Response: A list with all the objects in the database that matched with the filters
Example Request:
```json
{
    "campaignId":1,
    "firstName":"Javier",
    "email":"javiercalatayudginer@gmail.com",
    "gender": "M",
    "consent": true
}
```