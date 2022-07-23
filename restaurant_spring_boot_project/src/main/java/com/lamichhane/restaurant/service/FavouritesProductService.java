package com.lamichhane.restaurant.service;
import java.util.List;

import com.lamichhane.restaurant.entity.CartProduct;
import com.lamichhane.restaurant.entity.FavouritesProduct;

public interface FavouritesProductService {

	public List<FavouritesProduct> getAllFavouritesProduct();
	   
	public void saveFavouritesProduct(FavouritesProduct theFavouritesProduct);

	public FavouritesProduct getFavouritesProduct(int id);

	public void deleteFavouritesProduct(int id);
}
