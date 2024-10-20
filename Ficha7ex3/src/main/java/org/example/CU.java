package org.example;

import java.util.ArrayList;
import java.util.List;

public class CU {
    private String nameCU; // nome da unidade curricular
    private List<Mark> marks; // lista com as notas de cada aluno
    private int totalStudents; // nº máximo de alunos na UC

    public CU(String nameCU, int totalStudents) {
        this.nameCU = nameCU;
        this.marks = new ArrayList<>();
        this.totalStudents = totalStudents;
    }

    public void insertMarkCU(int numStudent, double mark) {
        if (marks.size() < totalStudents) {
            marks.add(new Mark(numStudent, mark));
        }
    }

    public double searchStudent(int numStudent) {
        for (Mark mark : marks) {
            if (mark.getNumStudent() == numStudent) {
                return mark.getMark();
            }
        }
        return -1; // Retorna -1 se o aluno não existir
    }

    public double averageCU() {
        if (marks.isEmpty()) {
            return 0.0; // Média 0 se não houver notas
        }
        double sum = 0.0;
        for (Mark mark : marks) {
            sum += mark.getMark();
        }
        return sum / marks.size(); // Média das notas
    }

    public boolean isApproved(int numStudent) {
        double studentMark = searchStudent(numStudent);
        return studentMark >= 9.5; // Aprovado se nota >= 9.5
    }
}