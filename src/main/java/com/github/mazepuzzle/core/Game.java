package com.github.mazepuzzle.core;

import com.github.mazepuzzle.core.algorithm.BinaryTree;

import java.util.Scanner;

public class Game {

    private static final int[] currentPosition = new int[]{0, 0};
    private static final int[] nextPosition = new int[]{0, 0};

    public static void main(String[] args) {
        System.out.println("---start---");

        Grid maze = createMaze(8, 8);
        maze.markCell(0, 0);

        System.out.println(maze.toString());

        Scanner scan = new Scanner(System.in);

        while (true) {
            String key = scan.nextLine();

            if (key.equals("q")) {
                break;
            } else if (key.equals("i")) {
                nextPosition[0] -= 1;
            } else if (key.equals("k")) {
                nextPosition[0] += 1;
            } else if (key.equals("j")) {
                nextPosition[1] -= 1;
            } else if (key.equals("l")) {
                nextPosition[1] += 1;
            }

            if (maze.canMove(currentPosition, nextPosition)) {
                currentPosition[0] = nextPosition[0];
                currentPosition[1] = nextPosition[1];
                maze.markCell(nextPosition[0], nextPosition[1]);
                System.out.println(maze.toString());
            } else {
                nextPosition[0] = currentPosition[0];
                nextPosition[1] = currentPosition[1];
            }
        }

        System.out.print("---end---");
    }

    private static Grid createMaze(int rows, int columns) {
        Grid grid = new Grid(rows, columns);
        BinaryTree binaryTree = new BinaryTree();
        return binaryTree.execute(grid);
    }

}
