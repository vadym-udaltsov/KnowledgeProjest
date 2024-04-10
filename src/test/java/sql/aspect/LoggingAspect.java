package sql.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAspect {

    @Before("execution(public String getSQLBase())")
    public void beforeMethodOneAdvice() {
        System.out.println("Before method ONE: ----------------------------");
    }

    @Around("execution(* SQLTest.getConnection())")
    public void beforeMethodTwoAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("Around getConnection method is started: ----------------------------");
        try {
            joinPoint.proceed();
            System.out.println("Around getConnection method is closed: ----------------------------");
        }
        catch (Throwable throwable) {
            System.out.println("Операция не удалась, откат транзакции...");
        }
    }


}
