/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 13 14:55:04 GMT 2017
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
import io.protostuff.GraphCodedInput;
import io.protostuff.GraphIOUtil;
import io.protostuff.GraphProtostuffOutput;
import io.protostuff.LinkBuffer;
import io.protostuff.LinkedBuffer;
import io.protostuff.LowCopyProtobufOutput;
import io.protostuff.LowCopyProtostuffOutput;
import io.protostuff.ProtobufOutput;
import io.protostuff.ProtostuffOutput;
import io.protostuff.Schema;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PushbackInputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.mock.java.io.MockFileInputStream;
import org.evosuite.runtime.mock.java.io.MockPrintStream;
import org.evosuite.runtime.testdata.EvoSuiteFile;
import org.evosuite.runtime.testdata.FileSystemHandling;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class GraphIOUtil_ESTest extends GraphIOUtil_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      PipedOutputStream pipedOutputStream0 = new PipedOutputStream(pipedInputStream0);
      byte[] byteArray0 = new byte[3];
      byteArray0[0] = (byte)125;
      byteArray0[1] = (byte) (-34);
      byteArray0[2] = (byte) (-95);
      pipedInputStream0.markSupported();
      ByteArrayInput byteArrayInput0 = new ByteArrayInput(byteArray0, (byte) (-95), (byte)125, false);
      Schema<ByteArrayInput> schema0 = (Schema<ByteArrayInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      pipedOutputStream0.flush();
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (-4262), 0);
      LinkedBuffer linkedBuffer1 = new LinkedBuffer(byteArray0, 0, 0, linkedBuffer0);
      GraphIOUtil.writeDelimitedTo((OutputStream) pipedOutputStream0, byteArrayInput0, schema0, linkedBuffer1);
      ProtobufOutput protobufOutput0 = new ProtobufOutput(linkedBuffer1);
      ProtobufOutput protobufOutput1 = protobufOutput0.clear();
      Schema<ProtobufOutput> schema1 = (Schema<ProtobufOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      protobufOutput1.writeString(8, "", false);
      GraphIOUtil.mergeFrom(byteArray0, protobufOutput1, schema1);
      DataInputStream dataInputStream0 = new DataInputStream(pipedInputStream0);
      Schema<DataInputStream> schema2 = (Schema<DataInputStream>) mock(Schema.class, new ViolatedAssumptionAnswer());
      Integer integer0 = new Integer(512);
      Schema<Integer> schema3 = (Schema<Integer>) mock(Schema.class, new ViolatedAssumptionAnswer());
      // Undeclared exception!
      try { 
        GraphIOUtil.optMergeDelimitedFrom((InputStream) pipedInputStream0, integer0, schema3, false, linkedBuffer1);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      byte[] byteArray0 = new byte[8];
      byteArray0[0] = (byte) (-13);
      byteArray0[1] = (byte)1;
      byteArray0[2] = (byte) (-9);
      byteArray0[3] = (byte)0;
      byteArray0[4] = (byte)0;
      byteArray0[5] = (byte) (-48);
      byteArray0[6] = (byte)81;
      byteArray0[7] = (byte) (-1);
      LinkedBuffer linkedBuffer0 = new LinkedBuffer((byte)1);
      LinkedBuffer linkedBuffer1 = new LinkedBuffer(byteArray0, (byte)0, (byte)0, linkedBuffer0);
      LinkedBuffer linkedBuffer2 = new LinkedBuffer(byteArray0, (byte) (-9), linkedBuffer1);
      Schema<LowCopyProtobufOutput> schema0 = (Schema<LowCopyProtobufOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      GraphIOUtil.writeTo(linkedBuffer2, (LowCopyProtobufOutput) null, schema0);
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      Schema<PipedInputStream> schema1 = (Schema<PipedInputStream>) mock(Schema.class, new ViolatedAssumptionAnswer());
      try { 
        GraphIOUtil.mergeDelimitedFrom((InputStream) byteArrayInputStream0, (PipedInputStream) null, schema1);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.
         //
         verifyException("io.protostuff.ProtobufException", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      byte[] byteArray0 = new byte[7];
      byteArray0[4] = (byte)84;
      byteArray0[1] = (byte) (-122);
      byteArray0[2] = (byte)84;
      byteArray0[3] = (byte)84;
      byteArray0[4] = (byte)127;
      byteArray0[5] = (byte)0;
      byteArray0[6] = (byte) (-62);
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      Schema<Integer> schema0 = (Schema<Integer>) mock(Schema.class, new ViolatedAssumptionAnswer());
      int int0 = GraphIOUtil.mergeDelimitedFrom((InputStream) byteArrayInputStream0, (Integer) null, schema0);
      assertEquals(6, byteArrayInputStream0.available());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      byte[] byteArray0 = new byte[8];
      byteArray0[0] = (byte) (-13);
      byteArray0[1] = (byte)1;
      byteArray0[2] = (byte) (-9);
      byteArray0[3] = (byte)0;
      byteArray0[4] = (byte)0;
      byteArray0[5] = (byte) (-48);
      byteArray0[6] = (byte)81;
      byteArray0[7] = (byte) (-1);
      LinkedBuffer linkedBuffer0 = new LinkedBuffer((byte)1);
      LinkedBuffer linkedBuffer1 = new LinkedBuffer(byteArray0, (byte)0, 0, linkedBuffer0);
      LinkedBuffer linkedBuffer2 = new LinkedBuffer(byteArray0, (byte) (-9), linkedBuffer1);
      linkedBuffer2.offset = (int) (byte) (-13);
      Schema<LowCopyProtobufOutput> schema0 = (Schema<LowCopyProtobufOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      // Undeclared exception!
      try { 
        GraphIOUtil.writeTo(linkedBuffer2, (LowCopyProtobufOutput) null, schema0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Schema<GraphCodedInput> schema0 = (Schema<GraphCodedInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      Enumeration<ByteArrayInputStream> enumeration0 = (Enumeration<ByteArrayInputStream>) mock(Enumeration.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(enumeration0).hasMoreElements();
      SequenceInputStream sequenceInputStream0 = new SequenceInputStream(enumeration0);
      sequenceInputStream0.available();
      GraphProtostuffOutput graphProtostuffOutput0 = new GraphProtostuffOutput((ProtostuffOutput) null, (byte)0);
      Schema<GraphProtostuffOutput> schema1 = (Schema<GraphProtostuffOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      try { 
        GraphIOUtil.mergeDelimitedFrom((InputStream) sequenceInputStream0, graphProtostuffOutput0, schema1);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.
         //
         verifyException("io.protostuff.ProtobufException", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      byte[] byteArray0 = new byte[7];
      byteArray0[1] = (byte)5;
      byteArray0[2] = (byte)0;
      byteArray0[3] = (byte) (-50);
      byteArray0[4] = (byte)60;
      byteArray0[5] = (byte) (-1);
      byteArray0[6] = (byte)56;
      Schema<FilterInputStream> schema0 = (Schema<FilterInputStream>) mock(Schema.class, new ViolatedAssumptionAnswer());
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (byte)0, (byte) (-50));
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      Schema<String> schema1 = (Schema<String>) mock(Schema.class, new ViolatedAssumptionAnswer());
      // Undeclared exception!
      try { 
        GraphIOUtil.optWriteDelimitedTo((OutputStream) byteArrayOutputStream0, "&Nb+dS%mZkR", schema1, linkedBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream(28);
      PipedOutputStream pipedOutputStream0 = new PipedOutputStream(pipedInputStream0);
      DataOutputStream dataOutputStream0 = new DataOutputStream(pipedOutputStream0);
      ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(dataOutputStream0);
      byte[] byteArray0 = new byte[8];
      byteArray0[0] = (byte)16;
      byteArray0[1] = (byte) (-128);
      byteArray0[2] = (byte)7;
      byteArray0[3] = (byte) (-87);
      byteArray0[4] = (byte)8;
      byteArray0[5] = (byte) (-36);
      byteArray0[6] = (byte)127;
      byteArray0[7] = (byte)6;
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0, 1, (byte) (-87));
      Schema<ByteArrayInputStream> schema0 = (Schema<ByteArrayInputStream>) mock(Schema.class, new ViolatedAssumptionAnswer());
      GraphIOUtil.writeDelimitedTo((DataOutput) objectOutputStream0, byteArrayInputStream0, schema0);
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, 6, 4096);
      LinkedBuffer linkedBuffer1 = new LinkedBuffer(linkedBuffer0, linkedBuffer0);
      LinkedBuffer linkedBuffer2 = new LinkedBuffer((byte)8, linkedBuffer1);
      CodedInput codedInput0 = CodedInput.newInstance((InputStream) byteArrayInputStream0);
      try { 
        codedInput0.readRawVarint64();
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.
         //
         verifyException("io.protostuff.ProtobufException", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      FileSystemHandling.createFolder((EvoSuiteFile) null);
      Schema<ByteArrayInput> schema0 = (Schema<ByteArrayInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      LinkedBuffer linkedBuffer0 = new LinkedBuffer((byte[]) null, (-1279), 1);
      // Undeclared exception!
      try { 
        GraphIOUtil.writeDelimitedTo((OutputStream) null, (ByteArrayInput) null, schema0, linkedBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      FileDescriptor fileDescriptor0 = new FileDescriptor();
      MockFileInputStream mockFileInputStream0 = new MockFileInputStream(fileDescriptor0);
      BufferedInputStream bufferedInputStream0 = new BufferedInputStream(mockFileInputStream0, 1554);
      byte[] byteArray0 = new byte[9];
      byteArray0[0] = (byte)0;
      byteArray0[1] = (byte)0;
      byteArray0[2] = (byte) (-15);
      byteArray0[3] = (byte) (-69);
      byteArray0[4] = (byte) (-125);
      byteArray0[5] = (byte)0;
      byteArray0[6] = (byte)11;
      byteArray0[7] = (byte)56;
      byteArray0[8] = (byte)99;
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, 3199, (byte) (-125));
      // Undeclared exception!
      try { 
        GraphIOUtil.optMergeDelimitedFrom((InputStream) bufferedInputStream0, mockFileInputStream0, (Schema<MockFileInputStream>) null, linkedBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream(3450);
      PipedOutputStream pipedOutputStream0 = new PipedOutputStream(pipedInputStream0);
      Schema<ProtostuffOutput> schema0 = (Schema<ProtostuffOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      byte[] byteArray0 = new byte[9];
      byteArray0[0] = (byte)0;
      byteArray0[1] = (byte)0;
      byteArray0[2] = (byte)0;
      byteArray0[3] = (byte) (-104);
      byteArray0[4] = (byte) (-95);
      byteArray0[5] = (byte)5;
      byteArray0[6] = (byte)0;
      byteArray0[7] = (byte) (-5);
      byteArray0[8] = (byte) (-60);
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, 0, (-1636));
      LinkedBuffer linkedBuffer1 = new LinkedBuffer(byteArray0, (-105), (-1636), linkedBuffer0);
      LinkedBuffer linkedBuffer2 = new LinkedBuffer(4, linkedBuffer1);
      int int0 = GraphIOUtil.writeTo((OutputStream) pipedOutputStream0, (ProtostuffOutput) null, schema0, linkedBuffer2);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      LinkBuffer linkBuffer0 = new LinkBuffer();
      LinkBuffer linkBuffer1 = linkBuffer0.writeVarInt32((-2248));
      LinkBuffer linkBuffer2 = linkBuffer1.writeByte((byte)28);
      LowCopyProtostuffOutput lowCopyProtostuffOutput0 = new LowCopyProtostuffOutput(linkBuffer2);
      Schema<LowCopyProtostuffOutput> schema0 = (Schema<LowCopyProtostuffOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      GraphIOUtil.mergeFrom((InputStream) null, lowCopyProtostuffOutput0, schema0);
      MockPrintStream mockPrintStream0 = null;
      try {
        mockPrintStream0 = new MockPrintStream((File) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.io.File", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Enumeration<MockFileInputStream> enumeration0 = (Enumeration<MockFileInputStream>) mock(Enumeration.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(enumeration0).hasMoreElements();
      SequenceInputStream sequenceInputStream0 = new SequenceInputStream(enumeration0);
      LowCopyProtostuffOutput lowCopyProtostuffOutput0 = new LowCopyProtostuffOutput((LinkBuffer) null);
      Schema<LowCopyProtostuffOutput> schema0 = (Schema<LowCopyProtostuffOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      try { 
        GraphIOUtil.mergeDelimitedFrom((InputStream) sequenceInputStream0, lowCopyProtostuffOutput0, schema0, (LinkedBuffer) null);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.
         //
         verifyException("io.protostuff.ProtobufException", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      LinkedBuffer linkedBuffer0 = new LinkedBuffer((byte[]) null, (-771));
      LinkedBuffer linkedBuffer1 = new LinkedBuffer(linkedBuffer0, linkedBuffer0);
      LinkedBuffer linkedBuffer2 = new LinkedBuffer((byte[]) null, (-900), 590, linkedBuffer1);
      Integer integer0 = new Integer(0);
      Schema<Integer> schema0 = (Schema<Integer>) mock(Schema.class, new ViolatedAssumptionAnswer());
      // Undeclared exception!
      try { 
        GraphIOUtil.writeTo(linkedBuffer2, integer0, schema0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Schema<String> schema0 = (Schema<String>) mock(Schema.class, new ViolatedAssumptionAnswer());
      // Undeclared exception!
      try { 
        GraphIOUtil.writeDelimitedTo((DataOutput) null, "6_BVQRW$:e95", schema0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("io.protostuff.ProtobufOutput", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Integer integer0 = new Integer(2641);
      Schema<Integer> schema0 = (Schema<Integer>) mock(Schema.class, new ViolatedAssumptionAnswer());
      LinkedBuffer linkedBuffer0 = new LinkedBuffer((byte[]) null, (-926), 0);
      LinkedBuffer linkedBuffer1 = new LinkedBuffer((byte[]) null, (-926), 1769, linkedBuffer0);
      // Undeclared exception!
      try { 
        GraphIOUtil.toByteArray(integer0, schema0, linkedBuffer1);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      byte[] byteArray0 = new byte[3];
      byteArray0[0] = (byte)0;
      byteArray0[1] = (byte)0;
      byteArray0[2] = (byte)0;
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, 0, (-1));
      // Undeclared exception!
      try { 
        GraphIOUtil.toByteArray((CodedInput) null, (Schema<CodedInput>) null, linkedBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      Schema<String> schema0 = (Schema<String>) mock(Schema.class, new ViolatedAssumptionAnswer());
      byte[] byteArray0 = new byte[9];
      byteArray0[0] = (byte)0;
      byteArray0[1] = (byte)0;
      byteArray0[2] = (byte) (-102);
      byteArray0[3] = (byte)11;
      byteArray0[4] = (byte) (-128);
      byteArray0[5] = (byte)67;
      byteArray0[6] = (byte)64;
      byteArray0[7] = (byte)0;
      byteArray0[8] = (byte) (-99);
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (byte) (-128), (byte)11);
      // Undeclared exception!
      try { 
        GraphIOUtil.writeTo((OutputStream) byteArrayOutputStream0, "", schema0, linkedBuffer0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      Schema<String> schema0 = (Schema<String>) mock(Schema.class, new ViolatedAssumptionAnswer());
      LinkedBuffer linkedBuffer0 = new LinkedBuffer((byte[]) null, (-1));
      LinkedBuffer linkedBuffer1 = new LinkedBuffer((byte[]) null, (-1), (-191), linkedBuffer0);
      // Undeclared exception!
      try { 
        GraphIOUtil.writeTo((OutputStream) byteArrayOutputStream0, "io.protostuff.GraphProtostuffOutput$IdentityMap", schema0, linkedBuffer1);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Buffer previously used and had not been reset.
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      byteArray0[0] = (byte)0;
      byteArray0[1] = (byte)0;
      byteArray0[2] = (byte)0;
      byteArray0[3] = (byte)58;
      byteArray0[4] = (byte)4;
      byteArray0[5] = (byte) (-95);
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (byte) (-95));
      // Undeclared exception!
      try { 
        GraphIOUtil.toByteArray((Object) null, (Schema<Object>) null, linkedBuffer0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("io.protostuff.GraphIOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      PipedOutputStream pipedOutputStream0 = new PipedOutputStream(pipedInputStream0);
      byte[] byteArray0 = new byte[3];
      byteArray0[0] = (byte)125;
      byteArray0[1] = (byte) (-34);
      byteArray0[2] = (byte) (-95);
      pipedInputStream0.markSupported();
      ByteArrayInput byteArrayInput0 = new ByteArrayInput(byteArray0, (byte) (-95), (byte)125, false);
      Schema<ByteArrayInput> schema0 = (Schema<ByteArrayInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      pipedOutputStream0.flush();
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (-4262), 0);
      LinkedBuffer linkedBuffer1 = new LinkedBuffer(byteArray0, 0, 0, linkedBuffer0);
      GraphIOUtil.writeDelimitedTo((OutputStream) pipedOutputStream0, byteArrayInput0, schema0, linkedBuffer1);
      ProtobufOutput protobufOutput0 = new ProtobufOutput(linkedBuffer1);
      ProtobufOutput protobufOutput1 = protobufOutput0.clear();
      Schema<ProtobufOutput> schema1 = (Schema<ProtobufOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      GraphIOUtil.mergeFrom(byteArray0, protobufOutput1, schema1);
      DataInputStream dataInputStream0 = new DataInputStream(pipedInputStream0);
      Schema<DataInputStream> schema2 = (Schema<DataInputStream>) mock(Schema.class, new ViolatedAssumptionAnswer());
      Integer integer0 = new Integer(512);
      Schema<Integer> schema3 = (Schema<Integer>) mock(Schema.class, new ViolatedAssumptionAnswer());
      GraphIOUtil.optMergeDelimitedFrom((InputStream) pipedInputStream0, integer0, schema3, false, linkedBuffer1);
      // Undeclared exception!
      try {
        GraphIOUtil.writeDelimitedTo((OutputStream) null, dataInputStream0, schema2, protobufOutput1.head);
        fail("Expecting exception: NullPointerException");

      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("io.protostuff.ProtobufOutput", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      byte[] byteArray0 = new byte[7];
      byteArray0[0] = (byte)84;
      byteArray0[1] = (byte) (-122);
      byteArray0[2] = (byte) (-20);
      byteArray0[3] = (byte)0;
      byteArray0[4] = (byte)121;
      byteArray0[5] = (byte)0;
      byteArray0[6] = (byte) (-62);
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      byteArrayInputStream0.reset();
      Schema<Integer> schema0 = (Schema<Integer>) mock(Schema.class, new ViolatedAssumptionAnswer());
      try { 
        GraphIOUtil.mergeDelimitedFrom((InputStream) byteArrayInputStream0, (Integer) null, schema0);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.
         //
         verifyException("io.protostuff.ProtobufException", e);
      }
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      PushbackInputStream pushbackInputStream0 = new PushbackInputStream((InputStream) null);
      Integer integer0 = new Integer(1221);
      Schema<Integer> schema0 = (Schema<Integer>) mock(Schema.class, new ViolatedAssumptionAnswer());
      byte[] byteArray0 = new byte[9];
      byteArray0[0] = (byte)6;
      byteArray0[1] = (byte) (-1);
      byteArray0[2] = (byte) (-1);
      byteArray0[3] = (byte) (-37);
      byteArray0[4] = (byte) (-24);
      byteArray0[5] = (byte) (-1);
      byteArray0[6] = (byte)36;
      byteArray0[7] = (byte) (-23);
      byteArray0[8] = (byte)0;
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (byte) (-1));
      LinkedBuffer linkedBuffer1 = new LinkedBuffer(0, linkedBuffer0);
      try { 
        GraphIOUtil.optMergeDelimitedFrom((InputStream) pushbackInputStream0, integer0, schema0, linkedBuffer1);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Stream closed
         //
         verifyException("java.io.PushbackInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      byte[] byteArray0 = new byte[8];
      byteArray0[0] = (byte) (-13);
      byteArray0[1] = (byte)1;
      byteArray0[2] = (byte) (-9);
      byteArray0[3] = (byte)0;
      byteArray0[4] = (byte)0;
      byteArray0[5] = (byte) (-48);
      byteArray0[6] = (byte)81;
      byteArray0[7] = (byte) (-1);
      LinkedBuffer linkedBuffer0 = new LinkedBuffer((byte)1);
      LinkedBuffer linkedBuffer1 = new LinkedBuffer((byte)0, linkedBuffer0);
      LinkedBuffer linkedBuffer2 = new LinkedBuffer(byteArray0, (byte) (-9), linkedBuffer1);
      Schema<LowCopyProtobufOutput> schema0 = (Schema<LowCopyProtobufOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      GraphIOUtil.writeTo(linkedBuffer2, (LowCopyProtobufOutput) null, schema0);
      PipedOutputStream pipedOutputStream0 = new PipedOutputStream();
      CodedInput codedInput0 = new CodedInput(byteArray0, (-351), (byte) (-13), false);
      Schema<CodedInput> schema1 = (Schema<CodedInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      // Undeclared exception!
      try { 
        GraphIOUtil.optWriteDelimitedTo((OutputStream) pipedOutputStream0, codedInput0, schema1, linkedBuffer1);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 4
         //
         verifyException("io.protostuff.IOUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      FileDescriptor fileDescriptor0 = new FileDescriptor();
      MockFileInputStream mockFileInputStream0 = new MockFileInputStream(fileDescriptor0);
      PushbackInputStream pushbackInputStream0 = new PushbackInputStream(mockFileInputStream0, 477);
      Integer integer0 = new Integer((-2064));
      Schema<Integer> schema0 = (Schema<Integer>) mock(Schema.class, new ViolatedAssumptionAnswer());
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(580);
      LinkedBuffer linkedBuffer1 = new LinkedBuffer((byte[]) null, 580, linkedBuffer0);
      LinkedBuffer linkedBuffer2 = new LinkedBuffer(linkedBuffer1, linkedBuffer0);
      GraphIOUtil.mergeFrom((InputStream) pushbackInputStream0, integer0, schema0, linkedBuffer2);
      assertNotSame(linkedBuffer2, linkedBuffer1);
  }

}
