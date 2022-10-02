package ru.job4j.stream;

import java.util.stream.Stream;

public class CardDesk {

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public class Card {
        private Suit suit;
        private Value value;

        public Card(Suit suit, Value value) {
            this.suit = suit;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Card{"
                    + "suit=" + suit
                    + ", value=" + value
                    + '}';
        }
    }

    public static void main(String[] args) {
        CardDesk cardDesk = new CardDesk();
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> cardDesk.new Card(suit, value)))
                .toList()
                .forEach(System.out::println);
    }
}
