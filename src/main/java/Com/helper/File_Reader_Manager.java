package Com.helper;

import java.io.IOException;

public class File_Reader_Manager {
	
	public Configuration_reader getInstanceCR() throws Throwable {
		
		Configuration_reader reader = new Configuration_reader();
		
		return reader;
		}
	
	public static File_Reader_Manager getInstanceFRM() {
		
		File_Reader_Manager frm = new File_Reader_Manager();

		
		return frm;
	}
	
	private File_Reader_Manager() {
	}

	
}
