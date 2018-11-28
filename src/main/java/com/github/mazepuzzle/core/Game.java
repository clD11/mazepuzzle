package com.github.mazepuzzle.core;

import com.github.mazepuzzle.core.algorithm.BinaryTree;

import java.util.Scanner;

public class Game {

    private static int[] currentCell;

    public static void main(String[] args) {
        System.out.println("---start---");

        Grid maze = createMaze(8, 8);

        currentCell = new int[]{0, 0};
        maze.markCell(0, 0);

        System.out.println(maze.toString());

        Scanner scan = new Scanner(System.in);

        while (true) {
            String key = scan.nextLine();

            if (key.equals("q")) {
                break;
            } else if (key.equals("i")) {
                currentCell[0] -= 1;
            } else if (key.equals("k")) {
                currentCell[0] += 1;
            } else if (key.equals("j")) {
                currentCell[1] -= 1;
            } else if (key.equals("l")) {
                currentCell[1] += 1;
            }

            maze.markCell(currentCell[0], currentCell[1]);
            System.out.println(maze.toString());
        }

        System.out.print("---end---");
    }

    private static Grid createMaze(int rows, int columns) {
        Grid grid = new Grid(rows, columns);
        BinaryTree binaryTree = new BinaryTree();
        return binaryTree.execute(grid);
    }

}
