package ru.job4j.array;

public class MatrixCheck
{
    public static boolean isWin(char[][] board)
    {
        boolean result=false;
        int xrow=0, xcell=0, celltmp=0;
        for(int row=0; row<board.length; row++){
            for(int cell=0; cell<board.length; cell++){
                char sign=board[row][cell];
                System.out.print(sign);
                if(sign=='X'){
                    xcell++;
                    if(celltmp==0)
                        celltmp=cell;
                    if(celltmp==cell)
                        xrow++;
                }
            }
            System.out.println();
            if(xcell==board.length)
                result=true;
            xcell=0;
        }
        if(xrow==board.length)
            result=true;
        return result;
    }

    public static void main(String[] args)
    {
        char[][] hasWinVertical={
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win=isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor={
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor=isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin={
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose=isWin(notWin);
        System.out.println("A board has a winner : " + lose);
    }
}