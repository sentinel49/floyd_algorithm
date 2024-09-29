/*
 * Title: Main_hw6_2.java
 * Abstract: This program implements the Floyd algorithm to display all-pairs shortst paths.
 * Date: 2/20/2024
 */

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    // get number of vertices from user
    int vertices = scan.nextInt();

    // create 2d array of size vertices x vertices
    int[][] graph = new int[vertices][vertices];

    // initialize "infinity" variable and populate 2d array
    int infinity = Integer.MAX_VALUE;
    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        graph[i][j] = scan.nextInt();
        if (graph[i][j] == -1) {
          graph[i][j] = infinity;
        }
      }
    }

    scan.close();

    // Floyd algorithm
    for (int k = 0; k < vertices; k++) {
      for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
          if (graph[i][k] != infinity && graph[k][j] != infinity) {
            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
          }
        }
      }
    }

    // final output
    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        if (graph[i][j] == infinity) {
          if (j == vertices - 1) {
            System.out.print("-1");
          } else {
            System.out.print("-1" + " ");
          }
        } else {
          if (j == vertices - 1) {
            System.out.print(graph[i][j]);
          } else
            System.out.print(graph[i][j] + " ");
        }
      }
      System.out.print("\n");
    }
  }

}