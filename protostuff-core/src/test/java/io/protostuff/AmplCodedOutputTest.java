/**
 * ========================================================================
 */
/**
 * Copyright 2007-2009 David Yu dyuproject@gmail.com
 */
/**
 * ------------------------------------------------------------------------
 */
/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
/**
 * you may not use this file except in compliance with the License.
 */
/**
 * You may obtain a copy of the License at
 */
/**
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Unless required by applicable law or agreed to in writing, software
 */
/**
 * distributed under the License is distributed on an "AS IS" BASIS,
 */
/**
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
/**
 * See the License for the specific language governing permissions and
 */
/**
 * limitations under the License.
 */
/**
 * ========================================================================
 */


package io.protostuff;


/**
 * CodedOutput test for the size of the bytes written.
 *
 * @author David Yu
 * @created Nov 11, 2009
 */
public class AmplCodedOutputTest extends AbstractTest {
    static final int[][] int32values = new int[][]{ new int[]{ 1 , 2 } , new int[]{ 10 , 20 } , new int[]{ 101 , 202 } , new int[]{ 1001 , 2002 } , new int[]{ 10001 , 20002 } , new int[]{ 100001 , 200002 } , new int[]{ 1000001 , 2000002 } , new int[]{ 10000001 , 20000002 } , new int[]{ 100000001 , 200000002 } , new int[]{ 1000000001 , 2000000002 } , new int[]{ Integer.MAX_VALUE } };

    static final long[][] int64values = new long[][]{ new long[]{ 1 , 2 } , new long[]{ 10 , 20 } , new long[]{ 101 , 202 } , new long[]{ 1001 , 2002 } , new long[]{ 10001 , 20002 } , new long[]{ 100001 , 200002 } , new long[]{ 1000001 , 2000002 } , new long[]{ 10000001 , 20000002 } , new long[]{ 100000001 , 200000002 } , new long[]{ 1000000001 , 2000000002 } , new long[]{ Long.MAX_VALUE } };

    static final float[][] floatValues = new float[][]{ new float[]{ 1 , 2 } , new float[]{ 10 , 20 } , new float[]{ 101 , 202 } , new float[]{ 1001 , 2002 } , new float[]{ 10001 , 20002 } , new float[]{ 100001 , 200002 } , new float[]{ 1000001 , 2000002 } , new float[]{ 10000001 , 20000002 } , new float[]{ 100000001 , 200000002 } , new float[]{ 1000000001 , 2000000002 } , new float[]{ Float.MAX_VALUE } };

    static final double[][] doubleValues = new double[][]{ new double[]{ 1 , 2 } , new double[]{ 10 , 20 } , new double[]{ 101 , 202 } , new double[]{ 1001 , 2002 } , new double[]{ 10001 , 20002 } , new double[]{ 100001 , 200002 } , new double[]{ 1000001 , 2000002 } , new double[]{ 10000001 , 20000002 } , new double[]{ 100000001 , 200000002 } , new double[]{ 1000000001 , 2000000002 } , new double[]{ Double.MIN_VALUE } };

    public void testBool() throws Exception {
        int num = 1;
        boolean value = true;
        int valueSize = 1;
        int tag = WireFormat.makeTag(num, WireFormat.FieldType.BOOL.wireType);
        int tagSize = CodedOutput.computeRawVarint32Size(tag);
        int expect = tagSize + valueSize;
        AmplCodedOutputTest.assertSize("boolean1", CodedOutput.computeBoolSize(num, value), expect);
        AmplCodedOutputTest.assertSize("boolean2", CodedOutput.getTagAndRawVarInt32Bytes(tag, 1).length, expect);
    }

    public void testRawVarInt32Bytes() throws Exception {
        String n1 = "int1";
        String n2 = "int2";
        for (int i = 0; i < (AmplCodedOutputTest.int32values.length);) {
            int[] inner = AmplCodedOutputTest.int32values[(i++)];
            int num = i;
            for (int j = 0; j < (inner.length); j++) {
                int value = inner[j];
                int valueSize = CodedOutput.computeRawVarint32Size(value);
                int tag = WireFormat.makeTag(num, WireFormat.FieldType.INT32.wireType);
                int tagSize = CodedOutput.computeRawVarint32Size(tag);
                int expect = tagSize + valueSize;
                AmplCodedOutputTest.assertSize(n1, CodedOutput.computeInt32Size(num, value), expect);
                AmplCodedOutputTest.assertSize(n2, CodedOutput.getTagAndRawVarInt32Bytes(tag, value).length, expect);
            }
        }
    }

    public void testRawVarInt64Bytes() throws Exception {
        String n1 = "long1";
        String n2 = "long2";
        for (int i = 0; i < (AmplCodedOutputTest.int64values.length);) {
            long[] inner = AmplCodedOutputTest.int64values[(i++)];
            int num = i;
            for (int j = 0; j < (inner.length); j++) {
                long value = inner[j];
                int valueSize = CodedOutput.computeRawVarint64Size(value);
                int tag = WireFormat.makeTag(num, WireFormat.FieldType.INT64.wireType);
                int tagSize = CodedOutput.computeRawVarint32Size(tag);
                int expect = tagSize + valueSize;
                AmplCodedOutputTest.assertSize(n1, CodedOutput.computeInt64Size(num, value), expect);
                AmplCodedOutputTest.assertSize(n2, CodedOutput.getTagAndRawVarInt64Bytes(tag, value).length, expect);
            }
        }
    }

    public void testRawLittleEndian32Bytes() throws Exception {
        String n1 = "float1";
        String n2 = "float2";
        for (int i = 0; i < (AmplCodedOutputTest.floatValues.length);) {
            float[] inner = AmplCodedOutputTest.floatValues[(i++)];
            int num = i;
            for (int j = 0; j < (inner.length); j++) {
                int value = Float.floatToRawIntBits(inner[j]);
                int valueSize = CodedOutput.LITTLE_ENDIAN_32_SIZE;
                int tag = WireFormat.makeTag(num, WireFormat.FieldType.FLOAT.wireType);
                int tagSize = CodedOutput.computeRawVarint32Size(tag);
                int expect = tagSize + valueSize;
                AmplCodedOutputTest.assertSize(n1, CodedOutput.computeFloatSize(num, inner[j]), expect);
                AmplCodedOutputTest.assertSize(n2, CodedOutput.getTagAndRawLittleEndian32Bytes(tag, value).length, expect);
            }
        }
    }

    public void testRawLittleEndian64Bytes() throws Exception {
        String n1 = "double1";
        String n2 = "double2";
        for (int i = 0; i < (AmplCodedOutputTest.doubleValues.length);) {
            double[] inner = AmplCodedOutputTest.doubleValues[(i++)];
            int num = i;
            for (int j = 0; j < (inner.length); j++) {
                long value = Double.doubleToRawLongBits(inner[j]);
                int tag = WireFormat.makeTag(num, WireFormat.FieldType.DOUBLE.wireType);
                int tagSize = CodedOutput.computeRawVarint32Size(tag);
                int expect = tagSize + (CodedOutput.LITTLE_ENDIAN_64_SIZE);
                AmplCodedOutputTest.assertSize(n1, CodedOutput.computeDoubleSize(num, inner[j]), expect);
                AmplCodedOutputTest.assertSize(n2, CodedOutput.getTagAndRawLittleEndian64Bytes(tag, value).length, expect);
            }
        }
    }

    static void assertSize(String name, int size1, int size2) {
        // System.err.println(size1 + " == " + size2 + " " + name);
        junit.framework.TestCase.assertTrue((size1 == size2));
    }
}

