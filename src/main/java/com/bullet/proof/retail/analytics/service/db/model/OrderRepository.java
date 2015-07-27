/**
 * 
 */
package com.bullet.proof.retail.analytics.service.db.model;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ram
 *
 */
public interface OrderRepository extends MongoRepository<Order, String> {

}
