package jstest;

import java.io.*;
import java.util.Random;

public class GBB {
	
	BufferedReader in;
	Random random;
	String gbbStr[] = {"가위","바위","보"};
	
	public GBB() {
//		1.network
//		InputStream is = s.getInputStream();
//		2.file
//		File file  = new File("a.txt");
//		InputStream is = new FileInputStream(file);
//		3.system(console)
//		InputStream is = System.in;
//		Reader r = new InputStreamReader(is);
//		in = new BufferedReader(r);
		in = new BufferedReader(new InputStreamReader(System.in));
		random = new Random();
	}
	
	private void game() throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		random = new Random();
		while(true) {	
			int com = random.nextInt(3);
			System.out.print("입력:");
			int my = Integer.parseInt(in.readLine());
			int result = (my - com)%3;
			
			if(result == 0) {
				System.out.println("나:" + gbbStr[my] + "\t컴:" + gbbStr[my] + "\t결과:이겼다");
			}else if(result == 1) {
				System.out.println("나:" + gbbStr[my] + "\t컴:" + gbbStr[my] + "\t결과:졌다");
			}else {
				System.out.println("나:" + gbbStr[my] + "\t컴:" + gbbStr[my] + "\t결과:비겼다");
			}
			System.out.print("종료(0) 계속(아무키) : ");
			String num = in.readLine();
			if(num == "0") {	
				break;
			}			
		}
	}
	
	public static void main(String[] args) throws IOException {
		GBB gbb = new GBB();
		gbb.game();
	}
}
