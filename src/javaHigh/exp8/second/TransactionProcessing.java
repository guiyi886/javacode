package javaHigh.exp8.second;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionProcessing {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Alice", "Bob", 150.0),
                new Transaction("Bob", "Charlie", 200.0),
                new Transaction("Alice", "David", 50.0),
                new Transaction("Alice", "Charlie", 300.0)
        );

        processTransactions(transactions);
    }

    public static void processTransactions(List<Transaction> transactions) {
        // 使用Stream API计算每个买家的总支出
        // Collectors.groupingBy组合了两个收集器，根据每个交易的买家对交易进行分组，并计算每个组中交易金额的总和。
        // 最终结果是一个 Map<String, Double>，其中键是买家的名字，值是该买家的总支出。
        Map<String, Double> totalSpentByBuyer = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getBuyer,
                        Collectors.summingDouble(Transaction::getAmount)));

        // 打印每个买家的总支出
        totalSpentByBuyer.forEach((buyer, totalSpent) ->
                System.out.println(buyer + ": " + totalSpent));
    }
}
