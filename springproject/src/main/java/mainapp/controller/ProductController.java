package mainapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mainapp.entity.Product;
import mainapp.service.ProductService;

@RestController
public class ProductController {
//@Autowired
public ProductService service;
@Bean
public ProductService getservice() {
	this.service=new ProductService();
	return service;
	}


@CrossOrigin
@PostMapping("/addproduct")
public Product addproduct(@RequestBody Product product) {
	return service.saveProduct(product);
}


@PostMapping("/addProducts")
public List<Product> addProducts(@RequestBody List<Product> products){
	return service.saveProducts(products);
}

@CrossOrigin
@GetMapping("/products")
public List<Product> findAllProducts() {
	return service.getProducts();
}

@GetMapping("/product/{name}")
public Product findProductByName(@PathVariable String name) {
	return service.getProductByName(name);
}
@CrossOrigin
@GetMapping("/findProductById/{id}")
public Product findProductById(@PathVariable int id) {
	return service.getProductById(id);
}

@PutMapping("/update")
public Product updateProduct(@RequestBody Product product) {
	return service.updateProduct(product);
}

@DeleteMapping("/delete/{id}")
public String deleteProduct(@PathVariable int id) {
	return service.deleteProduct(id);
}



}
