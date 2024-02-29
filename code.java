public class MazeRunner {
    public static String walk(int[][] maze, String[] directions) {
        int[] inicio = encontrarInicio(maze);

        for (String direction : directions) {
            if (direction.equals("N")) {
                inicio[0] -= 1;
            } else if (direction.equals("E")) {
                inicio[1] += 1;
            } else if (direction.equals("W")) {
                inicio[1] -= 1;
            } else if (direction.equals("S")) {
                inicio[0] += 1;
            }

            if (inicio[0] >= maze.length || inicio[0] < 0 || inicio[1] >= maze[0].length || inicio[1] < 0 || maze[inicio[0]][inicio[1]] == 1) {
                return "Dead";
            } else if (maze[inicio[0]][inicio[1]] == 3) {
                return "Finish";
            }
        }

        return "Lost";
    }

    private static int[] encontrarInicio(int[][] maze) {
        int[] inicio = new int[2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 2) {
                    inicio[0] = i;
                    inicio[1] = j;
                    return inicio;
                }
            }
        }
        return inicio;
    }
}