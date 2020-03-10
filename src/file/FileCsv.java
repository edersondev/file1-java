package file;

import exception.ProgramException;

public class FileCsv {
	
	private WriterCsv wcsv;
	protected String filePath;
	
	public FileCsv(String filePath) {
		this.filePath = filePath;
	}
	
	public void readAndWrite() {
		try {
			wcsv = new WriterCsv(filePath, new ReaderCsv(filePath));
			wcsv.WriterFile();
		} catch(ProgramException e) {
			System.out.println(e.getMessage());
		}
	}
}
