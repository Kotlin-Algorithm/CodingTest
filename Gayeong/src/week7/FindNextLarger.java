import java.util.*;

public class FineNextLarger {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {

            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}