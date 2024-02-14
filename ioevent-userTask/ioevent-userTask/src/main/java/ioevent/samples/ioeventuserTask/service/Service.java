package ioevent.samples.ioeventuserTask.service;

import com.ioevent.starter.annotations.IOEvent;
import com.ioevent.starter.annotations.IOFlow;
import com.ioevent.starter.annotations.InputEvent;
import com.ioevent.starter.annotations.OutputEvent;
import com.ioevent.starter.enums.EventTypesEnum;
import ioevent.samples.ioeventuserTask.domain.Product;
import ioevent.samples.ioeventuserTask.domain.WorkerDecision;

@IOFlow(name = "Products Flow")
@org.springframework.stereotype.Service
public class Service {

    @IOEvent(
            key = "capture prodcut",
            output = @OutputEvent(key = "product to search captured", topic = "product-topic", userActionRequired = true)
    )
    public Product captureOrder() {
        return new Product("1", "product1", "description", "category", 100.0);
    }

    @IOEvent(
            key = "check product availability",
            input = @InputEvent(key = "product to search captured", topic = "product-topic"),
            output = @OutputEvent(key = "product availability checked", topic = "product-topic"),EventType = EventTypesEnum.USER
    )
    public WorkerDecision checkProductAvailability(WorkerDecision workerDecision) {
        return workerDecision;

    }

    @IOEvent(
            key = "send decision to dashboard",
            topic = "product-topic",
            input = @InputEvent(key = "product availability checked", topic = "product-topic")
    )
    public WorkerDecision sendDecisionToDashboard(WorkerDecision workerDecision) {
        return workerDecision;
    }
}
