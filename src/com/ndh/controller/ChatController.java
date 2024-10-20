package com.ndh.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.HashMap;
import java.util.Map;

public class ChatController {

    @FXML
    private ListView<String> userListView;

    @FXML
    private TextArea chatTextArea;

    @FXML
    private TextField messageInput;

    @FXML
    private Label selectedUserLabel;

    private Map<String, StringBuilder> chatData;

    @FXML
    public void initialize() {
        // Dữ liệu người dùng giả lập
        ObservableList<String> users = FXCollections.observableArrayList("Người dùng 1", "Người dùng 2", "Người dùng 3");

        // Gán người dùng vào ListView
        userListView.setItems(users);

        // Tạo dữ liệu tin nhắn giả lập
        chatData = new HashMap<>();
        chatData.put("Người dùng 1", new StringBuilder("Chào bạn, mình là Người dùng 1.\n"));
        chatData.put("Người dùng 2", new StringBuilder("Hello! This is Người dùng 2.\n"));
        chatData.put("Người dùng 3", new StringBuilder("Xin chào, Người dùng 3 đây.\n"));

        // Khi người dùng chọn từ danh sách, hiển thị tin nhắn tương ứng
        userListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showChatForUser(newValue);
            }
        });
    }

    // Hiển thị tin nhắn cho người dùng được chọn
    private void showChatForUser(String user) {
        selectedUserLabel.setText("Tin nhắn với: " + user);
        chatTextArea.setText(chatData.get(user).toString());
    }

    // Gửi tin nhắn và cập nhật khu vực chat
    @FXML
    private void sendMessage() {
        String selectedUser = userListView.getSelectionModel().getSelectedItem();
        if (selectedUser != null && !messageInput.getText().trim().isEmpty()) {
            // Lấy tin nhắn
            String message = messageInput.getText().trim();
            // Thêm tin nhắn vào dữ liệu chat
            chatData.get(selectedUser).append("Bạn: ").append(message).append("\n");
            // Cập nhật giao diện
            chatTextArea.setText(chatData.get(selectedUser).toString());
            // Xóa nội dung đã nhập
            messageInput.clear();
        }
    }
}
