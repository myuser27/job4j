package ru.job4j.array;

public class Defragment
{
    public static String[] compress(String[] arr)
    {
        for(int i=0,index=0;i<arr.length;i++)
        {
            if(arr[i]==null)
            {
                index=i;
                while(arr[index]==null && index<arr.length-1)
                    index++;
                arr[i]=arr[index];
                arr[index]=null;
            }
        }
        return arr;
    }

    public static void main(String[] args)
    {
        String[] input={"I", null, "wanna", null, "be", null, "compressed"};
        for (int i=0; i<input.length; i++)
            System.out.print(input[i] + " ");

        String[] compressed=compress(input);

        System.out.println();
        for (int i=0; i<compressed.length; i++)
            System.out.print(compressed[i] + " ");
    }
}
