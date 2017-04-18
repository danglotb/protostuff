/**
 * ========================================================================
 */
/**
 * Copyright 2007-2010 David Yu dyuproject@gmail.com
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
 * Test case for tail-delimited protostuff messages.
 *
 * @author David Yu
 * @created Oct 5, 2010
 */
public class AmplTailDelimiterTest extends AbstractTest {
    public <T> int writeListTo(java.io.OutputStream out, java.util.List<T> messages, Schema<T> schema) throws java.io.IOException {
        return ProtostuffIOUtil.writeListTo(out, messages, schema, new LinkedBuffer(LinkedBuffer.DEFAULT_BUFFER_SIZE));
    }

    public <T> java.util.List<T> parseListFrom(java.io.InputStream in, Schema<T> schema) throws java.io.IOException {
        return ProtostuffIOUtil.parseListFrom(in, schema);
    }

    public void testBar() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        bars.add(SerializableObjects.bar);
        bars.add(SerializableObjects.negativeBar);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedBars.size()) == (bars.size())));
        int i = 0;
        for (Bar b : parsedBars)
            SerializableObjects.assertEquals(bars.get((i++)), b);
        
    }

    public void testEmptyBar() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        bars.add(new Bar());
        bars.add(new Bar());
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedBars.size()) == (bars.size())));
        int i = 0;
        for (Bar b : parsedBars)
            SerializableObjects.assertEquals(bars.get((i++)), b);
        
    }

    public void testEmptyBar2() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        bars.add(new Bar());
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedBars.size()) == (bars.size())));
        int i = 0;
        for (Bar b : parsedBars)
            SerializableObjects.assertEquals(bars.get((i++)), b);
        
    }

    public void testEmptyBarInner() throws Exception {
        Bar bar = new Bar();
        bar.setSomeBaz(new Baz());
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        bars.add(bar);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedBars.size()) == (bars.size())));
        int i = 0;
        for (Bar b : parsedBars)
            SerializableObjects.assertEquals(bars.get((i++)), b);
        
    }

    public void testFoo() throws Exception {
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        foos.add(SerializableObjects.foo);
        foos.add(SerializableObjects.foo);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    public void testEmptyFoo() throws Exception {
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        foos.add(new Foo());
        foos.add(new Foo());
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    public void testEmptyFoo2() throws Exception {
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        foos.add(new Foo());
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    public void testEmptyFooInner() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        bars.add(new Bar());
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        Foo foo = new Foo();
        foo.setSomeBar(bars);
        foos.add(foo);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    public void testEmptyFooInner2() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        Bar bar = new Bar();
        bar.setSomeBaz(new Baz());
        bars.add(bar);
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        Foo foo = new Foo();
        foo.setSomeBar(bars);
        foos.add(foo);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    public void testEmptyList() throws Exception {
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testEmptyList__5 = writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyList__5, 0);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyList */
    public void testEmptyList_literalMutation9616() throws Exception {
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testEmptyList_literalMutation9616__5 = writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyList_literalMutation9616__5, 0);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 1;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyList */
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyList_cf9674 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyList_cf9674_failAssert3_add10104() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyList_cf9674_failAssert3_add10104__7 = // MethodCallAdder
writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testEmptyList_cf9674_failAssert3_add10104__7, 0);
            writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_3215 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_3215.testBaz();
            // MethodAssertGenerator build local variable
            Object o_18_0 = (parsedFoos.size()) == (foos.size());
            int i = 0;
            for (Foo f : parsedFoos)
                SerializableObjects.assertEquals(foos.get((i++)), f);
            
            org.junit.Assert.fail("testEmptyList_cf9674 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyList */
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyList_add9615 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyList_add9615_cf9811_failAssert15_literalMutation10570() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // MethodAssertGenerator build local variable
            Object o_7_1 = 0;
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_7_1, 0);
            java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyList_add9615__5 = writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            // MethodAssertGenerator build local variable
            Object o_7_0 = o_testEmptyList_add9615__5;
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_7_0, 0);
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_3265 = (DelimiterTest)null;
            // AssertGenerator add assertion
            org.junit.Assert.assertNull(vc_3265);
            // StatementAdderMethod cloned existing statement
            vc_3265.testFoo();
            // MethodAssertGenerator build local variable
            Object o_20_0 = (parsedFoos.size()) == (foos.size());
            int i = 2;
            for (Foo f : parsedFoos) {
                // MethodCallAdder
                SerializableObjects.assertEquals(foos.get((i++)), f);
                SerializableObjects.assertEquals(foos.get((i++)), f);
            }
            org.junit.Assert.fail("testEmptyList_add9615_cf9811 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }
}

