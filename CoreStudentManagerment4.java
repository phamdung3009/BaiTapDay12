package org.example.ontap.baitapvenha.day12.lamlaibaitap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoreStudentManagerment4 {
    private Map<String, List<String>> map = new HashMap<String, List<String>>();

    // khởi tạo hàm chứa danh sách cấp bậc của điểm
    public List<String> ranks() {
        List<String> list = new ArrayList<String>();
        list.add("A"); // 86-100: Loại A
        list.add("B"); // 76-85: Loại B
        list.add("C"); // 66-75: Loại C
        list.add("D"); // 51-65: Loại D
        list.add("F"); // 0-50: Loại F
        return list;
    }

    // khởi tạo hàm hệ thống tự động phân loại.
    public String sortScoresByRank(int score) {
        if (score >= 0 && score < 50) {
            return ranks().get(4);
        } else if (score >= 51 && score <= 65) {
            return ranks().get(3);
        } else if (score >= 66 && score <= 75) {
            return ranks().get(2);
        } else if (score >= 76 && score <= 85) {
            return ranks().get(1);
        } else if (score >= 86 && score <= 100) {
            return ranks().get(0);
        } else {
            return "Điểm không phù hợp!!!";
        }
    }

    //tạo hàm Thêm sinh viên
    public void addStudent(String name, int score) {
        String grade = sortScoresByRank(score);
        map.computeIfAbsent(grade, k -> new ArrayList<>()).add(name);
    }

    //Lấy danh sách sinh viên thuộc một loại cụ thể.
    public List<String> getStudentsByGrade(String grade) {
        return map.get(grade);
    }

    // Hiển thị tất cả sinh viên phân theo loại.
    public void displayAllGrades(){
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        CoreStudentManagerment3 csm = new CoreStudentManagerment3();
        csm.addStudent("001", 23);
        csm.addStudent("002", 56);
        csm.addStudent("003", 65);
        csm.addStudent("004", 99);
        csm.addStudent("005", 84);
        csm.addStudent("006", 43);
        csm.addStudent("007", 73);

        csm.displayAllGrades();
        List<String> list = csm.getStudentsByGrade("D");
        System.out.println(list);
    }
}
