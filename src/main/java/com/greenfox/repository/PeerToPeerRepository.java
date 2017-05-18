package com.greenfox.repository;

import com.greenfox.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface PeerToPeerRepository extends CrudRepository <Message, Long> {

}