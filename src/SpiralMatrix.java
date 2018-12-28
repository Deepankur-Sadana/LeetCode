import java.util.*;

/**
 * 
 * Input: 
 * [ 
 * [ 1, 2, 3 ], 
 * [ 4, 5, 6 ], 
 * [ 7, 8, 9 ] ]
 *  
 * Output: 
 * [1,2,3,6,9,8,7,4,5]
 *
 * 
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return list;
        int col = matrix[0].length;
        int rS = 0, rE = rows - 1, cS = 0, cE = col - 1;

        while (rE >= rS && cE >= cS) {
            print(rS,rE,cS,cE,matrix);
            rS++;
            rE--;

            cS++;
            cE--;

        }
        return list;
    }

    List<Integer> list = new ArrayList<>();

    void print(int rS, int rE, int cS, int cE, int[][] matrix) {

        for (int c = cS; c <= cE; c++) {
            list.add(matrix[rS][c]);
        }

        for (int r = rS + 1; r <= rE; r++)
            list.add(matrix[r][cE]);

        for(int c = cE - 1;c >= cS ; c--){
            list.add(matrix[rE][c]);
        }

        for(int r = rE - 1;r >= rS+1 ; r--){
            list.add(matrix[r][cS]);
        }

    }

}
