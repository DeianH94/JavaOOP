package Methods.Pr06PrimeChecker;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer inputNum = Integer.parseInt(reader.readLine());

        boolean isPrime = true;
        for(int i = 2; 2 * i < inputNum; i++) {
            if(inputNum % i == 0) {
                isPrime = false;
            }
        }

        Number number = new Number(inputNum, isPrime);
        Integer nextPrime = number.findNextPrime();
        System.out.println(nextPrime + ", " + number.getPrime());

        Field[] fields = Number.class.getDeclaredFields();

        List<Field> filedsDeclared = Arrays.stream(fields)
                .filter(f -> f.getName().contains("prime") || f.getName().contains("number"))
                .collect(Collectors.toList());

        List<Constructor<?>> constructors = Arrays.stream(Number.class.getDeclaredConstructors())
                .filter(c -> c.getParameterCount() > 1)
                .collect(Collectors.toList());

        if (filedsDeclared.size() <= 1 || constructors.size() < 1) {
            throw new ClassFormatException();
        }

    }
}

class Number {
    private Integer number;
    private Boolean prime;

    Number(Integer number, Boolean prime) {
        this.number = number;
        this.prime = prime;
    }

    public Boolean getPrime() {
        return prime;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer findNextPrime () {
        while (true) {
            boolean isPrime = true;
            number += 1;
            int sqrt = (int)Math.sqrt(number);
            for (int i = 2; i <= sqrt; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) {
                return number;
            }
        }
    }
}
