package com.company;

public class Shuffler {

    private static final int SHUFFLE_COUNT = 5;

    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT + " consecutive perfect shuffles:");
        int[] values1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int j = 1; j <= SHUFFLE_COUNT; j++)
        {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++)
                System.out.print(" " + values1[k]);
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                " consecutive efficient selection shuffles:");
        for (int j = 1; j <= SHUFFLE_COUNT; j++)
        {
            selectionShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++)
                System.out.print(" " + values1[k]);
            System.out.println();
        }
        System.out.println();
    }

    public static void perfectShuffle(int[] values)
    {
        int [] shuff = new int[values.length];

        for(int i=0;i<values.length;i+=2)
            shuff[i]=values[i/2];
        for(int i=1;i<values.length;i+=2)
            shuff[i]=values[values.length/2+i/2];
        for(int i=0;i<values.length;i++)
            values[i]=shuff[i];
    }

    public static void selectionShuffle(int[] values)
    {
        int [] shuff = new int[values.length];

        for(int i=0;i<shuff.length;i++)
            shuff[i]=-100;
        for(int i=0;i<values.length;i++)
        {
            int rd;
            do rd = (int) (Math.random() * values.length);
            while(shuff[rd]!=-100);
            shuff[rd]=values[i];
        }
        for(int i=0;i<values.length;i++)
            values[i]=shuff[i];
    }
}