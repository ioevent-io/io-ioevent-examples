# Parallel Gateway Sample
This repository contains Parallel Gateway applications written using IO Event. it must run on Kafka middleware technologies. You have the option of running the samples against local or Docker containerized versions of Kafka. For convenience, `docker-compose.yml` files are provided as part of each application wherever it is applicable. 

# Sample Bpmn description 

This application used to process orders, first of all the process start by creating an order and send it to the next step  , in the next task there is an parallel gateway that will change the order state to pending and dispatch the order to both check stock task and check budget task ,in check budget task it will check if the customer has a sufficient budget to buy the order and the state will be updated according to the check, in the other hand a check will be made to see if there is enough of the demanded product in the stock and the state will be updated according to the check , a join task will wait for the output of both checks task to define the state of the order ( ACCEPTED , BUDGET_ERROR , STOCK_ERROR , ERROR ) , at the last task it will close and complete the orders with ACCEPTED state .  


# Following is the Bpmn implemented using IO Event

![alt text](https://raw.githubusercontent.com/ioevent-io/io-ioevent-samples/main/ioevent-parallel-exemple/ioevent-parrallel-flow-exemple.svg)
