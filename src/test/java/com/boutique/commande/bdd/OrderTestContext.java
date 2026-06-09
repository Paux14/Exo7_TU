package com.boutique.commande.bdd;

import com.boutique.commande.model.ClientProfile;
import com.boutique.commande.model.OrderResult;
import com.boutique.commande.repository.ProductRepository;
import com.boutique.commande.service.OrderService;
import org.mockito.Mockito;

public class OrderTestContext {

    private final ProductRepository productRepository;
    private final OrderService orderService;
    private String clientEmail;
    private ClientProfile clientProfile;
    private OrderResult lastResult;

    public OrderTestContext() {
        this.productRepository = Mockito.mock(ProductRepository.class);
        this.orderService = new OrderService(productRepository);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public ClientProfile getClientProfile() {
        return clientProfile;
    }

    public void setClientProfile(ClientProfile clientProfile) {
        this.clientProfile = clientProfile;
    }

    public OrderResult getLastResult() {
        return lastResult;
    }

    public void setLastResult(OrderResult lastResult) {
        this.lastResult = lastResult;
    }
}
