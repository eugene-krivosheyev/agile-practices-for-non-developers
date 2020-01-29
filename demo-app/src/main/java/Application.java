import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        System.out.println("Enter command:");
        final String readLine = in.nextLine();
        File file = new File("accounts.txt");

        if (readLine.equals("new")) {
            createAccount(in, file);
        } else if (readLine.equals("list")) {
            listAccounts(file);
        }
    }

    private static void listAccounts(File file) {
        try {
            final List<String> accounts = FileUtils.readLines(file);
            for (String account : accounts) {
                System.out.println(account);
            }
        } catch (IOException e) {
            System.out.println("ERROR!!!111");
            e.printStackTrace();
        }
    }

    private static void createAccount(Scanner in, File file) {
        System.out.println("Enter data:");
        final String accountData = in.nextLine();
        try {
            FileUtils.writeStringToFile(file, accountData, true);
            FileUtils.writeStringToFile(file, "\n", true);
        } catch (IOException e) {
            System.out.println("ERROR!!!111");
            e.printStackTrace();
        }
    }
}
