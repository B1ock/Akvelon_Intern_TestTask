package binarymatrix;


/**
 * Class with a field - a binary matrix and methods for working with it
 */
public class BinaryMatrix {

    private final byte[][] binary_matrix;

    public BinaryMatrix(int mr, int nc){
        this.binary_matrix = new byte[mr][nc];
    }

    public BinaryMatrix(byte[][] bmx){
        this.binary_matrix = bmx;
    }


    public int getValue(int row, int col) {
        return binary_matrix[row][col];
    }

    public int getRowCount() {
        return binary_matrix.length;
    }

    public int getColumnCount() {
        return binary_matrix[0].length;
    }

    /**
     * Fills the binary matrix with ones and zeros in a random way
     */
    public void toFillBMatrixRandom(){
        for (int i = 0; i < binary_matrix.length; i++) {
            for (int j = 0; j < binary_matrix[0].length; j++) {
                if (Math.random() >= 0.5) {
                    binary_matrix[i][j] = 1;
                } else {
                    binary_matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Print binary matrix
     */
    public void printBMatrix(){
        for (byte[] aBinary_matrix : binary_matrix) {
            for (int j = 0; j < binary_matrix[0].length; j++) {
                System.out.print(aBinary_matrix[j] + "  ");
            }
            System.out.println();
        }
    }
}
