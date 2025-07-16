package loto6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loto6 {

    public static void main(String[] args) {
    	 //1～43の数字リストを作成
        List<Integer> numbers = createNumberList(1, 43);

        // 6つのランダムな数字を抽選
        List<Integer> result = drawRandomNumbers(numbers);

        // 抽選結果を表示
        printResult(result);


    }

    // 数字リストを作成（1～43）
    public static List<Integer> createNumberList(int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    // ランダムに6つの数字を選ぶ
    public static List<Integer> drawRandomNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            int index = rand.nextInt(numbers.size());
            result.add(numbers.get(index));
            numbers.remove(index);//重複防止で元リストから削除
        }
        return result;
    }

    // 抽選結果を表示
    public static void printResult(List<Integer> result) {
        System.out.println("抽選された6つの数字:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
 }

