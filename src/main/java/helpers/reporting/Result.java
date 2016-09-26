package helpers.reporting;

import java.util.Date;

public class Result {

    public String email;
    public Boolean result;
    public String reason = "";
    public Date date;

    public Result(String email, Boolean result) {
        this.email = email;
        this.result = result;
        this.date = new Date();
    }

    public Result(String email, Boolean result, String reason) {
        this.email = email;
        this.result = result;
        this.reason = reason;
        this.date = new Date();
    }

}