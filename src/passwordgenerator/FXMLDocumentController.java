
package passwordgenerator;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class FXMLDocumentController implements Initializable {
    
    private final String[] LOWER = { "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z" };
    private final String[] UPPER = { "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" };
    private final String[] SYMBOLS = { "!", "@", "#", "$", "%", "&", "*", "(", ")", "=", "+", "<", ">", "?", "/"};
    private final String[] NUMBERS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };   
    private Random ran;
    private ArrayList<String> randomList;
    
    @FXML
    private TextField outputField;
    @FXML
    private Button btnGenerate;
    @FXML
    private TextField passLength;
    @FXML
    private TextField symbolsCount;
    @FXML
    private TextField numbersCount;
    @FXML
    private TextField lowerCount;
    @FXML
    private TextField upperCount;
    @FXML
    private CheckBox symbolsBox;
    @FXML
    private CheckBox numbersBox;
    @FXML
    private CheckBox lowerBox;
    @FXML
    private CheckBox upperBox;
    @FXML
    private Button btnReset;
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        randomList = new ArrayList<String>();
    }    
    

    @FXML
    private void onClickGenerate(ActionEvent event) {
        outputField.setText("");
        randomList.clear();
        
        if (upperBox.isSelected() && isDigit(upperCount.getText())) {
            getRandomUpperLetters(Integer.parseInt(upperCount.getText()));
        } else { 
            upperCount.setText(""); upperBox.setSelected(false);
        }
        if (lowerBox.isSelected() && isDigit(lowerCount.getText())) {
            getRandomLowerLetters(Integer.parseInt(lowerCount.getText()));
        } else {
            lowerCount.setText(""); lowerBox.setSelected(false);
        }
        if (symbolsBox.isSelected() && isDigit(symbolsCount.getText())) {
            genRandomSymbols(Integer.parseInt(symbolsCount.getText()));
        } else {
            symbolsCount.setText(""); symbolsBox.setSelected(false);
        }
        if (numbersBox.isSelected() && isDigit(numbersCount.getText())) {
            genRandomNumbers(Integer.parseInt(numbersCount.getText()));
        } else {
            numbersCount.setText(""); numbersBox.setSelected(false);
        }
        
        displayRandomPassword();
    }
    
    private void displayRandomPassword() {
        Collections.shuffle(randomList);
        passLength.setText(Integer.toString(randomList.size()));
        String pass = "";
        for (int i = 0; i < randomList.size(); i++) {
            pass += randomList.get(i);
        }
        outputField.setText(pass);
    }
    
    private void getRandomUpperLetters(int count) {
        ran = new Random();
        int num;
        for (int i = 0; i < count; i++) {
            num = ran.nextInt(26);
            randomList.add(UPPER[num]);
        }
    }
    
    private void getRandomLowerLetters(int count) {
        ran = new Random();
        int num;
        for (int i = 0; i < count; i++) {
            num = ran.nextInt(26);
            randomList.add(LOWER[num]);
        }
    }
    
    private void genRandomSymbols(int count) {
        ran = new Random();
        int num;
        for (int i = 0; i < count; i++) {
            num = ran.nextInt(10);
            randomList.add(SYMBOLS[num]);
        }
    }
    
    private void genRandomNumbers(int count) {
        ran = new Random();
        int num;
        for (int i = 0; i < count; i++) {
            num = ran.nextInt(10);
            randomList.add(NUMBERS[num]);
        }
    }
   

    @FXML
    private void onSymClick(MouseEvent event) {
        if (symbolsBox.isSelected()) {
            symbolsCount.setText("1");
        } else {
            symbolsCount.setText("");      
        }
    }

    @FXML
    private void onNumClick(MouseEvent event) {
        if (numbersBox.isSelected()) {
            numbersCount.setText("1");
        } else {
            numbersCount.setText("");   
        }
    }

    @FXML
    private void onLowerClick(MouseEvent event) {
        if (lowerBox.isSelected()) {
            lowerCount.setText("1");
        } else {
            lowerCount.setText(""); 
        }
    }

    @FXML
    private void onUpperClick(MouseEvent event) {
        if (upperBox.isSelected()) {
            upperCount.setText("1");
        } else {
            upperCount.setText("");   
        }
    }   
    
    private boolean isDigit(String val) {
        try {
            double d = Double.parseDouble(val);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    @FXML
    private void keyReleasedOnSymBox(KeyEvent event) {
        if (symbolsCount.getText().isEmpty()) {
            symbolsBox.setSelected(false);
        } else {
            symbolsBox.setSelected(true);
        }
    }

    @FXML
    private void keyReleasedOnNumBox(KeyEvent event) {
        if (numbersCount.getText().isEmpty()) {
            numbersBox.setSelected(false);
        } else {
            numbersBox.setSelected(true);
        }
    }

    @FXML
    private void keyReleasedOnLowerBox(KeyEvent event) {
        if (lowerCount.getText().isEmpty()) {
            lowerBox.setSelected(false);
        } else {
            lowerBox.setSelected(true);
        }
    }

    @FXML
    private void keyReleasedOnUpperBox(KeyEvent event) {
        if (upperCount.getText().isEmpty()) {
            upperBox.setSelected(false);
        } else {
            upperBox.setSelected(true);
        }
    }
    
    @FXML
    private void onClickResetBtn(MouseEvent event) {
        outputField.setText("");
        upperCount.setText("");
        lowerCount.setText("");
        numbersCount.setText("");
        symbolsCount.setText("");
        passLength.setText("");
        upperBox.setSelected(false);
        lowerBox.setSelected(false);
        numbersBox.setSelected(false);
        symbolsBox.setSelected(false);
    }
    
}
