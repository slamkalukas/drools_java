Java Drools API testing
===

Build the application:

    mvn clean package

Run the application:

    java -jar target/buspass-ws-1.0.0-SNAPSHOT.jar

Send request to http://127.0.0.1:8080/makeDecision3

{
    "name": "MyNewRequest",
    "id": 1
}