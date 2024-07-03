package constant;

import base.ReadConfig;

public class FrameworkConstant {
    private FrameworkConstant() {
    }

    public static final String URL_RAILWAY= ReadConfig.getProperty("railway.url");
    public static final String URL_TEMPMAIL= ReadConfig.getProperty("tempmail.url");
}
