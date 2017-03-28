package by.beregeiko.aop.secure;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Think on 03.02.2017.
 */
public class SecurityExample {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        SecureBean secureBean = getSecureBean(securityManager);

        securityManager.login("chris", "pwd");
        secureBean.writeSecureMessage();
        securityManager.logout();

        try {
            securityManager.login("invaliduser", "pwd");
            secureBean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            securityManager.logout();
        }

        try {
            secureBean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }

    }

    private static SecureBean getSecureBean(SecurityManager securityManager) {
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice(securityManager);
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);
        SecureBean proxy = (SecureBean) factory.getProxy();
        return proxy;
    }
}
