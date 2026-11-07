class Cart {
    private final String cartId;
    private final int maxItems;
    private int[] prices;
    private int count;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.maxItems = maxItems;
        this.prices = new int[maxItems];
        this.count = 0;
    }

    public void addItem(int price) {
        if (count < maxItems && price > 0) {
            this.prices[count] = price;
            count++;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += this.prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return this.count;
    }

    public String getCartId() {
        return this.cartId;
    }
}

public class M5_ShoppingCart {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId()); // Expected: CART-5
        System.out.println("Total: " + cart.getTotal()); // Expected: 500
        System.out.println("Item count: " + cart.getItemCount()); // Expected: 3
    }
}