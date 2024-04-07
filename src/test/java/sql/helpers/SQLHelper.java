package sql.helpers;

import lombok.SneakyThrows;
import org.junit.Assert;
import sql.models.SQLUserModel;

import java.sql.Statement;

public class SQLHelper {

    private final Statement statement;

    public SQLHelper(Statement statement) {
        this.statement = statement;
    }

    @SneakyThrows
    public SQLUserModel addUser(SQLUserModel model) {
        var query = "insert into users (name, age, email) values ('%s', %s, '%s');";
        var validQuery = String.format(query, model.getName(), model.getAge(), model.getEmail());
        statement.execute(validQuery);
        model.setId(getUserID(model));
        System.out.println("User is added successfully: " + model);
        return model;
    }

    @SneakyThrows
    public SQLUserModel getUserInfoByID(Integer userID) {
        var query = "SELECT * FROM users where id = %s;";
        var validQuery = String.format(query, userID);
        var resultSet = statement.executeQuery(validQuery);
        String userName, userEmail;
        Integer userAge;

        var isDataExist = resultSet.next();
        if (isDataExist) {
            userName = resultSet.getString("name");
            userAge = resultSet.getInt("age");
            userEmail = resultSet.getString("email");

            Assert.assertNotNull("User Name shouldn't be null", userName);
            Assert.assertNotNull("User Age shouldn't be null", userAge);
            Assert.assertNotNull("User Email shouldn't be null", userEmail);
        } else {
            throw new NullPointerException("User with ID: " + userID + "is not found");
        }
        return new SQLUserModel(userID, userName, userAge, userEmail);
    }

    @SneakyThrows
    public void deleteUser(Integer userID) {
        var query = "delete from users where id = %s;";
        var validQuery = String.format(query, userID);
        var user = getUserInfoByID(userID);
        statement.execute(validQuery);
        System.out.println(user + " is deleted successfully");
    }

    @SneakyThrows
    public SQLUserModel updateUser(Integer userID, SQLUserModel newModel) {
        var query = "update users set name = '%s', age = %s, email = '%s' where id = %s;";
        var validQuery = String.format(query, newModel.getName(), newModel.getAge(), newModel.getEmail(), userID);
        var user = getUserInfoByID(userID);
        statement.executeUpdate(validQuery);
        newModel.setId(userID);
        System.out.println(user + " is updated successfully: " + newModel);
        return newModel;
    }

    @SneakyThrows
    private Integer getUserID(SQLUserModel model) {
        var query = "SELECT id FROM users where name = '%s' and age = %s and email = '%s';";
        var validQuery = String.format(query, model.getName(), model.getAge(), model.getEmail());
        var resultSet = statement.executeQuery(validQuery);
        return resultSet.next() ? resultSet.getInt("id") : null;
    }
}
