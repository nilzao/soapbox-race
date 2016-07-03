package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VinylsType")
@XmlRootElement(name = "Vinyls")
public class VinylsType {
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(propOrder = { "Hash", "Hue1", "Hue2", "Hue3", "Hue4", "Layer", "Mir", "Rot", "Sat1", "Sat2", "Sat3",
			"Sat4", "ScaleX", "ScaleY", "Shear", "TranX", "TranY", "Var1", "Var2", "Var3", "Var4" })
	@XmlRootElement(name = "CustomVinylTrans")
	public static class CustomVinylTrans {
		@XmlElement(name = "Hash")
		private String Hash;
		@XmlElement(name = "Hue1")
		private String Hue1;
		@XmlElement(name = "Hue2")
		private String Hue2;
		@XmlElement(name = "Hue3")
		private String Hue3;
		@XmlElement(name = "Hue4")
		private String Hue4;
		@XmlElement(name = "Layer")
		private String Layer;
		@XmlElement(name = "Mir")
		private String Mir;
		@XmlElement(name = "Rot")
		private String Rot;
		@XmlElement(name = "Sat1")
		private String Sat1;
		@XmlElement(name = "Sat2")
		private String Sat2;
		@XmlElement(name = "Sat3")
		private String Sat3;
		@XmlElement(name = "Sat4")
		private String Sat4;
		@XmlElement(name = "ScaleX")
		private String ScaleX;
		@XmlElement(name = "ScaleY")
		private String ScaleY;
		@XmlElement(name = "Shear")
		private String Shear;
		@XmlElement(name = "TranX")
		private String TranX;
		@XmlElement(name = "TranY")
		private String TranY;
		@XmlElement(name = "Var1")
		private String Var1;
		@XmlElement(name = "Var2")
		private String Var2;
		@XmlElement(name = "Var3")
		private String Var3;
		@XmlElement(name = "Var4")
		private String Var4;

		public String getHash() {
			return Hash;
		}

		public String getHue1() {
			return Hue1;
		}

		public String getHue2() {
			return Hue2;
		}

		public String getHue3() {
			return Hue3;
		}

		public String getHue4() {
			return Hue4;
		}

		public String getLayer() {
			return Layer;
		}

		public String getMir() {
			return Mir;
		}

		public String getRot() {
			return Rot;
		}

		public String getSat1() {
			return Sat1;
		}

		public String getSat2() {
			return Sat2;
		}

		public String getSat3() {
			return Sat3;
		}

		public String getSat4() {
			return Sat4;
		}

		public String getScaleX() {
			return ScaleX;
		}

		public String getScaleY() {
			return ScaleY;
		}

		public String getShear() {
			return Shear;
		}

		public String getTranX() {
			return TranX;
		}

		public String getTranY() {
			return TranY;
		}

		public String getVar1() {
			return Var1;
		}

		public String getVar2() {
			return Var2;
		}

		public String getVar3() {
			return Var3;
		}

		public String getVar4() {
			return Var4;
		}

		public void setHash(String Hash) {
			this.Hash = Hash;
		}

		public void setHue1(String Hue1) {
			this.Hue1 = Hue1;
		}

		public void setHue2(String Hue2) {
			this.Hue2 = Hue2;
		}

		public void setHue3(String Hue3) {
			this.Hue3 = Hue3;
		}

		public void setHue4(String Hue4) {
			this.Hue4 = Hue4;
		}

		public void setLayer(String Layer) {
			this.Layer = Layer;
		}

		public void setMir(String Mir) {
			this.Mir = Mir;
		}

		public void setRot(String Rot) {
			this.Rot = Rot;
		}

		public void setSat1(String Sat1) {
			this.Sat1 = Sat1;
		}

		public void setSat2(String Sat2) {
			this.Sat2 = Sat2;
		}

		public void setSat3(String Sat3) {
			this.Sat3 = Sat3;
		}

		public void setSat4(String Sat4) {
			this.Sat4 = Sat4;
		}

		public void setScaleX(String ScaleX) {
			this.ScaleX = ScaleX;
		}

		public void setScaleY(String ScaleY) {
			this.ScaleY = ScaleY;
		}

		public void setShear(String Shear) {
			this.Shear = Shear;
		}

		public void setTranX(String TranX) {
			this.TranX = TranX;
		}

		public void setTranY(String TranY) {
			this.TranY = TranY;
		}

		public void setVar1(String Var1) {
			this.Var1 = Var1;
		}

		public void setVar2(String Var2) {
			this.Var2 = Var2;
		}

		public void setVar3(String Var3) {
			this.Var3 = Var3;
		}

		public void setVar4(String Var4) {
			this.Var4 = Var4;
		}
	}

	@XmlElement(name = "CustomVinylTrans")
	private CustomVinylTrans[] customVinylTrans;

	public CustomVinylTrans[] getCustomVinylTrans() {
		return customVinylTrans;
	}

	public void setCustomVinylTrans(CustomVinylTrans[] CustomVinylTrans) {
		this.customVinylTrans = CustomVinylTrans;
	}
}