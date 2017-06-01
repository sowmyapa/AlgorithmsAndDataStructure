package com.problem1.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sowmyaparameshwara on 5/28/17.
 */
public class MyRegex {

        private static String pattern = "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";

    private String ip;

        public MyRegex(String iP) {
            this.ip = iP;
        }

        public boolean isMatch() {
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(ip);
            return m.matches();
        }


}
