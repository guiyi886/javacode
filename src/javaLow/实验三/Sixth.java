package javaLow.实验三;

import java.util.HashSet;
import java.util.Set;

public class Sixth {
    public static void main(String[] args) {
        // 定义A社团和B社团的成员
        Set<String> clubAMembers = new HashSet<>();
        Set<String> clubBMembers = new HashSet<>();

        // 添加A社团成员
        clubAMembers.add("张三");
        clubAMembers.add("李四");
        clubAMembers.add("王五");

        // 添加B社团成员
        clubBMembers.add("李四");
        clubBMembers.add("王五");
        clubBMembers.add("赵六");

        // 输出参加A社团的人
        System.out.println("参加A社团的人：" + clubAMembers);

        // 输出参加B社团的人
        System.out.println("参加B社团的人：" + clubBMembers);

        // 求交集，即同时参加两个社团的人
        Set<String> bothClubsMembers = new HashSet<>(clubAMembers);
        bothClubsMembers.retainAll(clubBMembers);

        // 输出同时参加两个社团的人
        System.out.println("同时参加两个社团的人：" + bothClubsMembers);
    }
}

