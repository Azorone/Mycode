package Tool;

import java.util.regex.Pattern;

public class ChickString {
    public static final String PW_PATTERN = "^[`~!@#$%^&*()+=|{}';',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；”“’。，、？\\\\\\\\]";
    public static final String NUMBER = "1234567890";
    public static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String abc = "abcdefghijklmnopqrstuvwxyz";
    public static final String PA = "ABCD";
    public static final String OP ="{}[]''''_@||<>*/+=？、？?~`^&%$#";

    public static boolean  chick(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < PW_PATTERN.length(); j++) {
                if (s.charAt(i) == PW_PATTERN.charAt(j)) {
                    System.out.println(false);
                    return false;
                }
            }
        }
        System.out.println(true);
        return true;
    }


    public static boolean chickOP(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < OP.length(); j++) {
                if (s.charAt(i) == OP.charAt(j)) {
                    System.out.println(false);
                    return false;
                }
            }
        }
        System.out.println(true);
        return true;
    }

    public static boolean chickABCD(String S) {
        boolean key = false;
        if (S.length() == 1) {

            for (int j = 0; j < PA.length(); j++) {
                if (S.charAt(0) == PA.charAt(j)) {
                    key = true;
                }
            }


        } else {
            return false;
        }
        return key;
    }
}
