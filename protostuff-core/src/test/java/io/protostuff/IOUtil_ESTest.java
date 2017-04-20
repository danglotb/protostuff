/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 20 09:58:04 GMT 2017
 */

package io.protostuff;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import static org.evosuite.runtime.EvoAssertions.*;
import io.protostuff.ByteArrayInput;
import io.protostuff.CodedInput;
import io.protostuff.GraphByteArrayInput;
import io.protostuff.IOUtil;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufOutput;
import io.protostuff.Schema;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class IOUtil_ESTest extends IOUtil_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      // Undeclared exception!
      try { 
        IOUtil.putVarInt32AndGetOffset(884, byteArray0, 0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 4
         //
         verifyException("io.protostuff.IOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      int int0 = IOUtil.putVarInt32AndGetOffset(74, byteArray0, (byte)0);
      assertArrayEquals(new byte[] {(byte)0, (byte)0, (byte)0, (byte)0, (byte)74, (byte)0}, byteArray0);
      assertEquals(4, int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      byte[] byteArray0 = new byte[8];
      int int0 = IOUtil.putVarInt32AndGetOffset(256, byteArray0, (byte)3);
      assertArrayEquals(new byte[] {(byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte) (-128), (byte)2}, byteArray0);
      assertEquals(6, int0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      byteArray0[0] = (byte) (-13);
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      BufferedInputStream bufferedInputStream0 = new BufferedInputStream(byteArrayInputStream0);
      Schema<CodedInput> schema0 = (Schema<CodedInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      try { 
        IOUtil.mergeDelimitedFrom((InputStream) bufferedInputStream0, (CodedInput) null, schema0, false);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.
         //
         verifyException("io.protostuff.ProtobufException", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      byteArray0[0] = (byte)3;
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      BufferedInputStream bufferedInputStream0 = new BufferedInputStream(byteArrayInputStream0);
      Schema<CodedInput> schema0 = (Schema<CodedInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      int int0 = IOUtil.mergeDelimitedFrom((InputStream) bufferedInputStream0, (CodedInput) null, schema0, false);
      assertEquals(3, int0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (byte)3);
      ProtobufOutput protobufOutput0 = new ProtobufOutput(linkedBuffer0, 3);
      Schema<ProtobufOutput> schema0 = (Schema<ProtobufOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      int int0 = IOUtil.mergeDelimitedFrom((InputStream) byteArrayInputStream0, protobufOutput0, schema0, true);
      assertEquals(3, byteArrayInputStream0.available());
      assertEquals(0, int0);
  }

}
