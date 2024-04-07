package sql;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sql.helpers.SQLHelper;
import sql.models.SQLUserModel;
import sql.spec.SQLSpecification;

import java.sql.Statement;


public class SQLTest {

    private Statement statement;

    @Before
    public void setUp() {
        statement = SQLSpecification.getConnection();
    }

    @Test
    @SneakyThrows
    public void testConnectionToDataBase() {
        var newUser = new SQLUserModel("userModel", 33, "userModel@gmail.com");
        var userForUpdate = new SQLUserModel("updateMePlease", 41, "updateEmail@gmail.com");
        var newUserForUpdate = new SQLUserModel("I was updated", 78, "newUpdateEmail@gmail.com");
        var sqlHelper = new SQLHelper(statement);

        newUser = sqlHelper.addUser(newUser);
        sqlHelper.deleteUser(newUser.getId());
        /*userForUpdate = sqlHelper.addUser(userForUpdate);
        newUserForUpdate = sqlHelper.updateUser(userForUpdate.getId(), newUserForUpdate);
        sqlHelper.deleteUser(newUserForUpdate.getId());*/
    }

    @After
    public void closeConnection() {
        SQLSpecification.closeConnection();
    }
}
