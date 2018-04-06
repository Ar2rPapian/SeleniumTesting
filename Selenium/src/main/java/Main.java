import java.io.IOException;
import java.util.Iterator;

import static com.mypackage.am.helpers.Util.getLocatorFromProperties;

public class Main {
    public static void main(String[] args) throws IOException {
        getLocatorFromProperties("sign in", "button", "login");
    }
}
