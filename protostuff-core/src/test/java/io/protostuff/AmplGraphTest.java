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
 * Test ser/deser of graph objects (references and cyclic dependencies).
 *
 * @author David Yu
 * @created Dec 10, 2010
 */
public class AmplGraphTest extends AbstractTest {
    static final int INITIAL_CAPACITY = 32;

    public static <T> byte[] toByteArray(T message, Schema<T> schema) throws java.io.IOException {
        return GraphIOUtil.toByteArray(message, schema, AbstractTest.buf());
    }

    public static <T> void mergeFrom(byte[] data, int offset, int length, T message, Schema<T> schema) throws java.io.IOException {
        GraphIOUtil.mergeFrom(data, offset, length, message, schema);
    }

    public static <T> void mergeFrom(java.io.InputStream in, T message, Schema<T> schema) throws java.io.IOException {
        GraphIOUtil.mergeFrom(in, message, schema);
    }

    public void testReference() throws Exception {
        Foo fooCompare = AmplGraphTest.newFoo();
        // verify
        AmplGraphTest.checkReference(fooCompare);
        byte[] data = AmplGraphTest.toByteArray(fooCompare, Foo.getSchema());
        // from byte array
        Foo fooFromByteArray = new Foo();
        AmplGraphTest.mergeFrom(data, 0, data.length, fooFromByteArray, Foo.getSchema());
        SerializableObjects.assertEquals(fooCompare, fooFromByteArray);
        // verify parsed message
        AmplGraphTest.checkReference(fooFromByteArray);
        // from inputstream
        Foo fooFromStream = new Foo();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        AmplGraphTest.mergeFrom(in, fooFromStream, Foo.getSchema());
        SerializableObjects.assertEquals(fooCompare, fooFromStream);
        // verify parsed message
        AmplGraphTest.checkReference(fooFromStream);
    }

    static Foo newFoo() {
        // one-instance of Baz.
        Baz baz = new Baz();
        baz.setId(100);
        Bar bar1 = new Bar();
        bar1.setSomeInt(1);
        bar1.setSomeBaz(baz);
        Bar bar2 = new Bar();
        bar2.setSomeInt(2);
        bar2.setSomeBaz(baz);
        java.util.ArrayList<Bar> bars = new java.util.ArrayList<Bar>();
        bars.add(bar1);
        bars.add(bar2);
        Foo foo = new Foo();
        foo.setSomeBar(bars);
        return foo;
    }

    static void checkReference(Foo foo) {
        Bar bar1 = foo.getSomeBar().get(0);
        junit.framework.TestCase.assertNotNull(bar1);
        assert (bar1.getSomeInt()) == 1;
        Bar bar2 = foo.getSomeBar().get(1);
        junit.framework.TestCase.assertNotNull(bar2);
        assert (bar2.getSomeInt()) == 2;
        // check if its same instance
        junit.framework.TestCase.assertTrue(((bar1.getSomeBaz()) == (bar2.getSomeBaz())));
    }

    /* message ClubFounder { optional string name = 1; optional Club club = 2; }
    
    message Club { optional string name = 1; repeated Student student = 2; repeated Club partner_club = 3; }
    
    message Student { optional string name = 1; repeated Club club = 2; }
    
    ClubFounders: some_glee_club_founder
    
    Clubs: glee private_club_of_jake_partner_of_glee
    
    Students: jake john jane
    
    Links: (clubfounder-club) some_glee_club_founder -> glee
    
    (student-club) jake <- glee
    
    jake <-> private_club_of_jake_partner_of_glee
    
    john <-> glee
    
    jane <-> glee
    
    (club-club) glee <-> private_club_of_jake_partner_of_glee
     */
    public void testCyclic() throws Exception {
        ClubFounder founder = new ClubFounder();
        founder.setName("some_glee_club_founder");
        Club gleeClub = new Club();
        gleeClub.setName("glee");
        founder.setClub(gleeClub);
        AmplGraphTest.addPartnerStudentTo(gleeClub, "jake");
        // cyclic
        Student john = new Student();
        john.setName("john");
        john.addClub(gleeClub);
        gleeClub.addStudent(john);
        Student jane = new Student();
        jane.setName("jane");
        jane.addClub(gleeClub);
        gleeClub.addStudent(jane);
        // check that our scenario is coded correctly.
        AmplGraphTest.checkLinks(founder);
        byte[] data = AmplGraphTest.toByteArray(founder, ClubFounder.getSchema());
        // from byte array
        ClubFounder founderFromByteArray = new ClubFounder();
        AmplGraphTest.mergeFrom(data, 0, data.length, founderFromByteArray, ClubFounder.getSchema());
        // verify parsed message
        AmplGraphTest.checkLinks(founderFromByteArray);
        // from inputstream
        ClubFounder founderFromStream = new ClubFounder();
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(data);
        AmplGraphTest.mergeFrom(in, founderFromStream, ClubFounder.getSchema());
        // verify parsed message
        AmplGraphTest.checkLinks(founderFromStream);
    }

    static void addPartnerStudentTo(Club club, String studentName) {
        Student student = new Student();
        student.setName(studentName);
        // non-cyclic
        club.addStudent(student);
        Club privateClub = new Club();
        privateClub.setName(((("private_club_of_" + studentName) + "_partner_of_") + (club.getName())));
        // cyclic
        student.addClub(privateClub);
        privateClub.addStudent(student);
        // cyclic
        privateClub.addPartnerClub(club);
        club.addPartnerClub(privateClub);
    }

    static void checkLinks(ClubFounder founder) {
        junit.framework.TestCase.assertNotNull(founder);
        junit.framework.TestCase.assertEquals("some_glee_club_founder", founder.getName());
        Club glee = founder.getClub();
        junit.framework.TestCase.assertNotNull(glee);
        junit.framework.TestCase.assertTrue(((glee.getStudentCount()) == 3));
        junit.framework.TestCase.assertTrue(((glee.getPartnerClubCount()) == 1));
        Student jake = glee.getStudent(0);
        Student john = glee.getStudent(1);
        Student jane = glee.getStudent(2);
        junit.framework.TestCase.assertEquals("jake", jake.getName());
        junit.framework.TestCase.assertEquals("john", john.getName());
        junit.framework.TestCase.assertEquals("jane", jane.getName());
        junit.framework.TestCase.assertTrue(((jake.getClubCount()) == 1));
        junit.framework.TestCase.assertTrue(((john.getClubCount()) == 1));
        junit.framework.TestCase.assertTrue(((jane.getClubCount()) == 1));
        // john and jane are cyclic to their club
        junit.framework.TestCase.assertTrue(((john.getClub(0)) == glee));
        junit.framework.TestCase.assertTrue(((jane.getClub(0)) == glee));
        // jake's club is linked to its private club only
        junit.framework.TestCase.assertTrue(((jake.getClub(0)) != glee));
        Club privateClubOfJake = jake.getClub(0);
        junit.framework.TestCase.assertNotNull(privateClubOfJake);
        junit.framework.TestCase.assertTrue(((privateClubOfJake.getStudentCount()) == 1));
        junit.framework.TestCase.assertTrue(((privateClubOfJake.getStudent(0)) == jake));
        // club-club cyclic link
        junit.framework.TestCase.assertTrue(((glee.getPartnerClub(0)) == privateClubOfJake));
    }
}

