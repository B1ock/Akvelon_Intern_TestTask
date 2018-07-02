package calculator;

import binarymatrix.BinaryMatrix;
import org.junit.Test;

import static org.junit.Assert.*;



public class BasicCalculatorTest {

    public static final byte[][] BMX = {{0, 1, 0, 1, 0, 1, 0},
                                        {1, 0, 1, 0, 1, 0, 1},
                                        {0, 1, 0, 1, 0, 1, 0},
                                        {1, 1, 1, 1, 1, 1, 1},
                                        {0, 1, 0, 1, 0, 1, 0},
                                        {1, 0, 1, 0, 1, 0, 1},
                                        {0, 1, 0, 1, 0, 1, 0}
                                       };
    public static final byte[][] BMX_ONE_ROW = {{0, 1, 1, 1, 1, 1, 0}
    };

    public static final byte[][] BMX_ONE_ROW_ONLY_ONES = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public static final byte[][] BMX_ONE_ROW_ONLY_ZEROS = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };


    public static final byte[][] BMX_ONE_COLUMN = {{1},
                                                   {1},
                                                   {0},
                                                   {1},
                                                   {0},
                                                   {1},
                                                   {1}
    };

    public static final byte[][] BMX_ONE_COLUMN_ONLY_ONES = {{1},
                                                             {1},
                                                             {1},
                                                             {1},
                                                             {1},
                                                             {1},
                                                             {1},
                                                             {1}
    };

    public static final byte[][] BMX_ONE_COLUMN_ONLY_ZEROS  = {{0},
                                                               {0},
                                                               {0},
                                                               {0},
                                                               {0},
                                                               {0},
                                                               {0}
    };

    public static final byte[][] BMX_1 = {{0, 0, 0, 1, 0, 0, 0},
                                        {0, 0, 0, 1, 0, 0, 0},
                                        {0, 0, 0, 1, 0, 0, 0},
                                        {0, 0, 0, 1, 0, 0, 0},
                                        {0, 0, 0, 1, 0, 0, 0},
                                        {0, 0, 0, 1, 0, 0, 0},
                                        {0, 0, 0, 1, 0, 0, 0}
    };

    @Test
    public void testToCalculateSequence() throws Exception {
        System.out.println("Calculate Sequnce");
        BinaryMatrix bmx = new BinaryMatrix(BMX);
        int expResult = 7;
        int result = BasicCalculator.toCalculateSequence(bmx);
        assertEquals(expResult, result);
        //fail("The test case is prototype");
    }

    @Test
    public void testToCalculateSequence_1() throws Exception {
        System.out.println("Calculate Sequnce 1");
        BinaryMatrix bmx = new BinaryMatrix(BMX_1);
        int expResult = 7;
        int result = BasicCalculator.toCalculateSequence(bmx);
        assertEquals(expResult, result);
        //fail("The test case is prototype");
    }

    @Test
    public void testToCalcSeqOneRow() throws Exception {
        System.out.println("Calculate Sequnce One Row");
        BinaryMatrix bmx = new BinaryMatrix(BMX_ONE_ROW);
        int expResult = 5;
        int result = BasicCalculator.toCalculateSequence(bmx);
        assertEquals(expResult, result);
        //fail("The test case is prototype");
    }

    @Test
    public void testToCalcSeqOneColumn() throws Exception {
        System.out.println("Calculate Sequnce One Column");
        BinaryMatrix bmx = new BinaryMatrix(BMX_ONE_COLUMN);
        int expResult = 2;
        int result = BasicCalculator.toCalculateSequence(bmx);
        assertEquals(expResult, result);
        //fail("The test case is prototype");
    }

    @Test
    public void testToCalcSeqOneRowOnlyOnes() throws Exception {
        System.out.println("Calculate Sequnce One Row Only Ones");
        BinaryMatrix bmx = new BinaryMatrix(BMX_ONE_ROW_ONLY_ONES);
        int expResult = 10;
        int result = BasicCalculator.toCalculateSequence(bmx);
        assertEquals(expResult, result);
        //fail("The test case is prototype");
    }

    @Test
    public void testToCalcSeqOneRowOnlyZeros() throws Exception {
        System.out.println("Calculate Sequnce One Row Only Zeros");
        BinaryMatrix bmx = new BinaryMatrix(BMX_ONE_ROW_ONLY_ZEROS);
        int expResult = 0;
        int result = BasicCalculator.toCalculateSequence(bmx);
        assertEquals(expResult, result);
        //fail("The test case is prototype");
    }

    @Test
    public void testToCalcSeqOneColumnOnlyOnes() throws Exception {
        System.out.println("Calculate Sequnce One Column Only Ones");
        BinaryMatrix bmx = new BinaryMatrix(BMX_ONE_COLUMN_ONLY_ONES);
        int expResult = 8;
        int result = BasicCalculator.toCalculateSequence(bmx);
        assertEquals(expResult, result);
        //fail("The test case is prototype");
    }

    @Test
    public void testToCalcSeqOneColumnOnlyZeros() throws Exception {
        System.out.println("Calculate Sequnce One Column Only Zeros");
        BinaryMatrix bmx = new BinaryMatrix(BMX_ONE_COLUMN_ONLY_ZEROS);
        int expResult = 0;
        int result = BasicCalculator.toCalculateSequence(bmx);
        assertEquals(expResult, result);
        //fail("The test case is prototype");
    }

}