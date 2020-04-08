package com.packt.java.chapter13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example2 {

    public static void main(String[] args) {
        List<ShoppingItem> books = new ArrayList<>();
        books.add(new ShoppingItem("Java Fundamentals", 100));
        books.add(new ShoppingItem("Java 11 Quick Start", 200));

        List<ShoppingItem> immutableCopy = List.copyOf(books);
        List<ShoppingItem> unmodifiableCopy = Collections.unmodifiableList(books);

        System.out.println(immutableCopy);
        System.out.println(unmodifiableCopy);

        books.remove(0);

        System.out.println("removed 0");
        System.out.println(immutableCopy);
        System.out.println(unmodifiableCopy);
    }

    /**
     * Final modifier to ensure that it cannot be extended or it's behaviour changed.
     */
    public static final class ShoppingCart {
        private List<ShoppingItem> mShoppingList = new ArrayList<>();

        public ShoppingCart(List<ShoppingItem> shoppingItemList) {
            this.mShoppingList = List.copyOf(shoppingItemList);
            //this.mShoppingList = Collections.unmodifiableList(shoppingCartItemList);
        }

        public ShoppingCart addItem(ShoppingItem shoppingItem) {
            List<ShoppingItem> newList = new ArrayList<>(mShoppingList);
            newList.add(shoppingItem);
            return new ShoppingCart(newList);
        }

        public ShoppingCart removeItem(ShoppingItem shoppingItem) {
            List<ShoppingItem> newList = new ArrayList<>(mShoppingList);
            if (newList.contains(shoppingItem)) {

                if (shoppingItem.getQuantity() == 1) {
                    shoppingItem.setQuantity(shoppingItem.getQuantity() - 1);
                } else {
                    int index = newList.indexOf(shoppingItem);
                    newList.remove(index);
                }
            }
            return new ShoppingCart(newList);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ShoppingCart{");
            for (int i = 0; i < mShoppingList.size(); i++) {
                sb.append(mShoppingList.get(i)).append(", ");
            }
            return sb.toString();
        }
    }

    private static final class ShoppingItem {
        private final String name;
        private final int price;
        private int quantity;

        private ShoppingItem(String name, int price) {
            this.name = name;
            this.price = price;
        }

        private ShoppingItem(String name, int price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ShoppingCartItem{");
            sb.append("name='").append(name).append('\'');
            sb.append(", price=").append(price);
            sb.append('}');
            return sb.toString();
        }
    }
}
