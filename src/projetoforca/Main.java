package projetoforca;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        JogoDaForca jogo = new JogoDaForca();
        Palavra[] arrayValues = new Palavra[20];
        int pontos = 0, strike = 3;
        String linha;
        
        System.out.println("---J-O-G-O--D-A--F-O-R-C-A---");
        try{
            //Cria um objeto a partir do arquivo que eu quero que ele leia
            FileReader arq = new FileReader("palavras.txt");
            //Cria um fluxo de caractere com o arquivo ao invés de int
            BufferedReader lerArq = new BufferedReader(arq);
            
            //Preenchendo o array
            for(int c = 0; c < 19; c++){
                linha = lerArq.readLine();
                arrayValues[c] = new Palavra();
                arrayValues[c].setPalavra(linha);
            }
            
            //Fechar o arquivo depois de lê
            arq.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jogo.setDicionario(arrayValues);
        
        //Sortear uma palavra:
        jogo.sortear();
        System.out.println("A dica é: " + jogo.pegarDica());
        
        //Enquanto ainda tiver palavra e o player só pode errar três vezes
        while(jogo.getDicionario()[jogo.getPosicaoSorteada()].getPalavra() != null && strike > 0){
            if(jogo.testaSeAcabou()){
                pontos++;
                System.out.println("A palavra era: " + jogo.getGabarito() + " e você tem " + pontos + " pontos");
                jogo.sortear();
                System.out.println("A dica é: " + jogo.pegarDica());
            }else{
                System.out.println("Que palavra é essa? " + jogo.getGabarito());
                System.out.println("Digite uma letra: ");
                String text = input.nextLine();

                //Testa a letra que o usuário escolher
                if(jogo.testarLetra(text.toCharArray()[0])){
                    System.out.println("Acertou");
                }else{
                    strike--;
                    if(strike != 0){
                        System.out.println("Errou, você só pode errar mais " + (strike) + " vezes");
                    }
                }            
            } 
        }
        System.out.println("O jogo acabou, você adquiriu " + pontos + " pontos");
    }
        
}

