
# JDBC Guide


"**Java Database Connectivity** (JDBC) is a Java API for connecting and executing queries with a database. JDBC provides a standard interface for Java applications to interact with relational databases such as MySQL, PostgreSQL, Oracle, etc."




## Steps to Use JDBC

Step 1 :- **Load the JDBC Driver**

Ensure that the JDBC driver for your database is included in your project dependencies. For example, use the MySQL Connector/J that is the .jar file. if you're connecting to a MySQL database.


```bash
import java.sql.DriverManager;
 // Load the driver (optional for modern JDBC)
Class.forName("com.mysql.cj.jdbc.Driver");
```

Step 2 :- **Establish a Connection**

Use the DriverManager.getConnection method to establish a connection to your database. You need the database URL, username, and password.

```bash
String url = "jdbc:mysql://localhost:3306/your_database";
String username = "your_username";
String password = "your_password";

Connection connection = DriverManager.getConnection(url, username, password);
```

Step 3 :- **Create a Statement**

A Statement or PreparedStatement is used to execute SQL queries.

- Statement: Used for static SQL queries.

- PreparedStatement: Used for dynamic queries with parameters (recommended for security).

```bash
String sql = "INSERT INTO users (id, name, age) VALUES (?, ?, ?)";

PreparedStatement preparedStatement = connection.prepareStatement(sql);

preparedStatement.setInt(1, 1);
preparedStatement.setString(2, "John Doe");
preparedStatement.setInt(3, 25);
```

Step 4 :- **Execute the Query**

Use methods such as executeQuery for SELECT statements and executeUpdate for INSERT, UPDATE, or DELETE statements.

```bash
int rowsInserted = preparedStatement.executeUpdate();

if (rowsInserted > 0) {
    System.out.println("A new user was inserted successfully!");
}
```

Step 5 :- **Process the Results**

For SELECT queries, process the result set using the ResultSet object.

```bash
String selectSql = "SELECT * FROM users";
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(selectSql);

while (resultSet.next()) {
    int id = resultSet.getInt("id");
    String name = resultSet.getString("name");
    int age = resultSet.getInt("age");

    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
}
```

Step 6 :- **Close the Resources**

Always close Connection, Statement, and ResultSet objects to release database resources.

```bash
if (resultSet != null) resultSet.close();
if (preparedStatement != null) preparedStatement.close();
if (connection != null) connection.close();

```
## Common JDBC Connection URL Examples





**MySQL**

```bash
jdbc:mysql://localhost:3306/your_database?useSSL=false&serverTimezone=UTC
```
**PostGress**
```bash
jdbc:postgresql://localhost:5432/your_database
```
**Oracle**
```bash
jdbc:oracle:thin:@localhost:1521:your_database
```

## Conclusion

JDBC is a powerful API that allows Java applications to interact with relational databases. Following these steps and best practices ensures a secure and efficient implementation of database operations in your projects.

Happy coding!
 
