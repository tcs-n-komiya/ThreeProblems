package leap_year_checker;

/**
 * コマンドライン引数で指定された西暦年がうるう年かどうかを判定し、結果を表示するプログラム。
 */
public class LeapYearChecker {

    /** 判定可能な最小年（西暦0年） */
    private static final int MIN_YEAR = 0;

    /**
     * プログラムのエントリーポイント。
     * コマンドライン引数から年を取得し、うるう年かどうかを判定して表示。
     *
     * @param args コマンドライン引数。1つ目の引数に判定対象の西暦年（整数）を指定。
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("例: java LeapYearChecker 2024");
            return;
        }

        final String input = args[0];

        if (!validate(input)) {
            return;
        }

        final int year = Integer.parseInt(input);
        final boolean leap = isLeapYear(year);

        printResult(year, leap);
    }

    /**
     * 入力文字列のバリデーション処理。
     *
     * @param input コマンドラインから受け取った文字列
     * @return 有効な整数なら true、そうでなければ false
     */
    public static boolean validate(final String input) {
        if (!input.matches("\\d+")) {
            System.out.println("エラー：数字で西暦年を指定してください。");
            return false;
        }

        final int year = Integer.parseInt(input);

        if (year < MIN_YEAR) {
            System.out.println("エラー：西暦 " + MIN_YEAR + " 年以上を指定してください。");
            return false;
        }

        return true;
    }

    /**
     * 指定された西暦年がうるう年かどうかを判定。
     * うるう年の定義：4で割り切れる年かつ100で割り切れない年、または400で割り切れる年。
     *
     * @param year 判定対象の西暦年
     * @return 指定された年がうるう年の場合は true、それ以外の場合は false
     */
    public static boolean isLeapYear(final int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * 判定結果を整形して表示。
     *
     * @param year 判定対象の西暦年
     * @param isLeap うるう年かどうかの判定結果
     */
    public static void printResult(final int year, final boolean isLeap) {
        System.out.println(year + "年は" + (isLeap ? "うるう年です。" : "うるう年ではありません。"));
    }
}
