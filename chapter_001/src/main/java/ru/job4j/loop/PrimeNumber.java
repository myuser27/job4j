package ru.job4j.loop;

public class PrimeNumber
{
    public int calc(int finish)
    {
        int count1=0, count2=0;
        for(int i=2;i<=finish;i++)
        {
            for(int j=2;j<=finish;j++)
            {
                if (i % j == 0)
                    count1++;
            }
            if(count1==1)
                count2++;
            count1=0;
        }
        return count2;
    }
}
