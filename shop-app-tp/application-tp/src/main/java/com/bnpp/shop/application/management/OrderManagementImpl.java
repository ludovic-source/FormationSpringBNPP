package com.bnpp.shop.application.management;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.shop.domain.entity.CustomerEntity;
import com.bnpp.shop.domain.entity.ItemEntity;
import com.bnpp.shop.domain.entity.OrderEntity;
import com.bnpp.shop.infrastructure.repository.ItemRepository;
import com.bnpp.shop.infrastructure.repository.OrderRepository;

@Service
@Transactional
public class OrderManagementImpl implements OrderManagement {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemManagement itemManagement;
	
	@Autowired
	CustomerManagement customerManagement;
	
	private static Set<ItemEntity> itemsEntitiesFind;
	private static ItemEntity itemFind;
	
	private static final Log logger = LogFactory.getLog(OrderManagementImpl.class);
	
	public void create(OrderEntity order) {
		orderRepository.save(order);
		logger.info("create order");
		
	}	

	public Optional<OrderEntity> findEntity(Integer id) {
		logger.info("find Order by id");
		return orderRepository.findById(id);
	}

	public Set<OrderEntity> findEntityByCustomer(Integer idCustomer) {
		logger.info("find Order by Customer");
		Optional<CustomerEntity> customer = customerManagement.findCustomer(idCustomer);
		return orderRepository.findByCustomer(customer);
	}

	public void update(OrderEntity order) {
		orderRepository.save(order);
		logger.info(order);
		
	}

	@Override
	public Set<ItemEntity> findItemsByOrder(Integer idOrder) {
		Optional<OrderEntity> orderEntity = orderRepository.findById(idOrder);		
		orderEntity.ifPresent(theOrderEntity -> lambdaFindItemsByIdOrder(theOrderEntity));		
		return itemsEntitiesFind;
	}
	
	public static void lambdaFindItemsByIdOrder(OrderEntity orderEntity) {
		itemsEntitiesFind = orderEntity.getItems();
	}

	@Override
	public OrderEntity createOrderByCustomer(OrderEntity order) {
		OrderEntity orderValide = order;
		System.out.println("Management - order de début : " + order.getCustomer().getName());
		
		// verifier que le client existe et mettre à jour les infos clients de l'order, dont l'id
		CustomerEntity customer = customerManagement.findByName(order.getCustomer().getName());
		if (customer == null) {
			System.out.println("client non trouvé");
			return null;
		}
		orderValide.setCustomer(customer);
		
		// calculer le montant total de la commande
		// --- pour chaque item, récupérer le prix dans la base, puis faire la somme de tous les items
		BigDecimal totalOrder = new BigDecimal(0);
		for (ItemEntity item : order.getItems()) {
			System.out.println("item : " + item.getId());
			Optional<ItemEntity> itemComplet = itemManagement.findItem(item.getId());
			itemComplet.ifPresent(theItemComplet -> lambdaFindItemsByIdItem(theItemComplet));
			BigDecimal prix = itemFind.getPrice();
			totalOrder = totalOrder.add(prix);
		}
		orderValide.setTotal(totalOrder);
		
		// création de la commande dans la base, et récupération de l'id de commande via l'objet
		OrderEntity orderCree = orderRepository.save(orderValide);
		System.out.println("order créé : " + orderCree.getId());
		
		return orderCree;
	}
	
	public static void lambdaFindItemsByIdItem(ItemEntity itemEntity) {
		itemFind = itemEntity;
	}

}
