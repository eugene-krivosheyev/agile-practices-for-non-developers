import lombok.extern.java.Log;

import java.io.File;
import java.util.Scanner;

public class Controller {
    private File file = new File("accounts.txt");
    private FileAccountRepository accounts = new FileAccountRepository(file);

//    @RolesAllowed("admin")
//    @Transactional
//    @Log
    public void dispatch() {
        final Scanner in = new Scanner(System.in);
        System.out.println("Enter command:");
        final String readLine = in.nextLine();

        if (readLine.equals("new")) {
            accounts.createAccount(in);
        } else if (readLine.equals("list")) {
            accounts.listAccounts();
        }
    }
}
