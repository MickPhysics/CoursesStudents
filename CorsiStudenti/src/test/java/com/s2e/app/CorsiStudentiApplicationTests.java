package com.s2e.app;


//import static org.hamcrest.MatcherAssert.assertThat;
//
//import static org.hamcrest.Matchers.equalTo;
//
//import java.io.IOException;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

//import static org.junit.Assert.*;


@SpringBootTest
class CorsiStudentiApplicationTests {
    @LocalServerPort
	private int port;
	@Test
	void contextLoads() {
	}
	
	/*
	 * Test di un servizio Rest
	 */
	
//	@Test 
//	void givenStudents_studentsReceived_status200() throws ClientProtocolException, IOException {
//		
//		System.out.println("test partito");
//		// Scrivo la richiesta http
//		HttpUriRequest request = new HttpGet("http://localhost:4202/students/");
//		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//		// 200 response test
//		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
//		
//		System.out.println("test eseguito");
//	}
//	
//	@Test
//	void givenStudentsDelete_deleteById() throws ClientProtocolException, IOException {
//		
//		int idTest = 1;
//		HttpUriRequest request = new HttpGet("http://localhost:4202/students/"+idTest);
//		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
//	}
	
	
	

}
