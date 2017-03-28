package by.beregeiko.aop.keygen;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Think on 03.02.2017.
 */
public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
        if ((target instanceof KeyGenerator)
                && ("getKey".equals(method.getName()))) {
            long key = ((Long) returnValue).longValue();

            if (key == KeyGenerator.WEAK_KEY) {
                throw new SecurityException(
                        "Key Generator generated a weak key. Try again");
            }
        }
    }
}
