/**
 * 
 */
package mx.tec.web.lab.manager;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.tec.web.lab.entity.Product;
import mx.tec.web.lab.repository.ProductRepository;
import mx.tec.web.lab.entity.Sku;



/**
 * Takes care of all available business operations for Products
 * @author Javier Sosa Puga
 *
 */
@Service
public class ProductManager {
	@Resource
	ProductRepository productRepository;

	/**
	 * Retrieves all products on DB
	 * @return
	 */
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	/**
	 * Retrieves product by id
	 * @param id used to get product
	 * @return
	 */
	public Optional<Product> getProduct(final long id) {
				
		return productRepository.findById(id);
	}
	
	/**
	 * Retrieve a specific product based on a given product id
	 * @param pattern Pattern to search
	 * @return Optional containing a product if the product was found or empty otherwise
	 */
	public List<mx.tec.web.lab.entity.Product> getProducts(final String pattern) {
		return productRepository.findByNameLike(pattern);
	}

	/**
	 * Adds a new product 
	 * @param newProduct is used to add the product to the DB
	 * @return savedProduct
	 */
	public Product addProducts(final Product newProduct) {
		for(final Sku newSku : newProduct.getChildSkus()) {
			newSku.setParentProduct(newProduct);
		}

		return productRepository.save(newProduct);
	}
	
	/**
	 * Deletes an existing Product
	 * @param existingProduct used to know what Product to delete
	 */
	public void deleteProduct(final Product existingProduct){
		productRepository.delete(existingProduct);
	}
	
	/**
	 * Updates certain information of a product
	 * @param id
	 * @param modifiedProduct
	 */
	public void updateProduct(final long id, final Product modifiedProduct) {
		if (modifiedProduct.getId() == id) {
			for(final Sku modifiedSku : modifiedProduct.getChildSkus()) {
				modifiedSku.setParentProduct(modifiedProduct);
			}
			productRepository.save(modifiedProduct);
		}
	}



}
