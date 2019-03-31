package com.efact.util;


public class StringUtil {

	public static final <T> String implode(String[] elements, Object separator) {
	    String sepStr = separator.toString();
	    StringBuilder out = new StringBuilder();
	    boolean first = true;

	    for (Object s : elements) {

	        if (s == null) {
	            continue;
	        }

	        if (first) {
	            first = false;
	        } else {
	            out.append(sepStr);
	            out.append(s);
	        }
	    }
	    
	    return out.toString();
	}
	
}
