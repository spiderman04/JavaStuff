/**
 * @author CliffO
 *
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
		

/**
 * This program will demonstrate the Java environment variables and
 * system properties on the machine at Runtime. The system properties
 * will be written to an external file at the location of C:\Temp.
 * 
 * @param args
 */
public class JavaProps {

	public static void main(String[] args) {

		String[] optComponents = new String[] {"UI", "Workbench"
				, "Recorder","SilkCentral Integration", "BDL", "TrueLog Explorer"
				, "Performance Explorer", "Baseline Report", "Overview Report" 
				, "Load Test Summary Report", "Virtual User Report", "CloudBurst" + " (tm)" // \u2122"
				, "Installation", "Help", "Release Notes", "Silk4J", "Open Agent"};
			
		Arrays.sort(optComponents);
		System.out.println(Arrays.toString(optComponents));

		// get machine environment variables
		Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                              envName,
                              env.get(envName));
        }

        System.out.println("=========================================");
		Properties props = new Properties(System.getProperties());
		PrintWriter pw = null;
		
		try {
 
			props.list(new PrintWriter( new FileOutputStream("C:\\Temp\\myProperties1.txt"), true) );
			props.list(System.out);	
			
			pw = new PrintWriter( new FileOutputStream("C:\\Temp\\myProperties2.txt"), true);
			for (int i = 0; i < optComponents.length; i++){
				pw.println(optComponents[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null ) {
				System.out.print("Forcing the file stream to close!");
				pw.close();
			}
		}
			
	}

}