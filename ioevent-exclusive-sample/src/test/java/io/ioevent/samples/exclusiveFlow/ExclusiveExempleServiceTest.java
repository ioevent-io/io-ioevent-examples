package io.ioevent.samples.exclusiveFlow;

import com.ioevent.starter.annotations.IOResponse;
import io.ioevent.samples.exclusiveFlow.domain.TravelDestination;
import io.ioevent.samples.exclusiveFlow.domain.TravelPlan;
import io.ioevent.samples.exclusiveFlow.service.ExclusiveExempleService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExclusiveExempleServiceTest {
    private final ExclusiveExempleService exclusiveExempleService = new ExclusiveExempleService();

    @Test
    void testCheckDistance(){
        TravelDestination travelDestination = new TravelDestination("Dubai", 4500);

        IOResponse<TravelPlan> expectedResult = new IOResponse<>("more than 300km", new TravelPlan(travelDestination, null));

        IOResponse<TravelPlan> returnedResult = exclusiveExempleService.checkDistance(travelDestination);

        assertEquals(expectedResult.getBody().getDestination(),returnedResult.getBody().getDestination(),"expected destination is equal to returned destination");
        assertEquals(expectedResult.getBody().getWayOfTravel(),returnedResult.getBody().getWayOfTravel(),"expected way of travel is equal to returned way of travel");
        assertEquals(expectedResult.getKey(),returnedResult.getKey(),"expected key is equal to returned key");
    }

}