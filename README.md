This is a pokerhand analyzer/dealer

How to run?

Build project:

run command
```
mvn clean install
```

Docker build:
```
 docker build --tag=poker-server:latest . 
```


Run docker container on port 8080:
```
docker run -dp 8080:8080  poker-server:latest
```

Go to http://localhost:8080, now you can send requests.

To analyze a hand, include it in the url like this:
http://localhost:8080/analyze?hand=7s,7k,7r,7h,ts

To draw a hand and analyze it use
http://localhost:8080/deal
