package pers.ej.chapter08.item46;

import java.util.*;

// 扑克牌的花色
enum Suit {
    CLUB, DIAMOND, HEART, SPADE
}

// 扑克牌的名称
enum Rank {
    ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

// 扑克牌
class Card {
    final Suit suit;
    final Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }
}

/**
 * 对多个集合嵌套迭代
 * Created by lgc on 17-6-17.
 */
public class NestedIteration {
    public static void main(String[] args) {
        // 所有扑克牌花色
        List<Suit> suits = Arrays.asList(Suit.values());
        // 所有扑克牌名称
        List<Rank> ranks = Arrays.asList(Rank.values());
        // 遍历获得一副扑克牌
        List<Card> deck = null;
        try {
            // 传统for循环遍历，有异常
            getDeck1(suits, ranks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        print(deck);

        // 修复传统for循环问题
        deck = getDeck2(suits, ranks);
        print(deck);

        // 使用foreach循环
        System.out.println("=======use foreach======");
        deck = getDeck3(suits, ranks);
        print(deck);

    }

    /*打印元素*/
    private static <T> void print(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        for (T t : collection) {
            System.out.println(t);
        }
    }

    /*传统for循环遍历，容易犯这样的错误，因为外部的suitIterator只有四个元素，在内部调用了太多次next()，
    * 所以会报NoSuchElementException异常*/
    private static List<Card> getDeck1(List<Suit> suits, List<Rank> ranks) {
        List<Card> deck = new ArrayList<>();
        for (Iterator<Suit> suitIterator = suits.iterator(); suitIterator.hasNext(); ) {
            for (Iterator<Rank> rankIterator = ranks.iterator(); rankIterator.hasNext(); ) {
                deck.add(new Card(suitIterator.next(), rankIterator.next()));
            }
        }
        return deck;
    }

    /*修复传统for循环遍历的问题，在外部循环中增加一个变量保存元素即可*/
    private static List<Card> getDeck2(List<Suit> suits, List<Rank> ranks) {
        List<Card> deck = new ArrayList<>();
        for (Iterator<Suit> suitIterator = suits.iterator(); suitIterator.hasNext(); ) {
            Suit suit = suitIterator.next();
            for (Iterator<Rank> rankIterator = ranks.iterator(); rankIterator.hasNext(); ) {
                deck.add(new Card(suit, rankIterator.next()));
            }
        }
        return deck;
    }

    /*使用foreach循环*/
    private static List<Card> getDeck3(List<Suit> suits, List<Rank> ranks) {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }
}

