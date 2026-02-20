package main.bases.constantes;

public class PracticaConstante {
    public static void main(String[] args) {
        //---------Definición de variables---------------------------
        final byte AGE_OF_THE_GAME = 17;
        float actualVersion = 26.01f;
        char shortName= 'L';
        boolean gameIsActive = true;
        String out = "Age of " + shortName + " = "+AGE_OF_THE_GAME+".\nActual version: "+actualVersion+".\nThe game is active? "+gameIsActive;
        System.out.println(out);
        //---------Contantes buenas practicas---------------------------

        final double ITEM_RATE_NERF=0.10;
        int grossDamageItem = 3000;
        double netDamage = grossDamageItem * (1 - ITEM_RATE_NERF);
        String netDamageOut = "Net Damage = " + netDamage;
        System.out.println(netDamageOut);

        //---------Flujos de control---------------------------


    }
}
