package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.DeliveryNotFoundException;
import com.exception.ResourceNotFoundException;
import com.model.Delivery;
import com.model.Product;
import com.model.User;
import com.repository.DeliveryRepository;
import com.repository.OrderredProductRepo;
import com.repository.ProductRepository;

@Service
public class Deliveryservice {
	@Autowired
	private OrderredProductRepo orderredProductRepo;

	@Autowired
	private  DeliveryRepository deliveryRepository;
	
	

//	to see all Deliveries
	public List<Delivery> getallDeliveries() {
		return deliveryRepository.findAll();
	}
	
// to see by id
	/*public Delivery getDeliverybyID(int id) {
		// TODO Auto-generated method stub
		return deliveryRepository.findById(id).get();
	}*/
	
	
	
//	to update the delivery Status
	public Delivery UpdateDeliveryStatus(int deliveryId) throws Exception {
		Delivery delivery = deliveryRepository.findById(deliveryId).get();
		if(delivery != null) {
			delivery.setDeliveryStatus("Delivered");
			deliveryRepository.save(delivery);
			return delivery;
		}else {
			throw new Exception("No Order found");
		}
		
	}
	
	public List<Delivery> findAllUserOrders(int uid){
		return deliveryRepository.findAllByUserid(uid);
	}
	
	public Delivery AddFeedback(int did,String feedback) throws Exception {
		Delivery delivery = deliveryRepository.findById(did).get();
		if(delivery != null) {
			if(delivery.getDeliveryStatus().equalsIgnoreCase("Delivered")) {
				delivery.setFeedback(feedback);
				deliveryRepository.save(delivery);
				return delivery;
			}else {
				throw new Exception("Still Your Order is Not Delivered !! Thanks For Your Interest");
			}
			
		}else {
			throw new Exception("No Order Found");
		}
	}
	

}
