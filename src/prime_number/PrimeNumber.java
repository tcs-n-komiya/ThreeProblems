package prime_number;

public final class PrimeNumber { // クラスにfinal（継承禁止）

    public static void main(String[] args) {
        final int StartNumber = 1;   // 初めの数（変更しないのでfinal）
        final int EndNumber = 100;   // 終わりの数（変更しないのでfinal）
        showPrimeNumber(StartNumber, EndNumber); // 素数を表示する
    }

    // 指定範囲の素数を表示するメソッド
    public static void showPrimeNumber(final int start, final int end) {
        for (int number = start; number <= end; number++) {
            if (isPrimeNumber(number)) {
                System.out.println(number); // 素数なら表示する
            }
        }
    }

    // 数字が素数かどうか調べるメソッド
    public static boolean isPrimeNumber(final int number) {
        if (number <= 1) {
            return false; // 1以下は素数じゃない
        }
        if(number == 2) {
        	return true; //2は素数
        }
        if (number % 2 == 0) {
        	return false; //2以外の偶数は素数ではない
        }

        final int limit = (int) Math.sqrt(number); // 計算結果を変更しないのでfinal

        for (int i = 3; i <= limit; i += 2) {
            if (number % i == 0) {
                return false; // 割り切れたら素数じゃない
            }
        }

        return true;
    }
}
