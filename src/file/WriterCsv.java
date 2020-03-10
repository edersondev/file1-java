package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import entity.Product;
import exception.ProgramException;

public class WriterCsv {
	
	private String filePath;
	private ReaderCsv readCsv;
	
	public WriterCsv(String filePath, ReaderCsv readCsv) {
		this.filePath = filePath;
		this.readCsv = readCsv;
	}
	
	public void WriterFile() {
		String pathOut = this.setPathOut();
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))){
			ArrayList<Product> listProduct = readCsv.getList();
			for(Product p : listProduct) {
				bw.write(p.toOutCsv());
				bw.newLine();
			}
			System.out.println("File out done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String setPathOut() {
		File path = new File(filePath);
		this.createFolder(path);
		return path.getParent() + "/out/summary.csv";
	}
	
	private void createFolder(File path) {
		String pathOut = path.getParent() + "/out";
		boolean pathExists = new File(pathOut).exists();
		if(!pathExists) {
			if(!(new File(pathOut).mkdir())) {
				throw new ProgramException("Error on mkdir: " + path.getParent() + "/out");
			}			
		}
	}
}
