package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        ListObj<Politica> lista = new ListObj<>(5);

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar Política (cadastro)");
            System.out.println("2 - Exibir os cadastros (relatório)");
            System.out.println("3 - Gravar arquivo CSV (Writte)");
            System.out.println("4 - Exibir arquivo CSV (Read)");
            System.out.println("5 - Fim do programa (encerrar)");
            System.out.print("Opção: ");

            opcao = sc.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("\nCadastro de política:");
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Partido: ");
                    String partido = sc.nextLine();
                    System.out.print("Gastos: ");
                    double gastos = sc.nextDouble();
                    System.out.print("Votos: ");
                    int votos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();
                    System.out.print("Estado: ");
                    String estado = sc.nextLine();
                    Politica politica = new Politica(id, ano, partido, gastos, votos, cargo, estado);
                    lista.adiciona(politica);
                    System.out.println("\nPolítica cadastrada com sucesso!");
                    break;
                case 2:
                    System.out.println("\nRelatório de políticas:");
                    System.out.printf("%-5s%-10s%-20s%-15s%-10s%-15s%-15s\n", "ID", "Ano", "Partido", "Gastos", "Votos", "Cargo", "Estado");
                    for (int i = 0; i < lista.getTamanho(); i++) {
                        Politica p = lista.getElemento(i);
                        System.out.println(p);
                    }
                    break;

                case 3:
//                    salvar csv;
                    String nomeArquivo;
                    System.out.print("Nome do arquivo:");
                    nomeArquivo = scan.nextLine();
                    gravar(lista, nomeArquivo);


                    break;


                case 4:
//                    ler csv
                    String nomeArq;
                    System.out.println("Digite o nome do seu arquivo:");
                    nomeArq = scan.nextLine();
                    ler(nomeArq);
                    break;


                case 5:
                    System.out.println("\nEncerrando o programa...");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }

        sc.close();
    }

    public static void gravar(ListObj<Politica> obj, String nomeArq) {
        FileWriter arq = null;
        Formatter ext = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq);
            ext = new Formatter(arq);

        } catch (IOException e) {

            System.out.println("Erro ao abrir arquivo: " + e);
            e.printStackTrace();
            System.exit(1);

        }

        try {

            for (int i = 0; i < obj.getTamanho(); i++) {

                Politica ca = obj.getElemento(i);
                ext.format("%d;%d;%s;%.2f;%d;%s;%s\n", ca.getId(), ca.getAno(), ca.getPartido(), ca.getGastos(), ca.getVotos(), ca.getCargo(), ca.getEstado());
            }


        } catch (FormatterClosedException e) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
            e.printStackTrace();
            System.exit(1);

        } finally {

            ext.close();

            try {

                arq.close();
            } catch (IOException e) {

                System.out.println("Erro ao fechar arquivo");
                deuRuim = true;

            }

            if (deuRuim) {

                System.exit(1);
            }

        }


    }

    public static void ler(String nomeArq) {
        FileReader arq = null;
        Scanner scan = null;
        Boolean deuRuim = null;

        nomeArq += ".csv";

        try {

            arq = new FileReader(nomeArq);
            scan = new Scanner(arq).useDelimiter(";|\\n");

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }


        try {
            System.out.printf("%-5s%-10s%-20s%-15s%-10s%-15s%-15s\n", "ID", "Ano", "Partido", "Gastos", "Votos", "Cargo", "Estado");


            while (scan.hasNext()) {
                int id = scan.nextInt();
                int ano = scan.nextInt();
                String partido = scan.next();
                Double gastos = scan.nextDouble();
                int votos = scan.nextInt();
                String cargo = scan.next();
                String estado = scan.next();


                System.out.printf("%-5s%-10s%-20s%-15s%-10s%-15s%-15s\n", id, ano, partido, gastos, votos, cargo, estado);


            }

        } catch (NoSuchElementException e) {


            System.out.println("Arquivo com problemas!");
            deuRuim = true;

        } catch (IllegalStateException e) {

            System.out.println("Arquivo com problemas!");
            deuRuim = true;

        } finally {

            scan.close();


            if (Boolean.TRUE.equals(deuRuim)) {

                System.exit(1);
            }

        }


    }

}