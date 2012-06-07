package org.aksw.ldreader;

import java.io.IOException;

import org.junit.Test;

/**
 * 
 * @author Jens Lehmann
 *
 */
public class LinkedDataReaderTest {

	@Test
	public void baseTest() throws IOException {
		String uri = "http://dbpedia.org/resource/Berlin";
		LinkedDataReader ldr = new LinkedDataReader();
		String result = ldr.readLinkedData(uri);
		System.out.println(result);
	}
	
}
