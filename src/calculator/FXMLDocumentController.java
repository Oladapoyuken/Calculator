/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
/**
 *
 * @author Yuken4real
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Pane rootPane;
    @FXML
    private Label sign;
    @FXML
    private JFXButton start, pands, div, del, plus, minus, multi, dot, zero, 
            equal, one, two, three, four, five , six, seven, eight, nine;
    @FXML
    private JFXTextField display; 
    @FXML
    private FontAwesomeIconView delImage;
    
    private String operand1, operand, ans;
    private float x = 0, y = 0;
   
    private boolean check = true, equalP = false, signCheck = false,
            signCheck1 = false, signCheck2 = false, signCheck3 = false, 
            signCheck4 = false, signCheck5 = false, preState = false, 
            preDot = true; 
    private char preChar = '.', postChar = '.';
    
    private int started = 0, started1 = 0, started2 = 0, started3 = 0, 
            started4 = 0,
            started5 = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        display.setStyle("-fx-text-inner-color: white;");
        //entrance();
    }
    
    
//    @FXML
//    private void startButton(MouseEvent event){
//        display.setText("Started");
//    }
    @FXML
    private void actionEventHandler(ActionEvent event){
        
        
        if(event.getSource() == start){
            y = 0;
            started = 0; started1 =0; started2 = 0; started3 = 0; started4 = 0;
            signCheck = false; signCheck1 = false; preDot = true; 
            signCheck2 = false; signCheck3 = false; signCheck4 = false;
            sign.setText("");
            display.clear();
        }
        
        
        else if(event.getSource() == pands){
            String s = display.getText().toString().trim();
            
            if(!s.isEmpty()){
                float x = Float.parseFloat(s);
                x = x * x;
                forMat(String.valueOf(x));
                
            }
            
        }
        
        
        
        else if(event.getSource() == del || event.getSource() == delImage){
            clearFunc();
        }                                                                               //5+5/3x7-1
        
        
        else if(event.getSource() == div){
            if (signCheck3) {
                preChar = '/';
                
                float input = 0;
                try {
                    input = Float.parseFloat(display.getText());
                } catch (NumberFormatException nfe) {
                }
                
                if (y == 0 && started3 == 0) {
                    y = input;                                                  
                    started3++;
                } 
                else {
                    
                    if (equalP) {
                        addFunc(input);
                        equalP = true;
                    } 
                    else {
                        y = input;
                    }
                }
                sign.setText("/");
                equalP = true;
                check = false; //enable appending
                signCheck = false;
                signCheck1 = false;//no sign repeatition
                signCheck2 = false;
                signCheck3 = false;
                preDot = true;
            }
        }
        
        
        else if(event.getSource() == multi){
            if (signCheck2) {
                preChar = 'x';
                
                float input = 0;
                try {
                    input = Float.parseFloat(display.getText());
                } catch (NumberFormatException nfe) {
                }
                
                if (y == 0 && started2 == 0) {
                    y = input;                                                  
                    started2++;
                } 
                else {
                    
                    if (equalP) {
                        addFunc(input);
                        equalP = true;
                    } 
                    else {
                        y = input;
                    }
                }
                sign.setText("x");
                equalP = true;
                check = false; //enable appending
                signCheck = false;
                signCheck1 = false;//no sign repeatition
                signCheck2 = false;
                signCheck3 = false;
                preDot = true;
            }
        }
       
        
        else if(event.getSource() == plus){
            if (signCheck) {
                preChar = '+';
                
                
                float input = 0;
                try {
                    input = Float.parseFloat(display.getText());
                } catch (NumberFormatException nfe) {
                }
                
                if (y == 0 && started == 0) {
                    y = input;                                                  
                    started++;
                }                                           
                else {
                    
                    if (equalP) {
                        addFunc(input);
                        equalP = true;
                    } 
                    else {
                        y = input;
                    }
                }
                sign.setText("+");
                equalP = true;
                check = false; //enable appending
                signCheck = false;
                signCheck1 = false;//no sign repeatition
                signCheck2 = false;
                signCheck3 = false;
                preDot = true;
            }
        }
        
        else if(event.getSource() == minus){
            if (signCheck1) {
                preChar = '-';
                
                float input = 0;
                try {
                    input = Float.parseFloat(display.getText());
                } catch (NumberFormatException nfe) {
                }
                
                if (y == 0 && started1 == 0) {
                    y = input;                                                  
                    started1++;
                } 
                else {
                    if (equalP) {
                        addFunc(input);
                        equalP = true;
                    } 
                    else {
                        y = input;
                        
                    }
                }
                sign.setText("-");
                equalP = true;
                check = false; //enable appending
                signCheck = false;
                signCheck1 = false;//no sign repeatition
                signCheck2 = false;
                signCheck3 = false;
                preDot = true;
            }
        }
        
        
        
        else if(event.getSource() == equal){
            if (equalP) {
                preState = false;
                preDot = true;
                signCheck = true;
                signCheck1 = true;
                signCheck2 = true;
                signCheck3 = true;
                preDot = true;
                equalP = false;
                float input = 0;
                try {
                    input = Float.parseFloat(display.getText());
                } catch (NumberFormatException nfe) {
                }
                addFunc(input);
                check = false;
            }
        }
        
        
        
        
        else if(event.getSource() == dot){
            signCheck = true; signCheck1 = true; signCheck2 = true; 
            signCheck3 = true; signCheck4 = true; equalP = true;
            if (check && preDot == true) {
                display.appendText(".");
                preDot = false;
            }
            else{
                display.setText(".");
                check = true;
            }
        }
        else if(event.getSource() == zero){
            signCheck = true; signCheck1 = true; signCheck = true; preDot = true;
            signCheck3 = true; signCheck4 = true; equalP = true;
            if (check) {
                display.appendText("0");
            }
            else{
                display.setText("0");
                check = true;
            }
        }
        else if(event.getSource() == one){
            signCheck = true; equalP = true; signCheck1 = true; preDot = true;
            signCheck2 = true; signCheck3 = true; signCheck4 = true;
            if (check) {
                display.appendText("1");
            }
            else{
                display.setText("1");
                check = true;
            }
        }
        else if(event.getSource() == two){
            signCheck = true; equalP = true; signCheck1 = true; preDot = true;
            signCheck2 = true; signCheck3 = true; signCheck4 = true;
            if (check) {
                display.appendText("2");
            }
            else{
                display.setText("2");
                check = true;
            }
        }
        else if(event.getSource() == three){
            signCheck = true; equalP = true; signCheck1 = true; preDot = true; 
            signCheck2 = true; signCheck3 = true; signCheck4 = true;
            if (check){ 
                display.appendText("3");
            }
            else{
                display.setText("3");
                check = true;
            }
        }
        else if(event.getSource() == four){
            signCheck = true; equalP = true; signCheck1 = true; preDot = true; 
            signCheck2 = true; signCheck3 = true; signCheck4 = true;
            if (check) {
                display.appendText("4");
            }
            else{
                display.setText("4");
                check = true;
            }
        }
        else if(event.getSource() == five){
            signCheck = true; equalP = true; signCheck1 = true; preDot = true;
            signCheck2 = true; signCheck3 = true; signCheck4 = true;
            if (check) {
                display.appendText("5");
            }
            else{
                display.setText("5");
                check = true;
            }
        }
        else if(event.getSource() == six){
            signCheck = true; equalP = true; signCheck1 = true; preDot = true;
            signCheck2 = true; signCheck3 = true; signCheck4 = true;
            if (check) {
                display.appendText("6");
            }
            else{
                display.setText("6");
                check = true;
            }
        }
        else if(event.getSource() == seven){
            signCheck = true;equalP = true; signCheck1 = true; preDot = true;
            signCheck2 = true; signCheck3 = true; signCheck4 = true;
            if (check) {
                display.appendText("7");
            }
            else{
                display.setText("7");
                check = true;
            }
        }
        else if(event.getSource() == eight){
            signCheck = true; equalP = true; signCheck1 = true; preDot = true;
            signCheck2 = true; signCheck3 = true; signCheck4 = true;
            if (check) {
                display.appendText("8");
            }
            else{
                display.setText("8");
                check = true;
            }
        }
        else if(event.getSource() == nine){
            signCheck = true; equalP = true; signCheck1 = true; preDot = true; 
            signCheck2 = true; signCheck3 = true; signCheck4 = true;
            if (check) {
                display.appendText("9");
            }
            else{
                display.setText("9");
                check = true;
            }
        }
    }
    
    @FXML
    private void clearDisplay(MouseEvent event){
        clearFunc();
    }
        
    


    private void addFunc(float x){
        String pre = sign.getText().trim();
        if (!pre.isEmpty()) {
            char optr = pre.charAt(0);
            switch (optr) {
                case '+': {
                    y = y + x;
                    forMat(String.valueOf(y));
                    break;
                }
                case '-': {
                    y = y - x;
                    forMat(String.valueOf(y));
                    break;
                }
                case 'x': {
                    y = y * x;
                    forMat(String.valueOf(y));
                    break;
                }
                case '/': {
                    y = y / x;
                    forMat(String.valueOf(y));
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
    
    
    private void forMat(String in){
        String subS = "";       
        char[] subs = in.toCharArray();
        if (subs[subs.length-1] == '0'){
            for (int i = 0; i < subs.length; i++) {
                if (subs[i] == '.') {
                    subS = in.substring(0, i);
                    in = subS;
                } 
            }
            
            if (in.length() <= 12) {
                display.setText(in);
            } else {
                display.setText("OVERFLOW");
                try {
                    Thread.sleep(1000);
                    clearFunc();
                } catch (InterruptedException ex) {
                    
                }
            }
        }
        else{
            if (in.length() <= 12) {
                display.setText(in);
            } else {
                display.setText("OVERFLOW");
                try {
                    Thread.sleep(1000);
                    clearFunc();
                } catch (InterruptedException ex) {
                    
                }
            }
        }
    }

    private void clearFunc() {
        if (signCheck == false && signCheck1 == false && 
            signCheck2 == false && signCheck3 == false) {
            sign.setText("");
            signCheck = true; signCheck1 = true; signCheck2 = true; 
            signCheck3 = true;
        } 
        else {
            String content = display.getText().toString().trim();
            if (!content.isEmpty()) {
                content = content.substring(0, content.length() - 1);                
                display.setText(content);
            }
        }
    }
    
}
