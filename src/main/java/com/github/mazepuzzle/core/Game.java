package com.github.mazepuzzle.core;

import com.github.mazepuzzle.core.algorithm.BinaryTree;

public class Game {

    public static void main(String[] args) {
        System.out.print("---start---");
        Grid grid = new Grid(8, 8);
        BinaryTree binaryTree = new BinaryTree();
        grid = binaryTree.execute(grid);
        System.out.print(grid.toString());
        System.out.print("---end---");
    }

}
