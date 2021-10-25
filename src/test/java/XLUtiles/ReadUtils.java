package XLUtiles;

import org.apache.commons.lang3.RandomStringUtils;

import net.bytebuddy.utility.RandomString;

public class ReadUtils {
	public static String firstName() {
		String generatestring=RandomStringUtils.randomAlphabetic(3);
		return("jon"+ generatestring); 
	}
	public static String lastname() {
		String generatestring=RandomStringUtils.randomAlphabetic(5);
		return generatestring; 
	}
	public static String subjectid() {
		String generatestring=RandomStringUtils.randomNumeric(1);
		return generatestring; 
	}

}
