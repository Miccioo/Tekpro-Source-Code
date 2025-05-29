public class Product {
    private String name;
    private int price;
    private boolean discount;

    private Product(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.discount = builder.discount;
    }

    public void display() {
        System.out.println("Nama Produk: " + name);
        System.out.println("Harga: " + price);
        System.out.println("Diskon: " + (discount ? "Ya" : "Tidak"));
    }

    public static class Builder {
        private String name;
        private int price;
        private boolean discount;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setDiscount(boolean discount) {
            this.discount = discount;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}