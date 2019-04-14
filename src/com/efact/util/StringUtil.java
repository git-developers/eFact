package com.efact.util;


public class StringUtil {

	public static final <T> String implode(String[] elements, Object separator) {
	    String sepStr = separator.toString();
	    StringBuilder out = new StringBuilder();

	    for (Object s : elements) {

	        if (s == null) {
	            continue;
	        }

            out.append(sepStr);
            out.append(s);
	    }
	    
	    return out.toString();
	}
	
}
