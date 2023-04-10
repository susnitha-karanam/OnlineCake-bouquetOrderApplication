package com.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.model.Delivery;
import com.repository.DeliveryRepository;

public class DeliveryserviceTest {
	
	@Mock
	private DeliveryRepository deliveryrepo;
	
	
	@InjectMocks
	private Deliveryservice deliveryservice;
	
	
	@BeforeEach
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testUpdateDeliveryStatus() throws Exception
	{
		Delivery delivery = new Delivery();
		delivery.setId(1);
		delivery.setFeedback("good");
		delivery.setDeliveryStatus("Delivered");
		delivery.setUserid(1);
		delivery.setTotal(200);
		when(deliveryrepo.findById(1)).thenReturn(Optional.of(delivery));
		when(deliveryrepo.save(delivery)).thenReturn(delivery);
		Delivery updateddelivery = deliveryservice.UpdateDeliveryStatus(1);

		assertNotNull(updateddelivery);
		assertEquals ("good",updateddelivery.getDeliveryStatus());
		}
	
	
	@Test
	public void  testGetAllDeliveries()
	{
		Delivery delivery = new Delivery();
		delivery.setId(1);
		delivery.setFeedback("good");
		delivery.setDeliveryStatus("Delivered");
		delivery.setUserid(1);
		delivery.setTotal(200);
		
		Delivery delivery1 = new Delivery();
		delivery1.setId(2);
		delivery1.setFeedback("thankyou");
		delivery1.setDeliveryStatus("Deliveredd");
		delivery1.setUserid(2);
		delivery1.setTotal(2000);	
		List<Delivery> del = new ArrayList<Delivery>();
		del.add(delivery1);
		del.add(delivery);
		
		when(deliveryrepo.findAll()).thenReturn(del);
		List<Delivery> foundDeliveryList = deliveryservice.getallDeliveries();
		assertNotNull(foundDeliveryList);
		assertEquals(2,foundDeliveryList.size());
		}

		
	}
		
		
		



