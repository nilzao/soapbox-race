package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerformancePartsType", propOrder = { "performancePartTrans" })
@XmlRootElement(name = "PerformanceParts")
public class PerformancePartsType {
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "PerformancePartTrans")
	public static class PerformancePartTrans {
		@XmlElement(name = "PerformancePartAttribHash")
		private String PerformancePartAttribHash;

		public String getPerformancePartAttribHash() {
			return PerformancePartAttribHash;
		}

		public void setPerformancePartAttribHash(String PerformancePartAttribHash) {
			this.PerformancePartAttribHash = PerformancePartAttribHash;
		}
	}

	@XmlElement(name = "PerformancePartTrans")
	private PerformancePartTrans[] performancePartTrans;

	public PerformancePartTrans[] getPerformancePartTrans() {
		return performancePartTrans;
	}

	public void setPerformancePartTrans(PerformancePartTrans[] PerformancePartTrans) {
		this.performancePartTrans = PerformancePartTrans;
	}
}