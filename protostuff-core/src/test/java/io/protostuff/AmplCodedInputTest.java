/**
 * ========================================================================
 */
/**
 * Copyright 2012 David Yu
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
 * Tests for {@link CodedInput}.
 *
 * @author Max Lanin
 * @created Dec 22, 2012
 */
public class AmplCodedInputTest extends AbstractTest {
    public void testSkipFieldOverTheBufferBoundary() throws Exception {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
        int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
        int msgLength = 10;
        ProtobufOutput.writeRawVarInt32Bytes(out, tag);
        ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
        for (int i = 1; i <= msgLength; i++)
            ProtobufOutput.writeRawVarInt32Bytes(out, i);
        
        ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
        byte[] data = out.toByteArray();
        CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
        // AssertGenerator replace invocation
        int o_testSkipFieldOverTheBufferBoundary__21 = ci.pushLimit((msgLength + 2));
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testSkipFieldOverTheBufferBoundary__21, 2147483647);
        junit.framework.TestCase.assertEquals(tag, ci.readTag());
        // AssertGenerator replace invocation
        boolean o_testSkipFieldOverTheBufferBoundary__25 = ci.skipField(tag);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testSkipFieldOverTheBufferBoundary__25);
        junit.framework.TestCase.assertEquals(0, ci.readTag());
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf302_failAssert33() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
            ci.pushLimit((msgLength + 2));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_23_0 = ci.readTag();
            ci.skipField(tag);
            // StatementAdderMethod cloned existing statement
            ci.skipRawBytes(tag);
            // MethodAssertGenerator build local variable
            Object o_28_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf302 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf93_failAssert15() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
            ci.pushLimit((msgLength + 2));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_23_0 = ci.readTag();
            ci.skipField(tag);
            // StatementAdderOnAssert create literal from method
            int int_vc_2 = 2;
            // StatementAdderMethod cloned existing statement
            ci.readRawBytes(int_vc_2);
            // MethodAssertGenerator build local variable
            Object o_30_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf93 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf78_failAssert20() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
            ci.pushLimit((msgLength + 2));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_23_0 = ci.readTag();
            ci.skipField(tag);
            // StatementAdderOnAssert create literal from method
            int int_vc_1 = 1;
            // StatementAdderMethod cloned existing statement
            ci.skipField(int_vc_1);
            // MethodAssertGenerator build local variable
            Object o_30_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf78 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf77_failAssert0() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
            ci.pushLimit((msgLength + 2));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_23_0 = ci.readTag();
            ci.skipField(tag);
            // StatementAdderMethod cloned existing statement
            ci.skipField(anotherTag);
            // MethodAssertGenerator build local variable
            Object o_28_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf77 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    public void testSkipFieldOverTheBufferBoundary_literalMutation15_failAssert60() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[// TestDataMutator on numbers
            0], false);
            ci.pushLimit((msgLength + 2));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_24_0 = ci.readTag();
            ci.skipField(tag);
            // MethodAssertGenerator build local variable
            Object o_27_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_literalMutation15 should have thrown IllegalStateException");
        } catch (IllegalStateException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf154_failAssert39() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
            ci.pushLimit((msgLength + 2));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_23_0 = ci.readTag();
            ci.skipField(tag);
            // StatementAdderOnAssert create null value
            java.io.InputStream vc_64 = (java.io.InputStream)null;
            // StatementAdderMethod cloned existing statement
            ci.readRawVarint32(vc_64);
            // MethodAssertGenerator build local variable
            Object o_30_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf154 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf127_failAssert49() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
            ci.pushLimit((msgLength + 2));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_23_0 = ci.readTag();
            ci.skipField(tag);
            // StatementAdderOnAssert create random local variable
            int vc_46 = 1213657744;
            // StatementAdderMethod cloned existing statement
            ci.pushLimit(vc_46);
            // MethodAssertGenerator build local variable
            Object o_30_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf127 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf246_failAssert18() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
            ci.pushLimit((msgLength + 2));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_23_0 = ci.readTag();
            ci.skipField(tag);
            // StatementAdderMethod cloned existing statement
            ci.readByteBuffer();
            // MethodAssertGenerator build local variable
            Object o_28_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf246 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    public void testSkipFieldOverTheBufferBoundary_literalMutation23_failAssert6() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
            ci.pushLimit((msgLength + 0));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_24_0 = ci.readTag();
            ci.skipField(tag);
            // MethodAssertGenerator build local variable
            Object o_27_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_literalMutation23 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf304_failAssert43() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
            ci.pushLimit((msgLength + 2));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_23_0 = ci.readTag();
            ci.skipField(tag);
            // StatementAdderOnAssert create random local variable
            int vc_132 = -1054772223;
            // StatementAdderMethod cloned existing statement
            ci.skipRawBytes(vc_132);
            // MethodAssertGenerator build local variable
            Object o_30_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf304 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf277_failAssert47() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
            int msgLength = 10;
            ProtobufOutput.writeRawVarInt32Bytes(out, tag);
            ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
            for (int i = 1; i <= msgLength; i++)
                ProtobufOutput.writeRawVarInt32Bytes(out, i);
            
            ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
            byte[] data = out.toByteArray();
            CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
            ci.pushLimit((msgLength + 2));// +2 for tag and length
            
            // MethodAssertGenerator build local variable
            Object o_23_0 = ci.readTag();
            ci.skipField(tag);
            // StatementAdderOnAssert create random local variable
            int vc_120 = -1660410190;
            // StatementAdderMethod cloned existing statement
            ci.checkLastTagWas(vc_120);
            // MethodAssertGenerator build local variable
            Object o_30_0 = ci.readTag();
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf277 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf131_failAssert52_literalMutation1630_failAssert18() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // AssertGenerator generate try/catch block with fail statement
            try {
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int msgLength = 10;
                ProtobufOutput.writeRawVarInt32Bytes(out, tag);
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                for (int i = 1; i <= msgLength; i++)
                    ProtobufOutput.writeRawVarInt32Bytes(out, i);
                
                ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
                byte[] data = out.toByteArray();
                CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
                ci.pushLimit((msgLength + 1));// +2 for tag and length
                
                // MethodAssertGenerator build local variable
                Object o_23_0 = ci.readTag();
                ci.skipField(tag);
                // StatementAdderOnAssert create null value
                CodedInput vc_47 = (CodedInput)null;
                // StatementAdderMethod cloned existing statement
                vc_47.readEnum();
                // MethodAssertGenerator build local variable
                Object o_30_0 = ci.readTag();
                org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf131 should have thrown NullPointerException");
            } catch (NullPointerException eee) {
            }
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf131_failAssert52_literalMutation1630 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf137_failAssert59_literalMutation1809_failAssert1() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // AssertGenerator generate try/catch block with fail statement
            try {
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int msgLength = 10;
                ProtobufOutput.writeRawVarInt32Bytes(out, tag);
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                for (int i = 1; i <= msgLength; i++)
                    ProtobufOutput.writeRawVarInt32Bytes(out, i);
                
                ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
                byte[] data = out.toByteArray();
                CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[// TestDataMutator on numbers
                0], false);
                ci.pushLimit((msgLength + 2));// +2 for tag and length
                
                // MethodAssertGenerator build local variable
                Object o_23_0 = ci.readTag();
                ci.skipField(tag);
                // StatementAdderOnAssert create null value
                CodedInput vc_51 = (CodedInput)null;
                // StatementAdderMethod cloned existing statement
                vc_51.readInt32();
                // MethodAssertGenerator build local variable
                Object o_30_0 = ci.readTag();
                org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf137 should have thrown NullPointerException");
            } catch (NullPointerException eee) {
            }
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf137_failAssert59_literalMutation1809 should have thrown IllegalStateException");
        } catch (IllegalStateException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872_failAssert13() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // AssertGenerator generate try/catch block with fail statement
            try {
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int msgLength = 10;
                ProtobufOutput.writeRawVarInt32Bytes(out, tag);
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                for (int i = 1; i <= msgLength; i++)
                    ProtobufOutput.writeRawVarInt32Bytes(out, i);
                
                ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
                byte[] data = out.toByteArray();
                CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
                ci.pushLimit((msgLength + 2));// +2 for tag and length
                
                // MethodAssertGenerator build local variable
                Object o_23_0 = ci.readTag();
                // MethodCallAdder
                ci.skipField(tag);
                ci.skipField(tag);
                // StatementAdderOnAssert create null value
                java.io.InputStream vc_68 = (java.io.InputStream)null;
                // StatementAdderMethod cloned existing statement
                ci.readRawVarint32(vc_68, tag);
                // MethodAssertGenerator build local variable
                Object o_30_0 = ci.readTag();
                org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf164 should have thrown NullPointerException");
            } catch (NullPointerException eee) {
            }
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf113_failAssert50_literalMutation1582_failAssert7_literalMutation2075() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // AssertGenerator generate try/catch block with fail statement
            try {
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int msgLength = 0;
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(msgLength, 0);
                ProtobufOutput.writeRawVarInt32Bytes(out, tag);
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                for (int i = 1; i <= msgLength; i++)
                    ProtobufOutput.writeRawVarInt32Bytes(out, i);
                
                ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
                byte[] data = out.toByteArray();
                CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
                // AssertGenerator replace invocation
                int o_testSkipFieldOverTheBufferBoundary_cf113_failAssert50_literalMutation1582_failAssert7_literalMutation2075__26 = ci.pushLimit((msgLength + 0));
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(o_testSkipFieldOverTheBufferBoundary_cf113_failAssert50_literalMutation1582_failAssert7_literalMutation2075__26, 2147483647);
                // MethodAssertGenerator build local variable
                Object o_23_0 = ci.readTag();
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(o_23_0, 0);
                ci.skipField(tag);
                // StatementAdderOnAssert create null value
                CodedInput vc_38 = (CodedInput)null;
                // StatementAdderMethod cloned existing statement
                vc_38.getBytesUntilLimit();
                // MethodAssertGenerator build local variable
                Object o_30_0 = ci.readTag();
                org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf113 should have thrown NullPointerException");
            } catch (NullPointerException eee) {
            }
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf113_failAssert50_literalMutation1582 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872_failAssert13_literalMutation2216() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // AssertGenerator generate try/catch block with fail statement
            try {
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int msgLength = 10;
                ProtobufOutput.writeRawVarInt32Bytes(out, tag);
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                for (int i = 1; i <= msgLength; i++)
                    ProtobufOutput.writeRawVarInt32Bytes(out, i);
                
                ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
                byte[] data = out.toByteArray();
                CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
                // AssertGenerator replace invocation
                int o_testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872_failAssert13_literalMutation2216__25 = ci.pushLimit((msgLength + 0));
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(o_testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872_failAssert13_literalMutation2216__25, 2147483647);
                // MethodAssertGenerator build local variable
                Object o_23_0 = ci.readTag();
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(o_23_0, 10);
                // MethodCallAdder
                ci.skipField(tag);
                ci.skipField(tag);
                // StatementAdderOnAssert create null value
                java.io.InputStream vc_68 = (java.io.InputStream)null;
                // StatementAdderMethod cloned existing statement
                ci.readRawVarint32(vc_68, tag);
                // MethodAssertGenerator build local variable
                Object o_30_0 = ci.readTag();
                org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf164 should have thrown NullPointerException");
            } catch (NullPointerException eee) {
            }
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf272_failAssert2_literalMutation414_failAssert8_add2094() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // AssertGenerator generate try/catch block with fail statement
            try {
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int msgLength = 10;
                ProtobufOutput.writeRawVarInt32Bytes(out, tag);
                // MethodCallAdder
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                for (int i = 1; i <= msgLength; i++)
                    ProtobufOutput.writeRawVarInt32Bytes(out, i);
                
                ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
                byte[] data = out.toByteArray();
                CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[// TestDataMutator on numbers
                0], false);
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(((CodedInput)ci).getLastTag(), 0);
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(((CodedInput)ci).getTotalBytesRead(), 0);
                // AssertGenerator add assertion
                org.junit.Assert.assertFalse(((CodedInput)ci).isCurrentFieldPacked());
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(((CodedInput)ci).getBytesUntilLimit(), -1);
                ci.pushLimit((msgLength + 2));// +2 for tag and length
                
                // MethodAssertGenerator build local variable
                Object o_23_0 = ci.readTag();
                ci.skipField(tag);
                // StatementAdderOnAssert create null value
                CodedInput vc_118 = (CodedInput)null;
                // StatementAdderMethod cloned existing statement
                vc_118.checkLastTagWas(msgLength);
                // MethodAssertGenerator build local variable
                Object o_30_0 = ci.readTag();
                org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf272 should have thrown NullPointerException");
            } catch (NullPointerException eee) {
            }
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf272_failAssert2_literalMutation414 should have thrown IllegalStateException");
        } catch (IllegalStateException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872_failAssert13_literalMutation2217() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // AssertGenerator generate try/catch block with fail statement
            try {
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int msgLength = 10;
                ProtobufOutput.writeRawVarInt32Bytes(out, tag);
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                for (int i = 1; i <= msgLength; i++)
                    ProtobufOutput.writeRawVarInt32Bytes(out, i);
                
                ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
                byte[] data = out.toByteArray();
                CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
                // AssertGenerator replace invocation
                int o_testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872_failAssert13_literalMutation2217__25 = ci.pushLimit((msgLength + 3));
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(o_testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872_failAssert13_literalMutation2217__25, 2147483647);
                // MethodAssertGenerator build local variable
                Object o_23_0 = ci.readTag();
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(o_23_0, 10);
                // AssertGenerator replace invocation
                boolean o_testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872_failAssert13_literalMutation2217__31 = // MethodCallAdder
ci.skipField(tag);
                // AssertGenerator add assertion
                org.junit.Assert.assertTrue(o_testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872_failAssert13_literalMutation2217__31);
                ci.skipField(tag);
                // StatementAdderOnAssert create null value
                java.io.InputStream vc_68 = (java.io.InputStream)null;
                // StatementAdderMethod cloned existing statement
                ci.readRawVarint32(vc_68, tag);
                // MethodAssertGenerator build local variable
                Object o_30_0 = ci.readTag();
                org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf164 should have thrown NullPointerException");
            } catch (NullPointerException eee) {
            }
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf164_failAssert62_add1872 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf176_failAssert48_literalMutation1525_failAssert4_literalMutation2006() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // AssertGenerator generate try/catch block with fail statement
            try {
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int msgLength = 20;
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(msgLength, 20);
                ProtobufOutput.writeRawVarInt32Bytes(out, tag);
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                for (int i = 1; i <= msgLength; i++)
                    ProtobufOutput.writeRawVarInt32Bytes(out, i);
                
                ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
                byte[] data = out.toByteArray();
                CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
                // AssertGenerator replace invocation
                int o_testSkipFieldOverTheBufferBoundary_cf176_failAssert48_literalMutation1525_failAssert4_literalMutation2006__26 = ci.pushLimit((msgLength + 1));
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(o_testSkipFieldOverTheBufferBoundary_cf176_failAssert48_literalMutation1525_failAssert4_literalMutation2006__26, 2147483647);
                // MethodAssertGenerator build local variable
                Object o_23_0 = ci.readTag();
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(o_23_0, 10);
                ci.skipField(tag);
                // StatementAdderOnAssert create null value
                CodedInput vc_71 = (CodedInput)null;
                // StatementAdderMethod cloned existing statement
                vc_71.readSFixed32();
                // MethodAssertGenerator build local variable
                Object o_30_0 = ci.readTag();
                org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf176 should have thrown NullPointerException");
            } catch (NullPointerException eee) {
            }
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf176_failAssert48_literalMutation1525 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf197_failAssert22_add867_failAssert3_add1975() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // AssertGenerator generate try/catch block with fail statement
            try {
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int msgLength = 10;
                ProtobufOutput.writeRawVarInt32Bytes(out, tag);
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                for (int i = 1; i <= msgLength; i++)
                    ProtobufOutput.writeRawVarInt32Bytes(out, i);
                
                ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
                byte[] data = out.toByteArray();
                CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[10], false);
                ci.pushLimit((msgLength + 2));// +2 for tag and length
                
                // MethodAssertGenerator build local variable
                Object o_23_0 = ci.readTag();
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(o_23_0, 10);
                // AssertGenerator replace invocation
                boolean o_testSkipFieldOverTheBufferBoundary_cf197_failAssert22_add867_failAssert3_add1975__30 = // MethodCallAdder
ci.skipField(tag);
                // AssertGenerator add assertion
                org.junit.Assert.assertTrue(o_testSkipFieldOverTheBufferBoundary_cf197_failAssert22_add867_failAssert3_add1975__30);
                // MethodCallAdder
                ci.skipField(tag);
                ci.skipField(tag);
                // StatementAdderOnAssert create null value
                CodedInput vc_82 = (CodedInput)null;
                // StatementAdderMethod cloned existing statement
                vc_82.readBytes();
                // MethodAssertGenerator build local variable
                Object o_30_0 = ci.readTag();
                org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf197 should have thrown NullPointerException");
            } catch (NullPointerException eee) {
            }
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf197_failAssert22_add867 should have thrown ProtobufException");
        } catch (ProtobufException eee) {
        }
    }

    /* amplification of io.protostuff.CodedInputTest#testSkipFieldOverTheBufferBoundary */
    @org.junit.Test(timeout = 10000)
    public void testSkipFieldOverTheBufferBoundary_cf160_failAssert57_literalMutation1749_failAssert2_add1945() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // AssertGenerator generate try/catch block with fail statement
            try {
                java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                int tag = WireFormat.makeTag(1, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int anotherTag = WireFormat.makeTag(2, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                int msgLength = 10;
                ProtobufOutput.writeRawVarInt32Bytes(out, tag);
                ProtobufOutput.writeRawVarInt32Bytes(out, msgLength);
                for (int i = 1; i <= msgLength; i++)
                    ProtobufOutput.writeRawVarInt32Bytes(out, i);
                
                ProtobufOutput.writeRawVarInt32Bytes(out, anotherTag);
                byte[] data = out.toByteArray();
                CodedInput ci = new CodedInput(new java.io.ByteArrayInputStream(data), new byte[// TestDataMutator on numbers
                0], false);
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(((CodedInput)ci).getLastTag(), 0);
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(((CodedInput)ci).getTotalBytesRead(), 0);
                // AssertGenerator add assertion
                org.junit.Assert.assertFalse(((CodedInput)ci).isCurrentFieldPacked());
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(((CodedInput)ci).getBytesUntilLimit(), -1);
                // AssertGenerator replace invocation
                int o_testSkipFieldOverTheBufferBoundary_cf160_failAssert57_literalMutation1749_failAssert2_add1945__26 = // MethodCallAdder
ci.pushLimit((msgLength + 2));
                // AssertGenerator add assertion
                org.junit.Assert.assertEquals(o_testSkipFieldOverTheBufferBoundary_cf160_failAssert57_literalMutation1749_failAssert2_add1945__26, 2147483647);
                ci.pushLimit((msgLength + 2));// +2 for tag and length
                
                // MethodAssertGenerator build local variable
                Object o_23_0 = ci.readTag();
                ci.skipField(tag);
                // StatementAdderOnAssert create random local variable
                int vc_70 = -669775571;
                // StatementAdderOnAssert create null value
                java.io.InputStream vc_68 = (java.io.InputStream)null;
                // StatementAdderOnAssert create null value
                CodedInput vc_66 = (CodedInput)null;
                // StatementAdderMethod cloned existing statement
                vc_66.readRawVarint32(vc_68, vc_70);
                // MethodAssertGenerator build local variable
                Object o_34_0 = ci.readTag();
                org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf160 should have thrown NullPointerException");
            } catch (NullPointerException eee) {
            }
            org.junit.Assert.fail("testSkipFieldOverTheBufferBoundary_cf160_failAssert57_literalMutation1749 should have thrown IllegalStateException");
        } catch (IllegalStateException eee) {
        }
    }
}

