package br.com.soapboxrace.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "CATEGORY")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryEntity implements ISoapBoxEntity {

	private static final long serialVersionUID = -5211533179221745050L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategory", nullable = false)
	@XmlTransient
	private long idcategory;
	
	@XmlElement(name = "CatalogVersion", required = true)
	protected String catalogVersion;
	@XmlElement(name = "Categories")
	protected String categories;
	@XmlElement(name = "DisplayName", required = true)
	protected String displayName;
	@XmlElement(name = "FilterType", required = true)
	protected Integer filterType;
	@XmlElement(name = "Icon", required = true)
	protected String icon;
	@XmlElement(name = "Id", required = true)
	protected Long id;
	@XmlElement(name = "LongDescription", required = true)
	protected String longDescription;
	@XmlElement(name = "Name", required = true)
	protected String name;
	@XmlElement(name = "Priority", required = true)
	protected Short priority;
	
	@XmlElement(name="ProductTrans", type = VinylProductEntity.class)
	@XmlElementWrapper(name="Products")
	@OneToMany(mappedBy = "category", targetEntity = VinylProductEntity.class)
	private List<VinylProductEntity> listOfVinyls;
	
	@XmlElement(name = "ShortDescription", required = true)
	protected String shortDescription;
	@XmlElement(name = "ShowInNavigationPane", required = true)
	protected Boolean showInNavigationPane;
	@XmlElement(name = "ShowPromoPage", required = true)
	protected Boolean showPromoPage;
	@XmlElement(name = "WebIcon", required = true)
	protected String webIcon;

	public void setId(Long id) {
		this.idcategory = id;		
	}
	public Long getId() {
		return idcategory;
	}

	public String getCatalogVersion() {
		return catalogVersion;
	}
	public void setCatalogVersion(String catalogVersion) {
		this.catalogVersion = catalogVersion;
	}

	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getFilterType() {
		return filterType;
	}
	public void setFilterType(Integer filterType) {
		this.filterType = filterType;
	}

	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Short getPriority() {
		return priority;
	}
	public void setPriority(Short priority) {
		this.priority = priority;
	}

	public List<VinylProductEntity> getListOfVinyls() {
		return listOfVinyls;
	}
	public void setListOfVinyls(List<VinylProductEntity> listOfVinyls) {
		this.listOfVinyls = listOfVinyls;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public Boolean getShowInNavigationPane() {
		return showInNavigationPane;
	}
	public void setShowInNavigationPane(Boolean showInNavigationPane) {
		this.showInNavigationPane = showInNavigationPane;
	}

	public Boolean getShowPromoPage() {
		return showPromoPage;
	}
	public void setShowPromoPage(Boolean showPromoPage) {
		this.showPromoPage = showPromoPage;
	}

	public String getWebIcon() {
		return webIcon;
	}
	public void setWebIcon(String webIcon) {
		this.webIcon = webIcon;
	}
}