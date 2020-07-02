package com.nirodha.haulmatic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.nirodha.haulmatic.documents.Roles;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HaulmaticApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HaulmaticApplicationTests {
	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetAllRoles(){
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);

		ResponseEntity<String> responseEntity = testRestTemplate.exchange(getRootUrl()+"/roles/all", HttpMethod.GET, entity, String.class);
		assertNotNull(responseEntity.getBody());
	}

	@Test
	public void testCreateRole(){

		Roles role = new Roles(100,"test_org","test_fname","test_lname","test_nic", Roles.RoleType.DRIVER);
		ResponseEntity<Roles> postResponse = testRestTemplate.postForEntity(getRootUrl() + "/roles", role, Roles.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateRole(){
		int id = 1;
		Roles role = testRestTemplate.getForObject(getRootUrl() + "/roles/update" + id, Roles.class);
		role.setFirstName("admin1");
		role.setLastName("admin2");
		testRestTemplate.put(getRootUrl() + "/roles/update" + id, role);
		Roles updateRole = testRestTemplate.getForObject(getRootUrl() + "/roles/update" + id, Roles.class);
		assertNotNull(updateRole);
	}

	@Test
	public void testDeleteById(){
		int id = 1;
		Roles role = testRestTemplate.getForObject(getRootUrl() + "/roles/delete" + id, Roles.class);
		assertNotNull(role);
		testRestTemplate.delete(getRootUrl() + "/roles/delete" + id);
		try {
			role = testRestTemplate.getForObject(getRootUrl() + "/roles/delete" + id, Roles.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
