package polinomio;

public class Teste {
    
    public static void main(String[] args) {
        try {
            Polinomio p1 = new Polinomio(-5, 4, -3, 2, -1);
            exibir(p1);
            
            Polinomio p2 = new Polinomio(4, 3, 2, 1);
            exibir(p2);
            
            Polinomio p3 = new Polinomio(3, 2, 1);
            exibir(p3);
            
            Polinomio p4 = new Polinomio(2, 1);
            exibir(p4);
            
            Polinomio p5 = new Polinomio(1);
            exibir(p5);
            
//            Polinomio p6 = new Polinomio();
//            exibir(p6);
        } catch (GrauNegativoException | GrauZeroException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exibir(Polinomio p){
        int grau = p.getGRAU();
        System.out.println("Polinômio grau "+grau+":");
        System.out.println("P(x) = "+p.getPolinomio());
        if(grau>=4){
            System.out.println("P'(x) = "+p.getPolinomioPrimeiraDerivada());
            System.out.println("P''(x) = "+p.getPolinomioSegundaDerivada());
            System.out.println("P'''(x) = "+p.getPolinomioTerceiraDerivada());
        } else if(grau>-1){
            switch(grau){
                case 3:
                    System.out.println("P'(x) = "+p.getPolinomioPrimeiraDerivada());
                    System.out.println("P''(x) = "+p.getPolinomioSegundaDerivada());
                    break;
                case 2:
                    System.out.println("P'(x) = "+p.getPolinomioPrimeiraDerivada());
                    break;
                case 1:
                    System.out.println("P'(x) = "+p.getPolinomioPrimeiraDerivada());
                    break;    
                default:
                    System.out.println("Nunca chegará nesta opção!");
            }
        }
        System.out.println("----------------------------------");
    }
}
