package string_evaluating;

//Написать программу для вычисления выражения в строке.
// Ввод/вывод данных происходит через терминал.
// Пример входной строки: "3 + 45.7 - (12 + 5.6 * -7)

//Для решения задачи использовалась книга "Algorithms", Robert Sedgewick & Kevin Wayne, p.129.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class EvaluateString {

    public static void main(String[] args) {
        printResult("( 3 + 45.7 - ( 12 + 5.6 * -7 ) )"); //48.7 - (-27.2)
    }

    public static void printResult(String s) {
        String[] str = s.split("\\s+");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(str));
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!q.isEmpty()) { //Читаем элемент и вталкиваем его в стек, если операция.
            String token = q.poll();
            switch (token) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    ops.push(token);
                    break;
                case ")":
                    vals.push(evaluateOp(ops, vals));
                    break;
                default: //Если элемент не операция или скобка - вталкиваем значение double.
                    vals.push(Double.parseDouble(token));
                    break;
            }
        }
        System.out.println(s + " = " + evaluateOp(ops, vals));
    }

    private static Double evaluateOp(Stack<String> ops, Stack<Double> vals) {
        double v = vals.pop();
        if (!ops.empty()) {
            String op = ops.pop();
            switch (op) {
                case "+":
                    v = vals.pop() + v;
                    break;
                case "-":
                    v = vals.pop() - v;
                    break;
                case "*":
                    v = vals.pop() * v;
                    break;
                case "/":
                    v = vals.pop() / v;
                    break;
                case "sqrt":
                    v = Math.sqrt(v);
                    break;
                default:
                    break;
            }
        }
        return v;
    }
}
