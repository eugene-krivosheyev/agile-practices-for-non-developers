import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileAccountRepository {
    private File file;

    public FileAccountRepository(File file) {
        this.file = file;
    }

    public void listAccounts() {
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

    public void createAccount(Scanner in) {
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
