package com.test.demo.test;

import java.util.*;

/**
 * @author wentao.wang@xinboxinmo.com
 * @date 2019/1/2 下午2:12
 */
public class MainTest {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int index = judgeScanner(scanner);
            tryTest(index);
            forMap(getMap(index));
        }
    }

    private static void forMap(Map<String,Object> map) {
        forMap_1(map);
        forMap_2(map);
    }

    private static void forMap_2(Map<String,Object> map) {
        long begin = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        for (Object entry : map.values()) {
            result.add(entry + "");
        }
        System.out.println("values map time : " + (System.currentTimeMillis() - begin) + "ms" + ". result" + result);
    }


    private static void forMap_1(Map<String,Object> map) {
        long begin = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            result.add(entry.getKey() + "_" + entry.getValue());
        }
        System.out.println("entry map time : " + (System.currentTimeMillis() - begin) + "ms" + ". result" + result);
    }

    private static int judgeScanner(Scanner scanner) {
        while (true) {
            System.out.print("请输入：");
            String index = scanner.next();
            if (index == null || "".equals(index)) {
                System.out.println("输入为空，请重新输入：");
            }else {
                try {
                    return Integer.parseInt(index);
                }catch (Exception e) {
                    System.out.println("输入有误，必须为数字，请重新输入：");
                }
            }
        }
    }

    private static Map<String, Object> getMap(int index) {
        Map<String, Object> result = new HashMap<>();
        for (int i = 0; i <= index; i ++) {
            result.put("test_" + i , i);
        }
        return result;
    }

    private static void tryTest(int index) {
        tryTest_1(index);
        tryTest_2(index);
    }

    private static void tryTest_1(int index) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i <= index; i ++) {
            try {
                new Thread();
            }catch (Exception e) {
                System.out.println("error. index = " + i);
            }
        }
        System.out.println("try in for time : " + (System.currentTimeMillis() - begin) + "ms");
    }

    private static void tryTest_2(int index) {
        long begin = System.currentTimeMillis();
        try {
            for (int i = 0; i <= index; i ++) {
                new Thread();
            }
        }catch (Exception e) {
            System.out.println("error. index = " + index);
        }
        System.out.println("try out for time : " + (System.currentTimeMillis() - begin) + "ms");
    }

//    private static void isNew(long begin, List<Map<String, Object>> result) {
//        for (int i = 0; i < 10000; i ++) {
//            Map<String, Object> temp = new HashMap<>();
//            temp.put("i", i);
//            result.add(temp);
//        }
//    }
//
//    private static void notNew(long begin, List<Map<String, Object>> result) {
//        Map<String, Object> temp;
//        for (int i = 0; i < 10000; i ++) {
//            temp = new HashMap<>();
//            temp.put("i", i);
//            result.add(temp);
//        }
//    }
}
