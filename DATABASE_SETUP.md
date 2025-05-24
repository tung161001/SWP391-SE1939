# Database Setup for SWP391 Project

This guide explains how to set up the MySQL database for the SWP391 project.

## Prerequisites

1. MySQL Server 8.0 or higher
2. MySQL Connector/J JDBC driver (included in the project's lib directory)

## Database Setup

1. **Create a new MySQL database**:
   
   ```sql
   CREATE DATABASE swp391;
   ```

2. **Update connection parameters** (if necessary):
   
   If your MySQL credentials are different from the default, update them in:
   
   - `src/java/dao/connection.java` - For direct connection
   - `web/META-INF/context.xml` - For connection pool

   Default settings:
   - Host: localhost
   - Port: 3306
   - Database name: swp391
   - Username: root
   - Password: (empty)

## Auto-Initialization

The application includes an automatic database initialization feature:

1. The `DatabaseInitServlet` runs on application startup with `loadOnStartup=1`
2. It creates necessary tables if they don't exist
3. It inserts sample data if the tables are empty

You can also manually trigger database initialization by visiting:
```
http://localhost:8080/SWP391GROUP5/init-db
```

## Database Schema

The application currently creates the following table:

### Users Table

```sql
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role VARCHAR(20) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

## Fallback Mechanism

The application has a built-in fallback mechanism:

1. It first tries to use the connection pool defined in `context.xml`
2. If that fails, it attempts a direct JDBC connection
3. If both fail, it uses hardcoded sample data for demo purposes

## Adding MySQL Connector/J

1. Download MySQL Connector/J from [MySQL website](https://dev.mysql.com/downloads/connector/j/)
2. Place the JAR file in `web/WEB-INF/lib/` directory

## Troubleshooting

1. **Connection Issues**:
   - Verify MySQL is running
   - Check connection parameters
   - Ensure the database exists
   - Verify user has appropriate permissions

2. **Driver Issues**:
   - Make sure MySQL Connector/J is in the `web/WEB-INF/lib/` directory
   - Verify the driver class name is correct (`com.mysql.cj.jdbc.Driver`)

3. **Pooling Issues**:
   - Check the JNDI resource is correctly defined in `context.xml`
   - Verify Tomcat is properly configured to use JNDI resources 