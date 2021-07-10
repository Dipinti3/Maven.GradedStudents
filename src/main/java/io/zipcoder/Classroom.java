package io.zipcoder;

import java.util.*;

public class Classroom {
    ArrayList<Double>studentScores=new ArrayList<>();
    Student[] students;
    Integer maxNumberOfStudents;

    public Classroom(Student[] student) {
        this.students = student;
    }

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        students = new Student[this.maxNumberOfStudents];
    }

    public Classroom() {
        Student[] student = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        Double average = 0.0;
        Double totalAverage = 0.0;
        for (int i = 0; i < students.length; i++) {
            totalAverage += students[i].getAverageExamScore();
        }
        return totalAverage / students.length;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        if (this.students != null)
            studentsArrayList = new ArrayList<>(Arrays.asList(this.students));
        for (int i = 0; i < studentsArrayList.size(); i++) {
            if (studentsArrayList.get(i).getFirstName().equals(firstName))
                studentsArrayList.remove(i);
        }
        this.students = studentsArrayList.toArray(new Student[students.length]);
    }

    public Student[] getStudentByScore2(){
        Double[] averageArray=new Double[students.length];
        List<Double> studentAverageArrayList=new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            averageArray[i]=students[i].getAverageExamScore();
            studentAverageArrayList.add(averageArray[i]);
        }
        Collections.sort(studentAverageArrayList, Collections.reverseOrder());
        Student[] students=studentAverageArrayList.toArray(new Student[0]);
        return students;
    }

    public Student[] getStudentByScore() {
        List<Student> students = new ArrayList<>(Arrays.asList(this.students));
        Comparator<Student> byScore = Comparator.comparing(Student::getAverageExamScore);
        Comparator<Student> byFirstName = Comparator.comparing(Student::getLastName);
        Comparator<Student> byLastName = Comparator.comparing(Student::getFirstName);

        Collections.sort(students, byScore.thenComparing(byLastName).thenComparing(byFirstName));
        Collections.reverse(students);
        return students.toArray(new Student[0]);
    }

    public Map<Student,String> getGradeBook(){
        Map<Student, String> gradeBook=new HashMap<>();
        String grade="";
        for(Student student:students){
            double averageExamScore=student.getAverageExamScore();
            if(averageExamScore>=90)
                grade="A";
            else if(averageExamScore>=80)
                grade="B";
            else if(averageExamScore>=70)
                grade="C";
            else if(averageExamScore>=60)
                grade="D";
            else
                grade="E";
            gradeBook.put(student,grade);
        }
        return gradeBook;
        }
    }
