package prime_number;

import java.util.ArrayList;
import java.util.List;

/**
 * PrimeNumber クラスは、指定された範囲内の素数を判定し、表示・集計するプログラム。
 */
public class PrimeNumber {

	/** 判定開始の定数 */
	private static final int START_NUMBER = 1;

	/** 判定終了の定数 */
	private static final int END_NUMBER = 100;

	/**
	 * プログラムのエントリーポイント。
	 * 範囲の妥当性を確認し、素数を表示・集計。
	 *
	 * @param args コマンドライン引数（未使用）
	 */
	public static void main(String[] args) {
		if (!validateArgs(START_NUMBER, END_NUMBER)) {
			return;
		}

		final List<Integer> primes = collectPrimes(START_NUMBER, END_NUMBER);

		printPrimes(primes);
	}

	/**
	 * 開始・終了の引数をバリデートするメソッド。
	 *
	 * @param start 判定開始の整数
	 * @param end 判定終了の整数
	 * @return 有効なら true、無効なら false
	 */
	public static boolean validateArgs(final int start, final int end) {
		if (start <= 0 || end <= 0) {
			System.err.println("開始・終了の値は 1 以上である必要があります。");
			return false;
		}

		if (start > end) {
			System.err.println("開始値は終了値以下である必要があります。");
			return false;
		}

		return true;
	}

	/**
	 * 指定された範囲の素数を収集。
	 *
	 * @param start 判定開始
	 * @param end 判定終了
	 * @return 素数のリスト
	 */
	public static List<Integer> collectPrimes(final int start, final int end) {
		final List<Integer> primes = new ArrayList<>();
		for (int number = start; number <= end; number++) {
			if (isPrimeNumber(number)) {
				primes.add(number);
			}
		}
		return primes;
	}

	/**
	 * 素数リストを整形して表示し、個数も出力。
	 *
	 * @param primes 素数のリスト
	 */
	public static void printPrimes(final List<Integer> primes) {
		System.out.println("素数一覧（" + primes.size() + " 個）:");
		for (int i = 0; i < primes.size(); i++) {
			System.out.print(primes.get(i));
			if (i < primes.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println(); // 改行
	}

	/**
	 * 素数判定メソッド。
	 *
	 * @param number 判定対象の整数
	 * @return 素数なら true、そうでなければ false
	 */
	public static boolean isPrimeNumber(final int number) {
		if (number <= 1)
			return false;
		if (number == 2)
			return true;
		if (number % 2 == 0)
			return false;

		final int limit = (int) Math.sqrt(number);
		for (int i = 3; i <= limit; i += 2) {
			if (number % i == 0)
				return false;
		}

		return true;
	}
}
