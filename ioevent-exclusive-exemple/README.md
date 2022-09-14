# Exclusive Gateway Sample
This repository contains Exclusive Gateway applications written using IO Event. it must run on Kafka middleware technologies. You have the option of running the samples against local or Docker containerized versions of Kafka. For convenience, `docker-compose.yml` files are provided as part of each application wherever it is applicable. 

# Sample Bpmn description 

This application used to decide the way of traveling according to the destination distance , first of all the process start by choosing a travel destination then send the travel information to the next task , in the next task there is an exclusive gateway that will decide where to send the travel information according to destination distance , the travel information will be sent either to a task where the car will be attached to the travel information as a way to travel (in case travel distance is less than 300 km) or the plane will be attached to the travel information as a way to travel (in case travel distance is more than 300 km) .

# Following is the Bpmn implemented using IO Event


![alt text](https://raw.githubusercontent.com/ioevent-io/io-ioevent-samples/main/ioevent-exclusive-exemple/ioevent-exclusive-flow-exemple.svg)


