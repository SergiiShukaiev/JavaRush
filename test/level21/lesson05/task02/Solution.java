package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o==null || !(o instanceof Solution))
            return false;

        Solution n = (Solution) o;
        boolean firstS=(first !=null)? first.equals(n.first):n.first==null;
        boolean lastS=(last !=null)? last.equals(n.last):n.last==null;

        return firstS && lastS;
    }
    public int hashCode(){
        int result;
        result=first !=null ? first.hashCode():0;
        result=result*21+(last!=null ? last.hashCode():0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
