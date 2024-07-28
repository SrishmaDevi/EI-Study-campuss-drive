public class Pizza {
    private String size;
    private String crust;
    private String toppings;

    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.toppings = builder.toppings;
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", crust=" + crust + ", toppings=" + toppings + "]";
    }

    public static class PizzaBuilder {
        private String size;
        private String crust;
        private String toppings;

        public PizzaBuilder setSize(String size) {
            this.size = size;
            return this;
        }

        public PizzaBuilder setCrust(String crust) {
            this.crust = crust;
            return this;
        }

        public PizzaBuilder setToppings(String toppings) {
            this.toppings = toppings;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
