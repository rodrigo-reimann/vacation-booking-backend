# Vacation Booking Backend Migration Project

## Overview

This is a personal fictional project. The project scenario is: a modernization initiative for a legacy backend system of a travel agency, developed with the aim of migrating critical functionalities to a more contemporary framework. The new backend, developed in Java using Spring Boot, is designed to work seamlessly with an Angular-based front-end vacation booking application, enhancing the system's maintainability, scalability, and compatibility.

## Getting Started

### Prerequisites

- Java JDK 11 or later
- MySQL Server 5.7 or later
- Maven 3.6 or later
- Angular CLI
- Node.js and npm

Ensure that all prerequisites are installed and correctly configured on your system before proceeding with the installation of the project.

### Installation

#### Backend Setup

1. Clone the repository to your local machine.
2. Start your MySQL Server and create a new database for the application.
3. Run the `create_and_populate_db.sql` script provided in the project's root directory to set up and populate your database.
4. Update `src/main/resources/application.properties` with your MySQL instance details.
5. From the project root directory, run `mvn spring-boot:run` to start the application.

#### Frontend Setup

1. Navigate to the front-end application directory.
2. Run `npm install` to install the required node modules.
3. Start the Angular application by running `ng serve`. Ensure the backend service is running beforehand.
4. Open your browser and go to `http://localhost:4200` to view the application.

## Project Structure

- **Controllers**: REST controller for handling checkout and order placement.
- **Entities**: Entity classes and enums aligned with the provided UML diagram.
- **DAO**: Repository interfaces for entities, extending `JpaRepository` and supporting cross-origin.
- **Services**: Service interfaces and implementations, including checkout process and purchase data handling.
- **Config**: Configuration files, including `RestDataConfig.java` and `application.properties`.

## Features

- RESTful API endpoints for managing vacation bookings and processing orders.
- Seamless integration with an Angular front-end application.
- MySQL database integration for persistent storage of customer and order data.
- Pre-populated sample data for demonstration purposes.
- Comprehensive input validation to ensure compatibility with the Angular front-end.
