package io.ioevent.samples.parallelexemple.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ioevent.starter.annotations.EndEvent;
import com.ioevent.starter.annotations.GatewayInputEvent;
import com.ioevent.starter.annotations.GatewayOutputEvent;
import com.ioevent.starter.annotations.IOEvent;
import com.ioevent.starter.annotations.IOFlow;
import com.ioevent.starter.annotations.IOPayload;
import com.ioevent.starter.annotations.InputEvent;
import com.ioevent.starter.annotations.OutputEvent;

import io.ioevent.samples.parallelexemple.domain.Customer;
import io.ioevent.samples.parallelexemple.domain.Order;
import io.ioevent.samples.parallelexemple.domain.Product;
import io.ioevent.samples.parallelexemple.enums.OrderState;

@IOFlow(name = "parallel Exemple Flow")
@Service
public class ParallelExempleService {

	List<Product> products = Arrays.asList(new Product("0", 5, 300L), new Product("1", 2, 200L),
			new Product("2", 15, 100L), new Product("3", 6, 1000L));
	List<Customer> customers = Arrays.asList(new Customer("0", 5000L), new Customer("1", 300L),
			new Customer("2", 1000L), new Customer("3", 10000L));
	private static final Logger log = LoggerFactory.getLogger(ParallelExempleService.class);

	@IOEvent(key = "create order", topic = "order-exemple-topic", output = @OutputEvent(key = "order created"))
	public Order createOrder() {
		Random random = new Random();
		return new Order(String.valueOf(random.nextInt()), products.get(random.nextInt(3)).getId(), random.nextInt(10),
				customers.get(random.nextInt(3)).getCustomerId(), OrderState.CREATED);

	}

	@IOEvent(key = "Process Order", topic = "order-exemple-topic", input = @InputEvent(key = "order created"), //
			gatewayOutput = @GatewayOutputEvent(parallel = true, output = { //
					@OutputEvent(key = "order to check stock"), //
					@OutputEvent(key = "order to check budget")//
			}))
	public Order processingOrder(Order order) {
		order.setState(OrderState.PENDING);

		return order;
	}

	@IOEvent(key = "check stock", topic = "order-exemple-topic", input = @InputEvent(key = "order to check stock"), output = @OutputEvent(key = "stock checked"))
	public Order checkStock(Order order) {
		log.info("checking stock ...");
		if (order.getProductquatity() <= products.get(Integer.valueOf(order.getProductId())).getStock()) {
			order.setState(OrderState.VALID_STOCK);
		} else {
			order.setState(OrderState.INVALID_STOCK);
		}
		return order;
	}

	@IOEvent(key = "check budget", topic = "order-exemple-topic", input = @InputEvent(key = "order to check budget"), output = @OutputEvent(key = "budget checked"))
	public Order checkBudget(Order order) {
		log.info("checking budget ...");
		Product product = products.get(Integer.valueOf(order.getProductId()));
		Customer customer = customers.get(Integer.valueOf(order.getCustomerID()));

		if (customer.getBudget() >= (product.getPrice() * order.getProductquatity())) {
			order.setState(OrderState.VALID_BUDGET);
		} else {
			order.setState(OrderState.INVALID_BUDGET);
		}
		return order;
	}

	@IOEvent(key = "validate order", topic = "order-exemple-topic", //
			gatewayInput = @GatewayInputEvent(parallel = true, input = { //
					@InputEvent(key = "stock checked"), //
					@InputEvent(key = "budget checked")//
			}), output = @OutputEvent("close order"))
	public Order validateOrder(@IOPayload(index = 0) Order stock, @IOPayload(index = 1) Order budget) {
		Order order = new Order(stock.getId(), stock.getProductId(), stock.getProductquatity(), stock.getCustomerID(),
				null);
		if (stock.getState().equals(OrderState.INVALID_STOCK) && budget.getState().equals(OrderState.INVALID_BUDGET)) {
			order.setState(OrderState.ERROR);
		} else if (stock.getState().equals(OrderState.INVALID_STOCK)) {
			order.setState(OrderState.STOCK_ERROR);
		} else if (budget.getState().equals(OrderState.INVALID_BUDGET)) {
			order.setState(OrderState.BUDGET_ERROR);
		} else {
			order.setState(OrderState.ACCEPTED);
		}

		return order;
	}

	@IOEvent(key = "close order", topic = "order-exemple-topic", input = @InputEvent("close order"), endEvent = @EndEvent(key = "parallel Exemple Flow"))
	public Order closeOrder(Order order) {

		if (order.getState().equals(OrderState.ACCEPTED)) {
			order.setState(OrderState.CLOSED);
		}
		return order;
	}
}
