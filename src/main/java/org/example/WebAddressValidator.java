package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAddressValidator {
    private static final String DOMAIN_PATTERN =
            "/([\\da-z\\.-]+)\\.([a-z\\.]{2,6})(\\/([\\da-z\\.-]+))*\\/?(([\\w\\.-]+)\\.([\\da-z]{2,6}))?((\\#[\\w\\.-]+)|(\\?([\\da-z]+(=[\\da-z]+)?)(&([\\da-z]+(=[\\da-z]+)?))*))?/i";

    private static final Pattern pattern = Pattern.compile(DOMAIN_PATTERN);

    public static boolean isValidDomain(String domain) {
        Matcher matcher = pattern.matcher(domain);
        return matcher.matches();
    }
}
