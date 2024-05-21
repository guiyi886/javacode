package javaHigh.exp6.first;

import java.util.HashSet;
import java.util.Set;

public class SetOperation {

    // 返回集合的并集
    @SafeVarargs
    public static <E> Set<E> union(Set<? extends E>... sets) {
        Set<E> result = new HashSet<>();
        for (Set<? extends E> set : sets) {
            result.addAll(set);
        }
        return result;
    }

    // 返回集合的交集
    @SafeVarargs
    public static <E> Set<E> intersection(Set<? extends E>... sets) {
        if (sets == null || sets.length == 0) {
            throw new IllegalArgumentException("Sets cannot be null or empty");
        }
        Set<E> result = new HashSet<>(sets[0]);
        for (Set<? extends E> set : sets) {
            result.retainAll(set);
        }
        return result;
    }
}

