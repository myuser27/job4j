package ru.job4j.array;

public class FindLoop
{
    public int indexOf(int[] data, int el)
    {
        int index=-1;
        for(int i=0;i<data.length;i++)
        {
            if(data[i]==el)
            {
                index=i;
                break;
            }
        }
        return index;
    }

    public int indexOf(int[] data, int el, int start, int finish)
    {
        int index=-1;
        for(int i=start;i<=finish;i++)
        {
            if(data[i]==el)
            {
                index=i;
                break;
            }
        }
        return index;
    }
}
