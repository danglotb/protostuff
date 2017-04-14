/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 13 15:10:51 GMT 2017
 */

package io.protostuff;

import org.evosuite.shaded.org.mockito.Matchers;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import static org.evosuite.runtime.EvoAssertions.*;
import io.protostuff.ByteArrayInput;
import io.protostuff.ByteBufferInput;
import io.protostuff.ByteString;
import io.protostuff.FilterOutput;
import io.protostuff.GraphProtostuffOutput;
import io.protostuff.LinkedBuffer;
import io.protostuff.LowCopyProtobufOutput;
import io.protostuff.ProtostuffOutput;
import io.protostuff.Schema;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class ByteBufferInput_ESTest extends ByteBufferInput_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      byte[] byteArray0 = new byte[8];
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteString0.EMPTY_BYTE_ARRAY, (-1), (byte)0);
      ProtostuffOutput protostuffOutput0 = new ProtostuffOutput(linkedBuffer0);
      GraphProtostuffOutput graphProtostuffOutput0 = new GraphProtostuffOutput(protostuffOutput0);
      FilterOutput<GraphProtostuffOutput> filterOutput0 = new FilterOutput<GraphProtostuffOutput>(graphProtostuffOutput0);
      byteBufferInput0.transferByteRangeTo(filterOutput0, true, 619, true);
      assertEquals(3, protostuffOutput0.getSize());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      ByteString byteString0 = ByteString.copyFromUtf8("0_s2?>;_=94|");
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      byteBufferInput0.readTag();
      long long0 = byteBufferInput0.readRawLittleEndian64();
      assertEquals(48, byteBufferInput0.getLastTag());
      assertEquals(4422318497635398495L, long0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      ByteString byteString0 = ByteString.copyFromUtf8("io.protostuff.ProtobufOutput");
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      double double0 = byteBufferInput0.readDouble();
      assertTrue(byteBufferInput0.decodeNestedMessageAsGroup);
      assertEquals(7.745662836135993E228, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      byteArray0[3] = (byte) (-57);
      ByteString byteString0 = ByteString.copyFrom(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      int int0 = byteBufferInput0.readSFixed32();
      assertEquals((-956301312), int0);
      assertFalse(byteBufferInput0.decodeNestedMessageAsGroup);
      assertEquals(0, byteBufferInput0.getLastTag());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      byteArray0[2] = (byte) (-59);
      ByteString byteString0 = ByteString.copyFrom(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      int int0 = byteBufferInput0.readSFixed32();
      assertFalse(byteBufferInput0.decodeNestedMessageAsGroup);
      assertEquals(12910592, int0);
      assertEquals(0, byteBufferInput0.getLastTag());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      byteArray0[0] = (byte)40;
      byteArray0[2] = (byte) (-59);
      ByteString byteString0 = ByteString.copyFrom(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      Schema<GraphProtostuffOutput> schema0 = (Schema<GraphProtostuffOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      byteBufferInput0.readFieldNumber(schema0);
      int int0 = byteBufferInput0.readSFixed32();
      assertEquals(40, byteBufferInput0.getLastTag());
      assertEquals(50432, int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      byteArray0[4] = (byte)50;
      ByteString byteString0 = ByteString.copyFrom(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      int int0 = byteBufferInput0.readSFixed32();
      assertEquals(0, int0);
      
      byteBufferInput0.readRawVarint32();
      assertFalse(byteBufferInput0.decodeNestedMessageAsGroup);
      assertEquals(0, byteBufferInput0.getLastTag());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      byteArray0[0] = (byte) (-91);
      byteArray0[1] = (byte) (-128);
      byteArray0[2] = (byte)127;
      byteArray0[3] = (byte) (-21);
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      long long0 = byteBufferInput0.readSInt64();
      assertEquals(0, byteBufferInput0.getLastTag());
      assertTrue(byteBufferInput0.decodeNestedMessageAsGroup);
      assertEquals((-1040403L), long0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      byte[] byteArray0 = new byte[5];
      byteArray0[0] = (byte)88;
      byteArray0[1] = (byte) (-89);
      byteArray0[2] = (byte) (-128);
      byteArray0[3] = (byte) (-21);
      byteArray0[4] = (byte) (-21);
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      // Undeclared exception!
      try { 
        byteBufferInput0.skipMessage();
        fail("Expecting exception: BufferUnderflowException");
      
      } catch(BufferUnderflowException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.nio.Buffer", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      byte[] byteArray0 = new byte[5];
      byteArray0[0] = (byte)88;
      byteArray0[1] = (byte) (-113);
      byteArray0[2] = (byte) (-116);
      byteArray0[3] = (byte)19;
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      try { 
        byteBufferInput0.skipMessage();
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Protocol message contained an invalid tag (zero).
         //
         verifyException("io.protostuff.ProtobufException", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      byte[] byteArray0 = new byte[5];
      byteArray0[0] = (byte)88;
      byteArray0[1] = (byte) (-113);
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      try { 
        byteBufferInput0.skipMessage();
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Protocol message contained an invalid tag (zero).
         //
         verifyException("io.protostuff.ProtobufException", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      byte[] byteArray0 = new byte[8];
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      LinkedBuffer linkedBuffer0 = new LinkedBuffer(byteArray0, (-1), (byte)45);
      ProtostuffOutput protostuffOutput0 = new ProtostuffOutput(linkedBuffer0);
      Schema<ProtostuffOutput> schema0 = (Schema<ProtostuffOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(schema0).isInitialized(Matchers.<ProtostuffOutput>any());
      // Undeclared exception!
      try { 
        byteBufferInput0.mergeObject(protostuffOutput0, schema0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("io.protostuff.ByteBufferInput", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      ByteString byteString0 = ByteString.copyFrom(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      LowCopyProtobufOutput lowCopyProtobufOutput0 = new LowCopyProtobufOutput();
      Schema<LowCopyProtobufOutput> schema0 = (Schema<LowCopyProtobufOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(schema0).isInitialized(Matchers.<LowCopyProtobufOutput>any());
      // Undeclared exception!
      try { 
        byteBufferInput0.mergeObject(lowCopyProtobufOutput0, schema0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("io.protostuff.ByteBufferInput", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      byte[] byteArray0 = new byte[8];
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      ByteBuffer byteBuffer1 = byteBufferInput0.readByteBuffer();
      assertEquals(0, byteBufferInput0.getLastTag());
      assertTrue(byteBufferInput0.decodeNestedMessageAsGroup);
      assertFalse(byteBuffer1.hasRemaining());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      byte[] byteArray0 = new byte[8];
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      String string0 = byteBufferInput0.readString();
      assertEquals("", string0);
      assertEquals(0, byteBufferInput0.getLastTag());
      assertTrue(byteBufferInput0.decodeNestedMessageAsGroup);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      byteArray0[0] = (byte) (-91);
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      long long0 = byteBufferInput0.readSInt64();
      assertEquals((-19L), long0);
      assertEquals(0, byteBufferInput0.getLastTag());
      assertTrue(byteBufferInput0.decodeNestedMessageAsGroup);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      byte[] byteArray0 = new byte[5];
      byteArray0[0] = (byte)88;
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      long long0 = byteBufferInput0.readSInt64();
      assertEquals(44L, long0);
      assertTrue(byteBufferInput0.decodeNestedMessageAsGroup);
      assertEquals(0, byteBufferInput0.getLastTag());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      ByteString byteString0 = ByteString.copyFromUtf8("EZID6");
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      int int0 = byteBufferInput0.readSInt32();
      assertFalse(byteBufferInput0.decodeNestedMessageAsGroup);
      assertEquals(0, byteBufferInput0.getLastTag());
      assertEquals((-35), int0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      byte[] byteArray0 = new byte[5];
      byteArray0[2] = (byte) (-128);
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      int int0 = byteBufferInput0.readSInt32();
      assertEquals(0, int0);
      
      long long0 = byteBufferInput0.readRawVarint64();
      assertEquals(0L, long0);
      
      boolean boolean0 = byteBufferInput0.readBool();
      assertFalse(byteBufferInput0.decodeNestedMessageAsGroup);
      assertTrue(boolean0);
      assertEquals(0, byteBufferInput0.getLastTag());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      ByteString byteString0 = ByteString.copyFromUtf8("EZID6");
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      boolean boolean0 = byteBufferInput0.readBool();
      assertEquals(0, byteBufferInput0.getLastTag());
      assertTrue(boolean0);
      assertFalse(byteBufferInput0.decodeNestedMessageAsGroup);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      boolean boolean0 = byteBufferInput0.readBool();
      assertFalse(boolean0);
      assertTrue(byteBufferInput0.decodeNestedMessageAsGroup);
      assertEquals(0, byteBufferInput0.getLastTag());
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      byteArray0[4] = (byte) (-23);
      ByteString byteString0 = ByteString.copyFrom(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      byteBufferInput0.readSFixed32();
      Schema<ByteArrayInput> schema0 = (Schema<ByteArrayInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      int int0 = byteBufferInput0.readFieldNumber(schema0);
      assertEquals(105, byteBufferInput0.getLastTag());
      assertEquals(13, int0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      byteArray0[0] = (byte)52;
      ByteString byteString0 = ByteString.copyFrom(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      Schema<GraphProtostuffOutput> schema0 = (Schema<GraphProtostuffOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      int int0 = byteBufferInput0.readFieldNumber(schema0);
      assertEquals(0, byteBufferInput0.getLastTag());
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      byte[] byteArray0 = new byte[6];
      byteArray0[0] = (byte)95;
      ByteString byteString0 = ByteString.copyFrom(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, true);
      Schema<GraphProtostuffOutput> schema0 = (Schema<GraphProtostuffOutput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      int int0 = byteBufferInput0.readFieldNumber(schema0);
      assertEquals(95, byteBufferInput0.getLastTag());
      assertEquals(11, int0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      ByteString byteString0 = ByteString.copyFromUtf8("0_s2?>;_=94|");
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      long long0 = byteBufferInput0.readRawLittleEndian64();
      assertEquals(6862146898379366192L, long0);
      
      int int0 = byteBufferInput0.readFixed32();
      assertEquals(2083797309, int0);
      
      Schema<SequenceInputStream> schema0 = (Schema<SequenceInputStream>) mock(Schema.class, new ViolatedAssumptionAnswer());
      byteBufferInput0.readFieldNumber(schema0);
      assertFalse(byteBufferInput0.decodeNestedMessageAsGroup);
      assertEquals(0, byteBufferInput0.getLastTag());
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      byte[] byteArray0 = new byte[3];
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      try { 
        byteBufferInput0.checkLastTagWas((-2054));
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Protocol message end-group tag did not match expected tag.
         //
         verifyException("io.protostuff.ProtobufException", e);
      }
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      byte[] byteArray0 = new byte[5];
      byteArray0[0] = (byte)85;
      ByteString byteString0 = ByteString.wrap(byteArray0);
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      byteBufferInput0.skipMessage();
      assertEquals(0, byteBufferInput0.getLastTag());
      assertFalse(byteBufferInput0.decodeNestedMessageAsGroup);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      ByteString byteString0 = ByteString.bytesDefaultValue("0_s2?>;_=94|");
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      int int0 = byteBufferInput0.getLastTag();
      assertEquals(0, int0);
      assertFalse(byteBufferInput0.decodeNestedMessageAsGroup);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      ByteString byteString0 = ByteString.copyFromUtf8("io.protostuff.cesu8_compat");
      ByteBuffer byteBuffer0 = byteString0.asReadOnlyByteBuffer();
      ByteBufferInput byteBufferInput0 = new ByteBufferInput(byteBuffer0, false);
      byteBufferInput0.skipMessage();
      boolean boolean0 = byteBufferInput0.isCurrentFieldPacked();
      assertEquals(116, byteBufferInput0.getLastTag());
      assertFalse(boolean0);
  }
}
