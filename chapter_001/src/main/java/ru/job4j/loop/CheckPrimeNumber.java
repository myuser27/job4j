package ru.job4j.loop;

public class CheckPrimeNumber
{
    public boolean check(int finish)
    {
        boolean prime=false;
        int count=0;
        for(int i=1;i<=finish;i++)
        {
            if(finish%i==0)
                count++;
        }
        if(count==2)
            prime=true;
        return prime;
    }
}
