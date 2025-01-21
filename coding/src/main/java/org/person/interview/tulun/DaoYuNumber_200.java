package org.person.interview.tulun;

public class DaoYuNumber_200 {
  /**
   * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
   *
   * <p>岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
   *
   * <p>此外，你可以假设该网格的四条边均被水包围。
   *
   * @param grid
   * @return
   */
  public static int numIslands(char[][] grid) {
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          // dfs
          dfs(grid, i, j);
          ans++;
        }
      }
    }

    return ans;
  }

  public static void dfs(char[][] grid, int i, int j) {
    // 定义终止条件
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
      return;
    }

    grid[i][j] = '2'; // 避免反复横跳
    dfs(grid, i, j - 1);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i + 1, j);
  }

  public static void main(String[] args) {
    char[][] grid = {
      {'1', '1', '1', '1', '0'},
      {'1', '1', '0', '1', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '0', '0', '0'}
    };

    int ans = numIslands(grid);
    System.out.println(ans);
  }
}
