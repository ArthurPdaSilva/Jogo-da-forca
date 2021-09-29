package projetoforca;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JogoDaForca jogo = new JogoDaForca();
        Palavra[] arrayValues = new Palavra[10];
        int pontos = 0;
        boolean fim = false;
        
        System.out.println("---J-O-G-O--D-A--F-O-R-C-A---");
        for(int c = 0; c <= 9; c++){
            System.out.println("Por favor, digite uma palavra para compor o jogo: ");
            arrayValues[c] = new Palavra();
            arrayValues[c].setPalavra(input.nextLine());
        }
        
        jogo.setDicionario(arrayValues);
        
        jogo.sortear();
        while(!fim){
            if(jogo.testaSeAcabou()){
                System.out.println("O jogo acabou, a palavra era: " + jogo.getGabarito() + " e você tem " + pontos + " pontos");
                fim = true;
            }else{
                System.out.println("Que palavra é essa? " + jogo.getGabarito());
                System.out.println("Digite uma letra: ");
                String text = input.nextLine();
                if(jogo.testarLetra(text.toCharArray()[0])){
                    pontos++;
                }
                
            }
           
        }
        
    }

}
