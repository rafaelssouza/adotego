package br.com.senai.pi.controller;

import br.com.senai.pi.model.Animal;

public class AnimalController extends Animal {

	Animal animal = new Animal();

	public void setAnimal(Animal anim) {
		animal.setEspecie(anim.getEspecie());
		animal.setRaca(anim.getRaca());
		animal.setCaracteristicas(anim.getCaracteristicas());
	}

	public Animal getAnimal() {
		return animal;
	}
}
