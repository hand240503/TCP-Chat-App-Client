package com.ndh.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class UserCellController {

    @FXML
    private Circle avatar;

    @FXML
    private Circle status;

    @FXML
    private Label lbNameUser;

    @FXML
    private Label lbTime;

    @FXML
    private Label lbChat;
    
    @FXML
    private HBox userCellBox; // HBox đại diện cho user cell
    
    private static List<HBox> allUserCells = new ArrayList<>();
    
    @FXML
    public void initialize() {
        // Thêm user cell vào danh sách khi được khởi tạo
        allUserCells.add(userCellBox);

        // Lắng nghe sự kiện click
        userCellBox.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // Khi click vào một user cell, loại bỏ lớp 'active' khỏi các user cell khác
            for (HBox cell : allUserCells) {
                cell.getStyleClass().remove("active");
            }
            // Thêm lớp 'active' vào user cell được click
            userCellBox.getStyleClass().add("active");
        });
    }

    public void setUserData(String name, String imageUrl, boolean isOnline) {
        lbNameUser.setText(name);
        
        // Tạo hình ảnh từ URL
        Image image = new Image("file:///" + imageUrl.replace("\\", "/"));

        avatar.setFill(new ImagePattern(image ));

        // Cập nhật trạng thái online/offline
        if (isOnline) {
        	status.setFill(javafx.scene.paint.Color.web("#5AB570"));
        } else {
        	 status.setVisible(false); 
        }
    }
}
