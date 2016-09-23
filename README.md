# _Hair-salon Program_

#### By Garrett Boggs

## Description

_A Hair-salon program created with spark framework, java, and sql databases_

## Setup/Installation Requirements

* In PSQL:
* CREATE DATABASE hair_salon;
* CREATE TABLE stylists (id serial PRIMARY KEY, name varchar, details varchar);
* CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylistid int, details varchar);
* CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;

* _Copy the repository from GitHub_
* _Open in code editor of your choice_
* _Make sure you have gradle and junit installed!_
* _Gradle run and open at [http://localhost:4567](http://localhost:4567)_

## GitHub link

https://github.com/GarrettBoggs/hair-salon

## Licensing

* This project is licensed under the terms of the MIT license.

## Specs

  **Clients can be created**

  * Example input: New Client: "Jeff"
  * Example output: Client: Jeff

  **Stylists can be created**

  * Example input: New Stylist: "Zelda"
  * Example output: Stylist: Zelda

  **Multiple Clients can be assigned to one Stylist**

  * Example input: New Stylist: "Zelda"
  * Example output: Stylist: Zelda

  **Clients can be deleted**

  * Example input: Delete client: "Jeff"
  * Example output: none

  **Stylists can be deleted**

  * Example input: Delete Stylist: "Zelda"
  * Example output: none

  **Clients's details can be updated**
  * Example input: New Client: "Jeff"
  * Example output: Client: Jeff Details: None

  * Example input: Enter details: "Regular customer"
  * Example output: Client: Jeff Details: "Regular customer"


  **User details can be updated**
  * Example input: New Stylist: "Zelda"
  * Example output: Stylist: Zelda

  * Example input: Enter details: "Specialty Haircut: Mohawk"
  * Example output: Stylist: Zelda Details: "Specialty Haircut: Mohawk"



Copyright (c) 2016 **Garrett Boggs**
