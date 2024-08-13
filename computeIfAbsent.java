package org.example.ontap.baitapvenha.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class computeIfAbsent {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        /* => computeIfAbsent(key, Function) là 1 hàm tạo mới nó sẽ kiểm tra xem nếu key đã tồn tại chưa?
        nếu chưa nó sẽ thêm mới vào Map, còn kiểm tra nếu key đã tồn tại nó sẽ loại bỏ */
        //1. thay đổi key:2 và value thay đổi là B
        map.computeIfAbsent(2, k -> "D");
        System.out.println(map);
        //2. thêm key:4 và value là D, chưa có 4 trong map nó sẽ thêm vào
        map.computeIfAbsent(4, k -> "D");
        System.out.println(map);

        //C1. Môn học<SinhVien>
        Map<String, List<String>> maps = new HashMap<>();
        maps.computeIfAbsent("Toan", k -> new ArrayList<>()).add("Pham Hoang Dung");
        maps.computeIfAbsent("Toan", k -> new ArrayList<>()).add("Ha Phong Luu");

        maps.computeIfAbsent("Van", k -> new ArrayList<>()).add("Nguyen Van Linh");
        System.out.println(maps);

        //C2.
        Map<String, List<String>> maps2 = new HashMap<>();
        maps2.computeIfAbsent("Dia", k -> {
            List<String> list = new ArrayList<>();
            list.add("Le Cong Minh");
            list.add("Le Cong Danh");
            return list;
        });
        maps2.computeIfAbsent("Su", k ->{
            List<String> list = new ArrayList<>();
            list.add("Nguyen Van A");
            list.add("Nguyen Van B");
            return list;
        });
        System.out.println(maps2);
    }
}
