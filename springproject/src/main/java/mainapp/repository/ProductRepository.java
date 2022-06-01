package mainapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mainapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);
}
