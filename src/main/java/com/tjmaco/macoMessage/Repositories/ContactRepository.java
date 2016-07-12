package com.tjmaco.macoMessage.Repositories;

/**
 * Created by thomasmaco on 11/26/15.
 */
import com.tjmaco.macoMessage.Domains.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {}