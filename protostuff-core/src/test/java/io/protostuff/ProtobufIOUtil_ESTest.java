/*
 * This file was automatically generated by EvoSuite
 * Fri Apr 14 11:46:31 GMT 2017
 */

package io.protostuff;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import static org.evosuite.runtime.EvoAssertions.*;
import io.protostuff.ByteArrayInput;
import io.protostuff.CodedInput;
import io.protostuff.LinkedBuffer;
import io.protostuff.LowCopyProtostuffOutput;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.ProtobufOutput;
import io.protostuff.ProtostuffOutput;
import io.protostuff.Schema;
import java.io.DataOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.mock.java.io.MockFile;
import org.evosuite.runtime.mock.java.io.MockPrintStream;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ProtobufIOUtil_ESTest extends ProtobufIOUtil_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MockPrintStream mockPrintStream0 = new MockPrintStream("qXxDt1C)Oo^TKrg2%");
      Integer integer0 = new Integer(45);
      Schema<Integer> schema0 = (Schema<Integer>) mock(Schema.class, new ViolatedAssumptionAnswer());
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(45);
      int int0 = ProtobufIOUtil.optWriteDelimitedTo((OutputStream) mockPrintStream0, integer0, schema0, linkedBuffer0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      PipedOutputStream pipedOutputStream0 = new PipedOutputStream();
      LinkedList<ByteArrayInput> linkedList0 = new LinkedList<ByteArrayInput>();
      Schema<ByteArrayInput> schema0 = (Schema<ByteArrayInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      byte[] byteArray0 = new byte[7];
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, 0);
      int int0 = ProtobufIOUtil.writeListTo((OutputStream) pipedOutputStream0, (List<ByteArrayInput>) linkedList0, schema0, linkedBuffer0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      byte[] byteArray0 = new byte[8];
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (-5240), (byte)5);
      ProtobufOutput protobufOutput0 = new ProtobufOutput(linkedBuffer0, (byte) (-90));
      LinkedList<ProtostuffOutput> linkedList0 = new LinkedList<ProtostuffOutput>();
      // Undeclared exception!
      try { 
        ProtobufIOUtil.writeListTo((OutputStream) null, (List<ProtostuffOutput>) linkedList0, (Schema<ProtostuffOutput>) null, protobufOutput0.head);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.ProtobufIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      PipedOutputStream pipedOutputStream0 = new PipedOutputStream();
      MockPrintStream mockPrintStream0 = new MockPrintStream(pipedOutputStream0, false);
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(mockPrintStream0);
      byte[] byteArray0 = new byte[2];
      CodedInput codedInput0 = CodedInput.newInstance(byteArray0);
      Schema<CodedInput> schema0 = (Schema<CodedInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      int int0 = ProtobufIOUtil.writeDelimitedTo((DataOutput) objectOutputStream0, codedInput0, schema0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      MockFile mockFile0 = new MockFile("<wJ`n,El,qZ%", "<wJ`n,El,qZ%");
      MockPrintStream mockPrintStream0 = new MockPrintStream(mockFile0);
      byte[] byteArray0 = new byte[0];
      ByteArrayInput byteArrayInput0 = new ByteArrayInput(byteArray0, 2608, 2608, false);
      Schema<ByteArrayInput> schema0 = (Schema<ByteArrayInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (-3102));
      int int0 = ProtobufIOUtil.writeDelimitedTo((OutputStream) mockPrintStream0, byteArrayInput0, schema0, linkedBuffer0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      MockPrintStream mockPrintStream0 = new MockPrintStream("2s|!J6_4^5;c 1=*UVk");
      LowCopyProtostuffOutput lowCopyProtostuffOutput0 = new LowCopyProtostuffOutput();
      Schema<LowCopyProtostuffOutput> schema0 = (Schema<LowCopyProtostuffOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      byte[] byteArray0 = new byte[0];
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, 256, 14);
      // Undeclared exception!
      try { 
        ProtobufIOUtil.writeTo((OutputStream) mockPrintStream0, lowCopyProtostuffOutput0, schema0, linkedBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.ProtobufIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      byte[] byteArray0 = new byte[3];
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (byte) (-128), 0);
      ByteArrayInput byteArrayInput0 = new ByteArrayInput(byteArray0, 256, 0, false);
      Schema<ByteArrayInput> schema0 = (Schema<ByteArrayInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      // Undeclared exception!
      try { 
        ProtobufIOUtil.writeTo(linkedBuffer0, byteArrayInput0, schema0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.ProtobufIOUtil", e);
      }
  }
}
