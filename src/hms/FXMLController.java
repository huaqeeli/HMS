/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class FXMLController implements Initializable {

    @FXML
    private TableView<Data> idtable;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> age;
    @FXML
    private TableColumn<?, ?> phone;
    @FXML
    private TableColumn<?, ?> id;
    
    ObservableList<Data> liste = FXCollections.observableArrayList();
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       name.setCellValueFactory(new PropertyValueFactory<>("name"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        liste.add(new Data("hussein ahmad aqeeli", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        liste.add(new Data("حسين احمد عبدالله عقيلي", "40", "0546457259", "1047759806"));
        
        idtable.setItems(liste);
    }    
    
}
