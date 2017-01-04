package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(){}
    public Solution(int s){}
    public Solution(Object s){}

    Solution(double s){}
    Solution(char s){}
    Solution(byte s){}

    protected Solution(boolean s){}
    protected Solution(long s){}
    protected Solution(float s){}

    private Solution(Integer s){}
    private Solution(Long s){}
    private Solution(Double s){}
}

