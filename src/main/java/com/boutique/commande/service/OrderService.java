package com.boutique.commande.service;

import com.boutique.commande.model.Order;
import com.boutique.commande.model.OrderReceipt;
import com.boutique.commande.model.OrderResult;
import com.boutique.commande.model.Product;
import com.boutique.commande.repository.ProductRepository;

public class OrderService {

    private final ProductRepository productRepository;

    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public OrderResult processOrder(Order order) {
        Product product = productRepository.findByReference(order.getProductReference())
                .orElse(null);

        if (product == null) {
            return OrderResult.rejected("Produit inconnu : " + order.getProductReference());
        }

        if (order.getQuantity() > product.getAvailableStock()) {
            return OrderResult.rejected("Stock insuffisant pour le produit " + product.getReference());
        }

        double subtotal = product.getUnitPrice() * order.getQuantity();
        double discount = subtotal * order.getClientProfile().getDiscountRate();
        double totalAmount = subtotal - discount;

        OrderReceipt receipt = new OrderReceipt(
                product.getReference(),
                order.getQuantity(),
                totalAmount,
                "Commande confirmée pour " + order.getClientEmail()
        );

        return OrderResult.accepted(receipt);
    }
}
