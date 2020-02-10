# spring-cloud-stream-publisher
###Message publisher API to publish messages on messaging streams. Here I am using spring cloud stream, which has variety of binder implementations avaiable. Means without doing any code changes we can easily switch the underlying messaging layer just by changing the maven dependencies.

## Setup instructions..
1. Download Kafka from their official page.
 [Download](http://apachemirror.wuchna.com/kafka/2.3.1/kafka_2.11-2.3.1.tgz).

2. Start Zookeeper server
> kafka_2.12-2.3.1\bin\windows>zookeeper-server-start.bat ..\..\config\zookeeper.properties

3. Start Kafka broker 
> kafka_2.12-2.3.1\bin\windows>kafka-server-start.bat ..\..\config\server.properties>

4. Create a Kafka Topic to publish data in it
> kafka_2.12-2.3.1\bin\windows>kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic spring-cloud-stream

## Start the kafka publisher application
> mvn spring-boot:run
