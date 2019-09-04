package com.gt.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 04/09/2019, 1:32 PM
 * StringUtil.java
 *
 * @author prathabarsaiyan
 */
public class StringUtil {
    public static final String ALPHA_ONLY_PATTERN = "[^A-Za-z]";

    public static boolean isEmpty(String str){
        return str == null || str.trim().equals("");
    }

    public static boolean isNotEmpty(String str){
        return str == null || str.trim().equals("");
    }

    public static Map<Character,Integer> convertStringToCharCountMap(String str){
        if(isEmpty(str)){
            return null;
        }
        str = getAlphabetsOnly(str.toLowerCase());
        char[] chars = str.toCharArray();
        Map<Character,Integer> strCharCountMap = new HashMap<Character, Integer>();
        for(char ch:chars){
            int count = 1;
            if(strCharCountMap.containsKey(ch)){
                count = strCharCountMap.get(ch)+1;
            }
            strCharCountMap.put(ch,count);
        }
        return strCharCountMap;
    }

    public static String replace(String str,String pattern, String replaceWith){
        return str.replaceAll(pattern,replaceWith);
    }
    public static String getAlphabetsOnly(String text){
        return replace(text,ALPHA_ONLY_PATTERN, "" );
    }

    public static String convertListToString(List list, String emptyDefault) {
        if(list == null || list.isEmpty()){
            return emptyDefault;
        }
        StringBuffer buffer = new StringBuffer("");
        int count = 0;
        for(Object obj: list){
            if(count != 0){
                buffer.append(" ,");
            }
            buffer.append(obj);
            count++;
        }
        return buffer.toString();
    }
}
