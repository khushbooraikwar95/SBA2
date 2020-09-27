package com.eval.coronakit.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.eval.coronakit.dao.CoronaKitRepository;
import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller

@RequestMapping("/user")
public class UserController {
	@Autowired
	HttpSession session;

	@Autowired
	ProductService productService;

	@Autowired
	CoronaKitService coronaKitService;

	@Autowired
	KitDetailService kitDetailService;

	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}

	@RequestMapping("/show-list")
	public String showList(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "show-all-item-user";
	}

	@RequestMapping("/add-to-cart/{productId}")
	public String showKit(@PathVariable("productId") int productId) {
		String view = "redirect:/user/show-kit";
		@SuppressWarnings("unchecked")
		Map<Integer, KitDetail> cart = (Map<Integer, KitDetail>) session.getAttribute("cart");
		if (null == cart) {
			cart = new HashMap<Integer, KitDetail>();
			session.setAttribute("cart", cart);
		}

		if (cart.containsKey(productId)) {
			KitDetail kitDtls = cart.get(productId);
			int newQty = kitDtls.getQuantity() + 1;
			kitDtls.setQuantity(newQty);
			kitDtls.setAmount(productService.getProductById(productId).getCost() * newQty);
		} else {
			ProductMaster product = productService.getProductById(productId);
			if (null != product) {
				KitDetail kitDtls = new KitDetail();
				kitDtls.setProductId(productId);
				kitDtls.setQuantity(1);
				kitDtls.setAmount(product.getCost());
				cart.put(productId, kitDtls);
			}else {
				view = "redirect:/custom-error";
			}
		}
		return "redirect:/user/show-kit";
	}

	@RequestMapping("/show-kit")
	public String showKit(Model model) {
		@SuppressWarnings("unchecked")
		Map<Integer, KitDetail> cart = (Map<Integer, KitDetail>) session.getAttribute("cart");
		if (null != cart) {
			List<ProductMaster> selectedProducts = new ArrayList<ProductMaster>();
			cart.forEach((k, v) -> selectedProducts.add(productService.getProductById(k)));
			model.addAttribute("products", selectedProducts);
		}
		return "show-cart";
	}

	@RequestMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") int itemId) {
		@SuppressWarnings("unchecked")
		Map<Integer, KitDetail> cart = (Map<Integer, KitDetail>) session.getAttribute("cart");
		if (null != cart) {
			if (cart.containsKey(itemId)) {
				cart.remove(itemId);
			}
		}
		return "redirect:/user/show-kit";
	}

	@RequestMapping("/checkout")
	public String checkout(Model model) {
		return "checkout-address";
	}

	@RequestMapping(value = "/finalize")
	public String finalizeOrder(@RequestParam("address") String address, Model model) {
		@SuppressWarnings("unchecked")
		HashMap<Integer, KitDetail> cart = (HashMap<Integer, KitDetail>) session.getAttribute("cart");
		if (null != cart) {
			int totalAmt = 0;
			for (KitDetail kit : cart.values()) {
				totalAmt += kit.getAmount();
			}
			CoronaKit cKit = new CoronaKit();
			cKit.setDeliveryAddress(address);
			cKit.setOrderDate(LocalDateTime.now().toString());
			cKit.setTotalAmount(totalAmt);
			cKit = coronaKitService.saveKit(cKit);
			for (KitDetail kit : cart.values()) {
				kit.setCoronaKitId(cKit.getId());
				kitDetailService.addKitItem(kit);
			}
			model.addAttribute("address", address);
			model.addAttribute("totalAmount", totalAmt);

			List<ProductMaster> selectedProducts = new ArrayList<ProductMaster>();
			cart.forEach((k, v) -> selectedProducts.add(productService.getProductById(k)));
			model.addAttribute("orderedproducts", selectedProducts);
			model.addAttribute("orderDetils", cart);
			model.addAttribute("cart", null);
			session.removeAttribute("cart");
		}
		return "show-summary";
	}

}
