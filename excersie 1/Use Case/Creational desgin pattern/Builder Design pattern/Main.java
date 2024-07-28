public class Main {
    public static void main(String[] args) {
        Pizza margheritaPizza = new Pizza.PizzaBuilder()
                                    .setSize("Large")
                                    .setCrust("Thin Crust")
                                    .setToppings("Tomato, Mozzarella, Basil")
                                    .build();

        System.out.println(margheritaPizza);

        Pizza pepperoniPizza = new Pizza.PizzaBuilder()
                                .setSize("Medium")
                                .setCrust("Regular Crust")
                                .setToppings("Pepperoni, Mozzarella, Tomato Sauce")
                                .build();

        System.out.println(pepperoniPizza);
    }
    
}
