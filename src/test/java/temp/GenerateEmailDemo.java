package temp;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {
    Date date= new Date();
    String dateString = date.toString();
    String nospacedate = dateString.replaceAll("\\s", "");
    String nospacenocolans = nospacedate.replaceAll("\\:", "");
    String emailwithtimestamp = nospacenocolans+"@gmail.com";
    System.out.println(emailwithtimestamp);
	}

}
