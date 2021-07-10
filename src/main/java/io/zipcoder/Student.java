package io.zipcoder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    ArrayList<Double>examScores=new ArrayList<>();

    @Override
    public String toString(){
        NumberFormat nf = new DecimalFormat("##");
        String getExamScores = getExamScores().replace(".0","");
        String result= "Student Name: "+firstName+" "+lastName+"\n"+"> "+"Average Score: "+
                Math.round(getAverageExamScore())+"\n" +
                getExamScores;
        return result;
    }



    public Double getAverageExamScore(){
        Double total=0.0;
        for (int i = 0; i < examScores.size(); i++) {
             total+=examScores.get(i);
        }
        return total/examScores.size();
    }

    public String setExamScore(int examNumber,double newScore){
        for (int i = 0; i <examScores.size(); i++) {
             if(i==examNumber-1){
                 examScores.set(i,newScore);
             }
        }
        return getExamScores().toString();
    }

    public String addExamScore(double examScore){
        examScores.add(examScore);
        return getExamScores().toString();
    }

    public String getExamScores() {
        StringBuilder sb=new StringBuilder();
        sb.append("Exam Scores: ");
        int examTaken=1;
        for (int i = 0; i < examScores.size(); i++) {
            sb.append("\n");
            sb.append("Exam "+ examTaken+ " -> " +examScores.get(i));
            examTaken++;
        }
        return sb.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setExamScores(ArrayList<Double> examScores) {
        this.examScores = examScores;
    }

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        for (int i = 0; i < testScores.length; i++) {
             examScores.add(testScores[i]);
        }
    }
}
