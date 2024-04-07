package patterns.DecoratorAndObserver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import patterns.DecoratorAndObserver.annotation.RandomUser;
import patterns.DecoratorAndObserver.models.RandomUserResolver;
import patterns.DecoratorAndObserver.models.UserModel;

@ExtendWith({LoginExtension.class, RandomUserResolver.class})
public class DecoratorTests {

    @Test
    public void firstUserTest(@RandomUser UserModel user) {
        System.out.println(user);
    }

    @Test
    public void secondUserTest(@RandomUser UserModel user) {
        System.out.println(user);
    }
}
