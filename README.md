# spring-integration
Hello world (and not only) for Spring Integration

## Try this -->
https://spring.io/guides/gs/integration/


## ActiveMQ
- docker pull webcenter/activemq
- docker run --name='activemq' -p 8161:8161 -p 61616:61616 -p 61613:61613 -it --rm -P webcenter/activemq:latest
- http://localhost:8161/admin (in browser --> admin / admin)
- Create a queue (e.g. channel-spring-integration)