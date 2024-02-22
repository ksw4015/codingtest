package array;

public class NumberOfPeaks {

    /*
        주변은 0으로 둘러싸인 배열
            5 3 7 2 3
            3 7 1 6 1
            7 2 5 3 4
            4 3 6 4 1
            8 7 3 5 2
        해당 좌표의 숫자가 동서남북 좌표의 숫자보다 크면 봉우리
     */
    public int solution(int[][] mountain) {
        int answer = 0;
        int[][] mountainMap = new int[mountain.length+2][mountain[0].length+2];
        for(int i = 0 ; i < mountain.length ; i++) {
            System.arraycopy(mountain[i], 0, mountainMap[i + 1], 1, mountain[i].length);
        }
        for(int i = 1 ; i < mountainMap.length - 1 ; i++) {
            for(int j = 1 ; j < mountainMap[i].length - 1 ; j++) {
                if(mountainMap[i][j] > mountainMap[i][j+1] && mountainMap[i][j] > mountainMap[i][j-1] &&
                        mountainMap[i][j] > mountainMap[i+1][j] && mountainMap[i][j] > mountainMap[i-1][j]) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] mountain = new int[][]{
                {5, 3, 7, 2, 3},
                {3, 7, 1, 6, 1},
                {7, 2, 5, 3, 4},
                {4, 3, 6, 4, 1},
                {8, 7, 3, 5, 2},
        };
        NumberOfPeaks T = new NumberOfPeaks();
        System.out.println(T.solution(mountain));
    }
}
