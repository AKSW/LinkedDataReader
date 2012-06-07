package org.aksw.ldreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * Utility class for reading in Linked Data.
 * 
 * @author Jens Lehmann
 * @author Claus Stadler
 *
 */
public class LinkedDataReader {

	private int connectTimeOut;
	private int readTimeOut;
	private String[] formats;
	
	public LinkedDataReader(int connectTimeOut, int readTimeOut,
			String[] formats) {
		super();
		this.connectTimeOut = connectTimeOut;
		this.readTimeOut = readTimeOut;
		this.formats = formats;
	}

	public InputStream streamLinkedData(String uri) throws IOException {
		URL url = new URL(uri);
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("Accept", "application/rdf+xml");
		conn.setConnectTimeout(3000);
		conn.setReadTimeout(5000);
		return conn.getInputStream();
	}
	
	public String readLinkedData(String uri) throws IOException {
		InputStream in = streamLinkedData(uri);
		return inputStreamToString(in);
	}	
	
    private String inputStreamToString(InputStream in) {
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
	    StringBuilder stringBuilder = new StringBuilder();
	    String line = null;
	
	    try {
			while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line + "\n");
			}
	    bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	    
	    return stringBuilder.toString();
    }		
	
	public int getConnectTimeOut() {
		return connectTimeOut;
	}

	public void setConnectTimeOut(int connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}

	public int getReadTimeOut() {
		return readTimeOut;
	}

	public void setReadTimeOut(int readTimeOut) {
		this.readTimeOut = readTimeOut;
	}

	public String[] getFormats() {
		return formats;
	}

	public void setFormats(String[] formats) {
		this.formats = formats;
	}

}
