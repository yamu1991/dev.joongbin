import java.util.*;

/***********************************************************************
 * 배열회전 - 배열을 입력받아, 입력된 방햐으로 회전하여 그 결과값을 출력
 * 
 * 입력 - (가로열, 세로열) 
 *        회전명령어(L 왼쪽, R오른쪽, T뒤집기)
 *        출력할 배열위치
 * 출력 - 출력할 배열위치 값
 ***********************************************************************/


public class Ex2_2 {
	
	static int [][] arr1;
	static int [][] arr2;
	
	public static void main(String[] args) {
		System.out.println("Start Exame2-2");
		
		int map1;
		int map2;
		String LRT;
		String map;
		
		Scanner imap1 = new Scanner(System.in);
		System.out.print("가로열 입력: ");
		map1 = imap1.nextInt();
		
		Scanner imap2 = new Scanner(System.in);
		System.out.print("세로열 입력: ");
		map2 = imap2.nextInt();
		
		arr1 = new int[map1][map2];
		arr2 = new int[map2][map1];
		int number = 1;
		
		for(int x = 0 ; x < map1; x++)
		{
			for(int y = 0; y < map2; y++){
				arr1[x][y] = number++;
			}
		}
		
		for(int i = 0; i < arr1.length; i++)
		{
			System.out.print( (i+1) + "번째 배열 :");
			System.out.println(Arrays.toString(arr1[i]));	
		}
		
		
		Scanner iLRT = new Scanner(System.in);
		System.out.print("회전 입력: ");
		LRT = iLRT.next();
		
		for(int q = 0 ; q < LRT.length(); q++)
		{
			String oLRT = LRT.substring(q,q+1);
			
			for(int x = 0 ; x < map1; x++)
			{
				for(int y = 0; y < map2; y++){
					switch(oLRT)
					{
						case "R":
							arr2[x][y] = arr1[map2 -1 -y][x];
							break;
						
						case "L":
							arr2[x][y] = arr1[y][map1 -1 - x];
							break;
						
						case "T":
							arr2[x][y] = arr1[x][map2 -1 -y];
							break;
						
					}
				}
			}
			
			for(int x = 0 ; x < map1; x++)
			{
				for(int y = 0; y < map2; y++){
					arr1[x][y] = arr2[x][y];
				}
			}
			
		}
		
		System.out.println("회전후 배열 :");
		for(int i = 0; i < arr2.length; i++)
		{
			System.out.print( (i+1) + "번째 배열 :");
			System.out.println(Arrays.toString(arr2[i]));
		}
		
		
		Scanner imap = new Scanner(System.in);
		System.out.print("배열위치 입력: ");
		map = imap.next();
		
		String[] omap1 = map.split(",");
		String omapx = omap1[0];
		String omapy = omap1[1];
		
		int xx = Integer.parseInt(omapx);
		int yy = Integer.parseInt(omapy);
		
		xx = xx -1;
		yy = yy -1;
		
		System.out.println("배열위치 결과 : " +arr2[yy][xx]);
	}
}
