package simulation;

/**
 * 잃어버린 강아지
 *
 * 1.나무
 * 2.현수
 * 3.강아지
 *
 * 현수와 강아지는 북쪽으로 달리기 시작
 * 나무 or 맵 끝인 경우 90도로 회전
 * 이동 or 회전에 1분 소모
 * 10000분 후에도 찾지 못하면 0 반환
 * 서로 같은좌표가 되면 찾은거
 *
 */
public class FindDog {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {-1, 0, 1, 0};

    public int solution(int[][] board){
        int answer = 0;
        // 현수 포지션
        int[] hyP = new int[2];
        // 개 포지션
        int[] dgP = new int[2];
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                if(board[i][j] == 2) {
                    hyP[0] = i;
                    hyP[1] = j;
                } else if(board[i][j] == 3) {
                    dgP[0] = i;
                    dgP[1] = j;
                }
            }
        }
        int hyDir = 0;  // 시작은 북쪽
        int dgDir = 0;
        while (answer < 10000) {
            int hY = hyP[0] + dirY[hyDir];
            int hX = hyP[1] + dirX[hyDir];
            int dY = dgP[0] + dirY[dgDir];
            int dX = dgP[1] + dirX[dgDir];
            if(hY >= board.length || hY < 0 || hX >= board.length || hX < 0 || board[hY][hX] == 1) {
                hyDir = (hyDir + 1) % 4;
            } else {
                hyP[0] = hY;
                hyP[1] = hX;
            }
            if(dY >= board.length || dY < 0 || dX >= board.length || dX < 0 || board[dY][dX] == 1) {
                dgDir = (dgDir + 1) % 4;
            } else {
                dgP[0] = dY;
                dgP[1] = dX;
            }
            answer++;
            if(hyP[0] == dgP[0] && hyP[1] == dgP[1])
                break;
        }

        if(answer == 10000)
            return 0;

        return answer;
    }

    public static void main(String[] args) {
        FindDog T = new FindDog();
        int[][] arr1 = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(T.solution(arr1));
        int[][] arr2 = {
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}
        };
        System.out.println(T.solution(arr2));
    }
}
