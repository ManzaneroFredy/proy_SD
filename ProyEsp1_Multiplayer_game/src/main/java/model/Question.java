/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.ArrayList;

/**
 *
 * @author PC-Fredy
 */
public class Question {
    private String description;
    private ArrayList<String> answers;
    private String correctAnswer;

    public Question(String description, ArrayList<String> answers, String correctAnswer) {
        this.description = description;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

   
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    
    
}
