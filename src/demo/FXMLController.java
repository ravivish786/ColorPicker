/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import com.jfoenix.controls.JFXColorPicker;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author VICKY
 */
public class FXMLController implements Initializable {

    @FXML
    private Button saveimage;
    @FXML
    private Pane showpane;
    @FXML
    private JFXColorPicker colorbtn;
    @FXML
    private Text value;
    @FXML
    private TextField textvalue;
    int no=1;
    String str;
    @FXML
    private FontAwesomeIconView close;
    @FXML
    private Text filename;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        value.setText("#FFFFFF");
        textvalue.setText("#FFFFFF");
        showpane.setStyle("-fx-background-color: white;");
        value.setStyle("-fx-fill: black;");
    }    

    @FXML
    private void saveImage(MouseEvent event) {  
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            WritableImage writableImage = 
            new WritableImage((int)showpane.getWidth(), (int)showpane.getHeight());
            showpane.snapshot(new SnapshotParameters(), writableImage);
            //File file = new File("Snapshot"+String.valueOf(no)+".png");
           try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            filename.setText("Saved File "+file.getAbsolutePath());
            no++;
            } catch (IOException ex) {
           
            } 
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Save Image");
            alert.setHeaderText("Save File ");
            alert.setContentText("This image save for long time ");
            alert.showAndWait();
        }
        
        
        
    }

    @FXML
    private void changeColor(ActionEvent event) {
         str="#"+String.valueOf(colorbtn.getValue()).substring(2, colorbtn.getValue().toString().length()-2).toUpperCase();
        value.setText(str);
        textvalue.setText(str);
        showpane.setBackground(new Background(new BackgroundFill(Paint.valueOf(colorbtn.getValue().toString()), CornerRadii.EMPTY, Insets.EMPTY)));
                
    }


    @FXML
    private void closePage(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void onPressEnter(KeyEvent event) {
        String txt=textvalue.getText();
        if(txt.length()==7)
        {
            textvalue.setStyle("-fx-border-color: blue;");
            if (event.getCode()==KeyCode.ENTER) {
                textvalue.setText(txt.toUpperCase());
                colorbtn.setValue(Color.web(txt));
                
                if(txt.equalsIgnoreCase("#FFFFFF"))
                    value.setStyle("-fx-fill: black;");
                else
                    value.setStyle("-fx-fill: white;");
                
                value.setText(txt.toUpperCase());
                
                showpane.setBackground(new Background(new BackgroundFill(Paint.valueOf(txt), CornerRadii.EMPTY, Insets.EMPTY)));
               
            }
        }else{
            textvalue.setStyle("-fx-border-color: red; -fx-border-width: 3;");
        }
       
    }
       
}
