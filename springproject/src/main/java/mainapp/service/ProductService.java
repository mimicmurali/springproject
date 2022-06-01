package mainapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mainapp.entity.Product;
import mainapp.repository.ProductRepository;

@Service
@Profile(value= {"murali","abc"})
public class ProductService {
	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	
	 public List<Product> getProducts() {
		 return repository.findAll();
		 
	 }
	 public Product getProductByName(String name) {
			return repository.findByName(name);
		}

	public Product getProductById(int id) {
		
		return repository.findById(id).orElse(null);
	}
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		Product availableProduct=repository.findById(product.getId()).orElse(null);
		
		availableProduct.setQuantity(100);
		
		
		return repository.save(availableProduct) ;
	}


	public String deleteProduct(int id) {
	repository.deleteById(id);
		return "Product removed is:" +id;
	}
	

}
