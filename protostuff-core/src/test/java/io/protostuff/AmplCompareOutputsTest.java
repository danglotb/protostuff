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
 * Benchmark to compare the serialization speed of 3 types. CodedOutput, BufferedOutput and DeferredOutput.
 *
 * @author David Yu
 * @created Nov 13, 2009
 */
public class AmplCompareOutputsTest extends AbstractTest {
    static final Baz negativeBaz = new Baz((-567), "negativeBaz", (-202020202));

    static final Bar negativeBar = new Bar((-12), "negativeBar", AmplCompareOutputsTest.negativeBaz, Bar.Status.STARTED, ByteString.copyFromUtf8("a1"), true, (-130.031F), (-1000.0001), (-101010101));

    static final Baz baz = new Baz(567, "baz", 202020202);

    static final Bar bar = new Bar(890, "bar", AmplCompareOutputsTest.baz, Bar.Status.STARTED, ByteString.copyFromUtf8("b2"), true, 150.051F, 2000.0002, 303030303);

    // a total of 1000 bytes
    public static final Foo foo = SerializableObjects.newFoo(new Integer[]{ 90210 , -90210 , 0 }, new String[]{ "foo" , "123456789012345678901234567890123456789012" }, new Bar[]{ AmplCompareOutputsTest.bar , AmplCompareOutputsTest.negativeBar }, new Foo.EnumSample[]{ Foo.EnumSample.TYPE0 , Foo.EnumSample.TYPE2 }, new ByteString[]{ ByteString.copyFromUtf8("ef") , ByteString.copyFromUtf8("gh") , // two 350-byte bytestring.
    ByteString.copyFromUtf8("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890") , ByteString.copyFromUtf8("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890") }, new Boolean[]{ true , false }, new Float[]{ 1234.4321F , -1234.4321F , 0.0F }, new Double[]{ 1.234567887654321E7 , -1.234567887654321E7 , 0.0 }, new Long[]{ 7060504030201L , -7060504030201L , 0L });

    public void testFooProtobuf() throws Exception {
        Foo fooCompare = AmplCompareOutputsTest.foo;
        byte[] computed = AmplCompareOutputsTest.toByteArrayComputedProtobuf(fooCompare, fooCompare.cachedSchema());
        byte[] buffered = AmplCompareOutputsTest.toByteArrayBufferedProtobuf(fooCompare, fooCompare.cachedSchema());
        byte[] streamed = AmplCompareOutputsTest.toByteArrayStreamedProtobuf(fooCompare, fooCompare.cachedSchema());
        junit.framework.TestCase.assertTrue(((computed.length) == (buffered.length)));
        junit.framework.TestCase.assertTrue(((computed.length) == (streamed.length)));
        String strComputed = new String(computed, "UTF-8");
        junit.framework.TestCase.assertEquals(strComputed, new String(buffered, "UTF-8"));
        junit.framework.TestCase.assertEquals(strComputed, new String(streamed, "UTF-8"));
    }

    public void testFooProtostuff() throws Exception {
        Foo fooCompare = AmplCompareOutputsTest.foo;
        byte[] computed = AmplCompareOutputsTest.toByteArrayComputedProtostuff(fooCompare, fooCompare.cachedSchema());
        byte[] buffered = AmplCompareOutputsTest.toByteArrayBufferedProtostuff(fooCompare, fooCompare.cachedSchema());
        byte[] streamed = AmplCompareOutputsTest.toByteArrayStreamedProtostuff(fooCompare, fooCompare.cachedSchema());
        junit.framework.TestCase.assertTrue(((computed.length) == (buffered.length)));
        junit.framework.TestCase.assertTrue(((computed.length) == (streamed.length)));
        String strComputed = new String(computed, "UTF-8");
        junit.framework.TestCase.assertEquals(strComputed, new String(buffered, "UTF-8"));
        junit.framework.TestCase.assertEquals(strComputed, new String(streamed, "UTF-8"));
    }

    public void testBenchmark() throws Exception {
        if (!("false".equals(System.getProperty("benchmark.skip"))))
            return ;
        
        String dir = System.getProperty("benchmark.output_dir");
        java.io.PrintStream out = (dir == null) ? System.out : new java.io.PrintStream(new java.io.FileOutputStream(new java.io.File(new java.io.File(dir), (("protostuff-core-" + (System.currentTimeMillis())) + ".txt")), true));
        int warmups = Integer.getInteger("benchmark.warmups", 200000);
        int loops = Integer.getInteger("benchmark.loops", 2000000);
        String title = ("protostuff-core serialization benchmark for " + loops) + " runs";
        out.println(title);
        out.println();
        AmplCompareOutputsTest.start(AmplCompareOutputsTest.foo, AmplCompareOutputsTest.SERIALIZERS, out, warmups, loops);
        if ((System.out) != out)
            out.close();
        
    }

    public static void main(String[] args) throws Exception {
        String dir = System.getProperty("benchmark.output_dir");
        java.io.PrintStream out = (dir == null) ? System.out : new java.io.PrintStream(new java.io.FileOutputStream(new java.io.File(new java.io.File(dir), (("protostuff-core-" + (System.currentTimeMillis())) + ".txt")), true));
        int warmups = Integer.getInteger("benchmark.warmups", 200000);
        int loops = Integer.getInteger("benchmark.loops", 2000000);
        String title = ("protostuff-core serialization benchmark for " + loops) + " runs";
        out.println(title);
        out.println();
        AmplCompareOutputsTest.start(AmplCompareOutputsTest.foo, AmplCompareOutputsTest.SERIALIZERS, out, warmups, loops);
        if ((System.out) != out)
            out.close();
        
    }

    public static <T extends Message<T>> void start(T message, Serializer[] serializers, java.io.PrintStream out, int warmups, int loops) throws Exception {
        for (Serializer s : serializers)
            AmplCompareOutputsTest.ser(message, s, out, s.getName(), warmups, loops);
        
    }

    static <T extends Message<T>> void ser(T message, Serializer serializer, java.io.PrintStream out, String name, int warmups, int loops) throws Exception {
        int len = serializer.serialize(message).length;
        for (int i = 0; i < warmups; i++)
            serializer.serialize(message);
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < loops; i++)
            serializer.serialize(message);
        
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        out.println(((((elapsed + " ms elapsed with ") + len) + " bytes for ") + name));
    }

    static <T> byte[] toByteArrayComputedProtobuf(T message, Schema<T> schema) {
        return CodedOutput.toByteArray(message, schema, false);
    }

    static <T> byte[] toByteArrayBufferedProtobuf(T message, Schema<T> schema) {
        final ProtobufOutput output = new ProtobufOutput(new LinkedBuffer(AmplCompareOutputsTest.BUF_SIZE));
        try {
            schema.writeTo(output, message);
        } catch (java.io.IOException e) {
            throw new RuntimeException(("Serializing to a byte array threw an IOException " + "(should never happen)."), e);
        }
        return output.toByteArray();
    }

    static <T> byte[] toByteArrayStreamedProtobuf(T message, Schema<T> schema) {
        final java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        final CodedOutput output = new CodedOutput(out, new byte[AmplCompareOutputsTest.BUF_SIZE], false);
        try {
            schema.writeTo(output, message);
            output.flush();
        } catch (java.io.IOException e) {
            throw new RuntimeException(("Serializing to a byte array threw an IOException " + "(should never happen)."), e);
        }
        return out.toByteArray();
    }

    static <T> byte[] toByteArrayComputedProtostuff(T message, Schema<T> schema) {
        return CodedOutput.toByteArray(message, schema, true);
    }

    static <T> byte[] toByteArrayBufferedProtostuff(T message, Schema<T> schema) {
        final ProtostuffOutput output = new ProtostuffOutput(new LinkedBuffer(AmplCompareOutputsTest.BUF_SIZE));
        try {
            schema.writeTo(output, message);
        } catch (java.io.IOException e) {
            throw new RuntimeException(("Serializing to a byte array threw an IOException " + "(should never happen)."), e);
        }
        return output.toByteArray();
    }

    static <T> byte[] toByteArrayStreamedProtostuff(T message, Schema<T> schema) {
        /* final ByteArrayOutputStream out = new ByteArrayOutputStream(); try { ProtostuffIOUtil.writeTo(out, message,
        schema, new LinkedBuffer(BUF_SIZE)); } catch (IOException e) { throw new
        RuntimeException("Serializing to a byte array threw an IOException " + "(should never happen).", e); } return
        out.toByteArray();
         */
        final java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        final LinkedBuffer buffer = new LinkedBuffer(AmplCompareOutputsTest.BUF_SIZE);
        final ProtostuffOutput output = new ProtostuffOutput(buffer, out);
        try {
            schema.writeTo(output, message);
            LinkedBuffer.writeTo(out, buffer);
        } catch (java.io.IOException e) {
            throw new RuntimeException(("Serializing to a byte array threw an IOException " + "(should never happen)."), e);
        }
        return out.toByteArray();
    }

    static final int BUF_SIZE = 256;

    public interface Serializer {
        public <T extends Message<T>> byte[] serialize(T message);

        public String getName();
    }

    static final Serializer PROTOBUF_COMPUTED_OUTPUT = new Serializer() {
        @Override
        public <T extends Message<T>> byte[] serialize(T message) {
            return AmplCompareOutputsTest.toByteArrayComputedProtobuf(message, message.cachedSchema());
        }

        @Override
        public String getName() {
            return "protobuf-computed-output";
        }
    };

    static final Serializer PROTOBUF_BUFFERED_OUTPUT = new Serializer() {
        @Override
        public <T extends Message<T>> byte[] serialize(T message) {
            return AmplCompareOutputsTest.toByteArrayBufferedProtobuf(message, message.cachedSchema());
        }

        @Override
        public String getName() {
            return "protobuf-buffered-output";
        }
    };

    static final Serializer PROTOBUF_STREAMED_OUTPUT = new Serializer() {
        @Override
        public <T extends Message<T>> byte[] serialize(T message) {
            return AmplCompareOutputsTest.toByteArrayStreamedProtobuf(message, message.cachedSchema());
        }

        @Override
        public String getName() {
            return "protobuf-streamed-output";
        }
    };

    static final Serializer PROTOSTUFF_COMPUTED_OUTPUT = new Serializer() {
        @Override
        public <T extends Message<T>> byte[] serialize(T message) {
            return AmplCompareOutputsTest.toByteArrayComputedProtostuff(message, message.cachedSchema());
        }

        @Override
        public String getName() {
            return "protostuff-computed-output";
        }
    };

    static final Serializer PROTOSTUFF_BUFFERED_OUTPUT = new Serializer() {
        @Override
        public <T extends Message<T>> byte[] serialize(T message) {
            return AmplCompareOutputsTest.toByteArrayBufferedProtostuff(message, message.cachedSchema());
        }

        @Override
        public String getName() {
            return "protostuff-buffered-output";
        }
    };

    static final Serializer PROTOSTUFF_STREAMED_OUTPUT = new Serializer() {
        @Override
        public <T extends Message<T>> byte[] serialize(T message) {
            return AmplCompareOutputsTest.toByteArrayStreamedProtostuff(message, message.cachedSchema());
        }

        @Override
        public String getName() {
            return "protostuff-streamed-output";
        }
    };

    static final Serializer[] SERIALIZERS = new Serializer[]{ AmplCompareOutputsTest.PROTOBUF_COMPUTED_OUTPUT , AmplCompareOutputsTest.PROTOBUF_BUFFERED_OUTPUT , AmplCompareOutputsTest.PROTOBUF_STREAMED_OUTPUT , AmplCompareOutputsTest.PROTOSTUFF_COMPUTED_OUTPUT , AmplCompareOutputsTest.PROTOSTUFF_BUFFERED_OUTPUT , AmplCompareOutputsTest.PROTOSTUFF_STREAMED_OUTPUT };
}

