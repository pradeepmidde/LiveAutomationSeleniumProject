package Utilities;

import java.util.Date;

public class CommonUtils {

	public static String genarateEmail() {
        String emailwithtimestamp = new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";  //chaining
        return emailwithtimestamp;
    }
}
