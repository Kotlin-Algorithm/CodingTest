package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TreeCutting {
    public void cut() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> trees = new ArrayList<>() {
            {
                for(int i = 0; i < n; i++) {
                    add(sc.nextInt());
                }
            }
        };

        int start = 0;
        int end = Collections.max(trees);
        int result = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            long sum = trees.stream()
                    .filter(tree -> tree > mid)
                    .mapToLong(tree -> tree - mid)
                    .sum();

            if(sum >= n) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
