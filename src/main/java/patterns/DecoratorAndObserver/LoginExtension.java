package patterns.DecoratorAndObserver;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoginExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        System.out.println("Тест запустился: " + extensionContext.getDisplayName());
    }
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        System.out.println("Тест завершился: " + extensionContext.getDisplayName());
    }


}
