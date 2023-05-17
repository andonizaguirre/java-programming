
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Points {

    private ArrayList<Integer> pointsList;

    public Points() {
        this.pointsList = new ArrayList<>();
    }

    public ArrayList<Integer> getPointsList() {
        return this.pointsList;
    }

    public double average() {
        return this.averageOfPassingGrade(0);
    }

    public double averageOfPassingGrade(int passingGrade) {
        int count = 0;
        int sum = 0;
        for (int point : pointsList) {
            if (point >= passingGrade) {
                sum = sum + point;
                count++;
            }
        }
        return (double) sum / count;
    }

    public double passPercentage(int passingGrade) {
        int count = 0;
        for (int point : pointsList) {
            if (point >= passingGrade) {
                count++;
            }
        }
        return 100 * (double) count / this.pointsList.size();
    }

    public int[] pointsConversion() {
        int[] grades = new int[this.pointsList.size()];
        for (int i = 0; i < this.pointsList.size(); i++) {
            int point = this.pointsList.get(i);
            if (point < 50) {
                grades[i] = 0;
            } else if (point < 60) {
                grades[i] = 1;
            } else if (point < 70) {
                grades[i] = 2;
            } else if (point < 80) {
                grades[i] = 3;
            } else if (point < 90) {
                grades[i] = 4;
            } else {
                grades[i] = 5;
            }
        }
        return grades;
    }
}
