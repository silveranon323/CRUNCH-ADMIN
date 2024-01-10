import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Server {

    private ServerSocket server;
    private int port = 4123;

    public Server() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.welcomeMessage();
        server.connection();
    }

    public void welcomeMessage() {
        System.out.println("=== Welcome to Crunch Admin Server ===");
        Instant serverStartTime = Instant.now();
        System.out.println("Server started at: " + serverStartTime);
        System.out.println("======================================");
    }

    public void connection() {
        System.out.println("Waiting for client ...");
        try {
            Socket socket = server.accept();
            Instant clientAcceptedTime = Instant.now();
            System.out.println("Client accepted at: " + clientAcceptedTime);

            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            
            String inputData = dis.readUTF();
            String[] inputLines = inputData.split("\n");

            
            String keywords = inputLines[0];
            int wordLength = Integer.parseInt(inputLines[1]);
            String filePath = inputLines[2];
            int numberOfWords = Integer.parseInt(inputLines[3]);

           
            Instant start = Instant.now();
            generateDictionary(keywords.toCharArray(), wordLength, numberOfWords, filePath);
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);

          
            System.out.println("\n===== DICTIONARY GENERATION SUMMARY =====");
            System.out.println("|  Keywords       : " + keywords);
            System.out.println("|  Word Length    : " + wordLength);
            System.out.println("|  File Path      : " + filePath);
            System.out.println("|  No. of Words   : " + numberOfWords);
            System.out.println("|  Time Taken     : " + timeElapsed.toMillis() + " milliseconds");
            System.out.println("========================================");

            
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Dictionary generated successfully at: " + filePath);

            dis.close();
            dos.close();
            socket.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    private void generateDictionary(char[] characters, int wordLength, int numberOfWords, String filePath) {
        try (FileWriter fw = new FileWriter(filePath)) {//file location
            Set<String> generatedWords = new HashSet<>(); 

            while (generatedWords.size() < numberOfWords) {
                StringBuilder word = new StringBuilder();
                for (int i = 0; i < wordLength; i++) {
                    int randomIndex = (int) (Math.random() * characters.length);
                    word.append(characters[randomIndex]);
                }
                generatedWords.add(word.toString());
            }

            for (String generatedWord : generatedWords) {
                fw.write(generatedWord + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
