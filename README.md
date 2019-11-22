# Microservices-Messaging-with-Apache-Kafka
To run the project we need few configurations and setups as outlined:

1. What do you need on your development computer?
	JDK 1.8
	(Download Server JRE according to your OS and CPU from https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html.
	Single node Kafka cluster
	(Download Kafka 2.12-2.2.0 from http://kafka.apache.org/downloads.html.) - Download binary downloads *(Scala 2.12 - time of this guide)*

	Add JAVA_HOME - that to your jdk installation folder

2. Configure the Zookeeper Properties
	After downloading the Kafka single cluster, extract the folder and put it into your local drive. In here, we need to configure the Zookeeper. Zookeeper is basically used to manage the Kafka cluster and provides synchronization within distributed systems.
	Create the folder into the Kafka folder with the name of zookeeper to keep the file log.
	Go to your Kafka config directory. For me it’s `` D:\kafka\kafka_2.12-2.2.0\config ``, edit the *zookeeper.properties* file and change the following line,
	 `` dataDir=D:\Kafka\kafka_2.12-2.2.0\zookeeper ``



3. Configure the Kafka Server Properties
	Create the folder into the Kafka folder with the name of kafka_log to keep the log file.
	Go to your Kafka config directory. For me it’s ``D:\kafka\kafka_2.12-2.2.0\config``, edit the *server.properties* file and change the following line.
	
		# A comma separated list of directories under which to store log files    
		log.dirs=D:\Kafka\kafka_2.12-2.2.0\kafka_log    
		# The replication factor for the group metadata internal topics "__consumer_offsets" and "__transaction_state"    
		# For anything other than development testing, a value greater than 1 is recommended for to ensure availability such as 3.    
		offsets.topic.num.partitions=1    
		offsets.topic.replication.factor=1    
		transaction.state.log.replication.factor=1    
		transaction.state.log.min.isr=1    
		min.inaync.replicas=1    
		default.replication.factor=1   

4. How to start ZooKeeper and Kafka Server
   You need to make sure your ZooKeeper instance is up and running before starting the Kafka server.
   So, to run the ZooKeeper and Kafka instance, we need some commands to be available globally. Go to the Windows folder of Kafka folder> copy the path and set the path into the Environment Variable- The path should be like ``D:\kafka\kafka_2.12-2.2.0\bin\windows``
   
5. Go to your Kafka installation directory: For me, it’s ``D:\kafka\kafka_2.12-2.2.0\bin\windows``
   Open a command prompt and run the following command,
   ``zookeeper-server-start.bat D:\Kafka\kafka_2.12-2.2.0\config\zookeeper.properties`` 
   
6. After running the zookeeper follow the below steps.
   Go to your Kafka installation directory: For me, it’s ``D:\kafka\kafka_2.12-2.2.0\bin\windows``.
   Open a command prompt and run the following command,
  `` kafka-server-start.bat D:\Kafka\kafka_2.12-2.2.0\config\server.properties``
   
7. Creating Topics
 
	The Kafka topic has been divided into the number of partitions; you can say it is an anatomy of Kafka. It is the most essential part of this distributed messaging system. Topic should have a name to understand the purpose of the message that is stored and published into the server.
	 
	Now the time to create a topic with the name of “chat-message”. We are running it into only one Kafka server.
	Go to your Kafka installation directory: For me, it’s ``D:\kafka\kafka_2.12-2.2.0\bin\windows``
	Open a command prompt and run the following command,
	``kafka-topics.bat --create --zookeeper localhost:2181 -replication-factor 1 --partitions 1 --topic chat-message``  
	
Finally, checkout and run the projects:
Producer: http://localhost:8080
Consumer: http://localhost:8081

Visit the url: http://localhost:8080/send?message=hello
You will view logs ar the consumer console of the sent message
Check the IDE console for received message
