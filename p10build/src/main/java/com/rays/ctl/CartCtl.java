package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CartDTO;
import com.rays.dto.CartDTO;
import com.rays.form.CartForm;
import com.rays.service.CartServiceInt;

@RestController
@RequestMapping(value = "Cart")
public class CartCtl extends BaseCtl<CartForm, CartDTO, CartServiceInt> {
	
	 @GetMapping("/preload")
	    public ORSResponse preload() {
	        ORSResponse res = new ORSResponse(true);

	        HashMap<Integer, String> productMap = new HashMap<>();
	        productMap.put(1, "Fridge");
	        productMap.put(2, "washing Machine");
	        productMap.put(3, "Laptop");
	        

	        List<Map<String, Object>> productList = new ArrayList<>();
	        productMap.forEach((key, value) -> {
	            Map<String, Object> item = new HashMap<>();
	            item.put("key", key);
	            item.put("value", value);
	            productList.add(item);
	        });

	        res.addResult("productList", productList);

	        return res;
	    }
}
