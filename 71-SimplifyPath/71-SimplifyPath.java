// Last updated: 4/8/2025, 12:00:51 am
class Solution {
    public String simplifyPath(String path) {
        return countGroup(path);
    }
    public static String countGroup(String path) {
	    Stack<String> stack = new Stack<>();
	    String[] parts = path.split("/");

	    for (String part : parts) {
	        if (part.equals("") || part.equals(".")) {
	            continue;
	        } else if (part.equals("..")) {
	            if (!stack.isEmpty()) {
	                stack.pop();
	            }
	        } else {
	            stack.push(part);
	        }
	    }

	    StringBuilder result = new StringBuilder();
	    for (String d : stack) {
	        result.append("/").append(d);
	    }

	    return result.length() > 0 ? result.toString() : "/";
	}

}