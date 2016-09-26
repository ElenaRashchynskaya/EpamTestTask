package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

/**
 * Created by Lenovo on 9/21/2016.
 */
public class Random {
    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(20);
    }

    public static String getRandomSubject() {
        return String.format("%s from %s", getRandomString(), getFormatDate());
        //return getRandomString() + " from " + getFormatDate();
    }

    public static String getFormatDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_z");
        // SimpleDateFormat sdf = new SimpleDateFormat("E yyyy.MM.dd HH_mm_ss Z");
        // "e;yyMMddHHmmssZ";
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Minsk"));
        return sdf.format(new Date());
    }
}
