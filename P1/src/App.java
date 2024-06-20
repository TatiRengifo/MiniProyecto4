import java.util.*;

public class App {
    public static void main(String[] args) {
        StudentBinarySearchTree bst = new StudentBinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        boolean continueInput = true;

        while (continueInput) {
            try {
                System.out.println("1. Insertar estudiante");
                System.out.println("2. Buscar estudiante por nombre");
                System.out.println("3. Buscar estudiantes por nota");
                System.out.println("4. Listar estudiantes");
                System.out.println("5. Calcular promedio de notas");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (option) {
                    case 1:
                        System.out.print("Ingrese el nombre del estudiante: ");
                        String name = scanner.nextLine();
                        System.out.print("Ingrese la nota del estudiante (use punto para decimales): ");
                        double note = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        bst.insert(name, note);
                        break;
                    case 2:
                        System.out.print("Ingrese el nombre del estudiante a buscar: ");
                        name = scanner.nextLine();
                        Double result = bst.searchByName(name);
                        if (result != null) {
                            System.out.println("Estudiante encontrado: " + name + ", Nota: " + result);
                        } else {
                            System.out.println("Estudiante no encontrado.");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese la nota para buscar estudiantes: ");
                        double noteToSearch = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        List<String> students = bst.searchByGrade(noteToSearch);
                        if (students.isEmpty()) {
                            System.out.println("No se encontraron estudiantes con la nota " + noteToSearch);
                        } else {
                            System.out.println("Estudiantes con la nota " + noteToSearch + ": " + String.join(", ", students));
                        }
                        break;
                    case 4:
                        System.out.println("Lista de estudiantes en orden alfabético:");
                        bst.inorder();
                        break;
                    case 5:
                        double average = bst.calculateAverageGrade();
                        System.out.println("El promedio de las notas es: " + average);
                        break;
                    case 6:
                        continueInput = false;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese el valor correcto.");
                scanner.nextLine(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
