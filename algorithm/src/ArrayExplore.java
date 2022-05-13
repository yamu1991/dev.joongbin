import java.util.*;
import java.util.stream.Collectors;

public class ArrayExplore {

    public String arrayExplore() {

        Scanner scanner = new Scanner(System.in);
        List<Integer> answerArr = new ArrayList<>();

        System.out.println("가로 열의 개수를 입력해주세요");
        int widthSize = scanner.nextInt();

        scanner.nextLine();

        System.out.println("세로 열의 개수를 입력해주세요");
        int heightSize = scanner.nextInt();

        scanner.nextLine();

        // 배열 데이터를 받아와 ,구분자로 split 해주고 int로 파싱해주어 저장한다
        System.out.println("배열 데이터를 입력해주세요");
        int[] dataArr = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        // 이차원 배열을 알맞은 크기로 초기화한다
        int[][] secondDataArr = new int[widthSize][heightSize];

        // 이차원 배열에 데이터를 알맞게 넣어준다
        for (int i = 0; i < widthSize; i++) {
            for (int j = 0; j < heightSize; j++) {
                secondDataArr[i][j] = dataArr[(i * widthSize) + j];
            }
        }

        // 이차원 배열을 탐색하기 위한 커서를 초기화 해준다
        int column = 0;
        int row = 0;
        answerArr.add(secondDataArr[column][row]);

        // 커서가 사이즈를 넘어갔는지 검사한다
        while (!checkEndArr(column, row, widthSize, heightSize)) {

            // 현재 가로 커서가 가로 크기를 넘지 않았다면 가로 커서 ++
            // 넘었다면 가로줄은 탐색이 끝났으니 마지막 데이터 검색을 위해 세로 ++
            if (row + 1 < heightSize) row++;
            else column++;

            // 탐색한 데이터를 정답 배열에 넣어준다
            answerArr.add(secondDataArr[column][row]);

            // 마지막 데이터인지 확인한다
            if (checkEndArr(column, row, widthSize, heightSize)) break;

            // 왼쪽 밑으로 탐색하며 배열에 데이터를 넣어준다
            while (row > 0 && column < widthSize - 1) answerArr.add(secondDataArr[++column][--row]);

            // 만약 세로커서가 세로 크기보다 크다면 가로 커서 ++
            if (column + 1 < widthSize) column++;
            else row++;

            // 탐색한 데이터를 정답 배열에 넣어준다
            answerArr.add(secondDataArr[column][row]);

            // 오른쪽 위로 탐색하며 배열에 데이터를 넣어준다
            while (column > 0 && row < heightSize - 1) answerArr.add(secondDataArr[--column][++row]);
        }

        // Integer 배열이 map 함수를 돌며 각각 string 으로 파싱하고 Collector.joining 함수를 이용하여 ,를 사용해 하나로 합친다
        return answerArr.stream().map(Object::toString).collect(Collectors.joining(","));
    }

    // 가로세로가 배열의 크기를 넘었는지 검사해주는 util 함수
    private boolean checkEndArr(int column, int row, int widthSize, int heightSize) {
        return column == widthSize - 1 && row == heightSize - 1;
    }

    public static void main(String[] args) {
        ArrayExplore arrayExplore = new ArrayExplore();
        System.out.println(arrayExplore.arrayExplore());
    }
}
