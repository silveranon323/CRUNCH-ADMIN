import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host.getHostName(), 4123);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            Scanner sc = new Scanner(System.in);

            
            System.out.print("Enter Dictionary Keywords (separated by space): ");
            String keywords = sc.nextLine();


            System.out.print("Enter Word Length: ");
            int wordLength = sc.nextInt();
            sc.nextLine(); 

       
            System.out.print("Enter File Path for Dictionary Generation (or press Enter for default): ");
            String filePath = sc.nextLine();
            if (filePath.isEmpty()) {
                filePath = "default_path.txt";
            }

           
            System.out.print("Enter Number of Words to Generate: ");
            int numberOfWords = sc.nextInt();

            System.out.println("\n===== CLIENT INPUT SUMMARY =====");
            System.out.println("|  Keywords       : " + keywords);
            System.out.println("|  Word Length    : " + wordLength);
            System.out.println("|  File Path      : " + filePath);
            System.out.println("|  No. of Words   : " + numberOfWords);
            System.out.println("===============================");

            String message = keywords + "\n" + wordLength + "\n" + filePath + "\n" + numberOfWords;
            dos.writeUTF(message);
            dos.flush();

          
            String confirmation = dis.readUTF();
            System.out.println("\nServer Confirmation: " + confirmation);

            dos.close();
            dis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
