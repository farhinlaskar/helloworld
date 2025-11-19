# helloworld

## SIP Spike Summary API

A Spring Boot REST API for retrieving SIP spike summary data.

### API Endpoint

```
GET /sip/spike-summary
```

### Request Parameters

| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| MARKET | string | Yes | Market identifier |
| CATEGORY | string | Yes | Category identifier |
| DETECTED_TIME | string (ISO 8601) | Yes | Timestamp of detected spike |
| VENDOR | string | Yes | Vendor identifier |

### Response Schema

```json
[
  {
    "CATEGORY": "string",
    "MARKET": "string",
    "PERIOD_START_TIME": "2025-11-19T14:40:11.535Z",
    "POOL": "string",
    "TAC": 0,
    "SIP_408": 0,
    "SIP_480": 0,
    "SIP_481": 0,
    "SIP_500": 0,
    "SIP_503": 0,
    "SIP_504": 0,
    "OTHERS": 0,
    "TOTAL": 0
  }
]
```

### Example Request

```bash
curl "http://localhost:8080/sip/spike-summary?MARKET=US&CATEGORY=VOICE&DETECTED_TIME=2025-11-19T14:40:11&VENDOR=VENDOR_A"
```

### Example Response

```json
[
  {
    "CATEGORY": "VOICE",
    "MARKET": "US",
    "PERIOD_START_TIME": "2025-11-19T14:40:11",
    "POOL": "POOL_001",
    "TAC": 12345678,
    "SIP_408": 10,
    "SIP_480": 5,
    "SIP_481": 3,
    "SIP_500": 8,
    "SIP_503": 12,
    "SIP_504": 7,
    "OTHERS": 15,
    "TOTAL": 60
  }
]
```

## Project Structure

```
src/
├── main/
│   ├── java/com/helloworld/api/
│   │   ├── Application.java              # Main Spring Boot application
│   │   ├── controller/
│   │   │   └── SpikeSummaryController.java  # REST controller
│   │   ├── service/
│   │   │   └── SpikeSummaryService.java     # Business logic layer
│   │   ├── model/
│   │   │   └── SpikeSummary.java            # Domain model
│   │   └── dto/
│   │       ├── SpikeSummaryRequest.java     # Request DTO
│   │       └── SpikeSummaryResponse.java    # Response DTO
│   └── resources/
│       └── application.properties         # Application configuration
└── test/
    └── java/com/helloworld/api/
        ├── controller/
        │   └── SpikeSummaryControllerTest.java
        └── service/
            └── SpikeSummaryServiceTest.java
```

## Building and Running

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Build

```bash
mvn clean install
```

### Run Tests

```bash
mvn test
```

### Run Application

```bash
mvn spring-boot:run
```

The application will start on port 8080.

## Technology Stack

- **Spring Boot 3.1.5** - Application framework
- **Java 17** - Programming language
- **Maven** - Build tool
- **Lombok** - Code generation
- **JUnit 5** - Testing framework
- **Mockito** - Mocking framework