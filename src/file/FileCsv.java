package file;

import java.util.ArrayList;

import entity.Product;

public class FileCsv {
	
	private ArrayList<Product> productList;
	
	public FileCsv(String filePath) {
		ReaderCsv re = new ReaderCsv(filePath);
		productList = re.getList();
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}
	
}
