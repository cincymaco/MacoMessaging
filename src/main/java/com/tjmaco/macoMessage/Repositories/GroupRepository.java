package com.tjmaco.macoMessage.Repositories;

import com.tjmaco.macoMessage.Domains.*;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by thomasmaco on 11/27/15.
 */
public interface GroupRepository extends MongoRepository<Group, String> {

}

