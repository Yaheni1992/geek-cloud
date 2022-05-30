package com.geekbrains.cloud_2022_june.geekcloud;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    @FXML
    public ListView<String> clientView;
    @FXML
    public ListView<String> serverView;
    private Network network;

    @FXML
    public TextField textView;
    @FXML
    public ListView<String> listView;

    private void readLoop() {
        try {
            while (true) {
                String msg = network.readMessage();
                Platform.runLater(() -> clientView.getItems().add(msg));
            }
        } catch (Exception e) {
            System.err.println("Соединение потеряно");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            network = new Network(8189);
            Thread readThread = new Thread(this::readLoop);
            readThread.setDaemon(true);
            readThread.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}