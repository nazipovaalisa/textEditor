package com.example.texteditor;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Clear;

    @FXML
    private RadioButton black;

    @FXML
    private ToggleGroup color;

    @FXML
    private ComboBox<String> font;

    @FXML
    private RadioButton green;

    @FXML
    private RadioButton red;

    @FXML
    private ComboBox<Integer> size;

    @FXML
    private Label welcomeText;

    @FXML
    private ComboBox<FontWeight> weight;
    @FXML
    private TextArea text;

    @FXML
    private ComboBox<String> styl;

    @FXML
    private RadioButton yellow;

    @FXML
    void initialize() {
        assert Clear != null : "fx:id=\"Clear\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert black != null : "fx:id=\"black\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert color != null : "fx:id=\"color\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert font != null : "fx:id=\"font\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert green != null : "fx:id=\"green\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert red != null : "fx:id=\"red\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert size != null : "fx:id=\"size\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert yellow != null : "fx:id=\"yellow\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert styl != null : "fx:id=\"styl\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert text != null : "fx:id=\"text\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert weight != null : "fx:id=\"weight\" was not injected: check your FXML file 'hello-view.fxml'.";

        ObservableList<String> fonts = FXCollections.observableArrayList("Times New Roman",
                "Georgia", "Arial", "Cambria", "Verdana", "Chiller", "Consolas", "Courier New", "Dubai", "Gothic");
        font.setItems(fonts);
        font.setValue(fonts.get(0));
        ObservableList<Integer> sizes = FXCollections.observableArrayList();
        for(int i = 1; i < 101; i++)
            sizes.add(i);
        size.setItems(sizes);
        size.setValue(14);

        ObservableList<FontWeight> fontWeights = FXCollections.observableArrayList(
                FontWeight.BOLD,
                FontWeight.NORMAL);
        weight.setItems(fontWeights);
        weight.setValue(FontWeight.NORMAL);

        ObservableList<String> styles = FXCollections.observableArrayList("Regular", "Italic");
        styl.setItems(styles);
        styl.setValue(styles.get(0));

        text.setFont(Font.font(font.getValue(), weight.getValue(),FontPosture.findByName(styl.getValue()),
                size.getValue()));

        black.fire();

        font.setOnAction(actionEvent -> text.setFont(Font.font(font.getValue(),weight.getValue(), FontPosture.findByName(styl.getValue()),
                size.getValue())));
        size.setOnAction(actionEvent -> text.setFont(Font.font(font.getValue(), weight.getValue(), FontPosture.findByName(styl.getValue()),
                size.getValue())));
        styl.setOnAction(actionEvent -> text.setFont(Font.font(font.getValue(), weight.getValue(),FontPosture.findByName(styl.getValue()),
                size.getValue())));
        weight.setOnAction(actionEvent ->  text.setFont(Font.font(font.getValue(),weight.getValue(), FontPosture.findByName(styl.getValue()),
                size.getValue())));

        color.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue) {
                // получаем выбранный элемент RadioButton
                RadioButton selectedBtn = (RadioButton) newValue;
                String style = "-fx-text-fill: " + selectedBtn.getText() + ";";
                text.setStyle(style);
            }
        });
        Clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.clear();
            }
        });
    }

}
