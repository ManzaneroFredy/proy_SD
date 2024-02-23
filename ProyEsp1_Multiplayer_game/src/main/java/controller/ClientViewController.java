/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.Question;
import view.clientView;
import view.QuestionsView;

/**
 *
 * @author PC-Fredy
 */
public class ClientViewController implements MouseListener{
    private clientView clientV;
    private ArrayList<Question> questions;
    private QuestionsView qv = new QuestionsView();
    int questionIndex = 0;
    

    public ClientViewController(clientView clientV) throws IOException {
        this.clientV = clientV;
        this.questions = initializedQuestions(getQuestionsFromJson());
        this.clientV.getUsernameView1().getBtnUsername().addMouseListener(this);
        this.qv.getPanelAnswer1().addMouseListener(this);
        this.qv.getPanelAnswer2().addMouseListener(this);
        this.qv.getPanelAnswer3().addMouseListener(this);
        
        
        //this.showPanels(this.clientV);
        this.clientV.setLocationRelativeTo(null);
        this.clientV.setVisible(true);
    }
    
    
    
    
    private JsonArray getQuestionsFromJson() throws IOException{
        JsonArray questions = null;
        String filePath = "C:\\Users\\A16001581\\Desktop\\ProyectoSD\\proy_SD\\ProyEsp1_Multiplayer_game\\src\\main\\java\\utils\\Preguntas.JSON";
        String questionJson = new String(Files.readAllBytes(Paths.get(filePath)));
    
        JsonElement jsonElement = JsonParser.parseString(questionJson);
    
        if(jsonElement.isJsonArray()){
            questions = jsonElement.getAsJsonArray();
            
        }
        
        return questions;
    }
    
 
    private ArrayList<Question> initializedQuestions(JsonArray questions){
        
        ArrayList<Question> questionsFromResponse = new ArrayList();
        
        for(JsonElement question: questions){
            JsonObject questionFields = question.getAsJsonObject();
            String description = questionFields.get("Pregunta").getAsString();
            ArrayList<String> answers = new ArrayList();
            answers.add(questionFields.get("Respuestas").getAsJsonObject().get("a").getAsString());
            answers.add(questionFields.get("Respuestas").getAsJsonObject().get("b").getAsString());
            answers.add(questionFields.get("Respuestas").getAsJsonObject().get("c").getAsString());
            String correctAnswer = questionFields.get("Respuesta-correcta").getAsString();
            
            Question temp = new Question(description, answers, correctAnswer);
            questionsFromResponse.add(temp);
        }
        return questionsFromResponse;
    }
    
    private void showPanels(JPanel panelType){
        this.clientV.getMainPanel().removeAll();
        this.clientV.getMainPanel().add(panelType);
        this.clientV.getMainPanel().repaint();
        this.clientV.getMainPanel().revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int score = 0;
        if(e.getSource().equals(this.clientV.getUsernameView1().getBtnUsername())){
            showPanels(qv.getPanelQuestions());
            System.out.println("Presionado");
            try {
                setQuestion(initializedQuestions(getQuestionsFromJson()), questionIndex);
            } catch (IOException ex) {
                Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource().equals(this.qv.getPanelAnswer1())){
            try {
                questionIndex++;
                setQuestion(initializedQuestions(getQuestionsFromJson()), questionIndex);
                if(initializedQuestions(getQuestionsFromJson()).get(questionIndex).getCorrectAnswer().equals('a')) score += 100;
            } catch (IOException ex) {
                Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Presionado");
        }
        if(e.getSource().equals(this.qv.getPanelAnswer2())){
            
            try {
                questionIndex++;
                setQuestion(initializedQuestions(getQuestionsFromJson()), questionIndex);
                if(initializedQuestions(getQuestionsFromJson()).get(questionIndex).getCorrectAnswer().equals('b')) score += 100;
            } catch (IOException ex) {
                Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Presionado");
        }
        if(e.getSource().equals(this.qv.getPanelAnswer3())){
            
            try {
                questionIndex++;
                setQuestion(initializedQuestions(getQuestionsFromJson()), questionIndex);
                if(initializedQuestions(getQuestionsFromJson()).get(questionIndex).getCorrectAnswer().equals('c')) score += 100;
            } catch (IOException ex) {
                Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Presionado");
        }
    
    }
    
    private void setQuestion(ArrayList<Question> questions, int indexQuestion){
        this.qv.getTxtQuestion().setText(questions.get(indexQuestion).getDescription());
        this.qv.getTxtAnswer1().setText(questions.get(indexQuestion).getAnswers().get(0));
        this.qv.getTxtAnswer2().setText(questions.get(indexQuestion).getAnswers().get(1));
        this.qv.getTxtAnswer3().setText(questions.get(indexQuestion).getAnswers().get(2));
    }
    
    
    

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
