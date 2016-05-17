package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaintsType", propOrder = { "customPaintTrans" })
@XmlRootElement(name = "Paints")
public class PaintsType {
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "Slot", "Sat", "Hue", "Var", "Group" })
	@XmlRootElement(name = "CustomPaintTrans")
	public static class CustomPaintTrans {
		@XmlElement(name = "Slot")
		private String Slot;
		@XmlElement(name = "Sat")
		private String Sat;
		@XmlElement(name = "Hue")
		private String Hue;
		@XmlElement(name = "Var")
		private String Var;
		@XmlElement(name = "Group")
		private String Group;

		public String getGroup ()
		{
			return Group;
		}

		public String getHue ()
		{
			return Hue;
		}

		public String getSat ()
		{
			return Sat;
		}

		public String getSlot ()
		{
			return Slot;
		}

		public String getVar ()
		{
			return Var;
		}

		public void setGroup (String Group)
		{
			this.Group = Group;
		}

		public void setHue (String Hue)
		{
			this.Hue = Hue;
		}

		public void setSat (String Sat)
		{
			this.Sat = Sat;
		}

		public void setSlot (String Slot)
		{
			this.Slot = Slot;
		}

		public void setVar (String Var)
		{
			this.Var = Var;
		}
	}

	@XmlElement(name = "CustomPaintTrans")
	private CustomPaintTrans[] customPaintTrans;

	public CustomPaintTrans[] getCustomPaintTrans ()
	{
		return customPaintTrans;
	}

	public void setCustomPaintTrans (CustomPaintTrans[] CustomPaintTrans)
	{
		this.customPaintTrans = CustomPaintTrans;
	}
}