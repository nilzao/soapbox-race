package br.com.soapboxrace.jaxb.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class UnmarshalXML {

	public static Object unMarshal(String xmlStr, Object obj) {
		Object objTmp = null;
		try {
			StringReader reader = new StringReader(xmlStr);
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(reader);
			XMLReaderWithoutNamespace xr = new XMLReaderWithoutNamespace(xsr);
			objTmp = jaxbUnmarshaller.unmarshal(xr);
			// objTmp = jaxbUnmarshaller.unmarshal(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objTmp;
	}
}
