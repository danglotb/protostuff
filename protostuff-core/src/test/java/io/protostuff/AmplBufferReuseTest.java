

package io.protostuff;


public class AmplBufferReuseTest extends StandardTest {
    private static final ThreadLocal<LinkedBuffer> localBuffer = new ThreadLocal<LinkedBuffer>() {
        @Override
        protected LinkedBuffer initialValue() {
            return AbstractTest.buf();
        }
    };

    @Override
    protected <T> void mergeFrom(byte[] data, int offset, int length, T message, Schema<T> schema) throws java.io.IOException {
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data, offset, length);
        ProtostuffIOUtil.mergeFrom(in, message, schema, AmplBufferReuseTest.localBuffer.get());
    }

    @Override
    protected <T> byte[] toByteArray(T message, Schema<T> schema) {
        final LinkedBuffer buffer = AmplBufferReuseTest.localBuffer.get();
        try {
            return ProtostuffIOUtil.toByteArray(message, schema, buffer);
        } finally {
            buffer.clear();
        }
    }

    public void testFooSizeLimited() throws Exception {
        final Foo fooCompare = SerializableObjects.newFoo(new Integer[]{ 90210 , -90210 , 0 }, new String[]{ "ab" , "cd" }, new Bar[]{ SerializableObjects.bar , SerializableObjects.negativeBar , SerializableObjects.bar , SerializableObjects.negativeBar , SerializableObjects.bar , SerializableObjects.negativeBar }, new Foo.EnumSample[]{ Foo.EnumSample.TYPE0 , Foo.EnumSample.TYPE2 }, new ByteString[]{ ByteString.copyFromUtf8("ef") , ByteString.copyFromUtf8("gh") }, new Boolean[]{ true , false }, new Float[]{ 1234.4321F , -1234.4321F , 0.0F }, new Double[]{ 1.234567887654321E7 , -1.234567887654321E7 , 0.0 }, new Long[]{ 7060504030201L , -7060504030201L , 0L });
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        final LinkedBuffer buffer = LinkedBuffer.allocate(256);
        try {
            ProtostuffIOUtil.writeDelimitedTo(out, fooCompare, fooCompare.cachedSchema(), buffer);
        } finally {
            buffer.clear();
        }
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        Foo foo = new Foo();
        boolean hasException = true;
        try {
            ProtostuffIOUtil.mergeDelimitedFrom(in, foo, foo.cachedSchema(), buffer);
            hasException = false;
        } catch (ProtostuffException e) {
            junit.framework.TestCase.assertTrue(e.getMessage().startsWith("size limit exceeded."));
        }
        junit.framework.TestCase.assertTrue(hasException);
    }

    @org.junit.Test(timeout = 10000)
    public void testFooSizeLimited_add1_failAssert0() throws Exception {
        try {
            final Foo fooCompare = SerializableObjects.newFoo(new Integer[]{ 90210 , -90210 , 0 }, new String[]{ "ab" , "cd" }, new Bar[]{ SerializableObjects.bar , SerializableObjects.negativeBar , SerializableObjects.bar , SerializableObjects.negativeBar , SerializableObjects.bar , SerializableObjects.negativeBar }, new Foo.EnumSample[]{ Foo.EnumSample.TYPE0 , Foo.EnumSample.TYPE2 }, new ByteString[]{ ByteString.copyFromUtf8("ef") , ByteString.copyFromUtf8("gh") }, new Boolean[]{ true , false }, new Float[]{ 1234.4321F , -1234.4321F , 0.0F }, new Double[]{ 1.234567887654321E7 , -1.234567887654321E7 , 0.0 }, new Long[]{ 7060504030201L , -7060504030201L , 0L });
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            final LinkedBuffer buffer = LinkedBuffer.allocate(256);
            try {
                ProtostuffIOUtil.writeDelimitedTo(out, fooCompare, fooCompare.cachedSchema(), buffer);
                ProtostuffIOUtil.writeDelimitedTo(out, fooCompare, fooCompare.cachedSchema(), buffer);
            } finally {
                buffer.clear();
            }
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            Foo foo = new Foo();
            boolean hasException = true;
            try {
                ProtostuffIOUtil.mergeDelimitedFrom(in, foo, foo.cachedSchema(), buffer);
                hasException = false;
            } catch (ProtostuffException e) {
                Object o_35_0 = e.getMessage().startsWith("size limit exceeded.");
            }
            org.junit.Assert.fail("testFooSizeLimited_add1 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }
}

