package Graph.ShortestPath;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
public class NearestExitFromEntrance {
    public int nearestExit(char[][] board, int[] entrance) {
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<DijkstraNode> pq = new LinkedList<>();
        pq.offer(new DijkstraNode(0, entrance[0], entrance[1]));
        visited[entrance[0]][entrance[1]] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        while (!pq.isEmpty()) {
            DijkstraNode currFoodObject = pq.poll();
            int row = currFoodObject.row, col = currFoodObject.col, currDistance = currFoodObject.distance;
            for (int[] it : dirs) {
                int newRow = row + it[0];
                int newCol = col + it[1];
                if (0 <= newRow && newRow < ROWS && 0 <= newCol && newCol < COLS && !visited[newRow][newCol] && (board[newRow][newCol] != '+')) {
                    if (isBorderCell(newRow, newCol, ROWS, COLS)) {
                        return currDistance + 1;
                    }
                    pq.offer(new DijkstraNode(currDistance + 1, newRow, newCol));
                    visited[newRow][newCol] = true;

                }
            }

        }
        return -1;
    }

    boolean isBorderCell(int row, int col, int numRows, int numCols) {
        return row == 0 || col == 0 || row == numRows - 1 || col == numCols - 1;
    }
}

