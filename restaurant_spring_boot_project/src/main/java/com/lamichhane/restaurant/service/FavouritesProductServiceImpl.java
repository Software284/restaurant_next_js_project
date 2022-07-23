package com.lamichhane.restaurant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.restaurant.dao.FavouritesProductDAO;
import com.lamichhane.restaurant.entity.FavouritesProduct;
import com.lamichhane.restaurant.exception.classes.FavouritesProductNotFoundException;



@Service
public class FavouritesProductServiceImpl implements FavouritesProductService{
	
	@Autowired
	private FavouritesProductDAO favouritesProductDAO;

	
	@Override
	@Transactional
	public List<FavouritesProduct> getAllFavouritesProduct() {
		
		return favouritesProductDAO.findAll();
	}

	@Override
	@Transactional
	public void saveFavouritesProduct(FavouritesProduct theFavouritesProduct) {
		favouritesProductDAO.save(theFavouritesProduct);
	}

	@Override
	@Transactional
	public FavouritesProduct getFavouritesProduct(int theId) {
		Optional<FavouritesProduct> favproduct = favouritesProductDAO.findById(theId);
		if(favproduct.isEmpty()) {
			throw new FavouritesProductNotFoundException("FavouritesProduct Not Found With Id-"+theId);
		}
		return favproduct.get();
		
	}

	@Override
	@Transactional
	public void deleteFavouritesProduct(int id) {
		favouritesProductDAO.deleteById(id);
	}

	
	
}
