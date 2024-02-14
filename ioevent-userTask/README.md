# IOEvent User Task Sample
This repository contains two applications that demonstrate how to use the IOEvent implementation of the User Task. The first application is the main application, which contains our workflow, including a user task. This application has the IOEvent starter as a dependency. The second application, named ioevent-userTask-client, is a simple application that only has the IOEvent userTask starter as a dependency. This application gives the user the ability to interact with the user task and complete it.

This repository contains two applications written using IOEvent. it must run on Kafka middleware technologies. You have the option of running the samples against local or Docker containerized versions of Kafka. For convenience, `docker-compose.yml` files are provided as part of each application wherever it is applicable. 

# Sample Bpmn description 

The main application (ioevent-userTask) is used to search for orders manually in the stock. Initially, the process begins by creating an order that needs to be searched in the stock and sent to the next step, which is a user task. At this point, the workflow will pause, and our second application (ioevent-userTask-client) becomes aware of the user task. It already exposes endpoints that provide the user with the ability to interact with it. Now, the user can use the endpoint to view the list of waiting user tasks and obtain details about the product. At this stage, the user will check if the product is present or not and use another endpoint to send their response. The user task will then transmit this decision to the last step of our workflow, making this decision available for a dashboard in our system.

