package ru.job4j.loop;

public class CheckPrimeNumber
{
    public boolean check(int finish)
    {
        boolean prime=false;
        int count=2;
        for(;count<=finish;count++)
        {
            if(finish%count==0)
                break;
        }
        if(count==finish)
            prime=true;
        return prime;
    }
}
