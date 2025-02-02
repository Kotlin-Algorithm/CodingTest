package week4;

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] array = initArray(maps);
        Queue<int[]> queue = new LinkedList<>(List.of(new int[] {1, 1, 1}));

        while (!queue.isEmpty()) {
            int[] outed = queue.poll();
            array[outed[0]][outed[1]] = 2;

            if (outed[0] == maps.length && outed[1] == maps[0].length) return outed[2];
            for (int[] next : new int[][] {{outed[0] - 1, outed[1]}, {outed[0], outed[1] + 1}, {outed[0] + 1, outed[1]}, {outed[0], outed[1] - 1}}) {
                if (array[next[0]][next[1]] == 1) {
                    array[next[0]][next[1]] = 2;

                    queue.offer(new int[] {next[0], next[1], outed[2] + 1});
                }
            }
        }
        return -1;
    }

    private static int[][] initArray(int[][] maps) {
        int[][] array = new int[maps.length + 2][maps[0].length + 2];

        Arrays.setAll(array, value -> {
            int[] rows = new int[array[0].length];

            if (value > 0 && value <= maps.length) {
                Arrays.setAll(rows, operand -> operand > 0 && operand <= maps[value - 1].length ? maps[value - 1][operand - 1] : 0);
            }
            return rows;
        });
        return array;
    }
}