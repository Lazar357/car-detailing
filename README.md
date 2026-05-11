# Car Detailing Management System

A full-stack web application for managing a car detailing business. This project allows managing customers and their service bookings, featuring a Spring Boot backend and a clean HTML/JS frontend.

## 🚀 Features

- **Customer Management**: Create, read, update, and delete customer profiles.
- **Booking System**: Schedule detailing services for specific customers.
- **Service Packages**: Support for different detailing levels (Basic, Standard, Premium).
- **Validation**: Server-side validation for all inputs.
- **Responsive UI**: Web-based interface for easy navigation and management.
- **Global Exception Handling**: Robust error management for seamless user experience.

## 🛠 Tech Stack

### Backend
- **Java 21**
- **Spring Boot 3.5.0**
- **Spring Data JPA**: For database interactions.
- **MySQL**: Persistent data storage.
- **Lombok**: To reduce boilerplate code.
- **Jakarta Validation**: For data integrity.

### Frontend
- **HTML5 & CSS3**
- **JavaScript (Fetch API)**: For asynchronous communication with the backend.

## 📋 Prerequisites

- **JDK 21** or higher
- **Maven 3.x**
- **MySQL Server**

## ⚙️ Configuration

1. **Database Setup**:
   - Create a MySQL database named `car_detailing`.
   - You can use the provided script in `databases/car_detailing.sql` to initialize the schema.
   
2. **Application Properties**:
   Update `src/main/resources/application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/car_detailing
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

## 🏃 Getting Started

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd car-detailing
   ```
3. Build the project:
   ```bash
   ./mvnw clean install
   ```
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
5. Access the application:
   - Frontend: `http://localhost:8080/index.html`
   - API Base URL: `http://localhost:8080/api`

## 🛣 API Endpoints

### Customers (`/api/customer`)
- `GET /api/customer` - Retrieve all customers.
- `GET /api/customer/{id}` - Get a specific customer.
- `POST /api/customer` - Register a new customer.
- `PUT /api/customer/{id}` - Update customer details.
- `DELETE /api/customer/{id}` - Remove a customer.

### Bookings (`/api/booking`)
- `GET /api/booking` - Retrieve all bookings.
- `GET /api/booking/{id}` - Get a specific booking.
- `POST /api/booking` - Create a new booking.
- `PUT /api/booking/{id}` - Update a booking.
- `DELETE /api/booking/{id}` - Cancel a booking.

## 📂 Project Structure

- `src/main/java/.../controller`: REST API controllers.
- `src/main/java/.../entity`: Database models (Customer, Booking).
- `src/main/java/.../service`: Business logic layer.
- `src/main/java/.../repo`: JPA repositories.
- `src/main/java/.../dto`: Data Transfer Objects.
- `public/`: Frontend assets (HTML, CSS, JS, Images).
- `databases/`: SQL scripts for database initialization.

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
