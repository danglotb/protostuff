/*
 * This file was automatically generated by EvoSuite
 * Fri Apr 14 11:39:43 GMT 2017
 */

package io.protostuff;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import static org.evosuite.runtime.EvoAssertions.*;
import io.protostuff.CodedInput;
import io.protostuff.GraphByteArrayInput;
import io.protostuff.GraphCodedInput;
import io.protostuff.Schema;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.PipedInputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class GraphCodedInput_ESTest extends GraphCodedInput_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      byte[] byteArray0 = new byte[8];
      ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
      DataInputStream dataInputStream0 = new DataInputStream(byteArrayInputStream0);
      CodedInput codedInput0 = new CodedInput(dataInputStream0, true);
      GraphCodedInput graphCodedInput0 = new GraphCodedInput(codedInput0);
      Schema<CodedInput> schema0 = (Schema<CodedInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(schema0).isInitialized(any());
      // Undeclared exception!
      try { 
        graphCodedInput0.mergeObject(codedInput0, schema0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("io.protostuff.GraphCodedInput", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Enumeration<DataInputStream> enumeration0 = (Enumeration<DataInputStream>) mock(Enumeration.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(enumeration0).hasMoreElements();
      SequenceInputStream sequenceInputStream0 = new SequenceInputStream(enumeration0);
      byte[] byteArray0 = new byte[4];
      CodedInput codedInput0 = new CodedInput(sequenceInputStream0, byteArray0, true);
      GraphCodedInput graphCodedInput0 = new GraphCodedInput(codedInput0);
      Schema<GraphByteArrayInput> schema0 = (Schema<GraphByteArrayInput>) mock(Schema.class, new ViolatedAssumptionAnswer());
      int int0 = graphCodedInput0.readFieldNumber(schema0);
      assertEquals(0, int0);
      assertFalse(graphCodedInput0.isCurrentMessageReference());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      PipedInputStream pipedInputStream0 = new PipedInputStream();
      byte[] byteArray0 = new byte[1];
      CodedInput codedInput0 = new CodedInput(pipedInputStream0, byteArray0, (byte)3, 2857, true);
      GraphCodedInput graphCodedInput0 = new GraphCodedInput(codedInput0);
      // Undeclared exception!
      try { 
        graphCodedInput0.updateLast((Object) null, pipedInputStream0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }
}
