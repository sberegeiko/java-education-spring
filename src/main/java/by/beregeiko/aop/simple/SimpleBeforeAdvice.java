package by.beregeiko.aop.simple;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by Think on 02.02.2017.
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice{
    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(target);

        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();
        proxy.writeMessage();
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before method: " + method.getName());
    }
}
