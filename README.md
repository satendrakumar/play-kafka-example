# play-kafka-example

#### Steps to Install and Run zookeeper and kafka on your system : 

Step 1: Download kafka from [here](http://mirror.fibergrid.in/apache/kafka/0.10.0.0/kafka_2.11-0.10.0.1.tgz)

Once you download it, Set number of log partitions per topic to 8 in server.properties

    num.partitions=8

Step2: Extract it

    $ tar -xzf kafka_2.11-0.10.0.1.tgz
    $ cd  kafka_2.11-0.10.0.1

Step3: Start the server

Start  zookeeper:

     $ bin/zookeeper-server-start.sh config/zookeeper.properties

Start  Kafka server:

    $ bin/kafka-server-start.sh config/server.properties
    
#### Clone Project:
   
    
    $ git clone git@github.com:satendrakumar06/play-kafka-example.git
    
    $ cd play-kafka-example
    
    $ ./activator run
    
####Start Consumer & producer:
  
    $ curl http://localhost:9000/start
