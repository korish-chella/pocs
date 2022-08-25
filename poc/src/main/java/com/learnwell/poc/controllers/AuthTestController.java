package com.learnwell.poc.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwell.poc.dto.CartDto;
import com.learnwell.poc.dto.ItemDto;
import com.learnwell.poc.models.Cart;
import com.learnwell.poc.models.Item;
import com.learnwell.poc.repository.CartRepository;
import com.learnwell.poc.repository.ItemsRepository;
import com.learnwell.poc.vo.QueryRequest;
import com.learnwell.poc.vo.QueryValueMap;

/**
 * 
 * @author chellak
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class AuthTestController {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	ItemsRepository itemsRepository;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('BASIC_USER') or hasRole('MANAGER') or hasAuthority('SUPERADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/manager")
	@PreAuthorize("hasRole('MANAGER')")
	public String moderatorAccess() {
		return "Manager Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('SUPER_ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

	@GetMapping("/add/cart")
	public List<Cart> getItemsInCart() {

		Cart cart1 = new Cart();
		Cart cart2 = new Cart();
		cartRepository.save(cart1);
		cartRepository.save(cart2);
		Item item1 = new Item(cart1);
		Item item2 = new Item(cart2);
		Set<Item> itemsSet = new HashSet<Item>();
		itemsSet.add(item1);
		itemsSet.add(item2);
		itemsRepository.save(item1);
		itemsRepository.save(item2);
		return cartRepository.findAll();
	}

	@GetMapping("/items")
	public List<ItemDto> getItems() {
		List<ItemDto> result = new ArrayList<>();
		List<Item> items = itemsRepository.findAll();
		items.forEach(item -> {
			ItemDto itemDto = new ItemDto();
			itemDto.setId(item.getId());
			CartDto cart = new CartDto();
			cart.setId(item.getCart().getId());
			itemDto.setCartDto(cart);
			result.add(itemDto);
		});

		return result;
	}

	@PostMapping("/queries/list")
	public List<String> getConcatedQueries(@RequestBody QueryRequest queryRequest) {
		List<String> queries = new ArrayList<>();
		/*
		 * String qr1 =
		 * "UPDATE pn_crm_aim_pnsl.asset_inv_t  SET updtd_by=1, updtd_dt = NOW(),qr_inv_id =(SELECT id FROM pn_crm_aim_pnsl.asset_qr_inv_t WHERE vpa='"
		 * ; String qr2 =
		 * ".payswiff@indus') WHERE inv_id =(SELECT inv_id FROM pn_crm_aim_pnsl.asset_inv_t WHERE inv_serial_no = 'KD58Y"
		 * ; String qr3 = "');";
		 * 
		 * for (int i = 0; i < 3760; i++) { long vpa = 63270075230l + i; long serialNo =
		 * 101339 + i; String result = qr1 + vpa + qr2 + serialNo + qr3;
		 * System.out.println(result); }
		 */

		if (Objects.isNull(queryRequest)) {
			throw new RuntimeException("Request should not be Null or Empty");
		}
		List<QueryValueMap> queriesList = queryRequest.getQueryValueMap();
		if ((Objects.isNull(queriesList) || queriesList.isEmpty()) && Objects.isNull(queryRequest.getEndQuery())) {
			throw new RuntimeException("Please provide queries");
		}
		if (!Objects.isNull(queriesList) && !queriesList.isEmpty()) {
			for (int i = 0; i < queryRequest.getCount(); i++) {
				StringBuilder sb = new StringBuilder();
				for(QueryValueMap queryval : queriesList) {
					sb.append(queryval.getQuery());
					long value = queryval.getValue() + i;
					sb.append(value);
				}
				sb.append(queryRequest.getEndQuery());
				queries.add(sb.toString());
			}
			
		}
		return queries;
	}
}
