package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The class that has everything to do with Skus <3
 * @author Javier Sosa Puga
 *
 */
@Entity
public class Sku implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -431185648932504925L;
	/**
	 * id parameter
	 */
	@Id
	@GeneratedValue
	private long id;
	/**
	 * parameter color
	 */
	private String color;
	/**
	 * parameter size
	 */
	private String size;
	/**
	 * parameter listPrice
	 */
	private double listPrice;
	/**
	 * parameter salePrice
	 */
	private double salePrice;
	/**
	 * parameter quantityOnHand
	 */
	private long quantityOnHand;
	/**
	 * parameter smallImageUrl
	 */
	private String smallImgUrl;
	/**
	 * parameter mediumImgUrl
	 */
	private String mediumImgUrl;
	/**
	 * parameter largeImgUrl
	 */
	private String largeImgUrl;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Product parentProduct;


	/**
	 * Sku constructor
	 */
	public Sku() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param color
	 * @param size
	 * @param listPrice
	 * @param salePrice
	 * @param quantityOnHand
	 * @param smallImgUrl
	 * @param mediumImgUrl
	 * @param largeImgUrl
	 */
	public Sku(long id, String color, String size, double listPrice, double salePrice, long quantityOnHand,
			String smallImgUrl, String mediumImgUrl, String largeImgUrl) {
		this.id = id;
		this.color = color;
		this.size = size;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
		this.quantityOnHand = quantityOnHand;
		this.smallImgUrl = smallImgUrl;
		this.mediumImgUrl = mediumImgUrl;
		this.largeImgUrl = largeImgUrl;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the listPrice
	 */
	public double getListPrice() {
		return listPrice;
	}

	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * @return the salePrice
	 */
	public double getSalePrice() {
		return salePrice;
	}

	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * @return the quantityOnHand
	 */
	public long getQuantityOnHand() {
		return quantityOnHand;
	}

	/**
	 * @param quantityOnHand the quantityOnHand to set
	 */
	public void setQuantityOnHand(long quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	/**
	 * @return the smallImgUrl
	 */
	public String getSmallImgUrl() {
		return smallImgUrl;
	}

	/**
	 * @param smallImgUrl the smallImgUrl to set
	 */
	public void setSmallImgUrl(String smallImgUrl) {
		this.smallImgUrl = smallImgUrl;
	}

	/**
	 * @return the mediumImgUrl
	 */
	public String getMediumImgUrl() {
		return mediumImgUrl;
	}

	/**
	 * @param mediumImgUrl the mediumImgUrl to set
	 */
	public void setMediumImgUrl(String mediumImgUrl) {
		this.mediumImgUrl = mediumImgUrl;
	}

	/**
	 * @return the largeImgUrl
	 */
	public String getLargeImgUrl() {
		return largeImgUrl;
	}

	/**
	 * @param largeImgUrl the largeImgUrl to set
	 */
	public void setLargeImgUrl(String largeImgUrl) {
		this.largeImgUrl = largeImgUrl;
	}

	/**
	 * @return the parentProduct
	 */
	public Product getParentProduct() {
		return parentProduct;
	}

	/**
	 * @param parentProduct the parentProduct to set
	 */
	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "Sku [id=" + id + ", color=" + color + ", size=" + size + ", listPrice=" + listPrice + ", salePrice="
				+ salePrice + ", quantityOnHand=" + quantityOnHand + ", smallImgUrl=" + smallImgUrl + ", mediumImgUrl="
				+ mediumImgUrl + ", largeImgUrl=" + largeImgUrl + ", parentProduct=" + parentProduct + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sku)) {
			return false;
		}
		Sku other = (Sku) obj;
		return id == other.id;
	}

}
