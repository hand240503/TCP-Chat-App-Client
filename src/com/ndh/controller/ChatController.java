package com.ndh.controller;

import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ChatController {

    @FXML
    private HBox chatBtn;

    @FXML
    private HBox gearBtn;

    @FXML
    private HBox groupBtn;

    @FXML
    private TextField searchBox;

    @FXML
    private VBox listView;
    

    @FXML
    private ScrollPane scrollPane;

    @FXML
    public void initialize() {
        // Đăng ký các sự kiện cho nút
        chatBtn.setOnMouseClicked(event -> handleChatButtonClick());
        gearBtn.setOnMouseClicked(event -> handleGearButtonClick());
        groupBtn.setOnMouseClicked(event -> handleGroupButtonClick());
        
        // Hiển thị danh sách user mặc định
        showUserCellList1(); // Hiển thị danh sách user cell 1 khi bắt đầu
    }

    private void handleChatButtonClick() {
        setActiveButton(chatBtn);
        System.out.println("Chat button clicked!");
        showUserCellList1(); // Hiển thị danh sách user cell 1
    }

    private void handleGearButtonClick() {
        setActiveButton(gearBtn);
        System.out.println("Gear button clicked!");
        // Logic cho nút gear nếu cần
    }

    private void handleGroupButtonClick() {
        setActiveButton(groupBtn);
        System.out.println("Group button clicked!");
        showUserCellList2(); // Hiển thị danh sách user cell 2
    }

    // Phương thức để thiết lập trạng thái active cho nút
    private void setActiveButton(HBox activeButton) {
        // Xóa trạng thái active khỏi tất cả các nút
        chatBtn.getStyleClass().remove("active");
        gearBtn.getStyleClass().remove("active");
        groupBtn.getStyleClass().remove("active");

        // Thêm trạng thái active cho nút được nhấn
        activeButton.getStyleClass().add("active");
    }

    // Phương thức để hiển thị danh sách user cell 1
    private void showUserCellList1() {
        listView.getChildren().clear(); // Xóa các cell cũ
        Random random = new Random();
        for (int i = 0; i < 10; i++) { // Thêm 10 user cell
            boolean isOnline = random.nextBoolean(); // Tạo trạng thái online/offline ngẫu nhiên
            Pane userCell = createUserCell("User " + (i + 1), "D:\\VKU_2024-2025\\avatar.jpg", isOnline);
            listView.getChildren().add(userCell);
        }
        
//        if (listView.getChildren().size() <= 10) {
//            scrollPane.setVisible(false);
//            scrollPane.setManaged(false); 
//        } else {
//            // Hiện ScrollPane nếu có nhiều hơn 10 item
//            scrollPane.setVisible(true);
//            scrollPane.setManaged(true);
//        }
    }

    // Phương thức để hiển thị danh sách user cell 2
    private void showUserCellList2() {
        listView.getChildren().clear(); // Xóa các cell cũ
        for (int i = 0; i < 1; i++) { // Ví dụ: thêm 5 user cell khác
            Pane userCell = createUserCell("Group User " + (i + 1), "D:\\VKU_2024-2025\\avatar.jpg", false);
            listView.getChildren().add(userCell);
        }
        
//        if (listView.getChildren().size() <= 10) {
//            scrollPane.setVisible(true);
//            scrollPane.setManaged(true); 
//        } else {
//            // Hiện ScrollPane nếu có nhiều hơn 10 item
//            scrollPane.setVisible(true);
//            scrollPane.setManaged(true);
//        }
    }

    // Phương thức để tạo một user cell
    private Pane createUserCell(String name, String imageUrl, boolean isOnline) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ndh/design/user_cell.fxml")); // Đường dẫn đúng tới file FXML
            Pane userCell = loader.load();
            
            UserCellController controller = loader.getController();
            controller.setUserData(name, imageUrl, isOnline); // Gán dữ liệu cho user cell
            
            return userCell;
        } catch (IOException e) {
            e.printStackTrace();
            return new Pane(); // Trả về Pane rỗng nếu có lỗi
        }
    }
}
