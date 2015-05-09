API-TestSuite-V1.5
==================

API Test Suite to perform Black box testing of the 1.5 version of the Sensor Data Service Platform API.

Steps to run:
===========
1. git clone the repository

2. To Run Unit and Integration test cases, please run : mvn test

3. To Run performance tests of the API, please run : mvn gatling:execute -Dgatling.simulationClass=unit.APISimulationV15
