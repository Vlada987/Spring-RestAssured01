package com.example.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.AddResponse;
import com.example.demo.beans.Human;
import com.example.demo.service.HumanServise;

@RestController
@RequestMapping
public class HumanControl {
	
@Autowired
HumanServise hs;

@GetMapping("/humans")
public List<Human> getAll(){

return hs.getAllHumans();
}
@GetMapping("/humans/{id}")
public Human getHumanWithID(@PathVariable(value="id")int id) {
	
return hs.getByID(id);	
}
@GetMapping("/humans/name")
public Human getHumanWithName(@RequestParam(value="name")String name) {
	
return hs.getByName(name);
}

@PostMapping("/human")
public Human addNewHuman(@RequestBody Human human) {
	
return hs.addNew(human);
}
@PutMapping("/update")
public Human updateHuman(@RequestBody Human human) {

return hs.update(human);
}
@DeleteMapping("/delete/{id}")
public AddResponse deleteHuman(@PathVariable(value="id") int id ) {
	
return hs.delete(id);
}


}
