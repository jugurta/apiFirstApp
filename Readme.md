Creating a README for a GitHub project that implements a Contract-First API with Spring Boot WebFlux in a Clean Architecture design:

# Contract-First API with Spring Boot WebFlux and Clean Architecture


**Description:**

This project demonstrates the implementation of a Contract-First API using Spring Boot WebFlux in adherence to the Clean Architecture design principles. It emphasizes separation of concerns, maintainability, and scalability in building robust and testable applications.

---

## Table of Contents

1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Getting Started](#getting-started)
4. [Project Structure](#project-structure)
5. [Technologies Used](#technologies-used)
6. [Features](#features)
7. [Contributing](#contributing)
8. [License](#license)


---

## Introduction

Contract-First API development is a methodology that begins with defining the API contract (usually in OpenAPI or Swagger) before implementing the actual API logic. This approach ensures better communication between teams, promotes consistency, and facilitates efficient testing.

This project showcases the creation of a Contract-First API using Spring Boot WebFlux within the boundaries of a Clean Architecture, providing clear separation of responsibilities and promoting code maintainability.

---

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 17 or higher.
- Apache Maven installed (for building and packaging).
- A code editor or Integrated Development Environment (IDE) of your choice.
- Understanding of Clean Architecture and Spring Boot WebFlux.

---

## Getting Started

Follow these steps to get the project up and running on your local machine:

1. Clone the repository to your local environment:

   ```shell
   git clone https://github.com/jugurta/apiFirstApp.git
   ```

2. Navigate to the project directory:

   ```shell
   cd apiFirstApp
   ```

3. Build the project using Maven:

   ```shell
   mvn clean install
   ```

4. Run the application:

   ```shell
   mvn spring-boot:run
   ```

The application should now be accessible at `http://localhost:8080`. You can customize the port in the `application.yml` file.

---

## Project Structure

The project follows a Clean Architecture structure, which consists of the following main layers:

- **Presentation Layer**: Contains the API controllers and request/response models.
- **Application Layer**: Contains the use cases (business logic).
- **Domain Layer**: Contains domain entities and business rules.
- **Infrastructure Layer**: Contains the data access and external service communication.

The `src` directory contains sub-packages for each of these layers, ensuring a clear separation of concerns.

---

## Technologies Used

- Java
- Spring Boot WebFlux
- OpenAPI for API contract definition
- Lombok for reducing boilerplate code
- MapStruct for mapping objects from layer to layer 
- Project Reactor for reactive programming
- MongoDB for data storage

---

## Features

- [x] Contract-First API design with OpenAPI
- [x] Clean Architecture for maintainability
- [x] Reactive programming with Spring Boot WebFlux
- [x] Separation of concerns
- [x] Easily extendable and testable codebase

---
## Contributing

If you'd like to contribute to this project, please follow these guidelines:

1. Fork the project.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with clear and concise messages.
4. Push your changes to your fork.
5. Create a pull request to the `master` branch of this repository.

---

## License

This project is licensed under the [MIT License](LICENSE.md).

---

