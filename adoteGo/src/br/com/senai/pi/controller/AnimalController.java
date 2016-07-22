package br.com.senai.pi.controller;

import br.com.senai.pi.model.Animal;

public class AnimalController extends Animal {

	Animal animal = new Animal();

	public void setAnimal(String especie, String raca, String caracteristicas) {
		animal.setEspecie(especie);
		animal.setRaca(raca);
		animal.setCaracteristicas(caracteristicas);
	}

	public Animal getAnimal() {
		return animal;
	}
}
