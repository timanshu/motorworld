# motorworld
An example of how can we use MySQL along with Spring boot using docker-compose

All the configurations is done in docker-compose.yml


# How to?
In order to get the application running all you need to do is:
  1. Open your command-line terminal and browse to the root directory of this repository
  2. Package the Spring boot application using maven command 'mvn package'
  3. After succesful creation of package run "docker-compose up --build"
  
# The application
The containers are up. Application can be accessible at localhost:8070.

Just test the instance by doing some requests to application

1. Get all records:
        
        curl --location --request PUT 'http://localhost:8070/cars/1' \

2. Create new car instance 

        curl --location --request PUT 'http://localhost:8070/cars/1' \
        --header 'Content-Type: application/json' \
        --data-raw '{
               "id": 1,
                "name": "Audi"
        }'
 
 # Database
You can look at localhost:8081 for administration of databases through GUI. Username and password can be altered in docker-compose.yml before starting the containers.
