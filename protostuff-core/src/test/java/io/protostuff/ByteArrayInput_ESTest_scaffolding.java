/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Fri Apr 14 11:33:17 GMT 2017
 */

package io.protostuff;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.evosuite.shaded.org.mockito.Mockito.*;
@EvoSuiteClassExclude
public class ByteArrayInput_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) System.getProperties().clone();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "io.protostuff.ByteArrayInput"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    System.setProperties((java.util.Properties) defaultProperties.clone());
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    System.setProperties((java.util.Properties) defaultProperties.clone());
    System.setProperty("os.name", "Linux");
    System.setProperty("java.awt.headless", "true");
    System.setProperty("user.home", "/home/spirals/danglot");
    System.setProperty("java.home", "/home/spirals/danglot/jdk1.8.0_121/jre");
    System.setProperty("user.dir", "/tmp/dspot-experiments/dataset/protostuff/protostuff-core");
    System.setProperty("java.io.tmpdir", "/tmp");
    System.setProperty("line.separator", "\n");
    System.setProperty("java.specification.version", "1.8");
    System.setProperty("awt.toolkit", "sun.awt.X11.XToolkit");
    System.setProperty("file.encoding", "ANSI_X3.4-1968");
    System.setProperty("file.separator", "/");
    System.setProperty("java.awt.graphicsenv", "sun.awt.X11GraphicsEnvironment");
    System.setProperty("java.awt.printerjob", "sun.print.PSPrinterJob");
    System.setProperty("java.class.path", "/tmp/EvoSuite_pathingJar8385914833791385879.jar");
    System.setProperty("java.class.version", "52.0");
    System.setProperty("java.endorsed.dirs", "/home/spirals/danglot/jdk1.8.0_121/jre/lib/endorsed");
    System.setProperty("java.ext.dirs", "/home/spirals/danglot/jdk1.8.0_121/jre/lib/ext:/usr/java/packages/lib/ext");
    System.setProperty("java.library.path", "lib");
    System.setProperty("java.runtime.name", "Java(TM) SE Runtime Environment");
    System.setProperty("java.runtime.version", "1.8.0_121-b13");
    System.setProperty("java.specification.name", "Java Platform API Specification");
    System.setProperty("java.specification.vendor", "Oracle Corporation");
    System.setProperty("java.vendor", "Oracle Corporation");
    System.setProperty("java.vendor.url", "http://java.oracle.com/");
    System.setProperty("java.version", "1.8.0_121");
    System.setProperty("java.vm.info", "mixed mode");
    System.setProperty("java.vm.name", "Java HotSpot(TM) 64-Bit Server VM");
    System.setProperty("java.vm.specification.name", "Java Virtual Machine Specification");
    System.setProperty("java.vm.specification.vendor", "Oracle Corporation");
    System.setProperty("java.vm.specification.version", "1.8");
    System.setProperty("java.vm.vendor", "Oracle Corporation");
    System.setProperty("java.vm.version", "25.121-b13");
    System.setProperty("os.arch", "amd64");
    System.setProperty("os.version", "3.16.0-4-amd64");
    System.setProperty("path.separator", ":");
    System.setProperty("user.country", "US");
    System.setProperty("user.language", "en");
    System.setProperty("user.name", "danglot");
    System.setProperty("user.timezone", "Europe/Paris");
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(ByteArrayInput_ESTest_scaffolding.class.getClassLoader() ,
      "io.protostuff.FilterInput",
      "io.protostuff.WireFormat",
      "io.protostuff.Output",
      "io.protostuff.FilterOutput",
      "io.protostuff.GraphByteArrayInput",
      "io.protostuff.CodedInput",
      "io.protostuff.GraphInput",
      "io.protostuff.Schema",
      "io.protostuff.ProtobufOutput",
      "io.protostuff.LowCopyProtostuffOutput",
      "io.protostuff.LowCopyProtobufOutput",
      "io.protostuff.GraphProtostuffOutput",
      "io.protostuff.StringSerializer$STRING",
      "io.protostuff.LinkBuffer",
      "io.protostuff.GraphProtostuffOutput$IdentityMap",
      "io.protostuff.Input",
      "io.protostuff.UninitializedMessageException",
      "io.protostuff.ProtostuffException",
      "io.protostuff.WriteSink$1",
      "io.protostuff.WriteSink$2",
      "io.protostuff.LinkedBuffer",
      "io.protostuff.WriteSession",
      "io.protostuff.StringSerializer",
      "io.protostuff.ByteArrayInput",
      "io.protostuff.WriteSession$FlushHandler",
      "io.protostuff.GraphCodedInput",
      "io.protostuff.WriteSink",
      "io.protostuff.ProtobufException",
      "io.protostuff.ProtostuffOutput",
      "io.protostuff.ByteString"
    );
  } 
  @BeforeClass 
  public static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("io.protostuff.Schema", false, ByteArrayInput_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(ByteArrayInput_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "io.protostuff.StringSerializer$STRING",
      "io.protostuff.ByteString",
      "io.protostuff.WireFormat",
      "io.protostuff.ProtostuffException",
      "io.protostuff.ProtobufException",
      "io.protostuff.LinkedBuffer",
      "io.protostuff.LinkBuffer",
      "io.protostuff.WriteSession",
      "io.protostuff.ProtobufOutput",
      "io.protostuff.WriteSink$1",
      "io.protostuff.WriteSink$2",
      "io.protostuff.WriteSink",
      "io.protostuff.GraphProtostuffOutput$IdentityMap",
      "io.protostuff.UninitializedMessageException",
      "io.protostuff.CodedInput",
      "io.protostuff.GraphCodedInput",
      "io.protostuff.GraphByteArrayInput",
      "io.protostuff.StringSerializer"
    );
  }
}
