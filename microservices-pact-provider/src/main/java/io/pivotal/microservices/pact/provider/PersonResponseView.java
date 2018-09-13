package io.pivotal.microservices.pact.provider;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonResponseView {
	
	public PersonResponseView(int personId) {
		this.personId = personId;
	}

	public PersonResponseView() {

	}

	@XmlElement(name = "personId")
	private int personId;

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
}
