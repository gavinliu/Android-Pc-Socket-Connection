package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class PCClient {

    public static void main(String[] args) throws IOException {
        System.out.println("任意字符, 回车键发送Toast");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String msg = scanner.next();
            sendToast(msg);
        }
    }

    public static void sendToast(String msg) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(msg);
        socket.close();
    }
}
