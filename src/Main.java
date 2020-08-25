import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	/*
	// Frame
	// A. 입출력과 사칙연산
	// 1. Hello World 
	// Import 
	private static void A01() {
		System.out.println("Hello World!");
	}
	*/
	
	public static void main(String[] args) {

	}
	
	// E. 실습 1
	// 1. 평균 점수 - 10039 
	// Import Scanner
	private static void E01() {
		Scanner s = new Scanner(System.in);
		int sum = 0, score = 0;
		for (int i = 0; i < 5; i++) {
			score = s.nextInt();
			if (score < 40) {
				sum = sum + 40;
			} else {
				sum = sum + score;
			}
		}
		
		System.out.println(sum / 5);
	}
	
	// E. 실습 1
	// 2. 상근날드 - 5543 
	// Import Scanner
	private static void E02() {
		Scanner s = new Scanner(System.in);
		int price[] = new int[5];
		int burger = 0, drink = 0;
		for (int i = 0; i < 5; i++) {
			price[i] = s.nextInt();
			if (i == 0) {
				burger = price[i];
			} else if (i < 3) {
				if (burger > price[i])
					burger = price[i];
			} else if (i == 3) {
				drink = price[i];
			} else {
				if (drink > price[i]) 
					drink = price[i];
			}
		}
		
		System.out.println(burger + drink - 50);
	}
	
	// E. 실습 1
	// 3. 세 수 - 10817 
	// Import Scanner
	private static void E03() {
		Scanner s = new Scanner(System.in);
		int num[] = new int[3];
		int tmp = 0;
		for (int i = 0; i < 3; i++) {
			num[i] = s.nextInt();
		}
		
		if (num[0] > num[1]) {
			tmp = num[0];
			num[0] = num[1];
			num[1] = tmp;
		}
		
		if (num[0] > num[2]) {
			tmp = num[0];
			num[0] = num[2];
			num[2] = tmp;
		}
		
		if (num[1] > num[2]) {
			tmp = num[1];
			num[1] = num[2];
			num[2] = tmp;
		}
		
		System.out.println(num[1]);
	}
	
	// E. 실습 1
	// 4. 별 찍기 - 13 - 2523 
	// Import Scanner
	private static void E04() {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		
		for (int i = 1; i <= num; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = num-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// E. 실습 1
	// 5. 별 찍기 - 9 - 2446 
	// Import Scanner
	private static void E05() {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num*2-1; j++) {
				if (j >= i && j <= num*2-i)
					System.out.print("*");
				else if (j < i)
					System.out.print(" ");
			}
			System.out.println();
		}
		
		for (int i = num-1; i >= 1; i--) {
			for (int j = 1; j <= num*2-1; j++) {
				if (j >= i && j <= num*2-i)
					System.out.print("*");
				else if (j < i)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	// E. 실습 1
	// 6. 별 찍기 - 21 - 10996 
	// Import Scanner
	private static void E06() {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				if (j % 2 == 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			for (int j = 1; j <= num; j++) {
				if (j % 2 == 0)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	// D. while문
	// 1. A+B - 5 - 10952 
	// Import BufferedReader, BufferedWriter, NumberFormatException, IOException, InputStreamReader, OutputStreamWriter
	private static void D01() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String data = bf.readLine();
			String[] datas = data.split(" ");
			if (datas[0].equals("0") && datas[1].equals("0")) {
				break;
			} else {
				bw.write(Integer.parseInt(datas[0])+Integer.parseInt(datas[1])+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	// D. while문
	// 2. A+B - 4 - 10951 
	// Import BufferedReader, BufferedWriter, NumberFormatException, IOException, InputStreamReader, OutputStreamWriter
	private static void D02() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String data = bf.readLine();
			if (data == null) break;
			String[] datas = data.split(" ");
			bw.write(Integer.parseInt(datas[0])+Integer.parseInt(datas[1])+"\n");
			
		}
		bw.flush();
		bw.close();
	}
	
	// D. while문
	// 3. 더하기 사이클 - 1110 
	// Import Scanner
	private static void D03() {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int a, b, tmp, count = 0;
		if (num < 10) {
			a = 0;
		} else {
			a = num / 10;	
		}
		b = num % 10;
		tmp = a + b;
		while(true) {
			count++;
			a = b;
			b = tmp % 10;
			tmp = a + b;
			if ((a*10+b) == num) break;
		}
		System.out.println(count);
	}
	
	// C. for문
	// 1. 구구단 - 2739 
	// Import Scanner
	private static void C01() {
		Scanner scanner = new Scanner(System.in);
		int x;
		x = scanner.nextInt();
		
		for (int i = 1; i <= 9; i++) {
			System.out.println(x + " * " + i + " = " + x*i);	
		}
	}
	
	// C. for문
	// 2. A+B - 3 - 10950 
	// Import Scanner
	private static void C02() {
		Scanner scanner = new Scanner(System.in);
		int test, x, y;
		test = scanner.nextInt();
		
		for (int i = 0; i < test; i++) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			System.out.println(x+y);	
		}
	}
	
	// C. for문
	// 3. 합 - 8393 
	// Import Scanner
	private static void C03() {
		Scanner scanner = new Scanner(System.in);
		int x, sum = 0;
		x = scanner.nextInt();
		
		for (int i = 1; i <= x; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
	}
	
	// C. for문
	// 4. 빠른 A+B 
	// Import BufferedReader, BufferedWriter, NumberFormatException, IOException, InputStreamReader, OutputStreamWriter
	private static void C04() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine().trim());
		
		for (int i = 0; i < n; i++) {
			String text = bf.readLine();
			String[] word = text.split(" ");
			int a = Integer.parseInt(word[0]);
			int b = Integer.parseInt(word[1]);
			bw.write((a+b)+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	// C. for문
	// 5. N 찍기 - 2741 
	// Import BufferedReader, BufferedWriter, NumberFormatException, IOException, InputStreamReader, OutputStreamWriter
	private static void C05() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine().trim());
		
		for (int i = 1; i <= n; i++) {
			bw.write(i+"\n");
		}
		bw.flush();
		bw.close();System.out.println("Hello World!");
	}
	
	// C. for문
	// 6. 기찍 N - 2742
	// Import BufferedReader, BufferedWriter, NumberFormatException, IOException, InputStreamReader, OutputStreamWriter
	private static void C06() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine().trim());
		
		for (int i = n; i > 0; i--) {
			bw.write(i+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	// C. for문
	// 7. A+B - 7 - 11021 
	// Import BufferedReader, BufferedWriter, NumberFormatException, IOException, InputStreamReader, OutputStreamWriter
	private static void C07() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine().trim());
		
		for (int i = 1; i <= n; i++) {
			String text = bf.readLine();
			String[] word = text.split(" ");
			int a = Integer.parseInt(word[0]);
			int b = Integer.parseInt(word[1]);
			bw.write("Case #"+i+": "+(a+b)+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	// C. for문
	// 8. A+B - 8 - 11022 
	// Import BufferedReader, BufferedWriter, NumberFormatException, IOException, InputStreamReader, OutputStreamWriter
	private static void C08() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine().trim());
		
		for (int i = 1; i <= n; i++) {
			String text = bf.readLine();
			String[] word = text.split(" ");
			int a = Integer.parseInt(word[0]);
			int b = Integer.parseInt(word[1]);
			bw.write("Case #"+i+": "+a+" + "+b+" = "+(a+b)+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	// C. for문
	// 9. 별 찍기 - 1 - 2438 
	// Import BufferedReader, BufferedWriter, NumberFormatException, IOException, InputStreamReader, OutputStreamWriter
	private static void C09() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine().trim());
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	// C. for문
	// 10. 별 찍기 - 2 - 2439 
	// Import BufferedReader, BufferedWriter, NumberFormatException, IOException, InputStreamReader, OutputStreamWriter
	private static void C10() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine().trim());
		
		for (int i = 1; i <= n; i++) {
			for (int j = n; j > 0; j--) {
				if (j <= i) {
					bw.write("*");	
				} else {
					bw.write(" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	// C. for문
	// 11. X보다 작은 수 - 10871 
	// Import BufferedReader, BufferedWriter, NumberFormatException, IOException, InputStreamReader, OutputStreamWriter
	private static void C11() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String n = bf.readLine();
		String[] parse = n.split(" ");
		String data = bf.readLine();
		String[] datas = data.split(" ");
		
		for (int i = 0; i < Integer.parseInt(parse[0]); i++) {
			if (Integer.parseInt(datas[i]) < Integer.parseInt(parse[1]))
				bw.write(datas[i] + " ");
		}
		bw.flush();
		bw.close();
	}
	
	// B. if문
	// 1. 두 수 비교하기 - 1330 
	// Import Scanner
	private static void B01() {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		if (a > b) {
			System.out.println(">");
		} else if (a == b) {
			System.out.println("==");
		} else {
			System.out.println("<");
		}
	}

	// B. if문
	// 2. 시험 성적 - 9498 
	// Import Scanner
	private static void B02() {
		Scanner scanner = new Scanner(System.in);
		int a;
		a = scanner.nextInt();
		
		if (a >= 90) {
			System.out.println("A");
		} else if (a >= 80) {
			System.out.println("B");
		} else if (a >= 70) {
			System.out.println("C");
		} else if (a >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
	
	// B. if문
	// 3. 윤년 - 2753 
	// Import Scanner
	private static void B03() {
		Scanner scanner = new Scanner(System.in);
		int a;
		a = scanner.nextInt();
		
		if (a % 4 == 0) {
			if (a % 100 == 0 && a % 400 != 0) {
				System.out.println("0");	
			} else {
				System.out.println("1");	
			}
		} else {
			System.out.println("0");
		}
	}
	
	// B. if문
	// 4. 사분면 고르기 - 14681 
	// Import Scanner
	private static void B04() {
		Scanner scanner = new Scanner(System.in);
		int x, y;
		x = scanner.nextInt();
		y = scanner.nextInt();
		
		if (x > 0) {
			if (y > 0) {
				System.out.println("1");	
			} else {
				System.out.println("4");	
			}
		} else {
			if (y > 0) {
				System.out.println("2");	
			} else {
				System.out.println("3");	
			}
		}
	}
	
	// B. if문
	// 5. 알람 시계 - 2884 
	// Import Scanner
	private static void B05() {
		Scanner scanner = new Scanner(System.in);
		int x, y, time, hour, minute;
		x = scanner.nextInt();
		y = scanner.nextInt();
		
		time = x * 60 + y - 45;
        if (time < 0) {
			time = 1440 + time;
		}
		hour = time / 60;
		minute = time % 60;
		
		System.out.print(hour + " " + minute);
	}
	
	// A. 입출력과 사칙연산
	// 1. Hello World - 2557
	// Import 
	private static void A01() {
		System.out.println("Hello World!");
	}
	
	// A. 입출력과 사칙연산
	// 2. We love Kriii - 10718
	// Import 
	private static void A02() {
		System.out.println("강한친구 대한육군");
        System.out.println("강한친구 대한육군");
	}	
	
	// A. 입출력과 사칙연산
	// 3. 고양이 - 10171
	// Import 
	private static void A03() {
		System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");
	}
	
	// A. 입출력과 사칙연산
	// 4. 개 - 10172
	// Import 
	private static void A04() {
		System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");
	}
	
	// A. 입출력과 사칙연산
	// 5. A+B - 1000
	// Import Scanner
	private static void A05() {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		a = scanner.nextInt();
		b = scanner.nextInt();
		System.out.println(a+b);
	}
	
	// A. 입출력과 사칙연산
	// 6. A-B - 1001
	// Import Scanner
	private static void A06() {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		a = scanner.nextInt();
		b = scanner.nextInt();
		System.out.println(a-b);
	}
	
	// A. 입출력과 사칙연산
	// 7. AxB - 10998
	// Import Scanner
	private static void A07() {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		a = scanner.nextInt();
		b = scanner.nextInt();
		System.out.println(a*b);
	}
	
	// A. 입출력과 사칙연산
	// 8. A/B - 1008
	// Import Scanner
	private static void A08() {
		Scanner scanner = new Scanner(System.in);
		int a, b;
        
		a = scanner.nextInt();
		b = scanner.nextInt();
        
		System.out.println((double)a/b);
	}
	
	// A. 입출력과 사칙연산
	// 9. 사칙연산
	// Import Scanner
	private static void A09() {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		a = scanner.nextInt();
		b = scanner.nextInt();
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
	}
	
	// A. 입출력과 사칙연산
	// 10. 나머지 - 10430
	// Import Scanner
	private static void A10() {
		Scanner scanner = new Scanner(System.in);
		int A, B, C;
		A = scanner.nextInt();
		B = scanner.nextInt();
		C = scanner.nextInt();
		System.out.println((A+B)%C);
		System.out.println(((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C)*(B%C))%C);
	}
	
	// A. 입출력과 사칙연산
	// 11. 곱셈 - 2588
	// Import Scanner
	private static void A11() {
		Scanner scanner = new Scanner(System.in);
		int a, b, hundred, ten, one;
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		hundred = b / 100;
		ten = (b - hundred * 100) / 10;
		one = b % 10;
		
		System.out.println(a * one);
		System.out.println(a * ten);
		System.out.println(a * hundred);
		System.out.println(a * b);
	}
	
}
