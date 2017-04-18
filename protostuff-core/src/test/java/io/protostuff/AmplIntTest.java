/**
 * ========================================================================
 */
/**
 * Copyright 2007-2011 David Yu dyuproject@gmail.com
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
 * Tests for various protobuf int flavors.
 *
 * @author David Yu
 * @created Feb 14, 2011
 */
public class AmplIntTest extends AbstractTest {
    static PojoWithInts filledPojoWithInts(int i, int ni, long j, long nj) {
        junit.framework.TestCase.assertTrue((i >= 0));
        junit.framework.TestCase.assertTrue((j >= 0));
        PojoWithInts p = new PojoWithInts();
        p.setSomeInt32(i);
        p.setSomeUint32(i);
        p.setSomeFixed32(i);
        p.setSomeSint32(ni);
        p.setSomeSfixed32(ni);
        p.setSomeInt64(j);
        p.setSomeUint64(j);
        p.setSomeFixed64(j);
        p.setSomeSint64(nj);
        p.setSomeSfixed64(nj);
        return p;
    }

    public void testProtostuff() throws java.io.IOException {
        AmplIntTest.verifyProtostuff(AmplIntTest.filledPojoWithInts(0, 0, 0, 0));
        AmplIntTest.verifyProtostuff(AmplIntTest.filledPojoWithInts(1, 1, 1, 1));
        AmplIntTest.verifyProtostuff(AmplIntTest.filledPojoWithInts(1, (-1), 1, (-1)));
        AmplIntTest.verifyProtostuff(AmplIntTest.filledPojoWithInts(Integer.MAX_VALUE, Integer.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE));
        AmplIntTest.verifyProtostuff(AmplIntTest.filledPojoWithInts(Integer.MAX_VALUE, Integer.MIN_VALUE, Long.MAX_VALUE, Long.MIN_VALUE));
    }

    public void testProtobuf() throws java.io.IOException {
        AmplIntTest.verifyProtobuf(AmplIntTest.filledPojoWithInts(0, 0, 0, 0));
        AmplIntTest.verifyProtobuf(AmplIntTest.filledPojoWithInts(1, 1, 1, 1));
        AmplIntTest.verifyProtobuf(AmplIntTest.filledPojoWithInts(1, (-1), 1, (-1)));
        AmplIntTest.verifyProtobuf(AmplIntTest.filledPojoWithInts(Integer.MAX_VALUE, Integer.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE));
        AmplIntTest.verifyProtobuf(AmplIntTest.filledPojoWithInts(Integer.MAX_VALUE, Integer.MIN_VALUE, Long.MAX_VALUE, Long.MIN_VALUE));
    }

    static void verifyProtostuff(PojoWithInts p) throws java.io.IOException {
        Schema<PojoWithInts> schema = PojoWithInts.getSchema();
        byte[] data = ProtostuffIOUtil.toByteArray(p, schema, AbstractTest.buf());
        PojoWithInts pFromByteArray = new PojoWithInts();
        ProtostuffIOUtil.mergeFrom(data, pFromByteArray, schema);
        junit.framework.TestCase.assertEquals(p, pFromByteArray);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        ProtostuffIOUtil.writeTo(out, p, schema, AbstractTest.buf());
        byte[] dataFromStream = out.toByteArray();
        junit.framework.TestCase.assertTrue(java.util.Arrays.equals(data, dataFromStream));
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        PojoWithInts pFromStream = new PojoWithInts();
        ProtostuffIOUtil.mergeFrom(in, pFromStream, schema);
        junit.framework.TestCase.assertEquals(p, pFromStream);
    }

    static void verifyProtobuf(PojoWithInts p) throws java.io.IOException {
        Schema<PojoWithInts> schema = PojoWithInts.getSchema();
        byte[] data = ProtobufIOUtil.toByteArray(p, schema, AbstractTest.buf());
        PojoWithInts pFromByteArray = new PojoWithInts();
        ProtobufIOUtil.mergeFrom(data, pFromByteArray, schema);
        junit.framework.TestCase.assertEquals(p, pFromByteArray);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        ProtobufIOUtil.writeTo(out, p, schema, AbstractTest.buf());
        byte[] dataFromStream = out.toByteArray();
        junit.framework.TestCase.assertTrue(java.util.Arrays.equals(data, dataFromStream));
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        PojoWithInts pFromStream = new PojoWithInts();
        ProtobufIOUtil.mergeFrom(in, pFromStream, schema);
        junit.framework.TestCase.assertEquals(p, pFromStream);
    }
}

