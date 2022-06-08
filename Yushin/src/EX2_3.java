import java.util.*;

/***********************************************************************
 * 마지막남는자리 - N번만큼 이동해서 한명씩 탈락후 마지막 결과값 출력
 * 
 * 입력 - 사람수, 이동할 거리
 * 출력 - 마지막 결과값
 ***********************************************************************/

public class EX2_3 {

	public static void main(String[] args) {
		System.out.println("Start Exame2-3");
		
		Queue<Integer> Q = new LinkedList<>();
		int num1;
		int num2;
		
		Scanner inum1 = new Scanner(System.in);
		System.out.print("사람수 입력: ");
		num1 = inum1.nextInt();
		
		Scanner inum2 = new Scanner(System.in);
		System.out.print("이동할거리 입력: ");
		num2 = inum2.nextInt();
		
		for(int x=0; x < num1; x++)
		{
			Q.offer(x);
		}
		
		while(Q.size() != 1)
		{
			for (int y = 0; y < num2; y++){
				Q.offer(Q.poll());
			}
			
			Q.poll();
		}
		
		System.out.println("마지막 남은사람 :" + Q.poll());
	}

}
