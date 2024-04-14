package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.User;

import static io.restassured.RestAssured.*;

import api.Routes;

public class Methods {
	
public static Response getAlldata() {
	
Response response=given().get(Routes.getAllUrl);
return response;	
}

public static Response getByID(int id) {
	
String idS= "/"+String.valueOf(id);
Response response=given().get(Routes.getAllUrl+idS);
return response;
}

public static Response post(User user) {
	
Response response=given().contentType("application/json")
.accept(ContentType.JSON).body(user).post(Routes.postUrl);
return response;
}

public static Response update(User user) {
	
Response response=given().contentType("application/json")
.accept(ContentType.JSON).body(user).put(Routes.updateUrl);
return response;
}






}
