package com.eval.coronakit.test.utils;

import com.eval.coronakit.entity.ProductMaster;

public class MasterData {

	public static ProductMaster getProduct() {
		ProductMaster product = new ProductMaster(1, "First", 200,"First Product");
		return product;
	}
}
