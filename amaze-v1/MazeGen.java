//Maze Generator

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;


public class MazeGen {

    //Initializing variables

    public static int mSize = 20;
    public static int startX, startY;
    public static int finishX , finishY;

    public static int randMove(){
        return (int)(Math.random() * 3) - 1;
    }

    //Random maze generator

    public static int[][] gen(int mazeSideLen, int startX, int startY, int finishX, int finishY) {

        int[][] maze = new int[mazeSideLen][mazeSideLen];

        for (int i = 0 ; i < mazeSideLen; ++i){
            for (int j = 0 ; j < mazeSideLen; ++j){
                maze[i][j] = 1;
            }
        }

        int posX = startX, posY = startY;

        int moveX = 0, moveY = 0;
        maze[posX][posY] = 0;
        while (true) {
            if ((int) (Math.random() * 2) == 0) {
                moveX = randMove();
                if (posX + moveX < 1 || posX + moveX == mazeSideLen - 1)
                    continue;
                posX += moveX;
            } else {
                moveY = randMove();
                if (posY + moveY < 1 || posY + moveY == mazeSideLen - 1)
                    continue;
                posY += moveY;
            }

            maze[posX][posY] = 0;

            if (posX == finishX && posY == finishY) {
                break;
            }
        }

        maze[finishX][finishY] = 2;

        return maze;
    }

    //Maze checker

    public static boolean getPercentOfZeros (int [][] matrix) {
        int zeros = 0;
        int total = 0;

        for (int i = 0; i < matrix.length; ++i){
            for (int k = 0; k < matrix[i].length; k++){
                total += 1;
                if (matrix[i][k] == 0)
                    zeros += 1;
            }
        }
        if ((zeros / total) < 0.8)
            return false;
        return true;
    }

    public static void run(int size) {

        mSize = size;
        int mazeSideLen = mSize;
        startX = 1;
        startY = 1;
        finishX = mSize - 2;
        finishY = mSize - 2;
        int[][] maze = gen(mazeSideLen, startX, startY, finishX, finishY);


        while (getPercentOfZeros(maze))
            maze = gen(mazeSideLen, startX, startY, finishX, finishY);


        //File output
        try {
            File file = new File("maze.txt");
            PrintStream w;
            FileOutputStream stream = new FileOutputStream(file);
            w = new PrintStream(stream);

            w.print(mazeSideLen);  w.print(" ");  w.println(mazeSideLen);
            w.print(startX);  w.print(" ");  w.println(startY);

            for (int i = 0 ; i < mazeSideLen; ++i){
                for (int j = 0 ; j < mazeSideLen; ++j){
                    w.print(maze[i][j]); w.print(" ");
                }
                w.print("\n");
            }

            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}