package com.epicode.spring.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	private List<Pizza> menuPizze = new ArrayList<Pizza>();
	private List<Drink> menuDrink = new ArrayList<Drink>();
	private List<Franchise> menuFranchise = new ArrayList<Franchise>();
	

	public List<Pizza> getMenuPizze() {
		return menuPizze;
	}

	public void setMenPizze(List<Pizza> menu) {
		this.menuPizze = menu;
	}

	public List<Drink> getMenuDrink() {
		return menuDrink;
	}

	public void setMenuDrink(List<Drink> menuDrink) {
		this.menuDrink = menuDrink;
	}

	public List<Franchise> getMenuFranchise() {
		return menuFranchise;
	}

	public void setMenuFranchise(List<Franchise> menuFranchise) {
		this.menuFranchise = menuFranchise;
	}
	
	

	

}
