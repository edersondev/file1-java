package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import entity.Product;
import exception.ProgramException;

public class ReaderCsv {
	
	private ArrayList<Product> list;
	private String filePath;
	
	public ReaderCsv(String filePath) {
		list = new ArrayList<Product>();
		this.filePath = filePath;
		this.processFile();
	}

	public ArrayList<Product> getList() {
		return list;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	private void processFile() {
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line = br.readLine();
			while(line != null) {
				String[] productLine = line.split(",");
				Double price = Double.parseDouble(productLine[1]);
				Integer quantity = Integer.parseInt(productLine[2]);
				Product product = new Product(productLine[0],price,quantity);
				list.add(product);
				line = br.readLine();
			}
		} catch (IOException e) {
			throw new ProgramException(e.getMessage());
		}
	}
	
}
