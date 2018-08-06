package leetcode;

import java.util.Arrays;
import java.util.List;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] ind = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i=0;i<9;i++){
            int[] newInd = Arrays.copyOf(ind, ind.length);
            for (int j=0;j<9;j++){
                char c = board[i][j];
                if (c == '.')
                    continue;
                if ((--newInd[c - '1']) < 0){
                    System.out.println("(i,j):"+i+","+j);
                    return false;
                }
            }
        }
        for (int i=0;i<9;i++){
            int[] newInd = Arrays.copyOf(ind, ind.length);
            for (int j=0;j<9;j++){
                char c = board[j][i];
                if (c == '.')
                    continue;
                if ((--newInd[c - '1']) < 0){
                    System.out.println("(j,i):"+j+","+i);
                    return false;
                }
            }
        }
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                int[] newInd = Arrays.copyOf(ind, ind.length);
                for (int k=0;k<3;k++){
                    for (int l=0;l<3;l++){
                        char c = board[3*i+k][3*j+l];
                        if (c == '.')
                            continue;
                        if ((--newInd[c - '1']) < 0){
                            System.out.println("(l,k):"+(3*i+k)+","+(3*j+l));
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        char[][] vs0 = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] vs1 = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','5','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(vs.isValidSudoku(vs0));
        System.out.println(vs.isValidSudoku(vs1));
    }
}
