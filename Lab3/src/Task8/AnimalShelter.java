package Task8;
import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    private final List<Dog> dogs = new ArrayList<>();
    private final List<Animal> otherAnimals = new ArrayList<>();

    public void addAnimals(Dog dog) {
        dogs.add(dog);
    }

    public void addAnimals(Animal animal) {
        otherAnimals.add(animal);
    }

    public void printAnimalSounds() {
        for (Dog dog : dogs) {
            dog.makeSound();
        }
        for (Animal animal : otherAnimals) {
            animal.makeSound();
        }

    }
}
