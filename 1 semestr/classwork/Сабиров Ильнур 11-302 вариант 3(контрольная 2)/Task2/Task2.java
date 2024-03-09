import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        double[][] matrix = {
            {2, 1, -1, 8},
            {-3, -1, 2, -11},
            {-2, 1, 2, -3}
        };
        solve(matrix);
    }

    public static void solve(double matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][i] == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (matrix[j][i] != 0) {
                        double[] temp = matrix[i];
                        matrix[i] = matrix[j];
                        matrix[j] = temp;
                        break;
                    }
                }
            }

            for (int j = i + 1; j < n; j++) {
                double coeff = matrix[j][i] / matrix[i][i];
                for (int k = i; k < n + 1; k++) {
                    matrix[j][k] -= matrix[i][k] * coeff;
                }
            }
        }

        double[] solutions = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * solutions[j];
            }
            solutions[i] = (matrix[i][n] - sum) / matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            System.out.println("X" + i + " = " + solutions[i]);
        }
    }
} 
