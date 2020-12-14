package com.ll.mango.admin.util;

import java.util.*;

/**
 * @author 奥特曼
 * @version 1.0
 * @date 2020/12/2 0002 上午 11:10
 */
public class ListMap {


    private static List work() {
        List<Map<Integer, String>> list = new ArrayList<>();
        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        Map<Integer, String> map3 = new HashMap<>();
        Map<Integer, String> map4 = new HashMap<>();
        map1.put(0, "ABC");
        map1.put(1, "调用方1");
        map1.put(2, "123");
        map1.put(3, "提供方1");
        map2.put(0, "BCD");
        map2.put(1, "调用方2");
        map2.put(2, "234");
        map2.put(3, "提供方2");
        map3.put(0, "ABC");
        map3.put(1, "调用方1");
        map3.put(2, "345");
        map3.put(3, "调用方3");
        map4.put(0, "CDF");
        map4.put(1, "调用方3");
        map4.put(2, "345");
        map4.put(3, "调用方3");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

        //存储最后结果的list
        List<Map<String, List<Object>>> resultList = new ArrayList<>();

        //存储已存在的调用方
        List<String> conList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String con = list.get(i).get(0);
            Integer index = printList(conList, con);
            if (index == -1) {
                conList.add(con);
                List<Object> tempList = new ArrayList<>();
                tempList.add(list.get(i));
                Map<String, List<Object>> tempMap = new HashMap<>();
                tempMap.put(con, tempList);
                resultList.add(tempMap);
            } else {
                Map<String, List<Object>> tempMap = resultList.get(index);
                List<Object> tempList = tempMap.get(con);
                tempList.add(list.get(i));
            }
        }
        return resultList;
    }

    public static Integer printList(List<String> list, String con) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(con)) {
                return i;
            }
        }
        return -1;
    }

    //1.取出list中的map
    public void getlistMap1() {
        Map map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        List list = new ArrayList();
        list.add(map);
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map1 = (Map<String, Object>) list.get(i);
            String authorStr = map.get("key1").toString();
            System.out.println("author" + " : " + authorStr);
        }
    }


    //2.取出list中的map
    public void getlistMap2() {
        Map map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        List<Map> list = new ArrayList<Map>();
        list.add(map);
        for (Map m : list) {
            for (Object k : m.keySet()) {
                System.out.println(k + " : " + m.get(k));
            }
        }
    }


    //3.取出list中的map
    public void getlistMap3() {
        Map map = new HashMap();
        map.put("key3", "value3");
        map.put("key4", "value4");
        List<Map> list = new ArrayList<Map>();
        list.add(map);
        for (Map map1 : list) {
//            //Error:(114, 32) java: for-each 不适用于表达式类型
//            for (Map.Entry e : map1) {
//                System.out.println("e.getKey() " + e.getKey());
//                System.out.println("e.getValue() " + e.getValue());
//            }
        }
    }


    //4.取出list中的map
    public void getlistMap4() {
        Map map = new HashMap();
        map.put("key7", "value7");
        map.put("key8", "value8");
List list = new ArrayList();
        list.add(map);
        for (int i=0;i<list.size();i++)
        {
            Map  map1=(Map)list.get(i);
            Iterator iterator = map1.keySet().iterator();
            while (iterator.hasNext())
            {
                String key = (String) iterator.next();
                Object object = map1.get(key);
                System.out.println(object);
            }
        }
    }

    public static void main(String[] args) {
        ListMap listMap = new ListMap();
        work();
        listMap.getlistMap1();
        listMap.getlistMap2();
        listMap.getlistMap3();
        listMap.getlistMap4();
    }
}
