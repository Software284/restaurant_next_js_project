package com.lamichhane.restaurant.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lamichhane.restaurant.entity.CartProduct;
import com.lamichhane.restaurant.entity.FavouritesProduct;
import com.lamichhane.restaurant.service.FavouritesProductService;


@RestController
@RequestMapping("/restaurant")
public class FavouritesProductController {
	
	@Autowired
	private FavouritesProductService favouritesProductService;
	
	/* Product API request processing */
	
	@GetMapping("/favouritesproduct")
	public List<FavouritesProduct> getAllFavouritesProduct() {
		return favouritesProductService.getAllFavouritesProduct();
	}
	
	@GetMapping("/favouritesproduct/{favouritesproudctId}")
	public FavouritesProduct getFavouritesProduct(@PathVariable int favouritesproudctId) {
		FavouritesProduct favourites_product = favouritesProductService.getFavouritesProduct(favouritesproudctId);
		return favourites_product;
	}
	
	
	@PostMapping("/favouritesproduct")
	public ResponseEntity<FavouritesProduct> saveFavouritesProduct(@RequestBody FavouritesProduct favouritesproduct) {
		favouritesProductService.saveFavouritesProduct(favouritesproduct);
		return new ResponseEntity<>(favouritesproduct,HttpStatus.CREATED);
	}
	
	@PutMapping("/favouritesproduct")
	public FavouritesProduct updateFavouritesProduct(@RequestBody FavouritesProduct favouritesproduct) {
		favouritesProductService.saveFavouritesProduct(favouritesproduct);
		return favouritesproduct;
	}
	
	@DeleteMapping("/favouritesproduct/{cartproductId}")
	public String deleteFavouritesProduct(@PathVariable int favouritesproductId) {
		FavouritesProduct fav_product = favouritesProductService.getFavouritesProduct(favouritesproductId);
		favouritesProductService.deleteFavouritesProduct(favouritesproductId);
		
		return "Deleted Favourites Product  Id is : "+favouritesproductId;
	}

}
