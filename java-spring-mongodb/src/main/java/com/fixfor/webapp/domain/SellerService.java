package com.fixfor.webapp.domain;

import java.util.List;

public interface SellerService {

    List<Seller> findByDesignation(String designation);

}
