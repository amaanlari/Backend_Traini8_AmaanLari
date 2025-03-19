# Training Center Management System

This project is a Training Center Management System built using Java, Spring Boot, and Maven. It provides functionalities to manage training centers, including their details, courses offered, and contact information.

## Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- An IDE such as IntelliJ IDEA

## Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/amaanlari/Backend_Traini8_AmaanLari.git
   cd Backend_Traini8_AmaanLari

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application:**
   Open your browser and navigate to `http://localhost:8080`.

## Project Structure

- `src/main/java/com/lari/trainingcenter` - Contains the main application code.
    - `advice` - Contains global exception handling classes.
    - `exceptions` - Contains custom exception classes.
    - `models` - Contains entity classes representing the database tables.
    - `repositories` - Contains repository interfaces for data access.
    - `services` - Contains service classes with business logic.
    - `controllers` - Contains REST controllers for handling HTTP requests.

- `src/main/resources` - Contains application configuration files.
    - `application.properties` - Main configuration file for the Spring Boot application.

## Key Classes

- `TrainingCenter` - Entity class representing a training center.
- `Address` - Embedded entity class representing the address of a training center.
- `ResourceNotFoundException` - Custom exception class for resource not found errors.
- `GlobalExceptionHandler` - Global exception handler for handling various exceptions.

## API Endpoints

- `GET /training-centers` - Retrieve a list of all training centers.
- `POST /training-centers` - Create a new training center.

#### Payload for POST /training-centers
```json
{
  "centerName": "Center 01",
  "centerCode": "centerCode01",
  "address": {
    "detailedAddress": "Demo detailed address",
    "city": "demo city",
    "state": "demo state",
    "pinCode": "123456"
  },
  "studentCapacity": 10,
  "coursesOffered": ["Course 01", "Course 02"],
  "contactEmail": "contact@demo.com",
  "contactPhone": "1234567890"
}
```
