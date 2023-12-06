package com.epicode.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	public Menu() {}
	
	private List<Pizza> menuPizze = new ArrayList<>();
	private List<Drink> menuDrink = new ArrayList<>();
	private List<Franchise> franchise = new ArrayList<>();
	
	public List<Pizza> getMenuPizze() {
		return menuPizze;
	}
	public void setMenuPizze(List<Pizza> menuPizze) {
		this.menuPizze = menuPizze;
	}
	public List<Drink> getMenuDrink() {
		return menuDrink;
	}
	public void setMenuDrink(List<Drink> menuDrink) {
		this.menuDrink = menuDrink;
	}
	public List<Franchise> getFranchise() {
		return franchise;
	}
	public void setFranchise(List<Franchise> franchise) {
		this.franchise = franchise;
	}
	
	

}
