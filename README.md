# Transportation REST API

A Spring Boot REST API for managing transportation records.  
Built with **Java 17**, **Maven**, **Spring Data JPA**, and **H2 database**.

---

## Project Structure

```
transportation-api/
├── pom.xml
├── .gitignore
├── README.md
└── src/
    └── main/
        ├── java/com/example/transportation/
        │   ├── TransportationApplication.java      ← Main class
        │   ├── config/
        │   │   └── WebConfig.java                    ← CORS configuration
        │   ├── controller/
        │   │   └── TransportationController.java    ← REST endpoints
        │   ├── exception/
        │   │   └── GlobalExceptionHandler.java       ← Error handling
        │   ├── service/
        │   │   └── TransportationService.java       ← Business logic
        │   ├── repository/
        │   │   └── TransportationRepository.java    ← Database access
        │   └── entity/
        │       └── Transportation.java              ← JPA Entity
        └── resources/
            └── application.properties               ← Config
```

---

## How to Run

Make sure you have **Java 17+** and **Maven** installed.

```bash
cd transportation-api
mvn spring-boot:run
```

The server starts at **http://localhost:8080**

---

## API Endpoints

| Method | URL                        | Description          |
|--------|----------------------------|----------------------|
| POST   | `/transportations`         | Create a record      |
| GET    | `/transportations`         | Get all records      |
| GET    | `/transportations/{id}`    | Get a record by ID   |
| PUT    | `/transportations/{id}`    | Update a record      |
| DELETE | `/transportations/{id}`    | Delete a record      |

---

## Postman / cURL Examples

### 1. Create a Transportation Record

**POST** `http://localhost:8080/transportations`

Headers: `Content-Type: application/json`

Body:
```json
{
  "name": "City Bus",
  "type": "Bus",
  "origin": "Downtown",
  "destination": "Airport",
  "status": "Active",
  "capacity": 50,
  "price": 25.50,
  "date": "2026-03-11"
}
```

cURL:
```bash
curl -X POST http://localhost:8080/transportations \
  -H "Content-Type: application/json" \
  -d '{"name": "City Bus", "type": "Bus", "origin": "Downtown", "destination": "Airport", "status": "Active", "capacity": 50, "price": 25.50, "date": "2026-03-11"}'
```

---

### 2. Get All Records

**GET** `http://localhost:8080/transportations`

cURL:
```bash
curl http://localhost:8080/transportations
```

---

### 3. Get a Record by ID

**GET** `http://localhost:8080/transportations/1`

cURL:
```bash
curl http://localhost:8080/transportations/1
```

---

### 4. Update a Record

**PUT** `http://localhost:8080/transportations/1`

Headers: `Content-Type: application/json`

Body:
```json
{
  "name": "Express Bus",
  "type": "Bus",
  "origin": "Downtown",
  "destination": "University",
  "status": "Active",
  "capacity": 60,
  "price": 30.00,
  "date": "2026-03-15"
}
```

cURL:
```bash
curl -X PUT http://localhost:8080/transportations/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "Express Bus", "type": "Bus", "origin": "Downtown", "destination": "University", "status": "Active", "capacity": 60, "price": 30.00, "date": "2026-03-15"}'
```

---

### 5. Delete a Record

**DELETE** `http://localhost:8080/transportations/1`

cURL:
```bash
curl -X DELETE http://localhost:8080/transportations/1
```

---

## H2 Console

While the app is running, open **http://localhost:8080/h2-console** in your browser.

| Setting     | Value                           |
|-------------|---------------------------------|
| JDBC URL    | `jdbc:h2:mem:transportationdb`  |
| Username    | `sa`                            |
| Password    | *(leave empty)*                 |

---

## Tech Stack

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- H2 Database
- Maven
