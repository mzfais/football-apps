package id.ac.itn.gibolapps.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateConverter {
    public String UtcToLocal(String utcDate) {
        String localDate = "";
        SimpleDateFormat utcFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date cUtcDate = null;
        try {
            cUtcDate = utcFormatter.parse(utcDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat localFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        localFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));
        assert cUtcDate != null;
        localDate = localFormatter.format(cUtcDate.getTime());
        return localDate;
    }

    public String UtcToLocal(String utcDate, String format) {
        String localDate = "";
        SimpleDateFormat utcFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date cUtcDate = null;
        try {
            cUtcDate = utcFormatter.parse(utcDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat localFormatter = new SimpleDateFormat(format, Locale.US);
        localFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));
        assert cUtcDate != null;
        localDate = localFormatter.format(cUtcDate.getTime());
        return localDate;
    }
}
