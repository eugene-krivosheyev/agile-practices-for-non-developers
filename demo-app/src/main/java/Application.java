import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Controller controller = new Controller();
        controller.dispatch();
    }
}
