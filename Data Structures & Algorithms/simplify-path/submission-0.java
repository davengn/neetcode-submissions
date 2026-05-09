class Solution {
    public String simplifyPath(String path) {
        String[] sPath = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (String p : sPath) {
            if (p.isEmpty()) {
                continue;
            }
            System.out.println(p);
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if(!p.equals("") && !p.equals(".")) {
                stack.push( p);
            }
        }
        return "/" + String.join("/", stack);
    }
}