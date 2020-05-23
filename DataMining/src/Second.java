import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Second {           //Задание 2
/* Так как в таблице нет повторяющихся сторок(это значит что в каждой корзине по 1 единице товара ), то количество покупок товара можно узнать
посчитав количество одинаковых строк в первом столбце таблицы
  */
public static void main(String[] args) throws Exception{
    File file = new File("transactions.csv");
    BufferedReader b = new BufferedReader(new FileReader(file));
    String line;
    HashMap<String,Integer> sum = new HashMap<String, Integer>();
    String[] a;
    while ((line = b.readLine()) != null){
        a = line.split(";");
        if (sum.containsKey(a[0]))
            sum.put(a[0],sum.get(a[0])+1);
            else
            sum.put(a[0],1);
    }
    System.out.println("Топ 10 товаров:");
    sum.entrySet().stream()
            .sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).limit(10)
            .forEach(System.out::println);
}
}