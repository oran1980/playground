package com.hackerrank.algorrithm;

import static java.util.stream.Collectors.*;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Stream;

class Result{
    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        Map<Integer, Long> collect = candles.stream().collect(groupingBy(Function.identity(), counting()));
        Integer max = collect.keySet().stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
        Long maxHeight = collect.get(max);
        System.out.println(maxHeight);
        return maxHeight.intValue();
    }
}

public class BirthdayCakeCandles {
    public static void main (String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                      .map(Integer::parseInt)
                                      .collect(toList());

        int result = Result.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}