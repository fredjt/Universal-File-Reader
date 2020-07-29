package filereader;

import java.io.File;

public interface FileType {
	public void readFile(File file) throws Exception;

	public void readFile(File file, int start, int bufferSize) throws Exception;
}
