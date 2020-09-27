package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.KitDetail;

public interface KitDetailService {
	public KitDetail addKitItem(KitDetail kitItem);
	public KitDetail getKitItemById(int itemId);
	public List<KitDetail> getAllKitItemsOfAKit(int kitId);
}
