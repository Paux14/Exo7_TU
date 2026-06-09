package com.boutique.commande.bdd;

import io.cucumber.java.Before;
import org.mockito.Mockito;

public class CucumberHooks {

    private final OrderTestContext context;

    public CucumberHooks(OrderTestContext context) {
        this.context = context;
    }

    @Before
    public void resetMocks() {
        Mockito.reset(context.getProductRepository());
    }
}
