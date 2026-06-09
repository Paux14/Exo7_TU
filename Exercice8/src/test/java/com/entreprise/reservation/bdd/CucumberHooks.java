package com.entreprise.reservation.bdd;

import io.cucumber.java.Before;
import org.mockito.Mockito;

public class CucumberHooks {

    private final ReservationTestContext context;

    public CucumberHooks(ReservationTestContext context) {
        this.context = context;
    }

    @Before
    public void resetMocks() {
        Mockito.reset(
                context.getRoomRepository(),
                context.getReservationRepository(),
                context.getNotificationService()
        );
    }
}
