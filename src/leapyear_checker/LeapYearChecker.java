package leapyear_checker;

public class LeapYearChecker {

	public static void main(String[] args) {
		// 引数がない場合
		if (args.length == 0) {
			System.out.println("判定したい西暦年を指定してください。例：java LeapYearChecker 2024");
			return;
		}

		try {
			int year = Integer.parseInt(args[0]);

			if (year < 0) {
				System.out.println("エラー：負の年は指定できません。");
				return;
			}

			// うるう年判定と結果表示
			System.out.println(year + "年は" + (isLeapYear(year) ? "うるう年です。" : "うるう年ではありません。"));

		} catch (NumberFormatException e) {
			System.out.println("エラー：数字で年を指定してください。");
		}
	}

	// うるう年判定メソッド
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
