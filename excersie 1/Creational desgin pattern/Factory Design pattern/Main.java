// Main.java

// Step 1: Create an interface for animals
interface Animal {
    void speak();
}

// Step 2: Concrete classes for different types of animals
class Lion implements Animal {
    @Override
    public void speak() {
        System.out.println("Roar");
    }
}

class Elephant implements Animal {
    @Override
    public void speak() {
        System.out.println("Trumpet");
    }
}

class Monkey implements Animal {
    @Override
    public void speak() {
        System.out.println("Chatter");
    }
}

// Step 3: Create an abstract class with a factory method
abstract class AnimalFactory {
    public abstract Animal createAnimal();

    public void makeAnimalSpeak() {
        Animal animal = createAnimal();
        animal.speak();
    }
}

// Step 4: Concrete factories for creating specific animals
class LionFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Lion();
    }
}

class ElephantFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Elephant();
    }
}

class MonkeyFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Monkey();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Lion factory and make the lion speak
        AnimalFactory lionFactory = new LionFactory();
        lionFactory.makeAnimalSpeak();

        // Create an Elephant factory and make the elephant speak
        AnimalFactory elephantFactory = new ElephantFactory();
        elephantFactory.makeAnimalSpeak();

        // Create a Monkey factory and make the monkey speak
        AnimalFactory monkeyFactory = new MonkeyFactory();
        monkeyFactory.makeAnimalSpeak();
    }
}
