# IO Event Sample Applications
This repository contains a collection of applications written using IO Event. All the applications are self contained. They must run on Kafka middleware technologies. You have the option of running the samples against local or Docker containerized versions of Kafka. For convenience, `docker-compose.yml` files are provided as part of each application wherever it is applicable. For this reason, Docker Compose is required and it’s recommended to use the latest version. These compose files bring up the middleware Kafka and other necessary components for running each app. If you bring up Kafka in Docker containers, please make sure that you bring them down while in the same sample directory. You can read the README that is part of each sample and follow along the instructions to run them.

You can build the entire samples by going to the root of the repository and then do: ./mvnw clean package However, the recommended approach to build them is to pick the sample that you are interested in and go to that particular app and follow the instructions there in the README for that app.

# Following is the list of various sample applications provided

## Source samples

* Hello World Sample

![alt text](https://raw.githubusercontent.com/ioevent-io/io-ioevent-samples/main/ioevent-hello-world/ioevent-hello-world-diagram.svg)

* Exclusive Gateway Sample

![alt text](https://raw.githubusercontent.com/ioevent-io/io-ioevent-samples/main/ioevent-exclusive-exemple/ioevent-exclusive-flow-exemple.svg)

* Parallel Gateway Sample

![alt text](https://raw.githubusercontent.com/ioevent-io/io-ioevent-samples/main/ioevent-parallel-exemple/ioevent-parrallel-flow-exemple.svg)

* File Processing Sample

![alt text](https://raw.githubusercontent.com/ioevent-io/io-ioevent-samples/main/ioevent-file-processing/ioevent-file-processing-exemple.svg)
