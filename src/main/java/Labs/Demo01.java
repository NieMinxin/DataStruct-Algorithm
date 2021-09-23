package Labs;

public class Demo01 {
    public static void printPrime(int src,int dest){
        int k;
        int h = 0;
        //外层循环 表示数的范围
        for (int i = src; i <= dest ; i++) {
            if(isPrime(i)){
                System.out.print(String.format("%4d",i ));
                h++;
                if(h%15==0){
                    System.out.println();
                }
            }
        }
    }

    public static   boolean isPrime(int value){
        //使用 i*i 优化，减少循环
        for (int i = 2; i*i<=value ; i++) {
            if(value%i==0){
                //有其他整数因子
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        printPrime(200,300);
    }
}
