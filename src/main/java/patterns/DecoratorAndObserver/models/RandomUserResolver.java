package patterns.DecoratorAndObserver.models;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import patterns.DecoratorAndObserver.annotation.RandomUser;

import java.lang.reflect.Parameter;
import java.util.Random;

public class RandomUserResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(RandomUser.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return generateUser(parameterContext.getParameter());
    }

    private Object generateUser(Parameter parameter) {
        Class<?> type = parameter.getType();
        Random random = new Random();
        if (UserModel.class.equals(type)) {
            return UserModel.builder()
                    .name(new RandomString(15).nextString())
                    .age(random.nextInt(35))
                    .userName(new RandomString(5).nextString() + "." + new RandomString(6).nextString())
                    .password(new RandomString(18).nextString())
                    .email(new RandomString(12).nextString() + "@gmail.com")
                    .build();
        }
        throw new ParameterResolutionException("No random user is generated");
    }
}
