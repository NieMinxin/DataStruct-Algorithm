package leetcode.october;

import org.junit.Test;

import java.util.*;

public class Demo01 {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ran = new HashMap<>();
        HashMap<Character, Integer> mag = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            ran.put(ch, ran.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            mag.put(ch, mag.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int a = ran.get(ch);
            if (mag.get(ch) != null) {
                int b = mag.get(ch);
                if (a > b) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    //使用递归函数 和 栈 来逆序一个栈
    public int get(Stack<Integer> stack) {
        //递归的终止条件
        //下探
        //下一层的逻辑处理
        int tmp = stack.pop();
        if (stack.isEmpty()) {
            return tmp;
        } else {
            int res = get(stack);
            stack.push(res);
            return res;
        }
    }

    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = get(stack);
        reverseStack(stack);
        stack.push(i);
    }

    //使用栈排序栈
    public void sortStack(Stack<Integer> src) {
        if (src == null || src.isEmpty()) {
            return;
        }
        Stack<Integer> help = new Stack<>();
        while (!src.isEmpty()) {
            int cur = src.pop();
            while (!help.isEmpty() && cur > help.peek()) {
                src.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            src.push(help.pop());
        }
    }


    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] dirs = path.split("/");
        if (dirs.length == 0) {
            return "/";
        }

        for (String str : path.split("/")
        ) {

            if ("".equals(str) || ".".equals(str)) {
                continue;
            }
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(str);

        }

        Stack<String> tmp = new Stack<>();

        if (stack.isEmpty()) {
            return sb.append("/").toString();
        } else {
            while (!stack.isEmpty()) {
                tmp.push(stack.pop());
            }
        }

        while (!tmp.isEmpty()) {
            sb.append("/" + tmp.pop());
        }
        return sb.toString();
    }


    public int calculateII(String s) {
        if (s.length() == 0 || s == null) {
            return -1;
        }
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;//保存数值
        char preSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                }
                num = 0;
                preSign = ch;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


    public int calPoints(String[] ops) {
        if (ops.length == 0 || ops == null) {
            return -1;
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) {
            String str = ops[i];
            if (str.equals("C")) {
                stack.pop();
            } else if (str.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (str.equals("+")) {
                int top = stack.pop();
                int newTmp = stack.peek() + top;
                stack.push(top);
                stack.push(newTmp);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    int ptr = 0;

    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        ptr = 0;
        int len = s.length();
        while (ptr < len) {
            char ch = s.charAt(ptr);
            if (Character.isDigit(ch)) {
                String digits = getDigits(s);
                stack.addLast(digits);
            } else if (Character.isLetter(ch) || ch == '[') {
                stack.addLast(String.valueOf(ch));
                ptr++;
            } else {
                //右括号
                ++ptr;//先ptr ++ ，然后不断弹出栈内的元素
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                //将字符串倒置
                Collections.reverse(sub);
                //弹出左括号
                stack.removeLast();
                int repeat = Integer.parseInt(stack.removeLast());
                StringBuilder sb = new StringBuilder();
                String tmp = getString(sub);
                while (repeat-- > 0) {
                    sb.append(tmp);
                }
                stack.addLast(sb.toString());
            }
        }
        String str = getString(stack);
        return str;
    }

    public String getDigits(String s) {
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuilder ret = new StringBuilder();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
        /*
如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
如果当前的字符为字母或者左括号，直接进栈
如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，此时取出栈顶的数字（此时栈顶一定是数字，想想为什么？），\
就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
* */

    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }


}
