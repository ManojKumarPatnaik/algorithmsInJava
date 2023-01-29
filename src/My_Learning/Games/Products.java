package My_Learning.Games;

import java.util.Date;

public class Products {

	// Mapped field for column name
	public static final String PRODUCT_ID = "product_id";
	public static final String CATEGORY_ID = "category_id";
	public static final String NAME = "producct_name";
	public static final String PRICE = "product_price";
	public static final String CTIME = "creation_time";
	public static final String CURRENCY = "currency";

	private long productId;
	private long categoryId;
	private String name;
	private Date creationTime;
	private long price;
	private String currency;

	// getters and setters
	public long getProductId() {
		return productId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public long getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
