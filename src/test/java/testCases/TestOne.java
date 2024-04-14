package testCases;

import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.Methods;
import io.restassured.response.Response;
import pojo.User;

public class TestOne {

@Test(priority=1)	
public void getAlldataTest() {
	
Response res=Methods.getAlldata();
List<String>names=res.jsonPath().getList("name");
res.then().log().all();
System.out.println("Names list = "+names);
//Assert.assertEquals(names.size(), 2);

}
	
@Test(priority=2)
public void postTest() {
	
Faker f=new Faker();
Random r=new Random();
User user=new User();
user.setName(f.name().nameWithMiddle());
user.setAge(String.valueOf(r.nextInt(50)));
user.setTown(f.address().cityName());
Response res=Methods.post(user);

}

@Test(priority=3)
public void getAlldataAfterPostingNewHumanTest() {
	
Response res=Methods.getAlldata();
List<String>names=res.jsonPath().getList("name");

System.out.println("Names list = "+names);
//Assert.assertEquals(names.size(), 3);

}
@Test(priority=4)
public void updateHumanFromTheList() {

User user=new User();
user.setId(1);
user.setName("Alex");
user.setAge("37.5");
user.setTown("new york");
Methods.update(user);
	
}

@Test(priority=5)
public void getAlldataAfterUpdateHumanTest() {
	
Response res=Methods.getAlldata();
List<String>names=res.jsonPath().getList("name");

System.out.println("Names list = "+names);
//Assert.assertEquals(names.size(), 3);
String nameAfterUpdate=res.jsonPath().get("name[1]").toString();
System.out.println(nameAfterUpdate);
}


}
