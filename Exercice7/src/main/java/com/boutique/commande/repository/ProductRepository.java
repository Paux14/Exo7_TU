package com.boutique.commande.repository;

import com.boutique.commande.model.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findByReference(String reference);
}
