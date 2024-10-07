package Global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Global {

    public static boolean ignoreCase(String preg, String keyword) {
        Pattern p = Pattern.compile(Pattern.quote(preg), Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(preg);
        return m.matches();

    }
}
