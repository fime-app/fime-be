## MySQL DB Setup Scripts
### Fime Project Admin Setup
```roomsql
-- Drop user first if they exist
DROP USER if exists 'fimeproject'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'fimeproject'@'localhost' IDENTIFIED BY 'fimeproject';

GRANT ALL PRIVILEGES ON * . * TO 'fimeproject'@'localhost';
```

### Table Schema
```roomsql
CREATE DATABASE  IF NOT EXISTS `fime`;
USE `fime`;

CREATE TABLE `users` (
	`id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(45) UNIQUE NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1; 

CREATE TABLE `events` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `events_timeblocks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_date`DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `event_id` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`event_id`) REFERENCES events(id) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `availability` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `event_id` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`username`) REFERENCES users(username), 
  FOREIGN KEY (`event_id`) REFERENCES events(id) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `availability_timeblocks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_date`DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `availability_id` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`availability_id`) REFERENCES availability(id) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
```

### Sample records for testing
```roomsql
-- Insert records into users table
INSERT INTO users (username) VALUES ('Chika'), ('Nathan'), ('Wilson');

-- Insert records into events table
INSERT INTO events (name, description) VALUES
('Gym', "We go Gym"),
('Food', "We go food");

-- Insert records into events_timeblocks table
INSERT INTO events_timeblocks (start_date, end_date, event_id) VALUES
('2023-09-02 09:00:00', '2023-09-02 18:00:00', 1),
('2023-09-02 10:00:00', '2023-09-02 18:00:00', 2);

-- Insert records into availability table
INSERT INTO availability (username, event_id) VALUES
('Wilson', 1),
('Chika', 1),
('Nathan', 1);

-- Insert records into availability_timeblocks table
INSERT INTO availability_timeblocks (start_date, end_date, availability_id) VALUES
('2023-09-02 09:00:00', '2023-09-02 10:00:00', 1),
('2023-09-02 16:00:00', '2023-09-02 18:00:00', 1),
('2023-09-02 16:00:00', '2023-09-02 16:30:00', 2),
('2023-09-02 10:00:00', '2023-09-02 13:00:00', 2),
('2023-09-02 16:00:00', '2023-09-02 16:30:00', 3); 
```

### Fuck Tomcat
netstat -ano | findstr :8080

taskkill /PID [pid] /F

# APIS

## Get All Events

### Request

`GET /api/all-events`

### Response

```json
[
  {
    "id": 1,
    "name": "Gym",
    "description": "We go Gym",
    "dateRanges": [
      {
        "startDate": "2023-09-02T01:00:00.000+00:00",
        "endDate": "2023-09-02T10:00:00.000+00:00"
      }
    ]
  },
  {
    "id": 2,
    "name": "Food",
    "description": "We go food",
    "dateRanges": [
      {
        "startDate": "2023-09-02T02:00:00.000+00:00",
        "endDate": "2023-09-02T10:00:00.000+00:00"
      }
    ]
  }
]
```
## Post Events

### Request

`POST /api/create-events`

### Payload 
```json
[
    {
        "name": "Gym",
        "description": "We go gym",
        "dateRanges": [
            {
                "startDate": "2023-01-01",
                "endDate": "2023-01-02"
            },
            {
                "startDate": "2023-01-03",
                "endDate": "2023-01-04"
            },
            {
                "startDate": "2023-01-05",
                "endDate": "2023-01-07"
            }
        ]
    },
    {
        "name": "Karaoke",
        "description": "We go sing",
        "dateRanges": [
            {
                "startDate": "2023-01-01",
                "endDate": "2023-01-03"
            }
        ]
    }
]
```

### Response

```json
{
  "Events{id=5, name='Karaoke', description='We go sing'}": [
    {
      "startDate": "2023-01-01T00:00:00.000+00:00",
      "endDate": "2023-01-03T00:00:00.000+00:00",
      "eventId": 5
    }
  ],
  "Events{id=4, name='Gym', description='We go gym'}": [
    {
      "startDate": "2023-01-01T00:00:00.000+00:00",
      "endDate": "2023-01-02T00:00:00.000+00:00",
      "eventId": 4
    },
    {
      "startDate": "2023-01-03T00:00:00.000+00:00",
      "endDate": "2023-01-04T00:00:00.000+00:00",
      "eventId": 4
    },
    {
      "startDate": "2023-01-05T00:00:00.000+00:00",
      "endDate": "2023-01-07T00:00:00.000+00:00",
      "eventId": 4
    }
  ]
}
```

## Get Event Joiner Details and Common Date Ranges

### Request
`GET /api/event/{id}`

### Response
```json
{
  "users": [
    {
      "name": "Wilson",
      "availableDates": [
        {
          "startDate": "2023-09-02T01:00:00.000+00:00",
          "endDate": "2023-09-02T02:00:00.000+00:00"
        },
        {
          "startDate": "2023-09-02T08:00:00.000+00:00",
          "endDate": "2023-09-02T10:00:00.000+00:00"
        }
      ]
    },
    {
      "name": "Chika",
      "availableDates": [
        {
          "startDate": "2023-09-02T08:00:00.000+00:00",
          "endDate": "2023-09-02T08:30:00.000+00:00"
        },
        {
          "startDate": "2023-09-02T02:00:00.000+00:00",
          "endDate": "2023-09-02T05:00:00.000+00:00"
        }
      ]
    },
    {
      "name": "Nathan",
      "availableDates": [
        {
          "startDate": "2023-09-02T08:00:00.000+00:00",
          "endDate": "2023-09-02T08:30:00.000+00:00"
        }
      ]
    }
  ],
  "totalAvailability": [
    {
      "startDate": "2023-09-02T08:00:00.000+00:00",
      "endDate": "2023-09-02T08:30:00.000+00:00"
    }
  ]
}
```

## Post Event Joiner Availability

### Request
`GET /api/event/{id}`

### Payload
```roomsql
{
    "username": "Nathan",
    "availableDateRanges": [
        {
            "startDate": "2023-01-01",
            "endDate": "2023-01-03"
        }
    ]
}
```

### Response
```roomsql
{
    "username": "Nathan",
    "availableDateRanges": [
        {
            "id": 6,
            "startDate": "2023-01-01T00:00:00.000+00:00",
            "endDate": "2023-01-03T00:00:00.000+00:00",
            "availabilityId": 4
        }
    ]
}
```