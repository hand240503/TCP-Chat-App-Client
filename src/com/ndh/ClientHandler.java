package com.ndh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ClientHandler {

	private static final String SERVER_ADDRESS = "localhost";
	private static final int SERVER_PORT = 12345;

	private PrintWriter out;
	private BufferedReader in;
	private Socket socket;
	private Gson gson;

	public ClientHandler() {
		gson = new Gson();
	}

	public void startClient() {
		new Thread(() -> {
			try {
				socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
				System.out.println("Đã kết nối đến server");

				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				String response;
				while ((response = in.readLine()) != null) {
					System.out.println("Phản hồi từ server: " + response);
				}

			} catch (IOException e) {
				System.out.println("Không thể kết nối đến server: " + e.getMessage());
			}
		}).start();
	}

	public void sendMessage(String message) {
	    if (out != null) {

	        JsonObject json = new JsonObject();
	        json.addProperty("code", "MESSAGE");
	        json.addProperty("data", message);

	        out.println(json.toString());
	        System.out.println("Tin nhắn đã được gửi đến server: " + message);
	    } else {
	        System.out.println("Chưa kết nối đến server.");
	    }
	}

	public void sendLoginRequest(String username, String password) {
		if (out != null) {
			JsonObject data = new JsonObject();
			data.addProperty("username", username);
			data.addProperty("password", password);

			JsonObject request = new JsonObject();
			request.addProperty("code", "LOGIN");
			request.add("data", data);

			String jsonRequest = gson.toJson(request);
			out.println(jsonRequest);
			System.out.println("Yêu cầu đăng nhập đã được gửi đến server: " + jsonRequest);
		} else {
			System.out.println("Chưa kết nối đến server.");
		}
	}

	public void closeClient() {
		if (out != null) {
			out.println("CLOSE");
			out = null;
			System.out.println("Yêu cầu đóng kết nối đã được gửi đến server.");
		} else {
			System.out.println("Chưa kết nối đến server.");
		}
	}
}
