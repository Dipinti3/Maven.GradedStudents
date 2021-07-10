package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {
    @Test
    public void testGetAverageExamScore(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }


    @Test
    public void testAddStudent(){
        // given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(1);
        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        // when
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();
        // then
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void testRemoveStudent(){
        //given
        Double[] examScores1 = { 100.0, 110.0, 250.0};
        Double[] examScores2 = { 100.0, 150.0, 290.0};
        Double[] examScores3={99.9,112.5,257.5};
        Student student1 = new Student("Dolio", "Durant", examScores1);
        Student student2 = new Student("Kris", "Younger", examScores2);
        Student student3 = new Student("Leon","Hunter",examScores3);
        //when
        Student[] students = new Student[]{student1,student2,student3};
        Classroom classroom = new Classroom(students);
        classroom.removeStudent("Leon","Hunter");
        //then
        Student[] expected = classroom.getStudents();
        Assert.assertEquals(expected[0],student1);
        Assert.assertEquals(expected[1],student2);
        Assert.assertEquals(expected[2], null);

    }

    @Test
    public void testGetStudentByScore(){
        //given
        Double[] scores1 = new Double[]{45.0, 50.0, 55.0};
        Double[] scores2 = new Double[]{99.0, 65.0,99.0};
        Double[] scores3 = new Double[]{10.0, 10.0,20.2};
        Student student1 = new Student("Leon", "Hunter", scores1);
        Student student2 = new Student("Dolio", "Durant", scores2);
        Student student3 = new Student("Kris", "Younger", scores3);
        //when
        Student[] students = new Student[]{student1,student2,student3};
        Classroom classroom = new Classroom(students);
        Student[] expected = classroom.getStudentByScore();
        //then
        Assert.assertEquals(expected[0],student2);
        Assert.assertEquals(expected[1],student1);
        Assert.assertEquals(expected[2],student3);
    }

    @Test
    public void testGetGradeBook()
    {
        //given
        Double[] examScores1 = new Double[] {45.0,55.0,65.0};
        Double[] examScores2 = new Double[] {90.0,95.0,99.0};
        Student student1 = new Student("Leon", "Hunter", examScores1 );
        Student student2 = new Student("Kris", "Younger", examScores2 );
        //when
        Student[] newStudents = {student1, student2};
        Classroom classroom = new Classroom(newStudents);
        Map<Student,String> gradeBook = classroom.getGradeBook();
        //then
        Assert.assertEquals(gradeBook.get(student1),"E");
        Assert.assertEquals(gradeBook.get(student2),"A");

    }
}
