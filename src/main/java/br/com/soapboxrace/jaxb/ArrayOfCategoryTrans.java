package br.com.soapboxrace.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.soapboxrace.jpa.CategoryEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCategoryTransType")
@XmlRootElement(name = "ArrayOfCategoryTrans")
public class ArrayOfCategoryTrans {

	@XmlElement(name = "CategoryTrans")
    private List<CategoryEntity> categoryEntity;

    public List<CategoryEntity> getCategoryEntity()
    {
        return categoryEntity;
    }

    public void setCategoryEntity(List<CategoryEntity> CategoryEntity)
    {
        this.categoryEntity = CategoryEntity;
    }

}