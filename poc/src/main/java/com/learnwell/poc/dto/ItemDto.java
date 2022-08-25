package com.learnwell.poc.dto;

public class ItemDto {
	
	private Long id;
	private CartDto cartDto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CartDto getCartDto() {
		return cartDto;
	}
	public void setCartDto(CartDto cartDto) {
		this.cartDto = cartDto;
	}
	
	
}
