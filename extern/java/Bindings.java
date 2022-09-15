package extern.java;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import com.qunhe.util.nest.Nest;

public class Bindings {
    private static native void hello();
    private static native void hello2();

    static {       
		String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);

		if (os.equals("mac")) {
			Path currentRelativePath = Paths.get("");
        	Path p = currentRelativePath.toAbsolutePath();
			String fname = "target/debug/libnest4rs.dylib";
			Path fp = p.resolve(fname);
			System.load(fp.toString());
		} else if (os.equals("win")) {
			Path currentRelativePath = Paths.get("");
        	Path p = currentRelativePath.toAbsolutePath();
			String fname = "target\\debug\\libnest4rs.dll";
			Path fp = p.resolve(fname);
			System.load(fp.toString());
		} else {
			Path currentRelativePath = Paths.get("");
        	Path p = currentRelativePath.toAbsolutePath();
			String fname = "target/debug/libnest4rs.so";
			Path fp = p.resolve(fname);
			System.load(fp.toString());
		}
    }

    public static void hi() {
        System.out.println("Hola nest from java");
    }
}
