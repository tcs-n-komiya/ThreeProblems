package loto6;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Loto6 クラスは、1～43 の数字から重複のない 6 つの番号をランダムに抽選して表示するプログラム。
 * 抽選結果は昇順で表示。
 */
public class Loto6 {

    /** 抽選範囲の最小値 */
    private static final int MIN = 1;

    /** 抽選範囲の最大値 */
    private static final int MAX = 43;

    /** 抽選する数字の個数 */
    private static final int COUNT = 6;

    /**
     * プログラムのエントリーポイント。
     * 抽選範囲の妥当性を確認し、抽選結果を表示。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {

        if (!validate(MIN, MAX)) {
            return;
        }

        final List<Integer> result = generateLotoNumbers(MIN, MAX, COUNT);

        printResult(result);
    }

    /**
     * 抽選範囲の妥当性をチェック。
     *
     * @param start 抽選範囲の開始値
     * @param end 抽選範囲の終了値
     * @return 妥当であれば true、不正があれば false
     */
    public static boolean validate(final int start, final int end) {
        if (start < MIN || end > MAX) {
            System.out.println("エラー：抽選範囲は " + MIN + "～" + MAX + " の間で指定してください。");
            return false;
        }
        if (start > end) {
            System.out.println("エラー：開始値は終了値以下である必要があります。");
            return false;
        }
        if ((end - start + 1) < COUNT) {
            System.out.println("エラー：抽選対象数が " + COUNT + " 未満です。範囲を広げてください。");
            return false;
        }
        return true;
    }

    /**
     * 指定された範囲から重複なしでランダムに COUNT 個の数字を抽選。
     * 抽選には Collections.shuffle() を使用し、偏りのない結果を保証。
     *
     * @param start 抽選範囲の開始値
     * @param end 抽選範囲の終了値
     * @param count 抽選する個数
     * @return 抽選された整数リスト
     */
    public static List<Integer> generateLotoNumbers(final int start, final int end, final int count) {
        List<Integer> numbers = IntStream.rangeClosed(start, end)
                                         .boxed()
                                         .collect(Collectors.toList());

        Collections.shuffle(numbers, new Random());

        return numbers.stream()
                      .limit(count)
                      .sorted() // 昇順で表示するためにソート
                      .collect(Collectors.toList());
    }

    /**
     * 抽選結果をコンソールに出力。
     *
     * @param result 抽選された整数のリスト
     */
    public static void printResult(final List<Integer> result) {
        System.out.println("抽選された " + COUNT + " つの数字（昇順）:");
        result.forEach(num -> System.out.print(num + " "));
        System.out.println(); // 改行
    }
}
