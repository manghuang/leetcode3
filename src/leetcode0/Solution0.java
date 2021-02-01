
package leetcode0;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution0 {

    private static class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private int ans = 0;
    private final int[] X = {-1, 0, 1, 0};
    private final int[] Y = {0, 1, 0, -1};

    public int swimInWater(int[][] grid) {
        int length = grid.length;
        boolean[][] isVisted = new boolean[length][length];

        PriorityQueue<Coordinate> priorityQueue = new PriorityQueue<>(new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return grid[o1.x][o1.y] - grid[o2.x][o2.y];
            }
        });
        isVisted[0][0] = true;
        priorityQueue.add(new Coordinate(0, 0));
        while (true){
            Coordinate poll = priorityQueue.poll();
            assert poll != null;
            ans = grid[poll.x][poll.y];
            if(dfs(grid, poll.x, poll.y,  priorityQueue, isVisted)){
                break;
            }
        }

        return ans;
    }

    private boolean dfs(int[][] grid, int x, int y, PriorityQueue<Coordinate> priorityQueue, boolean[][] isVisted) {

        int length = grid.length;
        if(x == length-1 && y == length-1){
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + X[i];
            int newY = y + Y[i];
            if(newX < 0 || newX >= length || newY < 0 || newY >= length || isVisted[newX][newY]){
                continue;
            }
            isVisted[newX][newY] = true;
            if(grid[newX][newY] > ans){
                priorityQueue.add(new Coordinate(newX, newY));
            }else {
                if(dfs(grid, newX, newY, priorityQueue, isVisted)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,2},{1,3}};
        int ans = new Solution0().swimInWater(grid);
        System.out.println(ans);
    }
}
