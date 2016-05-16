package br.com.soapboxrace.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "PRODUCT")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductEntity implements ISoapBoxEntity {

	private static final long serialVersionUID = -3662485319709500345L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private long id;

	@XmlElement(name = "BundleItems", required = true)
	protected String bundleItems;
	@XmlElement(name = "CategoryId", required = true)
	protected String categoryId;
	@XmlElement(name = "Currency", required = true)
	protected String currency;
	@XmlElement(name = "Description", required = true)
	protected String description;
	@XmlElement(name = "DurationMinute")
	protected int durationMinute;
	@XmlElement(name = "Hash")
	protected long hash;
	@XmlElement(name = "Icon", required = true)
	protected String icon;
	@XmlElement(name = "Level")
	protected int level;
	@XmlElement(name = "LongDescription", required = true)
	protected String longDescription;
	@XmlElement(name = "Price")
	protected float price;
	@XmlElement(name = "Priority")
	protected int priority;
	@XmlElement(name = "ProductId", required = true)
	protected String productId;
	@XmlElement(name = "ProductTitle", required = true)
	protected String productTitle;
	@XmlElement(name = "ProductType", required = true)
	protected String productType;
	@XmlElement(name = "SecondaryIcon", required = true)
	protected String secondaryIcon;
	@XmlElement(name = "UseCount")
	protected int useCount;
	@XmlElement(name = "VisualStyle", required = true)
	protected String visualStyle;
	@XmlElement(name = "WebIcon", required = true)
	protected String webIcon;
	@XmlElement(name = "WebLocation", required = true)
	protected String webLocation;

	@XmlTransient
	protected String categoryName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBundleItems() {
		return bundleItems;
	}

	public void setBundleItems(String bundleItems) {
		this.bundleItems = bundleItems;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationMinute() {
		return durationMinute;
	}

	public void setDurationMinute(int durationMinute) {
		this.durationMinute = durationMinute;
	}

	public long getHash() {
		return hash;
	}

	public void setHash(long hash) {
		this.hash = hash;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getSecondaryIcon() {
		return secondaryIcon;
	}

	public void setSecondaryIcon(String secondaryIcon) {
		this.secondaryIcon = secondaryIcon;
	}

	public int getUseCount() {
		return useCount;
	}

	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}

	public String getVisualStyle() {
		return visualStyle;
	}

	public void setVisualStyle(String visualStyle) {
		this.visualStyle = visualStyle;
	}

	public String getWebIcon() {
		return webIcon;
	}

	public void setWebIcon(String webIcon) {
		this.webIcon = webIcon;
	}

	public String getWebLocation() {
		return webLocation;
	}

	public void setWebLocation(String webLocation) {
		this.webLocation = webLocation;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
