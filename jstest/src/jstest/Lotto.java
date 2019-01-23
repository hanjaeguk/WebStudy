package jstest;

public class Lotto {

	public static void main(String[] args) {
//		1. 1~45 난수
//		2. 같은 숫자 X
//		3. 3개 숫자 발생

		while (true) {
			int num1 = (int) (Math.random() * 3) + 1;
			int num2 = (int) (Math.random() * 3) + 1;
			int num3 = (int) (Math.random() * 3) + 1;
			if ((num1 != num2) && (num3 != num2) && (num3 != num1)) {
				System.out.println("금주 예상번호:" + num1 + "\t" + num2 + "\t" + num3);
				break;
			}	
		}
	}
}
