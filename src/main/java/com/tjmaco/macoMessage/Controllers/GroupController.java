package com.tjmaco.macoMessage.Controllers;


import com.tjmaco.macoMessage.Domains.Group;
import com.tjmaco.macoMessage.Repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by thomasmaco on 11/27/15.
 */

@RestController
public class GroupController {

    @Autowired
    private GroupRepository repo;


    @RequestMapping(value = "/groups/findall", method= RequestMethod.GET)
    public List<Group> getAllGroups() {
        return repo.findAll();
    }

    @RequestMapping(value = "/groups/create", method = RequestMethod.POST)
    public void createGroup(@RequestBody Group group){
        repo.save(group);
    }

    @RequestMapping(value = "/groups/{id}", method = RequestMethod.DELETE)
    public void deleteGroup(@PathVariable String id){
        repo.delete(id);
    }

}
