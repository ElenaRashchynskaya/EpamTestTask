package helpers;

/**
 * Created by Lenovo on 9/22/2016.
 */
public class Account {
    public String email;
    public String password;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account: Email=[" + this.email + "] Password=[" + this.password + "]";
    }

}
