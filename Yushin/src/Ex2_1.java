import java.util.*;

/***********************************************************************
 * 배열탐색 - 배열을 절차대로 탐생하여 그 결과를 출력
 * 
 * 입력 - (가로열, 세로열)
 * 출력 - 배열탐색 순서
 ***********************************************************************/


public class Ex2_1 {
	
	static int [][] arr;
	
	public static void main(String[] args){
		System.out.println("Start Exame2-1");
		
		int map1;
		int map2;
		
		Scanner imap1 = new Scanner(System.in);
		System.out.print("가로열 입력: ");
		map1 = imap1.nextInt();
		
		Scanner imap2 = new Scanner(System.in);
		System.out.print("세로열 입력: ");
		map2 = imap2.nextInt();
		
		arr = new int[map1][map2];
		int number = 1;
		
		for(int x = 0 ; x < map1; x++)
		{
			for(int y = 0; y < map2; y++){
				arr[x][y] = number++;
			}
		}
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print( (i+1) + "번째 배열 :");
			System.out.println(Arrays.toString(arr[i]));	
		}
		
		/* 탐색절차
		 * (0,0)                  -> 합 0
		 * (0,1) , (1,0)          -> 합 1
		 * (2,0) , (1,1) , (0,2)  -> 합 2
		 * (1,2) , (2,1)          -> 합 3
		 * (2,2)                  -> 합 4
		 */
		int chkout = (map1 - 1) + (map2 -1) + 1; 
		System.out.print("출력 : ");
		
		for(int z = 0; z < chkout; z++)
		{
			for(int x = 0 ; x < map1; x++)
			{
				for(int y = 0; y < map2; y++)
				{
					if((x+y) == z)
					{
						if((z%2) == 0){
							int chkin = arr[y][x];
							System.out.print(chkin);	
						}else{
							int chkin = arr[x][y];
							System.out.print(chkin);
						}
						
					}
				}
			}	
		}
		
	}

}
