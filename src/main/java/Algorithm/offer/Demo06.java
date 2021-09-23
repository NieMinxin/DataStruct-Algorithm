package Algorithm.offer;

import java.util.Arrays;
import java.util.Scanner;

public class Demo06 {

    public  static int numWays(int n) {

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]= 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2]) % 1000000007;
        }
        return dp[n];
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;

        //dp[i]=max(dp[i−1],prices[i]−min(prices[0:i]))
        int  minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i <len ; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            maxProfit = Math.max(maxProfit,prices[i]-minPrice);//记录 maxProfit 作为info
        }
        return maxProfit;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        //dp[i]=max(nums[i],dp[i-1]+nums[i]);
        int dp [] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            maxSum = Math.max(maxSum,dp[i]);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        float num[] = new float[13];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<12; i++) {
            System.out.printf("请输入%d 月的 账户余额:",i+1);
            num[i] = scanner.nextFloat();
        }
        float sum = 0.0f;
        for (int i = 0; i <12 ; i++) {
            sum += num[i];
        }
        float average = sum / 12;

        System.out.printf("你的平均账户余额为 %.2f",average);
    }


}
