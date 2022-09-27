package util;

public class MethodUtil {
	public static boolean isDisit(String str) {
		if (str.matches("-?\\d+")) {
			return true;
		} else {
			return false;
		}
	}
}
