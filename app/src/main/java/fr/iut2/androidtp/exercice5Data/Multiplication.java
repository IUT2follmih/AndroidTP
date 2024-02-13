package fr.iut2.androidtp.exercice5Data;

public class Multiplication {
    private int A;
    private int B;
    private int reponse;

    public Multiplication(int a, int b) {
        this.A = a;
        this.B = b;
    }

    public void setReponse(int reponse) {
        this.reponse = reponse;
    }

    public int getA() {
        return A;
    }

    public int getB() {
        return B;
    }

    public boolean isOk(int a, int b) {
        return a*b == reponse;
    }
}
