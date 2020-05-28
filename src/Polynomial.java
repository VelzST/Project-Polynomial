import java.util.NoSuchElementException;

public class Polynomial {
    class Node{
        int exponent;
        int coefficient;
        Node next;
        public Node(int exponent, int coefficient) {
            this.exponent = exponent;
            this.coefficient = coefficient;
        }
    }

    private Node root;
    private Polynomial polynomial;
    private int size;
    private int grade;

    //Constructor grado 0
    public Polynomial(){
    }

    //este constructor debe crear un objeto Polynomial cuyo grado
    //sea igual al tamaño del arreglo coef, y cuyos coeficientes sean tomados uno a uno
    //desde el mismo arreglo coef que entra como parámetro,
    public Polynomial(int[] coefficient){
        this.grade = coefficient.length;
        Polynomial p = new Polynomial();
        for(int i = 0; i < coefficient.length; i++){
            Node n = new Node(i, coefficient[i]);
            n.next = root;
            root = n;
            this.size++;
        }
    }

    public int getGrade(){
        if (grade == 0){
            return grade;
        }else {
            return grade-1;
        }
    }

    //retorna un Polynomial igual a la suma entre this pol.
    public Polynomial add(Polynomial pol){
        Polynomial nw = null;
        if(pol.getGrade()>grade){
            Node q = pol.root;
            Node p = root;
            for(int i=0;i < pol.grade ;i++){
                p=root;
                for (int j=0; j < grade; j++){
                    if(q.exponent == p.exponent){
                        q.coefficient = q.coefficient +p.coefficient;
                    }
                    p=p.next;
                }
                q=q.next;
            }
            nw = pol;
        }else{
            Node q = pol.root;
            Node p = root;
            for(int i=0;i < grade ;i++){
                q=pol.root;
                for (int j=0; j < pol.grade; j++){
                    if(q.exponent == p.exponent){
                        p.coefficient = q.coefficient +p.coefficient;
                    }
                    q=q.next;
                }
                p=p.next;
            }
            nw = this;
        }
        return nw;
    }

    //Devuelve el valor del coeficiente del grado
    public int getCoefficient(int exponent){
        if(exponent < 0 || exponent >= grade+1){
            throw new NoSuchElementException();
        }
        Node p = root;
        while (p.exponent != exponent){
            p=p.next;
        }
        return p.coefficient;
    }

    //establece el valor del coeficiente de grado x al valor coef
    public void setCoefficient(int exponent, int coefficient){
        Node p = root;
        while (p.exponent != exponent){
            p=p.next;
        }
        p.coefficient= coefficient;
    }

    //calcula y retorna el valor del polinomio en el punto x.
    public float valueOf(float x){
        float res = 0;
        Node p = root;
        for (int i=0; i < grade; i++){
            double doubleResult = Math.pow(x, p.exponent);
            res = res + (float) ((doubleResult*p.coefficient));
            p=p.next;
        }
        return res;
    }

    //retorna true si this es igual a x, y false en caso contrario.
    @Override
    public boolean equals(Object pol){
        Polynomial polynomial = (Polynomial) pol;
        Node p = polynomial.root;
        Node q = root;
        if(grade != polynomial.grade){
            return false;
        }
        for(int i=0; i < grade ;i++){
            if (root.coefficient != polynomial.root.coefficient){
                return false;
            }
            p=p.next;
            q=q.next;
        }
        p = polynomial.root;
        q = root;
        for(int i=0; i < grade ;i++){
            if (root.exponent != polynomial.root.exponent){
                return false;
            }
            p=p.next;
            q=q.next;
        }
        return true;
    }

    //retorna la representación del Polynomial en forma de String.
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node p = root;
        while (p != null){
            if (p.exponent == 0){
                stringBuilder.append(p.coefficient);
            }else {
                stringBuilder.append(p.coefficient);
                stringBuilder.append("x^");
                stringBuilder.append(p.exponent);
            }

            if(p.next == null){
                p = null;
            }else {
                stringBuilder.append("+");
                p=p.next;
            }
        }
        return stringBuilder.toString();
    }
}

