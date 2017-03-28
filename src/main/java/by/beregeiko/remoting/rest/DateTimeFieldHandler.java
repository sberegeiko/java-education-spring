package by.beregeiko.remoting.rest;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.exolab.castor.mapping.ValidityException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Properties;

/**
 * Created by Think on 16.02.2017.
 */
public class DateTimeFieldHandler extends GeneralizedFieldHandler {
    private static String dateFormatPattern;

    @Override
    public void setConfiguration(Properties config) throws ValidityException {
        dateFormatPattern = config.getProperty("date-format");
    }

    public Object convertUponGet(Object o) {
        DateTime dateTime = (DateTime) o;
        return format(dateTime);
    }

    public Object convertUponSet(Object o) {
        String dateTimeString = (String) o;
        return parse(dateTimeString);
    }

    public Class<DateTime> getFieldType() {
        return DateTime.class;
    }

    protected static String format(final DateTime dateTime) {
        String dateTimeString = "";
        if(dateTime != null){
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
            dateTimeString = dateTimeFormatter.print(dateTime);
        }
        return dateTimeString;
    }

    protected static DateTime parse(final String dateTimeString) {
        DateTime dateTime = new DateTime();
        if(dateTimeString != null){
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
            dateTime = dateTimeFormatter.parseDateTime(dateTimeString);
        }
        return dateTime;
    }
}
