package Labs;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Demo03 {

    //打印1-10的和
    public void fun() {
        int sum =0;
        for (int i = 0; i <=10 ; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }



    //编写将10进制的数转换为 2禁止

    public void fun1() {
        System.out.println("请输入一个10进制数:");
        Scanner scanner  = new Scanner(System.in);
        int num = scanner.nextInt();

        //转换为二进制数的算法为 %2 逆序取余
        //int 型为 4个字节 32位
        char binary[] = new char[33];
        Arrays.fill(binary,'0');
        char digits[] = new char[]{'0','1'};

        boolean negative = (num < 0);
        int charPos = 32;

       while (num>0){
           binary[charPos--] = digits[num%2];
           num = num / 2;
       }
       System.out.println(binary);
    }

    //判断是否为闰年
    public void fun3(int year) {
        if((year %4==0 && year %100!=0) || year % 400==0){
            System.out.println(String.format("%d是闰年", year));
        }else {
            System.out.println(String.format(String.format("%d不是闰年",year)));
        }
    }

    //实现 n 个  阶乘相加
    public int fun4(int n) {
        int sum = 0;
        for (int i = 1; i <=n ; i++) {
            int value = 1;
            for (int j = 1; j <=i; j++) {
                value = value * j;
                sum = sum + value;
            }
        }
        System.out.println(String.format("%d 个数 阶乘相加 = ", n));
        return  sum;
    }

    //编程求s=1-2+3-4+…+99-100
    public void fun5() {
        int sum=0;
        for (int i = 0; i <=100 ; i++) {
            if(i%2==0){
                sum = sum - i;
            }else {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }

    //试编写一个程序，其功能是：从键盘输入一个整数，输出这个数的每位数字之和。
    //例如：输入245789，输出35
    public int fun6() {
        System.out.println("输入245789，输出35");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = Integer.toString(num);
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            int n  = Integer.parseInt(String.valueOf(s.charAt(i)));
            sum = sum+n;
        }
        return sum;
    }

    //设计并实现一个要求用户输入两个数并猜测两数之和的程序。如果用户猜对结果，就显示祝贺消息，否则显示慰问信息以及正确答案。
    public void fun7() {
        int key = 100;
        System.out.println("请输入两个个数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int num1 = scanner.nextInt();
        if(num+num1==key){
            System.out.println("答对了");
        }else {
            System.out.println("cuole ,key is "+key);
        }
    }

    //编写程序，一列数的规律如下：1、1、2、3、5、8、13、21、34……
    //求这列数的第30个数是多少
    public int fun8(int len,int index) {
        //动态规划解决斐波那契数列
        //len 作为这个数列的长度
        System.out.println("斐波那契数列");
        int dp[] = new int[len+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <=len; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[index+1];
    }

    //9*.输入年月日，输出这一天的前一天。

    public void fun9() {
        System.out.println("输入年月日(2019-07-01):");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //解析字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//线程不安全
        Date date = null;
        try {
             date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //日历
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        date = calendar.getTime();

        s = sdf.format(date);
        System.out.println(s);
    }


    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        //demo03.fun3(1998);
        //System.out.println(demo03.fun4(10));
        //demo03.fun5();
        //System.out.println(demo03.fun6());
        //demo03.fun7();
        //System.out.println(demo03.fun8(30,29));
        demo03.fun9();

    }
}
