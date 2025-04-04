𝐋𝐨𝐚𝐝 & 𝐁𝐨𝐨𝐤𝐢𝐧𝐠 𝐌𝐚𝐧𝐚𝐠𝐞𝐦𝐞𝐧𝐭 𝐒𝐲𝐬𝐭𝐞𝐦 🚛📦
📌 Overview
This is a backend system built using Spring Boot and PostgreSQL to efficiently manage loads and bookings. It provides REST APIs with CRUD operations, validation, logging, and error handling to ensure robustness and scalability.

🚀 Features
✅ Create, update, delete, and retrieve Loads and Bookings
✅ Status updates based on booking actions (e.g., auto-change from POSTED → BOOKED)
✅ Secure and efficient API design with input validation and error handling
✅ Filter options to fetch loads/bookings based on various parameters
✅ PostgreSQL integration for data persistence

🛠️ Tech Stack :
‣ Spring Boot (REST APIs)
‣ PostgreSQL (Database)
‣ Spring Data JPA (ORM)
‣ Lombok (Boilerplate reduction)
‣ Swagger (API documentation)
‣ Spring Validation & Exception Handling

📦 𝐋𝐨𝐚𝐝 𝐄𝐧𝐭𝐢𝐭𝐲 : 
{
  "id": "UUID",
  "shipperId": "String",
  "facility": {
    "loadingPoint": "String",
    "unloadingPoint": "String",
    "loadingDate": "Timestamp",
    "unloadingDate": "Timestamp"
  },
  "productType": "String",
  "truckType": "String",
  "noOfTrucks": 1,
  "weight": 500.5,
  "comment": "Fragile items",
  "datePosted": "Timestamp",
  "status": "POSTED"
}
📌 Rules:

‣ Status defaults to POSTED when a load is created.
‣ Changes to BOOKED when a booking is made.
‣ If the booking is deleted, load status changes to CANCELLED.

📑 Booking Entity :
{
  "id": "UUID",
  "loadId": "UUID",
  "transporterId": "String",
  "proposedRate": 12000.0,
  "comment": "Urgent delivery",
  "status": "PENDING",
  "requestedAt": "Timestamp"
}
📌 Rules:

‣ A booking cannot be created for a CANCELLED load.
‣ When a booking is accepted, the status updates to ACCEPTED.

🔹 API ENDPOINTS : 

🚚 Load Management :

POST /load → Create a new load
GET /load → Fetch loads (filter by shipperId, truckType, etc.)
GET /load/{loadId} → Get load details
PUT /load/{loadId} → Update load details
DELETE /load/{loadId} → Delete a load

📦 Booking Management :

POST /booking → Create a new booking
GET /booking → Fetch bookings (filter by shipperId, transporterId)
GET /booking/{bookingId} → Get booking details
PUT /booking/{bookingId} → Update booking details
DELETE /booking/{bookingId} → Delete a booking

1️⃣ Clone the Repository : 
git clone https://github.com/your-username/load-booking-backend.git
cd load-booking-backend

2️⃣ Configure the Database
Update application.properties with your PostgreSQL credentials:

spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username // your username
spring.datasource.password=your_password //your password

3️⃣ Run the Application : mvn spring-boot:run

The server will start at http://localhost:8080 

📜 API Documentation :

After running the app, access Swagger UI for API testing:
🔗 http://localhost:8080/swagger-ui/index.html
