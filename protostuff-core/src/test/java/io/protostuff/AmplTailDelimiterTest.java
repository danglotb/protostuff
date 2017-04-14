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

    public void testEmptyBar2() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        // AssertGenerator replace invocation
        boolean o_testEmptyBar2__3 = bars.add(new Bar());
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyBar2__3);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testEmptyBar2__7 = writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyBar2__7, 2);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedBars.size()) == (bars.size())));
        int i = 0;
        for (Bar b : parsedBars)
            SerializableObjects.assertEquals(bars.get((i++)), b);
        
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

    /* amplification of io.protostuff.TailDelimiterTest#testBar */
    @org.junit.Test(timeout = 10000)
    public void testBar_add2() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        // AssertGenerator replace invocation
        boolean o_testBar_add2__3 = bars.add(SerializableObjects.bar);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testBar_add2__3);
        // AssertGenerator replace invocation
        boolean o_testBar_add2__4 = // MethodCallAdder
bars.add(SerializableObjects.negativeBar);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testBar_add2__4);
        // AssertGenerator replace invocation
        boolean o_testBar_add2__6 = bars.add(SerializableObjects.negativeBar);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testBar_add2__6);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testBar_add2__9 = writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testBar_add2__9, 243);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedBars.size()) == (bars.size())));
        int i = 0;
        for (Bar b : parsedBars)
            SerializableObjects.assertEquals(bars.get((i++)), b);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testBar */
    /* amplification of io.protostuff.TailDelimiterTest#testBar_cf57 */
    @org.junit.Test(timeout = 10000)
    public void testBar_cf57_failAssert4_add356() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
            bars.add(SerializableObjects.bar);
            bars.add(SerializableObjects.negativeBar);
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testBar_cf57_failAssert4_add356__9 = // MethodCallAdder
writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testBar_cf57_failAssert4_add356__9, 148);
            writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_305 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_305.testBar();
            // MethodAssertGenerator build local variable
            Object o_20_0 = (parsedBars.size()) == (bars.size());
            int i = 0;
            for (Bar b : parsedBars)
                SerializableObjects.assertEquals(bars.get((i++)), b);
            
            org.junit.Assert.fail("testBar_cf57 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyBar */
    @org.junit.Test(timeout = 10000)
    public void testEmptyBar_add1380() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        // AssertGenerator replace invocation
        boolean o_testEmptyBar_add1380__3 = bars.add(new Bar());
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyBar_add1380__3);
        // AssertGenerator replace invocation
        boolean o_testEmptyBar_add1380__5 = bars.add(new Bar());
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyBar_add1380__5);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testEmptyBar_add1380__9 = // MethodCallAdder
writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyBar_add1380__9, 3);
        // AssertGenerator replace invocation
        int o_testEmptyBar_add1380__12 = writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyBar_add1380__12, 3);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedBars.size()) == (bars.size())));
        int i = 0;
        for (Bar b : parsedBars)
            SerializableObjects.assertEquals(bars.get((i++)), b);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyBar */
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyBar_cf1438 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyBar_cf1438_failAssert6_add1767() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
            bars.add(new Bar());
            bars.add(new Bar());
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyBar_cf1438_failAssert6_add1767__11 = // MethodCallAdder
writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testEmptyBar_cf1438_failAssert6_add1767__11, 3);
            writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_765 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_765.testBarTooLarge3();
            // MethodAssertGenerator build local variable
            Object o_22_0 = (parsedBars.size()) == (bars.size());
            int i = 0;
            for (Bar b : parsedBars)
                SerializableObjects.assertEquals(bars.get((i++)), b);
            
            org.junit.Assert.fail("testEmptyBar_cf1438 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyBar2 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyBar2_add2788() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        // AssertGenerator replace invocation
        boolean o_testEmptyBar2_add2788__3 = bars.add(new Bar());
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyBar2_add2788__3);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testEmptyBar2_add2788__7 = // MethodCallAdder
writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyBar2_add2788__7, 2);
        // AssertGenerator replace invocation
        int o_testEmptyBar2_add2788__10 = writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyBar2_add2788__10, 2);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedBars.size()) == (bars.size())));
        int i = 0;
        for (Bar b : parsedBars)
            SerializableObjects.assertEquals(bars.get((i++)), b);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyBar2 */
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyBar2_cf2842 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyBar2_cf2842_failAssert4_add3085() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
            bars.add(new Bar());
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyBar2_cf2842_failAssert4_add3085__9 = // MethodCallAdder
writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testEmptyBar2_cf2842_failAssert4_add3085__9, 2);
            writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_1217 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_1217.testBar();
            // MethodAssertGenerator build local variable
            Object o_20_0 = (parsedBars.size()) == (bars.size());
            int i = 0;
            for (Bar b : parsedBars)
                SerializableObjects.assertEquals(bars.get((i++)), b);
            
            org.junit.Assert.fail("testEmptyBar2_cf2842 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyBarInner */
    public void testEmptyBarInner_literalMutation3890() throws Exception {
        Bar bar = new Bar();
        bar.setSomeBaz(new Baz());
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        // AssertGenerator replace invocation
        boolean o_testEmptyBarInner_literalMutation3890__7 = bars.add(bar);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyBarInner_literalMutation3890__7);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testEmptyBarInner_literalMutation3890__10 = writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyBarInner_literalMutation3890__10, 4);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedBars.size()) == (bars.size())));
        int i = 0;
        for (Bar b : parsedBars)
            SerializableObjects.assertEquals(bars.get((i++)), b);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyBarInner */
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyBarInner_cf3944 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyBarInner_cf3944_failAssert6_add4278() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            Bar bar = new Bar();
            bar.setSomeBaz(new Baz());
            java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
            bars.add(bar);
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyBarInner_cf3944_failAssert6_add4278__12 = // MethodCallAdder
writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testEmptyBarInner_cf3944_failAssert6_add4278__12, 4);
            writeListTo(out, bars, SerializableObjects.bar.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Bar> parsedBars = parseListFrom(in, SerializableObjects.bar.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_1557 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_1557.testBarTooLarge3();
            // MethodAssertGenerator build local variable
            Object o_23_0 = (parsedBars.size()) == (bars.size());
            int i = 0;
            for (Bar b : parsedBars)
                SerializableObjects.assertEquals(bars.get((i++)), b);
            
            org.junit.Assert.fail("testEmptyBarInner_cf3944 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFoo */
    @org.junit.Test(timeout = 10000)
    public void testEmptyFoo_add4903() throws Exception {
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        // AssertGenerator replace invocation
        boolean o_testEmptyFoo_add4903__3 = foos.add(new Foo());
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyFoo_add4903__3);
        // AssertGenerator replace invocation
        boolean o_testEmptyFoo_add4903__5 = foos.add(new Foo());
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyFoo_add4903__5);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testEmptyFoo_add4903__9 = // MethodCallAdder
writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyFoo_add4903__9, 3);
        // AssertGenerator replace invocation
        int o_testEmptyFoo_add4903__12 = writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyFoo_add4903__12, 3);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFoo */
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFoo_cf4967 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyFoo_cf4967_failAssert9_add5317() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
            foos.add(new Foo());
            foos.add(new Foo());
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyFoo_cf4967_failAssert9_add5317__11 = // MethodCallAdder
writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testEmptyFoo_cf4967_failAssert9_add5317__11, 3);
            writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_1827 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_1827.testFooEmpty();
            // MethodAssertGenerator build local variable
            Object o_22_0 = (parsedFoos.size()) == (foos.size());
            int i = 0;
            for (Foo f : parsedFoos)
                SerializableObjects.assertEquals(foos.get((i++)), f);
            
            org.junit.Assert.fail("testEmptyFoo_cf4967 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFoo2 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyFoo2_add5949() throws Exception {
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        // AssertGenerator replace invocation
        boolean o_testEmptyFoo2_add5949__3 = foos.add(new Foo());
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyFoo2_add5949__3);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testEmptyFoo2_add5949__7 = // MethodCallAdder
writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyFoo2_add5949__7, 2);
        // AssertGenerator replace invocation
        int o_testEmptyFoo2_add5949__10 = writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyFoo2_add5949__10, 2);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFoo2 */
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFoo2_cf6007 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyFoo2_cf6007_failAssert6_add6262() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
            foos.add(new Foo());
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyFoo2_cf6007_failAssert6_add6262__9 = // MethodCallAdder
writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testEmptyFoo2_cf6007_failAssert6_add6262__9, 2);
            writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_2133 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_2133.testBarTooLarge3();
            // MethodAssertGenerator build local variable
            Object o_20_0 = (parsedFoos.size()) == (foos.size());
            int i = 0;
            for (Foo f : parsedFoos)
                SerializableObjects.assertEquals(foos.get((i++)), f);
            
            org.junit.Assert.fail("testEmptyFoo2_cf6007 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFooInner */
    @org.junit.Test(timeout = 10000)
    public void testEmptyFooInner_add7081() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        // AssertGenerator replace invocation
        boolean o_testEmptyFooInner_add7081__3 = bars.add(new Bar());
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyFooInner_add7081__3);
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        Foo foo = new Foo();
        foo.setSomeBar(bars);
        // AssertGenerator replace invocation
        boolean o_testEmptyFooInner_add7081__10 = // MethodCallAdder
foos.add(foo);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyFooInner_add7081__10);
        // AssertGenerator replace invocation
        boolean o_testEmptyFooInner_add7081__12 = foos.add(foo);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyFooInner_add7081__12);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testEmptyFooInner_add7081__15 = writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyFooInner_add7081__15, 7);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFooInner */
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFooInner_cf7144 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyFooInner_cf7144_failAssert8_add7569() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
            bars.add(new Bar());
            java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
            Foo foo = new Foo();
            foo.setSomeBar(bars);
            foos.add(foo);
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyFooInner_cf7144_failAssert8_add7569__15 = // MethodCallAdder
writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testEmptyFooInner_cf7144_failAssert8_add7569__15, 4);
            writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_2497 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_2497.testFoo();
            // MethodAssertGenerator build local variable
            Object o_26_0 = (parsedFoos.size()) == (foos.size());
            int i = 0;
            for (Foo f : parsedFoos)
                SerializableObjects.assertEquals(foos.get((i++)), f);
            
            org.junit.Assert.fail("testEmptyFooInner_cf7144 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFooInner2 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyFooInner2_add8376() throws Exception {
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        Bar bar = new Bar();
        bar.setSomeBaz(new Baz());
        // AssertGenerator replace invocation
        boolean o_testEmptyFooInner2_add8376__7 = bars.add(bar);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyFooInner2_add8376__7);
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        Foo foo = new Foo();
        // MethodCallAdder
        foo.setSomeBar(bars);
        foo.setSomeBar(bars);
        // AssertGenerator replace invocation
        boolean o_testEmptyFooInner2_add8376__15 = foos.add(foo);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testEmptyFooInner2_add8376__15);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testEmptyFooInner2_add8376__18 = writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testEmptyFooInner2_add8376__18, 6);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFooInner2 */
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyFooInner2_cf8442 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyFooInner2_cf8442_failAssert9_add8960() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
            Bar bar = new Bar();
            bar.setSomeBaz(new Baz());
            bars.add(bar);
            java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
            Foo foo = new Foo();
            foo.setSomeBar(bars);
            foos.add(foo);
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyFooInner2_cf8442_failAssert9_add8960__18 = // MethodCallAdder
writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testEmptyFooInner2_cf8442_failAssert9_add8960__18, 6);
            writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_2883 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_2883.testFooEmpty();
            // MethodAssertGenerator build local variable
            Object o_29_0 = (parsedFoos.size()) == (foos.size());
            int i = 0;
            for (Foo f : parsedFoos)
                SerializableObjects.assertEquals(foos.get((i++)), f);
            
            org.junit.Assert.fail("testEmptyFooInner2_cf8442 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
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
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyList_cf9678 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyList_cf9678_failAssert5_add10118() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyList_cf9678_failAssert5_add10118__7 = // MethodCallAdder
writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testEmptyList_cf9678_failAssert5_add10118__7, 0);
            writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_3219 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_3219.testFooEmpty();
            // MethodAssertGenerator build local variable
            Object o_18_0 = (parsedFoos.size()) == (foos.size());
            int i = 0;
            for (Foo f : parsedFoos)
                SerializableObjects.assertEquals(foos.get((i++)), f);
            
            org.junit.Assert.fail("testEmptyList_cf9678 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.TailDelimiterTest#testEmptyList */
    /* amplification of io.protostuff.TailDelimiterTest#testEmptyList_add9614 */
    @org.junit.Test(timeout = 10000)
    public void testEmptyList_add9614_cf9745_failAssert10_literalMutation10537() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            // MethodAssertGenerator build local variable
            Object o_11_1 = 0;
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_11_1, 0);
            // MethodAssertGenerator build local variable
            Object o_7_1 = 0;
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_7_1, 0);
            java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testEmptyList_add9614__5 = // MethodCallAdder
writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            // MethodAssertGenerator build local variable
            Object o_7_0 = o_testEmptyList_add9614__5;
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_7_0, 0);
            // AssertGenerator replace invocation
            int o_testEmptyList_add9614__8 = writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            // MethodAssertGenerator build local variable
            Object o_11_0 = o_testEmptyList_add9614__8;
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_11_0, 0);
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_3243 = (DelimiterTest)null;
            // AssertGenerator add assertion
            org.junit.Assert.assertNull(vc_3243);
            // StatementAdderMethod cloned existing statement
            vc_3243.testFooEmpty();
            // MethodAssertGenerator build local variable
            Object o_24_0 = (parsedFoos.size()) == (foos.size());
            int i = -1;
            for (Foo f : parsedFoos)
                SerializableObjects.assertEquals(foos.get((i++)), f);
            
            org.junit.Assert.fail("testEmptyList_add9614_cf9745 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }

    /* amplification of io.protostuff.TailDelimiterTest#testFoo */
    public void testFoo_literalMutation10577() throws Exception {
        java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
        // AssertGenerator replace invocation
        boolean o_testFoo_literalMutation10577__3 = foos.add(SerializableObjects.foo);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testFoo_literalMutation10577__3);
        // AssertGenerator replace invocation
        boolean o_testFoo_literalMutation10577__4 = foos.add(SerializableObjects.foo);
        // AssertGenerator add assertion
        org.junit.Assert.assertTrue(o_testFoo_literalMutation10577__4);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        // AssertGenerator replace invocation
        int o_testFoo_literalMutation10577__7 = writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
        // AssertGenerator add assertion
        org.junit.Assert.assertEquals(o_testFoo_literalMutation10577__7, 509);
        byte[] data = out.toByteArray();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
        junit.framework.TestCase.assertTrue(((parsedFoos.size()) == (foos.size())));
        int i = 0;
        for (Foo f : parsedFoos)
            SerializableObjects.assertEquals(foos.get((i++)), f);
        
    }

    /* amplification of io.protostuff.TailDelimiterTest#testFoo */
    /* amplification of io.protostuff.TailDelimiterTest#testFoo_cf10639 */
    @org.junit.Test(timeout = 10000)
    public void testFoo_cf10639_failAssert10_add10996() throws Exception {
        // AssertGenerator generate try/catch block with fail statement
        try {
            java.util.ArrayList<Foo> foos = new java.util.ArrayList<Foo>();
            foos.add(SerializableObjects.foo);
            foos.add(SerializableObjects.foo);
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            // AssertGenerator replace invocation
            int o_testFoo_cf10639_failAssert10_add10996__9 = // MethodCallAdder
writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            // AssertGenerator add assertion
            org.junit.Assert.assertEquals(o_testFoo_cf10639_failAssert10_add10996__9, 509);
            writeListTo(out, foos, SerializableObjects.foo.cachedSchema());
            byte[] data = out.toByteArray();
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
            java.util.List<Foo> parsedFoos = parseListFrom(in, SerializableObjects.foo.cachedSchema());
            // StatementAdderOnAssert create null value
            DelimiterTest vc_3509 = (DelimiterTest)null;
            // StatementAdderMethod cloned existing statement
            vc_3509.testFooTooLarge();
            // MethodAssertGenerator build local variable
            Object o_20_0 = (parsedFoos.size()) == (foos.size());
            int i = 0;
            for (Foo f : parsedFoos)
                SerializableObjects.assertEquals(foos.get((i++)), f);
            
            org.junit.Assert.fail("testFoo_cf10639 should have thrown NullPointerException");
        } catch (NullPointerException eee) {
        }
    }
}

