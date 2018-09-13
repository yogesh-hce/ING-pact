package io.pivotal.microservices.pact.consumer;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Rule;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

public class ConsumerPostTest {

	@Rule
	public PactProviderRule rule = new PactProviderRule("Test_Provider", this);

	@Pact(provider = "Test_Provider", consumer = "Test_Consumer")
	public PactFragment createFragment(PactDslWithProvider builder)
			throws TransformerException, ParserConfigurationException {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/xml");

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("personResponseView");
		doc.appendChild(rootElement);
		doc.setXmlStandalone(true);

		// staff elements
		Element personId = doc.createElement("personId");
		personId.appendChild(doc.createTextNode("42"));
		rootElement.appendChild(personId);

		return builder.uponReceiving("a request for createUser").path("/createUser").method("POST")

				.willRespondWith().headers(headers).status(200)
				.body(doc).toFragment();
	}

	@Test
	@PactVerification("Test_Provider")
	public void runTest() {
		// System.out.println("hellp" + new ConsumerPort("http://localhost:8080").testPostMethod());
		assertNotNull(new ConsumerPort(this.rule.getConfig().url()).testPostMethod());
	}
}
