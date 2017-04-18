

package io.protostuff;


/**
 * From https://groups.google.com/forum/#!topic/protostuff/D7Bb1REf8pQ (Anil Pandge)
 */
public class AmplCodedDataInputTest extends junit.framework.TestCase {
    public static void main(String[] args) {
        try {
            SampleClass _clazz = new SampleClass();
            java.util.List<String> testStrings = new java.util.ArrayList<String>();
            for (int i = 0; i < 1800; i++) {
                String test = new String(("TestingString" + i));
                testStrings.add(test);
                try {
                    _clazz.setTestStringList(testStrings);
                    byte[] serialize = AmplCodedDataInputTest.serialize(_clazz);
                    System.out.println(("Payload Size = " + (serialize.length)));
                    SampleClass deserialize = AmplCodedDataInputTest.deserialize(serialize);
                    System.out.println(deserialize.getTestStringList().get(i));
                } catch (Exception ex) {
                    System.out.println("Failed");
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void testIt() throws Exception {
        SampleClass _clazz = new SampleClass();
        java.util.List<String> testStrings = new java.util.ArrayList<String>();
        for (int i = 0; i < 1800; i++) {
            String test = new String(("TestingString" + i));
            testStrings.add(test);
            _clazz.setTestStringList(testStrings);
            byte[] serialize = AmplCodedDataInputTest.serialize(_clazz);
            junit.framework.TestCase.assertNotNull(AmplCodedDataInputTest.deserialize(serialize));
        }
    }

    private static byte[] serialize(final SampleClass t) throws Exception {
        java.io.ObjectOutputStream oos = null;
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        try {
            oos = new java.io.ObjectOutputStream(baos);
            t.writeExternal(oos);
        } catch (java.io.IOException e) {
            throw new Exception(e);
        } finally {
            AmplCodedDataInputTest.tryClose(oos);
        }
        return baos.toByteArray();
    }

    private static SampleClass deserialize(final byte[] bytes) throws Exception {
        final SampleClass t = new SampleClass();
        java.io.ObjectInputStream ois = null;
        try {
            ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bytes));
            t.readExternal(ois);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AmplCodedDataInputTest.tryClose(ois);
        }
        return t;
    }

    private static void tryClose(java.io.Closeable closeable) throws Exception {
        try {
            closeable.close();
        } catch (java.io.IOException e) {
            throw new Exception(e);
        }
    }
}

