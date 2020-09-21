import java.io.*;
import java.util.*;

public class Main {
	/*
	// A. 입출력과 사칙연산
	// 1. Hello World 
	// Import 
	private static void A01() {
		System.out.println("Hello World!");
	}
	*/
	
	public static void main(String[] args) throws IOException {
		T05();
	}
	
	// T. 분할 정복
	// 1. 색종이 만들기 - 2630 
	// Import BufferedReader
	private static int t01Black = 0, t01White = 0;
	private static int[][] t01Square;
	
	private static void T01() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		t01Square = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] line = bf.readLine().split(" ");
			for (int j = 0; j < n; j++)
				t01Square[i][j] = Integer.parseInt(line[j]);
		}
		
		t01Separate(0, n - 1, 0, n - 1);
		
		System.out.println(t01White);
		System.out.println(t01Black);
	}
	
	private static void t01Separate(int x1, int x2, int y1, int y2) {
		if (x2 - x1 == 0) {
			if (t01Square[x1][y1] == 0)
				t01White++;
			else
				t01Black++;
		} else {
			int flag = t01Check(x1, x2, y1, y2);
			
			if (flag == 0) {
				t01White++;
			} else if (flag == 1) {
				t01Black++;
			} else {
				int xGap = x2 - x1  + 1;
				int yGap = y2 - y1  + 1;
				t01Separate(x1, x1 + xGap / 2 - 1, y1, y1 + yGap / 2 - 1);
				t01Separate(x1 + xGap / 2, x2, y1, y1 + yGap / 2 - 1);
				t01Separate(x1, x1 + xGap / 2 - 1, y1 + yGap / 2, y2);
				t01Separate(x1 + xGap / 2, x2, y1 + yGap / 2, y2);
			}
		}
	}
	
	private static int t01Check(int x1, int x2, int y1, int y2) {
		int color = t01Square[x1][y1];
		
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (color != t01Square[i][j])
					return -1;
			}
		}
		
		return color;
	}
	
	// T. 분할 정복
	// 2. 쿼드트리 - 1992
	// Import BufferedReader
	private static int[][] t02Square;
	
	private static void T02() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		t02Square = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String line = bf.readLine();
			for (int j = 0; j < n; j++) {
				t02Square[i][j] = line.charAt(j) - 48;
			}
		}
		
		String answer = t02Separate(0, n - 1, 0, n - 1);
		
		System.out.println(answer);
	}
	
	private static String t02Separate(int x1, int x2, int y1, int y2) {
		String answer = "(";
		if (x2 == x1) {
			if (t02Square[x1][y1] == 0)
				return "0";
			else
				return "1";
		} else {
			int flag = t02Check(x1, x2, y1, y2);
			
			if (flag == 0) {
				return "0";
			} else if (flag == 1) {
				return "1";
			} else {
				int xGap = x2 - x1  + 1;
				int yGap = y2 - y1  + 1;
				answer += t02Separate(x1, x1 + xGap / 2 - 1, y1, y1 + yGap / 2 - 1);
				answer += t02Separate(x1, x1 + xGap / 2 - 1, y1 + yGap / 2, y2);
				answer += t02Separate(x1 + xGap / 2, x2, y1, y1 + yGap / 2 - 1);
				answer += t02Separate(x1 + xGap / 2, x2, y1 + yGap / 2, y2);
			}
		}
		
		return answer + ")";
	}
	
	private static int t02Check(int x1, int x2, int y1, int y2) {
		int color = t02Square[x1][y1];
		
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (color != t02Square[i][j])
					return -1;
			}
		}
		
		return color;
	}
	
	// T. 분할 정복
	// 3. 종이의 개수 - 1780
	// Import BufferedReader
	private static int[][] t03Square;
	private static int[] t03Count = {0, 0, 0};
	
	private static void T03() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		t03Square = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] line = bf.readLine().split(" ");
			for (int j = 0; j < n; j++)
				t03Square[i][j] = Integer.parseInt(line[j]);
		}
		
		t03Separate(0, n - 1, 0, n - 1);
		
		System.out.println(t03Count[0]);
		System.out.println(t03Count[1]);
		System.out.println(t03Count[2]);
	}
	
	private static void t03Separate(int x1, int x2, int y1, int y2) {
		if (x2 == x1) {
			if (t03Square[x1][y1] == -1)
				t03Count[0]++;
			else if (t03Square[x1][y1] == 0) 
				t03Count[1]++;
			else
				t03Count[2]++;
		} else {
			int flag = t03Check(x1, x2, y1, y2);
			
			if (flag == -1) {
				t03Count[0]++;
			} else if (flag == 0) {
				t03Count[1]++;
			} else if (flag == 1) {
				t03Count[2]++;
			} else {
				int xGap = x2 - x1  + 1;
				int yGap = y2 - y1  + 1;
				
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 3; j++)
						t03Separate(x1 + xGap * i / 3, x1 + xGap * (i + 1) / 3 - 1, y1 + yGap * j / 3, y1 + yGap * (j + 1) / 3 - 1);
			}
		}
	}
	
	private static int t03Check(int x1, int x2, int y1, int y2) {
		int color = t03Square[x1][y1];
		
		for (int i = x1; i <= x2; i++)
			for (int j = y1; j <= y2; j++)
				if (color != t03Square[i][j])
					return -2;
		
		return color;
	}
	
	// T. 분할 정복
	// 4. 곱셈 - 1629
	// Import Scanner
	private static void T04() {
		Scanner s = new Scanner(System.in);
		
		long a = s.nextInt(), b = s.nextInt(), c = s.nextInt();
		
		System.out.println(t04Cal(a, b, c));
	}
	
	private static long t04Cal(long a, long b, long c) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a % c;
		} else if (b % 2 == 0){
			long tmp = t04Cal(a, b / 2, c);
			return (tmp * tmp) % c;
		} else {
			long tmp = t04Cal(a, b -1, c);
			return (a * tmp) % c;
		}
	}
	
	// T. 분할 정복
	// 5. 이항 계수 3 - 11401 
	// Import Scanner
	private static void T05() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), k = s.nextInt();
		
		System.out.println(t05Cal(n, k));
	}
	
	private static int t05Cal(int n, int k) {
		if (k == 0) {
			return 1;
		}
		
		return tmp;
	}
	
	// T. 분할 정복
	// 6. 행렬 곱셈 - 2740
	// Import 
	private static void T06() {
		System.out.println("Hello World!");
	}
	
	// T. 분할 정복
	// 7. 행렬 제곱 - 10830
	// Import 
	private static void T07() {
		System.out.println("Hello World!");
	}
	
	// T. 분할 정복
	// 8. 피보나치 수 3 - 2749
	// Import 
	private static void T08() {
		System.out.println("Hello World!");
	}
	
	// T. 분할 정복
	// 9. 히스토그램에서 가장 큰 직사각형 - 6549
	// Import 
	private static void T09() {
		System.out.println("Hello World!");
	}
	
	// T. 분할 정복
	// 10. 가장 가까운 두 점 - 2261
	// Import 
	private static void T10() {
		System.out.println("Hello World!");
	}
	
	// S. 큐, 덱
	// 1. 큐 2 - 18258 
	// Import BufferedReader
	private static void S01() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int last = -1;
		
		Queue<Integer> command = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			String[] line = bf.readLine().split(" ");
			
			if (line[0].equals("push")) {
				command.offer(Integer.parseInt(line[1]));
				last = Integer.parseInt(line[1]);
			} else if (line[0].equals("pop")) {
				if (command.size() != 0) {
					sb.append(command.poll() + "\n");
					if (command.size() == 0)
						last = -1;
				} else {
					sb.append("-1\n");
				}
			} else if (line[0].equals("size")) {
				sb.append(command.size() + "\n");
			} else if (line[0].equals("empty")) {
				if (command.size() == 0)
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (line[0].equals("front")) {
				if (command.size() != 0)
					sb.append(command.peek() + "\n");
				else
					sb.append("-1\n");
			} else if (line[0].equals("back")) {
				if (command.size() != 0)
					sb.append(last + "\n");
				else
					sb.append("-1\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	// S. 큐, 덱
	// 2. 카드 2 - 2164
	// Import Scanner
	private static void S02() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		Queue<Integer> command = new LinkedList<>();
		
		for (int i = 1; i <= n; i++)
			command.offer(i);
		
		while(command.size() > 1) {
			command.poll();
			command.offer(command.poll());
		}
		
		System.out.println(command.peek());
	}
	
	// S. 큐, 덱
	// 3. 오세푸스 문제 0 - 11866
	// Import Scanner
	private static void S03() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), k = s.nextInt(), index = 0, count = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		for (int i = 1; i <= n; i++)
			list.add(i);
		
		while (count < n) {
			int i = 0;
			
			while(i < k - 1) {
				if (index == list.size())
					index = 0;
				
				if (index == list.size() - 1)
					index = 0;
				else
					index++;
				i++;
			}
			
			if (count != n - 1)
				sb.append(list.get(index) + ", ");
			else
				sb.append(list.get(index));
			
			list.remove(index);
			count++;
		}
		
		sb.append(">");
		
		System.out.println(sb.toString());
	}
	
	// S. 큐, 덱
	// 4. 프린터 큐 - 1966 ★
	// Import BufferedReader
	private static void S04() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < T; i++) {
			String[] line = bf.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			int result = 1;
			
			String[] num = bf.readLine().split(" ");
			
			ArrayList<int[]> pri = new ArrayList<>();
			
			for (int j = 0; j < n; j++) {
				pri.add(new int[] {j, Integer.parseInt(num[j])});
			}
			
			while(pri.size() > 0) {
				int[] current = pri.get(0);
				boolean check = true;
				
				for (int j = 0; j < pri.size(); j++) {
					if (pri.get(j)[1] > current[1]) {
						check = false;
						break;
					}
				}
				
				if (!check) {
					pri.add(current);
					pri.remove(0);
				} else {
					if (current[0] == m) {
						System.out.println(result);
						break;
					} else {
						result++;
						pri.remove(0);
					}
				}
			}
		}
	}
	
	// S. 큐, 덱
	// 5. 덱 - 10866
	// Import BufferedReader
	private static void S05() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			String[] line = bf.readLine().split(" ");
			
			if (line[0].equals("push_front")) {
				deque.offerFirst(Integer.parseInt(line[1]));
			} else if (line[0].equals("push_back")) {
				deque.offerLast(Integer.parseInt(line[1]));
			} else if (line[0].equals("pop_front")) {
				if (deque.size() != 0)
					sb.append(deque.pollFirst() + "\n");
				else
					sb.append("-1\n");
			} else if (line[0].equals("pop_back")) {
				if (deque.size() != 0)
					sb.append(deque.pollLast() + "\n");
				else
					sb.append("-1\n");
			} else if (line[0].equals("size")) {
				sb.append(deque.size() + "\n");
			} else if (line[0].equals("empty")) {
				if (deque.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (line[0].equals("front")) {
				if (deque.size() != 0)
					sb.append(deque.peekFirst() + "\n");
				else
					sb.append("-1\n");
			} else if (line[0].equals("back")) {
				if (deque.size() != 0)
					sb.append(deque.peekLast() + "\n");
				else
					sb.append("-1\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	// S. 큐, 덱
	// 6. 회전하는 큐 - 1021
	// Import Scanner
	private static void S06() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), m = s.nextInt(), count = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> num = new ArrayList<>();
		
		for (int i = 1; i <= n; i++)
			list.add(i);
		
		for (int i = 0; i < m; i++) {
			int goal = s.nextInt();
			boolean done = false;
			
			while(!done) {
				if (goal == list.get(0)) {
					list.remove(0);
					done = true;
				} else {
					if (list.indexOf(goal) <= list.size() / 2)
						list.add(list.size() - 1, list.remove(0));
					else
						list.add(0, list.remove(list.size() - 1));
					count++;
				}
			}
			
		}
		
		System.out.println(count);
	}
	
	// S. 큐, 덱
	// 7. AC - 5430
	// Import BufferedReader
	private static void S07() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			String command = bf.readLine();
			int n = Integer.parseInt(bf.readLine());
			boolean done = true, reverse = false;
			
			String tmp = bf.readLine();
			String[] split = tmp.substring(1, tmp.length() - 1).split(",");
			
			Deque<Integer> num = new ArrayDeque<>();
			
			for (int j = 0; j < n; j++)
				num.offer(Integer.parseInt(split[j]));
			
			for (int j = 0; j < command.length(); j++) {
				if (command.charAt(j) == 'R') {
					reverse = !reverse;
				} else {
					if (num.size() == 0) {
						done = false;
						break;
					} else {
						if (reverse)
							num.pollLast();
						else
							num.pollFirst();
					}
				}
			}
			
			if (done) {
				sb.append("[");
				int repeat = num.size();
				if (!reverse) {
					for (int j = 0; j < repeat; j++) {
						if (num.size() != 1)
							sb.append(num.pollFirst() + ",");
						else
							sb.append(num.pollFirst());
					}	
				} else {
					for (int j = 0; j < repeat; j++) {
						if (num.size() != 1)
							sb.append(num.pollLast() + ",");
						else
							sb.append(num.pollLast());
					}	
				}
				
				sb.append("]\n");
			} else {
				sb.append("error\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	// R. 스택
	// 1. 스택 - 10828 
	// Import BufferedReader
	private static void R01() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		ArrayList<Integer> array = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			String[] command = bf.readLine().split(" ");
			
			if (command[0].equals("push")) {
				array.add(Integer.parseInt(command[1]));
			} else if (command[0].equals("pop")) {
				if (array.size() > 0) {
					System.out.println(array.get(array.size() - 1));
					array.remove(array.size() - 1);	
				} else {
					System.out.println(-1);
				}
			} else if (command[0].equals("size")) {
				System.out.println(array.size());
			} else if (command[0].equals("empty")) {
				if (array.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (command[0].equals("top")) {
				if (array.size() > 0) {
					System.out.println(array.get(array.size() - 1));
				} else {
					System.out.println(-1);
				}
			}
		}
	}
	
	// R. 스택
	// 2. 제로 - 10773 
	// Import BufferedReader
	private static void R02() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine()), sum = 0;
		ArrayList<Integer> array = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(bf.readLine());
			
			if (num == 0) {
				array.remove(array.size() - 1);
			} else {
				array.add(num);
			}
		}
		
		for (int i = 0; i < array.size(); i++)
			sum += array.get(i);
		
		System.out.println(sum);
	}
	
	// R. 스택
	// 3. 괄호 - 9012
	// Import BufferedReader
	private static void R03() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine()), count;
		
		for (int i = 0; i < n; i++) {
			String line = bf.readLine();
			count = 0;
			
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == '(')
					count++;
				else
					count--;
				
				if (count < 0)
					break;
			}
			
			if (count == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	// R. 스택
	// 4. 균형잡힌 세상 - 4949
	// Import BufferedReader
	private static void R04() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		
		while(true) {
			String line = bf.readLine();
			
			if (line.charAt(0) == '.')
				break;
			
			stack.clear();
			
			for (int j = 0; j < line.length(); j++) {
				char t = line.charAt(j);
				if (t == '(' || t == '[') {
					stack.push(t);
				} else if (t == ')' || t == ']') {
					if (stack.isEmpty() ||
						(t == ')' && stack.peek() != '(') ||
						(t == ']' && stack.peek() != '[')) {
						stack.push(t);
						break;
					}
					stack.pop();
				}
			}
			if (stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	// R. 스택
	// 5. 스택 수열 - 1874 ★
	// Import BufferedReader
	private static void R05() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int[] array = new int[n];
		int num = 1;
		
		boolean isAble = true;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(bf.readLine());
			
			if (isAble) {
				if (num <= array[i]) {
					while(num <= array[i]) {
						stack.push(num++);
						sb.append("+\n");
					}
				}
				if (stack.isEmpty()) {
					isAble = false;
				} else {
					while(stack.peek() >= array[i]) {
						stack.pop();
						sb.append("-\n");
						if(stack.isEmpty())
							break;
					}
				}
			}
		}
		
		if (isAble)
			System.out.println(sb.toString());
		else
			System.out.println("NO");
	}
	
	// Q. 수학 3
	// 1. 배수와 약수 - 5086 
	// Import BufferedReader
	private static void Q01() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] line = br.readLine().split(" ");
			int[] num = new int[2];
			num[0] = Integer.parseInt(line[0]);
			num[1] = Integer.parseInt(line[1]);
			
			if (num[0] == 0 && num[1] == 0)
				break;
			
			if (num[0] > num[1]) {
				if (num[0] % num[1] == 0) {
					System.out.println("multiple");
				} else {
					System.out.println("neither");	
				}
			} else if (num[0] < num[1]) {
				if (num[1] % num[0] == 0) {
					System.out.println("factor");
				} else {
					System.out.println("neither");
				}
			} else {
				System.out.println("neither");
			}
		}
		br.close();
	}
	
	// Q. 수학 3
	// 2. 약수 - 1037
	// Import Scanner
	private static void Q02() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] num = new int[n];
		long result = 1;
		
		for (int i = 0; i < n; i++)
			num[i] = s.nextInt();
		
		Arrays.sort(num);
		
		result = num[0] * num[n - 1];
		
		System.out.println(result);
	}
	
	// Q. 수학 3
	// 3. 소인수분해 - 11653
	// Import Scanner
	private static void Q03() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), i = 2;
		
		while (n > 1) {
			if (n % i == 0) {
				System.out.println(i);
				n /= i;
			} else {
				i++;
			}
		}
	}
	
	// Q. 수학 3
	// 4. 최대공약수와 최소공배수 - 2609 
	// Import Scanner
	private static void Q04() {
		Scanner s = new Scanner(System.in);
		
		int a = s.nextInt(), b = s.nextInt(), i = 2, max = 1, min = a * b;
		int goal = Math.min(a, b);
		
		while(i < goal) {
			if (a % i == 0 && b % i == 0) {
				a /= i;
				b /= i;
				max *= i;
			} else {
				i++;
			}
		}
		
		min = max * a * b;
		
		System.out.println(max);
		System.out.println(min);
	}
	
	// Q. 수학 3
	// 5. 검문 - 2981 ★
	// Import Scanner
	private static void Q05() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] num = new int[n];
		
		for (int i = 0; i < n; i++)
			num[i] = s.nextInt();
		
		Arrays.sort(num);
		
		int x = num[1] - num[0];
		
		for (int i = 2; i < num.length; i++)
			x = gcb(x, num[i] - num[i - 1]);
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 2; i <= x; i++) {
			if (x % i == 0)
				sb.append(i + " ");
		}
		
		System.out.println(sb);
	}
	
	public static int gcb(int a, int b) {
		if (a % b == 0)
			return b;
		else
			return gcb(b, a % b);
	}
	
	// Q. 수학 3
	// 6. 링 - 3036
	// Import Scanner
	private static void Q06() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), first = s.nextInt();
		int[][] rings = new int[n -1][2];
		
		for (int i = 0; i < n - 1; i++) {
			rings[i][0] = s.nextInt();
			rings[i][1] = gcb(first, rings[i][0]);
			
			System.out.println(first / rings[i][1] + "/" + rings[i][0] / rings[i][1]);
		}
	}
	
	// Q. 수학 3
	// 7. 이항 계수 1 - 11050 
	// Import Scanner
	private static void Q07() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), k = s.nextInt();
		
		if (k < 0 || k > n) {
			System.out.println(0);
		} else {
			System.out.println(factorial(n) / (factorial(k) * factorial(n - k)));
		}
	}
	
	// Q. 수학 3
	// 8. 이항 계수 2 - 11051
	// Import Scanner
	private static void Q08() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), k = s.nextInt();
		
		int[][] list = new int[1001][1001];
		
		list[0][0] = list[1][0] = list[1][1] = 1;
		
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0)
					list[i][j] = 1;
				else
					list[i][j] = list[i - 1][j - 1] + list[i - 1][j];
				
				list[i][j] %= 10007;
			}
		}
		
		System.out.println(list[n][k]);
	}
	
	// Q. 수학 3
	// 9. 패션왕 신해빈 - 9375
	// Import BufferedReader
	private static void Q09() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(bf.readLine());
			HashMap<String, Integer> cloth = new HashMap<>();
			
			for (int j = 0; j < n; j++) {
				String[] tmp = bf.readLine().split(" ");
				if (cloth.containsKey(tmp[1]))
					cloth.put(tmp[1], cloth.get(tmp[1]) + 1);
				else
					cloth.put(tmp[1], 1);
			}
			
			int result = 1;
			
			for (int val : cloth.values())
				result *= val + 1;
			
			System.out.println(result - 1);
		}
	}
	
	// Q. 수학 3
	// 10. 팩토리얼 0의 개수 - 1676
	// Import Scanner
	private static void Q10() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), count = 0;
		
		for (int i = 5; i <= n; i *= 5)
			count += n / i;
				
		System.out.println(count);
	}
	
	// Q. 수학 3
	// 11. 조합 0의 개수 - 2004
	// Import Scanner
	private static void Q11() {
		Scanner s = new Scanner(System.in);
		
		long n = s.nextLong(), m = s.nextLong(), nm = n - m;
		long count2 = 0, count5 = 0;
		
		for (long i = 2; i <= n; i *= 2)
			count2 += n / i;
		
		for (long i = 5; i <= n; i *= 5)
			count5 += n / i;
		
		for (long i = 2; i <= m; i *= 2)
			count2 -= m / i;
		
		for (long i = 5; i <= m; i *= 5)
			count5 -= m / i;

		for (long i = 2; i <= nm; i *= 2)
			count2 -= nm / i;
		
		for (long i = 5; i <= nm; i *= 5)
			count5 -= nm / i;
		
		System.out.println(Math.min(count2, count5));
	}
	
	// P. 그리디 알고리즘
	// 1. 동전 0 - 11047 
	// Import Scanner
	private static void P01() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), k = s.nextInt(), tmp = 0, count = 0, index = n - 1;
		int[] coins = new int[n];
		
		for (int i = 0; i < n; i++) {
			coins[i] = s.nextInt();
		}
		
		while(tmp < k) {
			if (k - tmp > coins[index]) {
				tmp += coins[index];
				count++;
			} else if (k - tmp == coins[index]) {
				count++;
				break;
			} else {
				index--;
			}
		}
		
		System.out.println(count);
	}
	
	// P. 그리디 알고리즘
	// 2. 회의실배정 - 1931 
	// Import BufferedReader
	private static void P02() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] time = new int[n][2]; 
		
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			
			time[i][0] = Integer.parseInt(tmp[0]);
			time[i][1] = Integer.parseInt(tmp[1]);
		}
		
		Arrays.sort(time, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int count = 0, end = -1;
		
		for (int i = 0; i < n; i++) {
			if (time[i][0] >= end) {
				end = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	// P. 그리디 알고리즘
	// 3. ATM - 11399
	// Import Scanner
	private static void P03() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), sum = 0;
		int[] time = new int[n];
		
		for (int i = 0; i < n; i++) {
			time[i] = s.nextInt();
		}
		
		Arrays.sort(time);
		
		for (int i = 0; i < n; i++)
			sum += time[i] * (n - i);
		
		System.out.println(sum);
	}
	
	// P. 그리디 알고리즘
	// 4. 잃어버린 괄호
	// Import Scanner
	private static void P04() {
		Scanner s = new Scanner(System.in);
		
		String[] minusSplit = s.nextLine().split("\\-");
		int sum = 0;
		
		for (int i = 0; i < minusSplit.length; i++) {			
			if (i == 0) {
				if (minusSplit[i].contains("+")) {
					String[] plusSplit = minusSplit[i].split("\\+");
					
					for (int j = 0; j < plusSplit.length; j++) {
						sum += Integer.parseInt(plusSplit[j]);
					}
				} else {
					sum += Integer.parseInt(minusSplit[i]);
				}
			} else {
				if (minusSplit[i].contains("+")) {
					String[] plusSplit = minusSplit[i].split("\\+");
					
					for (int j = 0; j < plusSplit.length; j++) {
						sum -= Integer.parseInt(plusSplit[j]);
					}
				} else {
					sum -= Integer.parseInt(minusSplit[i]);
				}
			}
		}
		
		System.out.println(sum);
	}
	
	// O. 동적 계획법 1단계
	// 1. 피보나치 수 2 - 2748 
	// Import Scanner
	private static void O01() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		long[] array = new long[n + 1];
		
		for (int i = 0; i <= n; i++) {
			if (i == 0)
				array[i] = 0;
			else if (i == 1)
				array[i] = 1;
			else
				array[i] = array[i - 1] + array[i - 2];
		}
		
		System.out.println(array[n]);
	}
	
	// O. 동적 계획법 1단계
	// 2. 피보나치 함수 - 1003 
	// Import Scanner
	private static void O02() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int[][] count = new int[41][2];
		
		count[0][0] = 1;
		count[1][1] = 1;
		
		for (int i = 2; i < 41; i++) {
			for (int j = 0; j < 2; j++) {
				count[i][j] = count[i-1][j] + count[i-2][j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			int num = s.nextInt();
			System.out.println(count[num][0] + " " + count[num][1]);
		}
	}
	
	// O. 동적 계획법 1단계
	// 3. 01타일 - 1904
	// Import Scanner
	private static void O03() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int[] array = new int[n + 1];

		array[1] = 1;
		if (n > 1)
			array[2] = 2;
				
		for (int i = 3; i <= n; i++) {
			array[i] = (array[i - 1] + array[i - 2]) % 15746;
		}
		
		System.out.println(array[n]);
	}
	
	// O. 동적 계획법 1단계
	// 4. 파도반 수열 - 9461 
	// Import Scanner
	private static void O04() {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for (int i = 0; i < T; i++) {
			int n = s.nextInt();
			
			long[] array = new long[n];
			
			array[0] = 1;
			if (n > 1)
				array[1] = 1;
			if (n > 2)
				array[2] = 1;
			if (n > 3)
				array[3] = 2;
			if (n > 4)
				array[4] = 2;

			for (int j = 5; j < n; j++) {
				array[j] = array[j - 1] + array[j - 5];
			}
			
			System.out.println(array[n - 1]);
		}
	}
	
	// O. 동적 계획법 1단계
	// 5. RGB거리 - 1149 
	// Import BufferedReader
	private static void O05() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] list = new int[n][3];
		int[][] cost = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			String[] RGB = br.readLine().split(" ");
			
			for (int j = 0; j < 3; j++)
				list[i][j] = Integer.parseInt(RGB[j]);
		}
		
		cost[0][0] = list[0][0];
		cost[0][1] = list[0][1];
		cost[0][2] = list[0][2];
		
		for (int i = 1; i < n; i++) {
			cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + list[i][0];
			cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + list[i][1];
			cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + list[i][2];
		}
		
		System.out.println(Math.min(Math.min(cost[n-1][0], cost[n-1][1]), cost[n-1][2]));
	}
	
	// O. 동적 계획법 1단계
	// 6. 정수 삼각형 - 1932 
	// Import Scanner
	private static void O06(){
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[][] array = new int[n + 1][n + 1];
		int max = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				array[i][j] = s.nextInt();
				if (j == 1) {
					array[i][j] = array[i][j] + array[i - 1][j];
				} else if (i == j) {
					array[i][j] = array[i][j] + array[i - 1][j - 1];
				} else {
					array[i][j] = array[i][j] + Math.max(array[i - 1][j], array[i - 1][j - 1]);
				}
				if (array[i][j] > max)
					max = array[i][j];
			}
		}
		
		System.out.println(max);
	}
	
	// O. 동적 계획법 1단계
	// 7. 계단 오르기 - 2579 
	// Import Scanner
	private static void O07() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int[] score = new int[n+1];
		int[] max = new int[n+1];
		int noJump = 0, jump = 0;
		
		for (int i = 1; i <= n; i++)
			score[i] = s.nextInt();
		
		max[1] = score[1];
		if (n > 1)
			max[2] = score[1] + score[2];
		
		for (int i = 3; i <= n; i++) {
			noJump = score[i] + score[i - 1] + max[i - 3];
			jump = score[i] + max[i - 2];
			
			max[i] = Math.max(noJump, jump);
		}
		
		System.out.println(max[n]);
	}
	
	// O. 동적 계획법 1단계
	// 8. 1로 만들기 - 1463 
	// Import Scanner
	private static void O08() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] count = new int[n + 1];
		
		count[0] = 0;
		count[1] = 0;
		for (int i = 2; i <= n; i++) {
			count[i] = count[i - 1] + 1;
			
			if (i % 2 == 0)
				count[i] = Math.min(count[i], count[i / 2] + 1);
			if (i % 3 == 0)
				count[i] = Math.min(count[i], count[i / 3] + 1);
		}
	
		
		System.out.println(count[n]);
	}
	
	// O. 동적 계획법 1단계
	// 9. 쉬운 계단 수 - 10844 
	// Import Scanner 
	private static void O09() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), mod = 1000000000;
		long sum = 0;
		long[][] count = new long[n + 1][10];
		
		count[1][0] = 0;
		for (int i = 1; i < 10; i++) {
			count[1][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					count[i][j] = count[i - 1][1];
				} else if (j == 9) {
					count[i][j] = count[i - 1][8];
				} else {
					count[i][j] = count[i - 1][j - 1] + count[i - 1][j + 1];
				}
				
				count[i][j] %= mod;
			}
			
		}
		
		for (int i = 0; i < 10; i++)
			sum += count[n][i];
		
		System.out.println(sum % mod);
	}
	
	// O. 동적 계획법 1단계
	// 10. 포도주 시식 - 2156 
	// Import Scanner
	private static void O10() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int[] score = new int[n+1];
		int[] max = new int[n+1];
		
		for (int i = 1; i <= n; i++)
			score[i] = s.nextInt();
		
		max[0] = 0;
		max[1] = score[1];
		if (n > 1)
			max[2] = score[1] + score[2];
		
		for (int i = 3; i <= n; i++) {
			max[i] = Math.max(max[i - 1], Math.max(max[i - 2] + score[i],  max[i - 3] + score[i - 1] + score[i]));
		}
		
		System.out.println(max[n]);
	}
	
	// O. 동적 계획법 1단계
	// 11. 가징 긴  증가하는 부분 수열 - 11053
	// Import Scanner
	private static void O11() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), max = 0;
		int[] number = new int[n + 1];
		int[] count = new int[n + 1];
		
		for (int i = 1; i <= n; i++)
			number[i] = s.nextInt();
		
		count[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			count[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (number[j] < number[i] && count[j] >= count[i])
					count[i] = count[j] + 1;
			}
		}
		
		for (int i = 1; i <= n; i++)
			if (count[i] > max)
				max = count[i];
		
		System.out.println(max);
	}
	
	// O. 동적 계획법 1단계 
	// 12. 가장 긴 바이토닉 부분 수열 - 11054 
	// Import Scanner
	private static void O12() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), max = 0;
		int[] number = new int[n + 1];
		int[][] count = new int[n + 1][2];
		
		for (int i = 1; i <= n; i++) {
			number[i] = s.nextInt();
		}
			
		
		count[1][0] = 1;
		count[n][1] = 1;
		
		for (int i = 2; i <= n; i++) {
			count[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				if (number[i] > number[j])
					count[i][0] = Math.max(count[i][0], count[j][0] + 1);
			}
		}
		
		for (int i = n - 1; i > 0; i--) {
			count[i][1] = 1;
			for (int j = n; j > i; j--) {
				if (number[i] > number[j])
					count[i][1] = Math.max(count[i][1], count[j][1] + 1);
			}
		}
		
		for (int i = 1; i <= n; i++)
			if (count[i][0] + count[i][1] - 1 > max)
				max = count[i][0] + count[i][1] - 1;
		
		System.out.println(max);
	}
	
	// O. 동적 계획법 1단계
	// 13. 전깃줄 - 2565 
	// Import Scanner
	private static void O13() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), max = 0;
		int[][] line = new int[n + 1][2];
		int[] count = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			line[i][0] = s.nextInt();
			line[i][1] = s.nextInt();
		}
		
		Arrays.sort(line, Comparator.comparingInt(o1 -> o1[0]));
		
		count[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			count[i] = 1;
			for (int j = 1; j <= n; j++) {
				if (line[i][1] > line[j][1]) {
					count[i] = Math.max(count[i], count[j] + 1);
				}
			}
		}
		
		for (int i = 1; i <= n; i++)
			if (count[i] > max)
				max = count[i];
		
		System.out.println(n - max);
	}
	
	// O. 동적 계획법 1단계
	// 14. LCS - 9251 ★
	// Import Scanner
	private static void O14() {
		Scanner s = new Scanner(System.in);
		
		String first = s.nextLine();
		String second = s.nextLine();
		
		int[][] count = new int[first.length() + 1][second.length() + 1];
		
		count[1][1] = 0;
		
		for (int i = 1; i <= first.length(); i++) {
			for (int j = 1; j <= second.length(); j++) {
				if (first.charAt(i - 1) != second.charAt(j - 1))
					count[i][j] = Math.max(count[i][j - 1], count[i - 1][j]);
				else
					count[i][j] = count[i - 1][j - 1] + 1;
			}
		}
		
		System.out.println(count[first.length()][second.length()]);
	}
	
	// O. 동적 계획법 1단계
	// 15. 연속합 - 1912 
	// Import Scanner
	private static void O15() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), max = Integer.MIN_VALUE;
		int[] array = new int[n + 1];
		int[] sum = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			array[i] = s.nextInt();
			sum[i] = Integer.MIN_VALUE;
		}
		
		sum[1] = array[1];
		
		for (int i = 1; i <= n; i++) {
			sum[i] = Math.max(array[i], sum[i - 1] + array[i]); 
		}
		
		
		for (int i = 1; i <= n; i++)
			if (sum[i] > max)
				max = sum[i];
		
		System.out.println(max);
	}
	
	// O. 동적 계획법 1단계
	// 16. 평범한 배낭 - 12865
	// Import Scanner
	private static void O16() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), k = s.nextInt();
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		int[][] value = new int[n + 1][k + 1];
		
		for (int i = 1; i <= n; i++) {
			w[i] = s.nextInt();
			v[i] = s.nextInt();
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				value[i][j] = value[i - 1][j];
				if (j - w[i] >= 0)
					value[i][j] = Math.max(value[i - 1][j], value[i - 1][j-w[i]] + v[i]);
			}
		}
		
		System.out.println(value[n][k]);
	}
	
	// N. 백트래킹
	// 1. N과 M (1) - 15649 
	// Import Scanner
	private static void N01() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), m = s.nextInt();
		
		ArrayList<Integer> array = new ArrayList<>();
		ArrayList<Integer> empty = new ArrayList<>();
		
		for (int i = 1; i <= n; i++)
			array.add(i);
		
		NandM1(array, empty, m);
	}
	
	private static void NandM1(ArrayList<Integer> array, ArrayList<Integer> pre, int m) {
		if (m == 1) {
			for (int i = 0; i < array.size(); i++) {
				for (int j = 0; j < pre.size(); j++) {
					System.out.print(pre.get(j) + " ");
				}
				System.out.println(array.get(i));
			}
		} else {
			for (int i = 0; i < array.size(); i++) {
				ArrayList<Integer> tmpArr = new ArrayList<>();
				ArrayList<Integer> tmpPre = new ArrayList<>();
				
				tmpArr.addAll(array);
				tmpPre.addAll(pre);
				tmpPre.add(tmpArr.get(i));
				tmpArr.remove(i);
				
				NandM1(tmpArr, tmpPre, m - 1);
			}
		}
	}
	
	// N. 백트래킹
	// 2. N과 M (2) - 15650 
	// Import Scanner
	private static void N02() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), m = s.nextInt();
		
		ArrayList<Integer> array = new ArrayList<>();
		ArrayList<Integer> empty = new ArrayList<>();
		
		for (int i = 1; i <= n; i++)
			array.add(i);
		
		NandM2(array, empty, m);
	}
	
	private static void NandM2(ArrayList<Integer> array, ArrayList<Integer> pre, int m) {
		if (pre.size() >= 2) {
			for (int i = 1; i < pre.size(); i++) {
				if (pre.get(i-1) > pre.get(i))
					return;		
			}
		}
		
		if (m == 1) {
			for (int i = 0; i < array.size(); i++) {
				boolean pass = false;
				for (int j = 0; j < pre.size(); j++) {
					if (array.get(i) < pre.get(j))
						pass = true;
				}
				
				if (!pass) {
					for (int j = 0; j < pre.size(); j++) {
						System.out.print(pre.get(j) + " ");
					}
					
					System.out.println(array.get(i));	
				}
			}
		} else {
			for (int i = 0; i < array.size(); i++) {
				ArrayList<Integer> tmpArr = new ArrayList<>();
				ArrayList<Integer> tmpPre = new ArrayList<>();
				
				tmpArr.addAll(array);
				tmpPre.addAll(pre);
				tmpPre.add(tmpArr.get(i));
				tmpArr.remove(i);
				
				NandM2(tmpArr, tmpPre, m - 1);
			}
		}
	}
	
	// N. 백트래킹
	// 3. N과 M (3) - 15651 
	// Import Scanner
	private static void N03() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), m = s.nextInt();
		
		ArrayList<Integer> array = new ArrayList<>();
		ArrayList<Integer> empty = new ArrayList<>();
		
		for (int i = 1; i <= n; i++)
			array.add(i);
		
		System.out.println(NandM3(array, empty, m));
	}
	
	private static StringBuilder NandM3(ArrayList<Integer> array, ArrayList<Integer> pre, int m) {
		StringBuilder sb = new StringBuilder();
		
		if (m == 1) {
			for (int i = 0; i < array.size(); i++) {
				for (int j = 0; j < pre.size(); j++) {
					sb.append(pre.get(j) + " ");
				}
				sb.append(array.get(i) + "\n");
			}
		} else {
			for (int i = 0; i < array.size(); i++) {
				ArrayList<Integer> tmpPre = new ArrayList<>();
				
				tmpPre.addAll(pre);
				tmpPre.add(array.get(i));
				
				sb.append(NandM3(array, tmpPre, m - 1));
			}
		}
		return sb;
	}
	
	// N. 백트래킹
	// 4. N과 M (4) - 15652 
	// Import Scanner
	private static void N04() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), m = s.nextInt();
		
		ArrayList<Integer> array = new ArrayList<>();
		ArrayList<Integer> empty = new ArrayList<>();
		
		for (int i = 1; i <= n; i++)
			array.add(i);
		
		System.out.println(NandM4(array, empty, m));
	}
	
	private static StringBuilder NandM4(ArrayList<Integer> array, ArrayList<Integer> pre, int m) {
		StringBuilder sb = new StringBuilder();
		
		if (pre.size() >= 2) {
			for (int i = 1; i < pre.size(); i++) {
				if (pre.get(i-1) > pre.get(i))
					return sb;		
			}
		}

		if (m == 1) {
			for (int i = 0; i < array.size(); i++) {
				boolean pass = false;
				for (int j = 0; j < pre.size(); j++) {
					if (array.get(i) < pre.get(j))
						pass = true;
				}
				
				if (!pass) {
					for (int j = 0; j < pre.size(); j++) {
						sb.append(pre.get(j) + " ");
					}
					
					sb.append(array.get(i) + "\n");	
				}
			}
		} else {
			for (int i = 0; i < array.size(); i++) {
				ArrayList<Integer> tmpPre = new ArrayList<>();
				
				tmpPre.addAll(pre);
				tmpPre.add(array.get(i));
				
				sb.append(NandM4(array, tmpPre, m - 1));
			}
		}

		return sb;
	}
	
	// N. 백트래킹
	// 5. N-Queen - 9663 ★
	// Import Scanner
	private static int queenCount = 0, queenN;
	private static int[] queenCol;
	
	private static void N05() {
		Scanner s = new Scanner(System.in);
		
		queenN = s.nextInt();
		
		for (int i = 1; i <= queenN; i++) {
			queenCol = new int[15];
			queenCol[1] = i;
	        // 정점은 행을 기준. (i = 1) => 1행(1열), (i = 2) => 2행(1열), (i = 3) => 3행(1열) 
	        checkQueen(1);
	    }

		System.out.println(queenCount);
	}
	
	private static void checkQueen(int row) {
		if (row == queenN) {
	        ++queenCount;
	    } else {
	        for (int i = 1; i <= queenN; i++) {
	        	queenCol[row + 1] = i;
	            if (isPossible(row + 1)) {
	            	checkQueen(row + 1);
	            } else {
	            	queenCol[row + 1] = 0;    
	            }
	        }
	    }
		queenCol[row] = 0;
	}

	public static boolean isPossible(int c) {
	    for (int i = 1; i < c; i++) {
	        // 같은 행, 열
	        if (queenCol[i] == queenCol[c]) {
	            return false;
	        }
	        // 대각선
	        if (Math.abs(queenCol[i] - queenCol[c]) == Math.abs(i - c)) {
	            return false;
	        }
	    }
	    return true;
	}
		
	// N. 백트래킹
	// 6. 스도쿠 - 2580 
	// Import BufferedReader
	private static int[][] sdoku = new int[9][9];
	private static ArrayList<int[]> emptySdoku = new ArrayList<>();
	
	private static void N06() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = Integer.parseInt(split[j]);
				if (sdoku[i][j] == 0) {
					emptySdoku.add(new int[] {i, j});
				}
			}	
		}
		solveSdoku(0);
	}
	
	private static void solveSdoku(int index) {
		if (index == emptySdoku.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sdoku[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		for (int i = 1; i <= 9; i++) {
			if (checkSdokuRow(index, i) && checkSdokuCol(index, i) && checkSdokuBox(index, i)) {
				sdoku[emptySdoku.get(index)[0]][emptySdoku.get(index)[1]] = i;
				solveSdoku(index + 1);
			}
			if (i == 9)
				sdoku[emptySdoku.get(index)[0]][emptySdoku.get(index)[1]] = 0;
		}
	}
	
	private static boolean checkSdokuRow(int index, int num) {
		for (int i = 0; i < 9; i++) {
			if (emptySdoku.get(index)[1] == i)
				continue;
			if (sdoku[emptySdoku.get(index)[0]][i] == num)
				return false;
		}
		return true;
	}
	
	private static boolean checkSdokuCol(int index, int num) {
		for (int i = 0; i < 9; i++) {
			if (emptySdoku.get(index)[0] == i)
				continue;
			if (sdoku[i][emptySdoku.get(index)[1]] == num)
				return false;
		}
		return true;
	}

	private static boolean checkSdokuBox(int index, int num) {
		int xBox = emptySdoku.get(index)[0] / 3;
		int yBox = emptySdoku.get(index)[1] / 3;
		xBox *= 3;
		yBox *= 3;
		
		for (int i = xBox; i < xBox + 3; i++) {
			for (int j = yBox; j < yBox + 3; j++) {
				if (emptySdoku.get(index)[0] == i && emptySdoku.get(index)[1] == j)
					continue;
				if (sdoku[i][j] != 0 && sdoku[i][j] == num)
					return false;
			}
		}
		
		return true;
	}
	
	// N. 백트래킹
	// 7. 연산자 끼워넣기 - 14888 
	// Import BufferedReader
	private static int n07Count, n07Max = Integer.MIN_VALUE, n07Min = Integer.MAX_VALUE;
	private static int[] n07Array;
	
	private static void N07() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n07Count = Integer.parseInt(br.readLine());
		n07Array = new int[n07Count];
		
		String[] tmpNum = br.readLine().split(" ");
		
		for (int i = 0; i < n07Count; i++)
			n07Array[i] = Integer.parseInt(tmpNum[i]);
		
		String[] tmpOperator = br.readLine().split(" ");
		int[] operator = {0, 0, 0, 0};
		
		
		for (int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(tmpOperator[i]);
		
		checkOperator(1, n07Array[0], operator);
		
		System.out.println(n07Max);
		System.out.println(n07Min);
	}
	
	private static void checkOperator(int index, int sum, int[] operator) {
		if (index == n07Count) {
			if (n07Max < sum)
				n07Max = sum;
			if (n07Min > sum)
				n07Min = sum;
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operator[i] != 0) {
				int[] tmpOperator = operator.clone();
				tmpOperator[i]--;
				
				int tmpSum = sum;
				
				if (i == 0) {
					tmpSum += n07Array[index];
				} else if (i == 1) {
					tmpSum -= n07Array[index];
				} else if (i == 2) {
					tmpSum *= n07Array[index];
				} else if (i == 3) {
					tmpSum /= n07Array[index];
				}
				
				checkOperator(index + 1, tmpSum, tmpOperator);
			}
		}
	}
	
	// N. 백트래킹
	// 8. 스타트와 링크 - 14889 
	// Import BufferedReader
	private static int[][] n08Array;
	private static int n08Score = Integer.MAX_VALUE, n08Count;
	private static boolean[] n08Check;
	
	private static void N08() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n08Count = Integer.parseInt(br.readLine());
		
		n08Array = new int[n08Count][n08Count];
		
		for (int i = 0; i < n08Count; i++) {
			String[] tmpScore = br.readLine().split(" ");
			
			for (int j = 0; j < n08Count; j++)
				n08Array[i][j] = Integer.parseInt(tmpScore[j]);
		}
		
		n08Check = new boolean[n08Count];
		
		makeTeam(0, 0);
		
		System.out.println(n08Score);
	}
	
	private static void makeTeam(int v, int n) {
		if (n == n08Count / 2) {
			getScore();
			return;
		}
		
		for (int i = v; i < n08Count; i++) {
			if (n08Check[i])
				continue;
			
			n08Check[i] = true;
			makeTeam(i, n + 1);
			n08Check[i] = false;
		}
	}
	
	private static void getScore() {
		int[] a = new int[n08Count / 2];
		int[] b = new int[n08Count / 2];
		int aIndex = 0, bIndex = 0;
		
		for (int i = 0; i < n08Count; i++) {
			if (n08Check[i])
				a[aIndex++] = i;
			else
				b[bIndex++] = i;
		}
		
		int aState = getState(a);
		int bState = getState(b);
		int gap = Math.abs(aState - bState);
		n08Score = Math.min(gap, n08Score);
	}
	
	private static int getState(int[] array) {
		int result = 0;
		for (int i = 0; i < n08Count / 2; i++) {
			for (int j = 0; j < n08Count / 2; j++) {
				result += n08Array[array[i]][array[j]];
				result += n08Array[array[j]][array[i]];
			}
		}
		
		return result / 2;
	}
	
	// M. 정렬
	// 1. 수 정렬하기 - 2750 
	// Import BufferedReader
	private static void M01() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int array[] = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		for (int i = 0; i < n; i++) {
			System.out.println(array[i]);
		}
	}
	
	// M. 정렬
	// 2. 수 정렬하기 2 - 2751
	// Import BufferedReader
	private static void M02() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			array.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(array);
		
		for (int i = 0; i < n; i++) {
			System.out.println(array.get(i));
		}
	}
	
	private static void quickSort(int[] data, int start, int end) {
		if (start >= end)
			return;
		
		int key = start, i = start + 1, j = end, tmp;
		
		while(i <= j) {
			while(i <= end && data[i] <= data[key])
				i++;
			
			while(j > start && data[j] >= data[key])
				j--;
			
			if (i > j) {
				tmp = data[j];
				data[j] = data[key];
				data[key] = tmp;
			} else {
				tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
			}
		}
		
		quickSort(data, start, j - 1);
		quickSort(data, j + 1, end);
	}

	
	// M. 정렬
	// 3. 수 정렬하기  3 - 10989 
	// Import BufferedReader 
	private static void M03() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int array[] = new int[n], newArray[] = new int [n];
		int count[] = new int[10000];
		
		for (int i = 0; i < 10000; i++)
			count[i] = 0;
		
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
			count[array[i] - 1]++;
		}
		
		for (int i = 1; i < 10000; i++)
			count[i] = count[i] + count[i - 1];
		
		for (int i = 0; i < n; i++) {
			newArray[count[array[i] - 1] - 1] = array[i];
			count[array[i] - 1]--;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < n; i++)
			bw.write(newArray[i] + "\n");
		
		bw.close();
	}
	
	// M. 정렬
	// 4. 통계학 - 2108 
	// Import BufferedReader
	private static void M04() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0, min = 4000, max = -4000, fre = 0;
		boolean dup = false;
		int count[] = new int[8001], array[] = new int[n];
		
		for (int i = 0; i < 8001; i++)
			count[i] = 0;
		
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
			count[array[i] + 4000]++;
			
			if (count[array[i] + 4000] > fre) {
				fre = count[array[i] + 4000];
				dup = false;
			} else if (count[array[i] + 4000] == fre) {
				dup = true;
			}
			
			if (array[i] > max)
				max = array[i];
			
			if (array[i] < min)
				min = array[i];
			
			sum += array[i];
		}
			
		Arrays.sort(array);
		
		System.out.println(Math.round((double)sum / n));
		System.out.println(array[n / 2]);
		for (int i = 0; i < 8001; i++) {
			if (dup && count[i] == fre) {
				dup = false;
			} else if (!dup && count[i] == fre) {
				System.out.println(i - 4000);
				break;
			}
		}
		if (min == max)
			System.out.println(0);
		else
			if (max >= 0 && min >= 0) {
				System.out.println(max - min);
			} else if (max >= 0 && min < 0) {
				System.out.println(max + Math.abs(min));
			} else if (max < 0 && min < 0) {
				System.out.println(max - min);
			}
	}
	
	// M. 정렬
	// 5. 소트인사이드 - 1427 
	// Import Scanner
	private static void M05() {
		Scanner s = new Scanner(System.in);
		
		String num = s.nextLine();
		int numArray[] = new int[num.length()];
		
		for (int i = 0; i < num.length(); i++)
			numArray[i] = num.charAt(i) - 48;
		
		Arrays.sort(numArray);
		
		for (int i = numArray.length - 1; i >= 0; i--)
			System.out.print(numArray[i]);
	}
	
	// M. 정렬
	// 6. 좌표 정렬하기 - 11650 
	// Import BufferedReader
	private static void M06() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] array = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
					
			array[i][0] = Integer.parseInt(tmp[0]);
			array[i][1] = Integer.parseInt(tmp[1]);
		}
		
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				else
					return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(array[i][0] + " " + array[i][1]);
		}
	}
	
	// M. 정렬
	// 7. 좌표 정렬하기 2 - 11651 
	// Import BufferedReader
	private static void M07() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] array = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
					
			array[i][0] = Integer.parseInt(tmp[0]);
			array[i][1] = Integer.parseInt(tmp[1]);
		}
		
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return Integer.compare(o1[0], o2[0]);
				else
					return Integer.compare(o1[1], o2[1]);
			}
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(array[i][0] + " " + array[i][1]);
		}
	}
	
	// M. 정렬
	// 8. 단어 정렬 - 1181 
	// Import BufferedReader
	private static void M08() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] array = new String[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = br.readLine();
		}
		
		Arrays.sort(array);
		
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		for (int i = 0; i < n; i++)
			if (i == 0)
				System.out.println(array[i]);
			else if (!array[i-1].equals(array[i]))
				System.out.println(array[i]);
	}
	
	// M. 정렬
	// 9. 나이순 정렬 - 10814 
	// Import 
	private static void M09() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[][] array = new String[n][2];
		
		for (int i = 0; i < n; i++) {
			array[i] = br.readLine().split(" ");
		}
		
		Arrays.sort(array, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.compare(Integer.parseInt(s1[0]), Integer.parseInt(s2[0]));
			}
		});
		
		for (int i = 0; i < n; i++)
			System.out.println(array[i][0] + " " + array[i][1]);
	}
	
	// L. 브루트 포스
	// 1. 블랙잭 - 2798 
	// Import BuffuredReader
	private static void L01() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String firstLine = br.readLine();
		String[] firstSplit = firstLine.split(" ");
		int n = Integer.parseInt(firstSplit[0]);
		int count = Integer.parseInt(firstSplit[1]);
		
		String secondLine = br.readLine();
		String[] secondSplit = secondLine.split(" ");
		
		int max = 0, tmp;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (i != j && i != k && j != k) {
						tmp = Integer.parseInt(secondSplit[i]) + Integer.parseInt(secondSplit[j]) + Integer.parseInt(secondSplit[k]);
						
						if (tmp == count) {
							System.out.println(tmp);
							return;
						} else if (tmp < count && tmp > max) {
							max = tmp;
						}
					}
				}				
			}
		}
		System.out.println(max);
	}
	
	// L. 브루트 포스
	// 2. 분해합 - 2231 
	// Import Scanner
	private static void L02() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), m, length = (int)(Math.log10(n) + 1);
		
		m = n - length * 9;
		
		for (int i = m; i <= n; i++) {
			int sum = i, tmp = i;
			if (i == n) {
				System.out.println(0);
				break;
			}
			
			while(tmp > 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			
			if (sum == n) {
				System.out.println(i);
				return;
			}
		}
	}
	
	// L. 브루트 포스
	// 3. 덩치 - 7568 
	// Import Scanner
	private static void L03() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int grade[][] = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			grade[i][0] = s.nextInt();
			grade[i][1] = s.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			int rank = 1;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (grade[i][0] < grade[j][0] && grade[i][1] < grade[j][1])
						rank++;
				}
			}
			System.out.print(rank + " ");
		}
	}
	
	// L. 브루트 포스
	// 4. 체스판 다싯 칠하기 - 1018 
	// Import BufferedReader
	private static void L04() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String firstLine = br.readLine();
		String[] firstSplit = firstLine.split(" ");
		int h = Integer.parseInt(firstSplit[0]);
		int w = Integer.parseInt(firstSplit[1]);
		
		String chess[] = new String[h];
		
		for (int i = 0; i < h; i++) {
			chess[i] = br.readLine();
		}
		
		int checkH = h - 7;
		int checkW = w - 7;
		int fixCount = 64;
			
		for (int i = 0; i < checkH; i++) {
			for (int j = 0; j < checkW; j++) {
				char B = 'B';
				char W = 'W';
				int bCount = 0, wCount = 0, tmpCount;
				
				for (int m = 0; m < 8; m++) {
					for (int n = 0; n < 8; n++) {
						if ((m % 2 == 0 && n % 2 == 0) || (m % 2 == 1 && n % 2 == 1)) {
							if (chess[i + m].charAt(j + n) != B) {
								bCount++;
							}
							if (chess[i + m].charAt(j + n) != W) {
								wCount++;
							}
						} else {
							if (chess[i + m].charAt(j + n) == B) {
								bCount++;
							}
							if (chess[i + m].charAt(j + n) == W) {
								wCount++;
							}
						}
					}
				}
				
				tmpCount = Math.min(bCount, wCount);
				
				if (tmpCount < fixCount)
					fixCount = tmpCount;
				
				if (fixCount == 0)
					break;
			}
		}
		System.out.println(fixCount);
	}
	
	// L. 브루트 포스
	// 5. 영화감독 숌 - 1436 
	// Import Scanner
	private static void L05() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), count = 0, i = 1;
		String title = "";
		
		while(count < n) {
			String tmpTitle = i++ + "";
			if (tmpTitle.contains("666")) {
				count++;
				title = tmpTitle;
			}
		}
		
		System.out.println(title);
	}
	
	// K. 재귀
	// 1. 팩토리얼 - 10872 
	// Import Scanner
	private static void K01() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		System.out.println(factorial(n));
	}
	
	private static long factorial(long n) {
		if (n == 0)
			return 1;
		else
			return n * (factorial(n - 1));
	}
	
	// K. 재귀
	// 2. 피보나치 수 5 - 10870 
	// Import Scanner
	private static void K02() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		System.out.println(fibonacci(n));
	}
	
	private static int fibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	// K. 재귀
	// 3. 별찍기 - 10 - 2447 ☆
	// Import Scanner
	static char[][] starArray;
	
	private static void K03() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), k = 0, tmp;
		
		starArray = new char[n][n];
		
		drawBlankStar(0, 0, n, false);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(starArray[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	
	private static void drawBlankStar(int x, int y, int n, boolean blank) {
		if (blank) {
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++)
					starArray[i][j] = ' ';
			}
		} else if (n == 1) {
			starArray[x][y] = '*';
		} else {
			int smallN = n / 3;
			int count = 0;
			for (int i = x; i < x + n; i += smallN) {
				for (int j = y; j < y + n; j += smallN) {
					count++;
					if (count == 5) {
						drawBlankStar(i, j, smallN, true);
					} else {
						drawBlankStar(i, j, smallN, false);
					}
				}
			}
		}
	}
	
	// K. 재귀
	// 4. 하노이 탑 이동 순서 - 11729 
	// Import Scanner
	private static int hanoiCount = 0;
	private static StringBuilder hanoiString = new StringBuilder();
	
	private static void K04() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		hanoi(n, 1, 3, 2);
		
		System.out.println(hanoiCount);
		System.out.println(hanoiString);
	}
	
	private static void hanoi(int n, int from, int to, int sub) {
		if (n == 1) {
			hanoiCount++;
			hanoiString.append(from + " " + to + "\n");
		} else {
			hanoi(n - 1, from, sub, to);
			hanoiCount++;
			hanoiString.append(from + " " + to + "\n");
			hanoi(n - 1, sub, to, from);
		}
	}
	
	// J. 수학 2
	// 1. 소수 찾기 - 1978 
	// Import Scanner
	private static void J01() {
		Scanner s = new Scanner(System.in);
		
		int T, n, count = 0;
		boolean divided = false;
		T = s.nextInt();
		
		for (int i = 0; i < T; i++) {
			n = s.nextInt();
			for (int j = 2; j < n; j++) {
				if (n % j == 0)
					divided = true;
			}
			if (!divided && n != 1)
				count++;
			else
				divided = false;
		}
		System.out.println(count);
	}
	
	// J. 수학 2
	// 2. 소수 -  2581
	// Import Scanner
	private static void J02() {
		Scanner s = new Scanner(System.in);
		
		int start, end, sum = 0, min = 0;
		boolean divided = false;
		start = s.nextInt();
		end = s.nextInt();
		
		for (int i = start; i <= end; i++) {
			
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					divided = true;
					break;
				}
			}
			if (!divided && i != 1) {
				if (min == 0)
					min = i;
				sum += i;
			} else {
				divided = false;
			}
		}
		if (min == 0) {
			System.out.println("-1");	
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	
	// J. 수학 2
	// 3. 소수 구하기 - 1929 
	// Import Scanner
	private static void J03() {
		Scanner s = new Scanner(System.in);
		
		int start, end;
		start = s.nextInt();
		end = s.nextInt();
		
		boolean array[] = new boolean[end + 1];
		array[1] = true;
		
		for (int i = 2; i <= end; i++) {
			for (int j = 2; i * j <= end; j++) {
				array[i * j] = true;
			}
		}
		
		for (int i = start; i <= end; i++) {
			if (!array[i])
				System.out.println(i);
		}
	}
	
	// J. 수학 2
	// 4. 베르트랑 공준 - 4948 
	// Import  
	private static void J04() {
		Scanner s = new Scanner(System.in);
		
		int start, end, count = 0;

		while(true) {
			start = s.nextInt();
			
			if (start == 0) {
				break;
			} else {
				end = 2 * start;
				count = 0;
			}
			
			boolean array[] = new boolean[end + 1];
			
			for (int i = 2; i <= end; i++) {
				for (int j = 2; i * j <= end; j++) {
					array[i * j] = true;
				}
			}
			
			for (int i = start + 1; i <= end; i++) {
				if (!array[i])
					count++;
			}
			System.out.println(count);
		}
	}
	
	// J. 수학 2
	// 5. 골드바흐의 추측 - 9020 
	// Import Scanner
	private static void J05() {
		Scanner s = new Scanner(System.in);
		
		int T, n, first, second;
		T = s.nextInt();
		
		for (int i = 0; i < T; i++) {
			n = s.nextInt();
			
			if (n == 0) {
				break;
			} else {
				first = 0;
				second = n;
			}
			
			boolean array[] = new boolean[n + 1];
			array[1] = true;
			ArrayList<Integer> prime = new ArrayList<>();
			
			for (int j = 2; j <= n; j++) {
				for (int k = 2; j * k <= n; k++) {
					array[j * k] = true;
				}
			}
			
			for (int j = 2; j <= n; j++) {
				if (!array[j]) {
					prime.add(j);
				}
					
			}
			
			for (int j = 0; j < prime.size(); j++) {
				for (int k = 0; k < prime.size(); k++) {
					if (prime.get(j) + prime.get(k) > n) {
						break;
					} else if (prime.get(j) + prime.get(k) == n &&
							prime.get(j) - prime.get(k) < second - first) {
						first = prime.get(j);
						second = prime.get(k);
					}
				}
			}
			
			System.out.println(first + " " + second);
		}
	}
	
	// J. 수학 2
	// 6. 직사각형에서 탈출 - 1085 
	// Import Scanner
	private static void J06() {
		Scanner s = new Scanner(System.in);
		
		int x, y, w, h, xp, yp, result = 1000;
		x = s.nextInt();
		y = s.nextInt();
		w = s.nextInt();
		h = s.nextInt();
		
		xp = w - x;
		yp = h - y;
		
		result = x;
		
		if (xp < result)
			result = xp;
		if (y < result)
			result = y;
		if (yp < result)
			result = yp;
		
		System.out.println(result);
	}
	
	// J. 수학 2
	// 7. 네 번째 점 - 3009 
	// Import Scanner
	private static void J07() {
		Scanner s = new Scanner(System.in);
		
		int x1, y1, x2, y2, x3, y3, resultX = 0, resultY = 0;
		
		x1 = s.nextInt();
		y1 = s.nextInt();
		x2 = s.nextInt();
		y2 = s.nextInt();
		x3 = s.nextInt();
		y3 = s.nextInt();
		
		if (x1 == x2)
			resultX = x3;
		else if (x1 == x3)
			resultX = x2;
		else
			resultX = x1;
		
		if (y1 == y2)
			resultY = y3;
		else if (y1 == y3)
			resultY = y2;
		else
			resultY = y1;
		
		System.out.println(resultX + " " + resultY);
	}
	
	// J. 수학 2
	// 8. 직각삼각형 - 4153 
	// Import Scanner
	private static void J08() {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			int a, b, c;
			boolean right = false;
			a = s.nextInt();
			b = s.nextInt();
			c = s.nextInt();
			
			if (a == 0 && b == 0 && c == 0)
				break;

			a = (int) Math.pow(a, 2);
			b = (int) Math.pow(b, 2);
			c = (int) Math.pow(c, 2);
			
			if (a > b) {	
				if (a > c) {
					if (a == b + c)
						right = true;
				} else {
					if (c == a + b)
						right = true;
				}
			} else {
				if (b > c) {
					if (b == a + c)
						right = true;
				} else {
					if (c == a + b)
						right = true;
				}
			}
			
			if (right)
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}
	
	// J. 수학 2
	// 9. 택시 기하학 - 3053 
	// Import Scanner
	private static void J09() {
		Scanner s = new Scanner(System.in);
		
		int r = s.nextInt();
		
		System.out.printf("%.6f\n", Math.pow(r, 2) *  Math.PI);
		System.out.printf("%.6f\n", Math.pow(r, 2) * 2.0);
	}
	
	// J. 수학 2
	// 10. 터렛 - 1002 
	// Import Scanner
	private static void J10() {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for (int i = 0; i < T; i++) {
			int x1, y1, r1, x2, y2, r2;
			double d;
			
			x1 = s.nextInt();
			y1 = s.nextInt();
			r1 = s.nextInt();
			x2 = s.nextInt();
			y2 = s.nextInt();
			r2 = s.nextInt();
			
			d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
			
			if (x1 == x2 && y1 == y2 && r1 == r2)
				System.out.println(-1);
			else if ((x1 == x2 && y1 == y2 && r1 != r2) || d > r1 + r2 || d < Math.abs(r1-r2))
				System.out.println(0);
			else if ( d == r1 + r2 || d == Math.abs(r1-r2))
				System.out.println(1);
			else
				System.out.println(2);
		}
	} 
	
	// I. 수학 1
	// 1. 손익분기점 - 1712 
	// Import Scanner
	private static void I01() {
		Scanner s = new Scanner(System.in);
		
		long a, b, c, count = 0;
		a = s.nextInt();
		b = s.nextInt();
		c = s.nextInt();
		
		if (b < c)
			while(true) {
				count++;
				if (a < (c-b) * count)
					break;
			}
		else
			count = -1;
		
		System.out.println(count);
	}
	
	// I. 수학 1
	// 2. 설탕 배달 - 2839
	// Import Scanner
	private static void I02() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), count = 0, min = n, tmp;
		boolean able = false;
		
		for (int i = 0; i <= n/5; i++) {
			count = 0;
			tmp = n - (i * 5);
			count += i;
			
			if (tmp % 3 == 0) {
				count += tmp / 3;
				able = true;
			}
			
			
			if (able) {
				if (count < min)
					min = count;
				able = false;
			}
		}
		
		if (min == n)
			min = -1;
		
		System.out.println(min);
	}
	
	// I. 수학 1
	// 3. 벌집 - 2292  
	// Import 
	private static void I03() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), count = 0;
		
		while (n > 0) {
			count++;
			if (count == 1)
				n -= 1;
			else
				n -= 6 * (count-1);
		}

		System.out.println(count);
	}
	
	// I. 수학 1
	// 4. 분수찾기 - 1193  
	// Import Scanner
	private static void I04() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), first, last, count = 1;
		
		while(n > 0) {
			n -= count;
			count++;
		}
		
		n += count - 1;
		count--;
		
		if (count % 2 == 1) {
			first = count - n + 1;
			last = n;	
		} else {
			first = n;
			last = count - n + 1;
		}
		
		
		System.out.println(first+"/"+last);
	}
	
	// I. 수학 1
	// 5. 달팽이는 올라가고 싶다  - 2869
	// Import Scanner
	private static void I05() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a, b, v, present = 0, day = 1, dis;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken()) - b;
		
		dis = a - b;
		
		day = v / dis;
		
		if ((v) % dis != 0)
			day++;
		
		System.out.println(day);
	}
	
	// I. 수학 1
	// 6. ACM 호텔 - 10250  
	// Import Scanner
	private static void I06() {
		Scanner s = new Scanner(System.in);
		
		int time, h, w, n, guestH, guestW;
		time = s.nextInt();
		for (int i = 0; i < time; i++) {
			h = s.nextInt();
			w = s.nextInt();
			n = s.nextInt();
			
			if (n % h != 0) {
				guestW = n / h + 1;
				guestH = n % h;	
			} else {
				guestW = n / h;
				guestH = h;
			}
						
			System.out.println(guestH*100+guestW);
		}
	}
	
	// I. 수학 1
	// 7. 부녀회장이 될테야 - 2775
	// Import Scanner
	private static void I07() {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for (int i = 0; i < T; i++) {
			int k, n;
			k = s.nextInt();
			n = s.nextInt();
			
			System.out.println(home(k, n));
		}
	}
	
	private static int home(int k, int n) {
		if (k == 0)
			return n;
		else if (n == 0)
			return 0;
		else
			return home(k-1, n) + home(k, n-1);
	}
	
	// I. 수학 1
	// 8. Fly me to the Alpha Centauri  
	// Import 
	private static void I08() {
		Scanner s = new Scanner(System.in);
		
		int T, start, end, dis, v;
		
		T = s.nextInt();
		
		for (int i = 0; i < T; i++) {
			v = 1;
			
			start = s.nextInt();
			end = s.nextInt();
			
			dis = end - start;
			int square = (int)Math.sqrt(dis-1);
			
			if (dis == 1) {
				v = 1;
			} else {
				if (dis-1 < square * square + square) {
					v = 2 * square;
				} else {
					v = 2 * square + 1;
				}
			}
			
			System.out.println(v);
		}
	}
	
	// H. 문자열
	// 1. 아스키 코드 - 11654 
	// Import Scanner
	private static void H01() {
		Scanner s = new Scanner(System.in);
		
		String num = s.nextLine();		
		
		System.out.println(num.charAt(0)+0);
	}
	
	// H. 문자열
	// 2. 숫자의 합 - 11720
	// Import Scanner
	private static void H02() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), sum = 0;
		String numbers = s.nextLine();
		numbers = s.nextLine();
		
		for (int i = 0; i < n; i++) {
			sum += numbers.charAt(i) - 48;
		}
		
		System.out.println(sum);
	}
	
	// H. 문자열
	// 3. 알파벳 찾기 - 10809 
	// Import Scanner
	private static void H03() {
		Scanner s = new Scanner(System.in);
		
		String word = s.nextLine();
		int index[] = new int[26];
		
		for (int i = 0; i < 26; i++)
			index[i] = -1;
		
		for (int i = 0; i < word.length(); i++) {
			if (index[word.charAt(i)-97] == -1)
				index[word.charAt(i)-97] = i;
		}
		
		for (int i = 0; i < 26; i++) {
			System.out.print(index[i] + " ");
		}
	}
	
	// H. 문자열
	// 4. 문자열 반복 - 2675 
	// Import Scanner
	private static void H04() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), time = 0;
		String word = s.nextLine();
		String repeat;
		
		
		for (int i = 0; i < n; i++) {
			repeat = "";
			word = s.nextLine();
			
			String[] split = word.split(" ");
			
			time = split[0].charAt(0) - 48;
			
			for (int j = 0; j < split[1].length(); j++) {
				for (int k = 0; k < time; k++)
					repeat += split[1].charAt(j);
			}
			
			System.out.println(repeat);
		}
	}
	
	// H. 문자열
	// 5. 단어 공부 - 1157 
	// Import Scanner
	private static void H05() {
		Scanner s = new Scanner(System.in);
		
		String word = s.nextLine();
		int index[] = new int[26], count = 0, max = -1;
		boolean duplicate = false;
		
		for (int i = 0; i < 26; i++)
			index[i] = 0;
		
		word = word.toLowerCase();
		
		for (int i = 0; i < word.length(); i++) {
			index[word.charAt(i)-97]++;
		}
		
		for (int i = 0; i < 26; i++) {
			if (index[i] == count) {
				duplicate = true;
			} else if (index[i] > count) {
				count = index[i];
				max = i;
				duplicate = false;
			}
		}
		
		if (duplicate) {
			System.out.println("?");			
		} else {
			System.out.println((char)(max+65));
		}
	}
	
	// H. 문자열
	// 6. 단어의 개수 - 1152 
	// Import Scanner
	private static void H06() {
		Scanner s = new Scanner(System.in);
		
		String word = s.nextLine().trim();
		
		if (word.isEmpty()) {
			System.out.println(0);			
		} else {
			String[] split = word.split(" ");
			
			int count = split.length;
			
			System.out.println(count);			
		}
	}
	
	// H. 문자열
	// 7. 상수 - 2908
	// Import Scanner
	private static void H07() {
		Scanner s = new Scanner(System.in);
		
		int a, b, newA, newB, max;
		a = s.nextInt();
		b = s.nextInt();
		
		newA = (a % 10) * 100 + (a % 100 / 10) * 10 + (a / 100);
		newB = (b % 10) * 100 + (b % 100 / 10) * 10 + (b / 100);
		
		if (newA > newB) {
			System.out.println(newA);
		} else {
			System.out.println(newB);
		}
	}
	
	// H. 문자열
	// 8. 다이얼 - 5622 
	// Import Scanner
	private static void H08() {
		Scanner s = new Scanner(System.in);
		
		String word = s.nextLine().toUpperCase();
		char[][] alphabet ={
				{'A', 'B', 'C'}, {'D', 'E', 'F'},
				{'G', 'H', 'I'}, {'J', 'K', 'L'},
				{'M', 'N', 'O'}, {'P', 'Q', 'R', 'S'},
				{'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}
		};
		int time = 0;
		
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < alphabet[j].length; k++) {
					if (word.charAt(i) == alphabet[j][k]) {
						time += j + 3;
						break;
					}
				}
			}
		}
		
		System.out.println(time);
	}
	
	// H. 문자열
	// 9. 크로아티아 알파벳 - 2941 
	// Import Scanner
	private static void H09() {
		Scanner s = new Scanner(System.in);
		
		String word = s.nextLine();
		int count = 0, i = 0;
		
		while(i + 1 < word.length()) {
			count++;
			if (
					(word.charAt(i) == 'c' && word.charAt(i+1) == '=') ||
					(word.charAt(i) == 'c' && word.charAt(i+1) == '-') ||
					(word.charAt(i) == 'd' && word.charAt(i+1) == '-') ||
					(word.charAt(i) == 'l' && word.charAt(i+1) == 'j') ||
					(word.charAt(i) == 'n' && word.charAt(i+1) == 'j') ||
					(word.charAt(i) == 's' && word.charAt(i+1) == '=') ||
					(word.charAt(i) == 'z' && word.charAt(i+1) == '=')
				) {
				i++;
			} else if (word.charAt(i) == 'd' && word.charAt(i+1) == 'z') {
				if (i + 2 != word.length() && word.charAt(i+2) == '=')
					i += 2;
			}
			i++;
		}
		if (i + 1 == word.length())
			count++;
		
		System.out.println(count);
	}
	
	// H. 문자열
	// 10. 그룹 단어 체커 - 1316 
	// Import Scanner
	private static void H10() {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(), count = 0;
		String word = s.nextLine();
		char pre = 0;
		boolean group = true;
		
		int[] alphabet = new int[26];

		for (int i = 0; i < n; i++) {
			clearAlphabet(alphabet);
			word = s.nextLine();
			for (int j = 0; j < word.length(); j++) {
				if (j == 0) {
					pre = word.charAt(j);
					alphabet[word.charAt(j)-97]++;
				} else if (pre == word.charAt(j)) {
					
				} else if (pre != word.charAt(j) && checkDuplicate(alphabet, word.charAt(j))) {
					group = false;
					break;
				} else {
					pre = word.charAt(j);
					alphabet[word.charAt(j)-97]++; 
				}
			}
			if (group)
				count++;
			
			pre = 0;
			group = true;
		}
		System.out.println(count);
	}
	
	private static void clearAlphabet(int[] alphabet) {
		for (int i = 0; i < 26; i++)
			alphabet[i] = 0;
	}
	
	private static boolean checkDuplicate(int[] alphabet, char character) {
		for (int i = 0; i < 26; i++) {
			if (alphabet[character-97] != 0)
				return true;
		}
		return false;
	}
	
	// G. 함수
	// 1. 정수 N개의 합 - 15596 
	// Import 
	private static void G01() {
		int[] num = {0, 0};
		sumG01(num);
	}
	
	private static long sumG01(int[] a) {
        long ans = 0;
        
        for (int i = 0; i < a.length; i++) {
            ans += a[i];
        }
        
        return ans;
    }
	
	// G. 함수
	// 2. 셀프 넘버 - 4673 
	// Import 
	private static void G02() {
		int num = 1, tmp = 0;;
		
		int result[] = new int[10000];
		
		while(num < 10000) {
			tmp = sumG02(num);
			
			if (tmp < 10000) {
				result[tmp-1] = 1;	
			}
			
			num++;
		}
		num = 0;
		while(num < 9999) {
			if (result[num] != 1)
				System.out.println(num+1);
			num++;
		}
	}
	
	private static int sumG02(int num) {
		return num + (num / 1000) + (num % 1000) / 100 + (num % 100) / 10 + (num % 10);
	}
	
	// G. 함수
	// 3. 한수 - 1065 
	// Import Scanner
	private static void G03() {
		Scanner s = new Scanner(System.in);
		
		int num = s.nextInt();
		
		int a, b, c, count = 0;
		
		a = num / 100;
		b = num % 100 / 10;
		c = num % 10;
		
		if (a == 0 && num != 1000) {
			count = num;
		} else {
			count += 99;
			for (int i = 1; i <= a; i++) {
				if (i == a) {
					for (int j = 0; j <= b; j++) {
						if (j == b) {
							for (int k = 0; k <= c; k++) {
								if (check(i, j, k))
									count++;
							}
						} else {
							for (int k = 0; k < 10; k++) {
								if (check(i, j, k))
									count++;	
							}
						}
					}
				} else {
					for (int j = 0; j < 10; j++) {
						for (int k = 0; k < 10; k++) {
							if (check(i, j, k))
								count++;
						}
					}
				}
			}
		}
		
		System.out.println(count);
	}
	
	static boolean check (int i, int j, int k) {
		if (i - j == j - k)
			return true;
		else
			return false;
	}
	
	// F. 1차원 배열
	// 1. 최소, 최대 - 10818 
	// Import Scanner
	private static void F01() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int num[] = new int[n];
		int min = 0, max = 0;
		
		
		for (int i = 0; i < n; i++) {
			num[i] = s.nextInt();
			if (i == 0) {
				min = num[i];
				max = num[i];
			}
			
			if (min > num[i])
				min = num[i];
			
			if (max < num[i])
				max = num[i];
		}
		System.out.print(min + " " + max);
	}
	
	// F. 1차원 배열
	// 2. 최댓값 - 2562
	// Import Scanner
	private static void F02() {
		Scanner s = new Scanner(System.in);
		int num[] = new int[9];
		int max = 0, index = 0;
		
		
		for (int i = 0; i < 9; i++) {
			num[i] = s.nextInt();
			if (max < num[i]) {
				max = num[i];
				index = i+1;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
	
	// F. 1차원 배열
	// 3. 숫자의 개수 - 2577 
	// Import Scanner
	private static void F03() {
		Scanner s = new Scanner(System.in);
		int num[] = new int[3];
		int sum = 0;
		
		int count[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		for (int i = 0; i < 3; i++) {
			num[i] = s.nextInt();
		}
		
		sum = num[0] * num[1] * num[2];
		
		String numText = sum + "";
		for (int i = 0; i < numText.length(); i++) {
			count[numText.charAt(i)-'0']++;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(count[i]);	
		}
	}
	
	// F. 1차원 배열
	// 4. 나머지 - 3052 
	// Import Scanner, ArrayList
	private static void F04() {
		Scanner s = new Scanner(System.in);
		int num = 0;
		boolean newOne = true;
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			num = s.nextInt() % 42;
			
			for (int j = 0; j < array.size(); j++) {
				if (array.contains(num)) {
					newOne = false;
					break;
				}	
			}
			
			if (newOne) {
				array.add(num);
			} else {
				newOne = true;
			}
		}
		
		System.out.println(array.size());
	}
	
	// F. 1차원 배열
	// 5. 평균 - 1546 
	// Import Scanner, ArrayList
	private static void F05() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		float sum = 0;
		int max = 0, tmp;
		ArrayList<Integer> score = new ArrayList<>();
		
		
		for (int i = 0; i < n; i++) {
			tmp = s.nextInt();
			if (max < tmp)
				max = tmp;
				
			score.add(tmp);
		}
		
		for (int i = 0; i < n; i++) {
			sum += (float) score.get(i) / max * 100;
		}
		
		System.out.println(sum/n);
	}
	
	// F. 1차원 배열
	// 6. OX퀴즈 
	// Import Scanner, ArrayList
	private static void F06() {
		Scanner s = new Scanner(System.in);
		
		int continuous = 0, tmp = 0;
		ArrayList<Integer> score = new ArrayList<>();
		String result;
		
		int n = s.nextInt();
		result = s.nextLine();
		
		
		
		for (int i = 0; i < n; i++) {
			result = s.nextLine();
			for (int j = 0; j < result.length(); j++) {
				if (result.charAt(j) == 'O') {
					continuous++;
					tmp += continuous;
				} else {
					continuous = 0;
				}
			}
			score.add(tmp);
			tmp = 0;
			continuous = 0;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(score.get(i));
		}
	}
	
	// F. 1차원 배열
	// 7. 평균은 넘겠지 - 4344 
	// Import Scanner, ArrayList
	private static void F07() {
		Scanner s = new Scanner(System.in);
		
		int tmp = 0, count = 0;
		float average = 0;
		ArrayList<Float> percent = new ArrayList<>();
		String result;
		
		int n = s.nextInt();
		result = s.nextLine();
		
		for (int i = 0; i < n; i++) {
			result = s.nextLine();
			String[] score = result.split(" ");
			
			for (int j = 1; j < score.length; j++) {
				tmp += Integer.parseInt(score[j]);
			}
			
			average = tmp/Float.parseFloat(score[0]); 
			
			for (int j = 1; j < score.length; j++) {
				if (average < Float.parseFloat(score[j]))
					count++;
			}
			
			percent.add(count / Float.parseFloat(score[0]) * 100);
			tmp = 0;
			count = 0;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.printf("%.3f%%\n", percent.get(i));
		}
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
