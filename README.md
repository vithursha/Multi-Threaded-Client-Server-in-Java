# Multi-Threaded-Client-Server-in-Java

## Introduction
This assignment aims to create a car park management system using a multi-threaded client-server system implemented in Java. The car park management system, with a maximum capacity of 5, will have four clients (two entrance and two exits) and each entry will have a queue and the aim of the server is to manage the overall number of cars in the car park. This will be achieved by the clients sending requests to the server when a car is entering or leaving the car park and the server taking actions accordingly. 

## How to run 
To run the car park management system, first the CarParkServer class is run, followed by the Client classes. To add a car, enter "ce" in the consoles of the entry classes and to remove a car from the car park, type "cl" in the console of the exit classes. In summary, at first, threads are created and executed in the server. Then once the clients established a connection with the server, the server takes the user input and processes it using the state class and outputs the correct output. Meanwhile, the Thread class maintains synchronization and makes sure only one thread is run at one time. 
