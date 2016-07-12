package Methods.Pr09PizzaTime;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PizzaTime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(\\d+)(.*)";
        Pattern pattern = Pattern.compile(regex);
        String[] input = reader.readLine().split("\\s+");

        for (String anInput : input) {
            Matcher matcher = pattern.matcher(anInput);
            while (matcher.find()) {
                Integer pizzaGroup = Integer.parseInt(matcher.group(1));
                String pizzaName = matcher.group(2);
                Pizza pizza = new Pizza(pizzaName, pizzaGroup);
            }
        }

        HashMap<Integer, ArrayList<String>> pizzaMap = Pizza.returnMap();

        pizzaMap.entrySet().stream()
                .forEach(pizza1 -> System.out.printf("%s - %s\n",
                        pizza1.getKey(),
                        pizza1.getValue().toString().replaceAll("\\[", "").replaceAll("\\]", "")));

        Class<?> pizzaClass = Pizza.class;
        Method[] methods = pizzaClass.getDeclaredMethods();
        List<Method> checkedMethods = Arrays.stream(methods)
                .filter(m -> m.getReturnType().getName().contains("Map"))
                .collect(Collectors.toList());

        if (checkedMethods.size() < 1) {
            throw new ClassFormatException();
        }

    }
}

class Pizza {
    private String name;
    private Integer group;
    private static HashMap<Integer, ArrayList<String>> pizzaMap;

    static {
        pizzaMap = new HashMap<>();
    }

    public Pizza(String name, Integer group) {
        this.name = name;
        this.group = group;
        if (!pizzaMap.containsKey(group)) {
            pizzaMap.put(group, new ArrayList<>());
        }

        pizzaMap.get(group).add(name);
    }

    public static HashMap<Integer, ArrayList<String>> returnMap () {
        return pizzaMap;
    }
}