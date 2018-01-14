package model;

import java.security.SecureRandom;

public class NumeroAleatorio {
    public static int getNumeroAleatorio(int limiteInferior, int limiteSuperior){
        return new SecureRandom().ints(limiteInferior, limiteSuperior).findAny().getAsInt();
    }
    public static boolean getBooleanAleatorio(){
        return new SecureRandom().nextBoolean();
    }
}
