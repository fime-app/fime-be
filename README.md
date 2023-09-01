## MySQL DB Setup Scripts
```roomsql
-- Drop user first if they exist
DROP USER if exists 'fimeproject'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'fimeproject'@'localhost' IDENTIFIED BY 'fimeproject';

GRANT ALL PRIVILEGES ON * . * TO 'fimeproject'@'localhost';
```

```roomsql
CREATE DATABASE  IF NOT EXISTS `fime`;
USE `fime`;

--
-- Table structure for table `student`
--

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
  `name` varchar(45) NOT NULL,
  `event_id` int NOT NULL,
  PRIMARY KEY (`id`),
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
    "Events{id=10, name='Gym', description='We go gym'}": [
        {
            "startDate": "2023-01-01",
            "endDate": "2023-01-02",
            "eventId": 10
        },
        {
            "startDate": "2023-01-03",
            "endDate": "2023-01-04",
            "eventId": 10
        },
        {
            "startDate": "2023-01-05",
            "endDate": "2023-01-07",
            "eventId": 10
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
      "name": "John Smith",
      "availableDates": [
        {
          "startDate": "2023-09-01T05:00:00.000+00:00",
          "endDate": "2023-09-01T07:00:00.000+00:00"
        },
        {
          "startDate": "2023-09-01T10:00:00.000+00:00",
          "endDate": "2023-09-01T11:00:00.000+00:00"
        },
        {
          "startDate": "2023-09-03T06:30:00.000+00:00",
          "endDate": "2023-09-03T07:00:00.000+00:00"
        }
      ]
    },
    {
      "name": "Michael Davis",
      "availableDates": [
        {
          "startDate": "2023-09-01T03:00:00.000+00:00",
          "endDate": "2023-09-01T07:00:00.000+00:00"
        },
        {
          "startDate": "2023-09-01T08:00:00.000+00:00",
          "endDate": "2023-09-01T09:00:00.000+00:00"
        },
        {
          "startDate": "2023-09-03T06:30:00.000+00:00",
          "endDate": "2023-09-03T07:00:00.000+00:00"
        }
      ]
    },
    {
      "name": "John Johnson",
      "availableDates": [
        {
          "startDate": "2023-09-01T06:30:00.000+00:00",
          "endDate": "2023-09-01T07:00:00.000+00:00"
        },
        {
          "startDate": "2023-09-03T06:30:00.000+00:00",
          "endDate": "2023-09-03T07:00:00.000+00:00"
        },
        {
          "startDate": "2023-09-03T06:30:00.000+00:00",
          "endDate": "2023-09-03T07:00:00.000+00:00"
        },
        {
          "startDate": "2023-09-03T06:30:00.000+00:00",
          "endDate": "2023-09-03T07:00:00.000+00:00"
        }
      ]
    }
  ],
  "totalAvailability": [
    {
      "startDate": "2023-09-03T06:30:00.000+00:00",
      "endDate": "2023-09-03T07:00:00.000+00:00"
    },
    {
      "startDate": "2023-09-01T06:30:00.000+00:00",
      "endDate": "2023-09-01T07:00:00.000+00:00"
    }
  ]
}
```