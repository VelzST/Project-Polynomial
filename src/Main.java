public class Main {
    public static void main(String[] args) {

        int[] p1Coefficients = {32, 3, 5, 22, 33, 42};
        int[] p2Coefficients = {2, 5, 32, 20};

        //Crear polinomios
        Polynomial p1 = new Polynomial(p1Coefficients);
        Polynomial p2 = new Polynomial(p2Coefficients);

        Polynomial grade0= new Polynomial();

        //Mostrar los polinomios toString
        System.out.println("Polinomio 1: " + p1.toString());
        System.out.println("Polinomio 2: " + p2.toString());

        //Sumar polinomios add
        System.out.println("Suma de p1 + p2: "+p1.add(p2));

        //getCoefficient
        System.out.println("Coeficiente de grado 4 del polinomio 1: "+ p1.getCoefficient(4));
        System.out.println("Coeficiente de grado 0 del polinomio 2: "+ p2.getCoefficient(0));
        System.out.println("Coeficiente de grado 2 del polinomio 2: "+ p2.getCoefficient(2));

        //setCoefficient
        System.out.println("Polinomio 1: " + p1.toString());
        p1.setCoefficient(4,72);
        System.out.println("Cambio el coeficiente de grado 4 a 72: "+ p1.toString());

        //valueOf
        System.out.println("Polinomio p2: " + p2.toString());
        System.out.println("Polinomio p2 evaluado x=2: " + p2.valueOf(2));

        //equals
        Polynomial p3 = new Polynomial(p2Coefficients);
        System.out.println("Polinomio 1: " + p1.toString());
        System.out.println("Polinomio 2: " + p2.toString());
        System.out.println("Polinomio 3: " + p3.toString());
        System.out.println("P1 = P2? "+ p1.equals(p2));
        System.out.println("P2 = P3? "+ p2.equals(p3));

    }
}
