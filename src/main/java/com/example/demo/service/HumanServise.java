package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.beans.AddResponse;
import com.example.demo.beans.Human;

@Component
public class HumanServise {
	
static HashMap<Integer,Human> humansMap;

public HumanServise() {
	
humansMap=new HashMap<Integer,Human>();
Human rocky=new Human(1,"Rocky","37","philadelphia");
Human alex=new Human(2,"Alexander","35","paris");
humansMap.put(1, rocky);
humansMap.put(2, alex);
}

public List<Human> getAllHumans(){
	
List<Human>humansList=new ArrayList<>(humansMap.values());
return humansList;
}

public Human getByID(int id) {
	
Human human=humansMap.get(id);
return human;
}

public Human getByName(String name) {

Human human=null;
for(int a:humansMap.keySet()) {
Human humanX=humansMap.get(a);
String nameX=humanX.getName();
if(nameX.equals(name)) {
human=humanX;	
}
}
return human;
}

public Human addNew(Human human) {
	
int max=humansMap.size();
human.setId(max+1);
humansMap.put(human.getId(), human);
return human;
}

public Human update(Human human) {
	
int id=human.getId();
humansMap.put(id, human);
return human;
}

public AddResponse delete(int id) {

AddResponse ar=new AddResponse();
humansMap.remove(id);
ar.setId(id);
ar.setMsg("This Is Deleted");
return ar;
}









}
