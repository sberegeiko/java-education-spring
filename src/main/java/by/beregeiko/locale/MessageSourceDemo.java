package by.beregeiko.locale;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Think on 02.02.2017.
 */
public class MessageSourceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/locale/app-context-xml.xml");
        context.refresh();

        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cs", "CZ");
        System.out.println(context.getMessage("msg", null, english));
        System.out.println(context.getMessage("msg", null, czech));

        System.out.println(context.getMessage("nameMsg", new Object[]{"Chris", "Schaefer"}, english));

    }
}
