package calculator;


import binarymatrix.BinaryMatrix;




/**
 * Class that computes the maximum length
 * of a sequence of ones in a given identity matrix.
 */
public class BasicCalculator {


    /**
     *Return maximum length of a sequence of ones
     * in a given identity matrix.
     * @param bmx binary matrix
     * @return maximum length
     * of a sequence of ones
     */
    public static int toCalculateSequence(BinaryMatrix bmx){
        int temp, rc, cc;
        int max_seq = 0;
        rc = bmx.getRowCount();
        cc = bmx.getColumnCount();

        for (int i = 0; i < rc; i++){
            temp = 0;
            for(int j = 0; j < cc; j++){
                if(bmx.getValue(i, j) == 1){
                    temp++;
                    if(temp > max_seq) {
                        max_seq = temp;
                    }
                } else {
                    temp = 0;
                }
            }
        }

        for (int i = 0; i < bmx.getColumnCount(); i++){
            temp = 0;
            for(int j = 0; j < bmx.getRowCount(); j++){
                if(bmx.getValue(j, i) == 1){
                    temp++;
                    if(temp > max_seq) {
                        max_seq = temp;
                    }
                } else {
                    temp = 0;
                }
            }
        }
        return max_seq;
    }

    /**
     * Сreates a binary matrix using class methods BinaryMatrix
     */
    public static void toCreateBMatrix(int mr, int nc) {
        BinaryMatrix bmx = new BinaryMatrix(mr, nc);
        bmx.toFillBMatrixRandom();
        bmx.printBMatrix();
        System.out.println("The maximum length of a sequence\n of units in a given unit matrix is --->  " + toCalculateSequence(bmx));

    }

}