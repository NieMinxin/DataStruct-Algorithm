package Labs;

public class Demo02 {
    public static void main(String[] args) {
        for(int i=2;i<=1000;i++)
        {
            int sum=0;
            for(int j=1;j<i;j++)
            {
                if(i%j==0)
                    sum+=j;
            }
            if(sum==i)
            {
                System.out.print(String.format("%d是完数",i));
                for(int k=1;k<i;k++)
                {
                    if(i%k==0)
                        System.out.print(String.format("%4d",k));
                }
                System.out.println();
            }
        }
    }
}
