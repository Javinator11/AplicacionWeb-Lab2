/**
 * 
 */
package mx.tec.web.lab.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.web.lab.entity.Product;
import mx.tec.web.lab.manager.ProductManager;

/**
 * This is the class that handles all the REST api routes
 * @author Javier Sosa Puga
 *
 */
@RestController
public class ProductController {
	@Resource
	private ProductManager productManager;

	/**
	* returns all products
	*@param no parameters 
	*@return the JSON of all the product
	*/
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productManager.getProducts();
		
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	/**
	* returns a specific product with the id
	*@param id
	*@return the specific JSON of the product
	*/
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK);
		}
		
		return responseEntity;
	}	
	
	/**
	 * The end point for GET {url}/products?search={pattern}
	 * @param search Pattern to search
	 * @return a json list of all the products matching the pattern
	 */
	@GetMapping(value="/products", params="search")
	public ResponseEntity<List<Product>> getProducts(@RequestParam String search) {
		List<Product> products = productManager.getProducts(search);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	
	/**
	 * Adds the product object
	 * @param product Product
	 * @return status 201 if the product is created or status 400 if the server couldn´t complete the request
	 */
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
		ResponseEntity<Product> responseEntity;
		
		Product product = productManager.addProducts(newProduct);
		
		responseEntity = new ResponseEntity<>(product, HttpStatus.CREATED);
		
		return responseEntity;
	}
	
	/**
	 * Deletes the Product referred by an id
	 * @param id Product id
	 * @return status 200 if the product is deleted or status 204 if the product is not found
	 */
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			productManager.deleteProduct(product.get());
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		
		return responseEntity;
	}	
	
	/**
	 * The end point for PUT {url}/products/{id}
	 * @param id Product id
	 * @param modifiedProduct a json containing the info for the modified product
	 * @return status 200 if the product is found and updated or status 204 if the product is not found
	 */
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") long id, @RequestBody Product modifiedProduct) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			productManager.updateProduct(id, modifiedProduct);
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
}
