package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jpa.CategoryEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCategoryTrans")
@XmlRootElement(name = "ArrayOfCategoryTrans")
public class ArrayOfCategoryTrans {

	@XmlElement(name = "CategoryTrans")
    private List<CategoryEntity> categoryEntityList;

    public List<CategoryEntity> getCategoryEntityList()
    {
        return categoryEntityList;
    }

    public void setCategoryEntityList(List<CategoryEntity> categoryEntityList)
    {
        this.categoryEntityList = categoryEntityList;
    }

}