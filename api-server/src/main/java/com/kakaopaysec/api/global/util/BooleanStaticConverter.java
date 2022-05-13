package com.kakaopaysec.api.global.util;

public class BooleanStaticConverter {

    public static String convertBooleanToString(Boolean attribute) {
        return (attribute != null && attribute) ? "Y" : "N";
    }

    public static Boolean convertStringToBoolean(String dbData) {
        return "Y".equalsIgnoreCase(dbData);
    }
}
