package src.Languages.Java.Resolutions.PedroV.Day20;

import src.Languages.Java.Resolutions.PedroV.Day16.Day16Solucao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Day20Solucao {
    public static class Codificador{
        private Integer valorRecebido;


        protected void receberValor(){
            Scanner entrada = new Scanner(System.in);
            while(true) {
                try {
                    System.out.println("Digite o valor para Codificar ?");
                    Integer numeroValido = entrada.nextInt();
                        this.valorRecebido =  numeroValido;
                }catch (InputMismatchException e){
                    System.out.println("Digite apenas numeros");
                    entrada.next();
                }
            }
        }




    }
    public static class Menu {
        public void menu() {
            Scanner entrada = new Scanner(System.in);
            Boolean pegando = false;
            while (!pegando) {
                try {
                    options();
                    Integer escolha = entrada.nextInt();
                    switch (escolha) {
                        case 1:
                            System.out.println("\n");

                            break;
                        case 2:
                            System.out.println("\n");
                            break;
                        case 3:
                            pegando = true;
                            System.out.println("Te vejo depois :) ");
                            break;
                        default:
                            System.out.println("Opção Invalida");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Digite Apenas uma das opções !!");
                    entrada.next();
                }
            }

        }

        private void options() {
            System.out.println("Bem vindo ao sistema de Criptografia ;) ");
            System.out.println("[ 1 ] Codificar");
            System.out.println("[ 2 ] Decodificar");
            System.out.println("[ 3 ] Sair do Sistema");
        }

    }
    public static void main(String[] args) {
        System.out.println("Iaeeeee");
    }
    }
