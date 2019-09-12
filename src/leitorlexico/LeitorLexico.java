/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leitorlexico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabrica
 */
public class LeitorLexico {

    static String pathOut = "result.txt";

    static Scanner ler = new Scanner(System.in);

    static String[] getLineWithoutSpaces(BufferedReader lerArq) {
        String line[] = {};
        try {
            line = lerArq.readLine().trim().split("");
        } catch (IOException ex) {
        } finally {
            return line;
        }
    }

    static String[] getLine(BufferedReader lerArq) {
        String line[] = {};
        try {
            line = lerArq.readLine().split("");
        } catch (IOException ex) {
        } finally {
            return line;
        }
    }

    static void setLine(String input, PrintWriter gravarArq, FileWriter arqOut) {
        gravarArq.println(input);
    }

    static void closeLine(FileWriter arqOut) {
        try {
            arqOut.close();
        } catch (IOException ex) {
        }
    }

    static int[] CheckID(int escreva, int ver, StringBuilder id, int cont, String[] atualLine, String intid_type[], String id_type[], PrintWriter gravarArq, FileWriter arqOut) {
        int check = 1;
        int aux[] = {cont, escreva};
        if (escreva == 0) {
            for (int i = 0; i < intid_type.length; i++) {
                if (atualLine[cont].equals(intid_type[i])) {
                    ver = 1;
                }
            }
            if (ver == 1) {
                for (int i = 0; i < intid_type.length; i++) {
                    if (cont + 1 < atualLine.length) {
                        if (atualLine[cont + 1].equals(intid_type[i])) {
                            check = 0;
                        }
                    } else {
                        check = 1;
                    }
                }

                for (int i = 0; i < intid_type.length; i++) {

                    if (atualLine[cont].equals(intid_type[i])) {
                        id.append(intid_type[i]);
                        cont++;
                        break;
                    }
                }
                if (check == 1) {
                    setLine("tk_intid_type: " + id, gravarArq, arqOut);
                    System.out.println("tk_intid_type: " + id);
                    id.delete(0, cont);
                }
            }
            if (ver == 0) {
                for (int i = 0; i < id_type.length; i++) {
                    if (cont + 1 < atualLine.length) {
                        if (atualLine[cont + 1].equals(id_type[i])) {
                            check = 0;
                        }
                    } else {
                        check = 1;
                    }
                }

                for (int i = 0; i < id_type.length; i++) {

                    if (atualLine[cont].equals(id_type[i])) {
                        id.append(id_type[i]);
                        cont++;
                        break;
                    }
                }
                if (check == 1) {
                    setLine("tk_id_type: " + id, gravarArq, arqOut);
                    System.out.println("tk_id_type: " + id);
                    id.delete(0, cont);
                }
            }
        }

        if (escreva >= 1) {
            escreva = 2;
            for (int i = 0; i < id_type.length; i++) {
                if (cont + 1 < atualLine.length) {
                    if (atualLine[cont + 1].equals(id_type[i]) || atualLine[cont + 1].equals(" ")) {
                        check = 0;
                    }
                } else {
                    check = 1;
                }
            }

            for (int i = 0; i < id_type.length; i++) {
                if (atualLine[cont].equals(id_type[i])) {
                    id.append(id_type[i]);
                    cont++;
                    break;
                }
                if (atualLine[cont].equals(" ")) {
                    id.append(" ");
                    cont++;
                    break;
                }
            }
            if (check == 1) {
                setLine("tk_idString_type: " + id, gravarArq, arqOut);
                System.out.println("tk_idString_type: " + id);
                id.delete(0, cont);
                escreva = 0;
            }
        }
        aux[0] = cont;
        aux[1] = escreva;
        return aux;
    }

    static void Check(String pathOut, BufferedReader lerArq, PrintWriter gravarArq, FileWriter arqOut, StringBuilder pathCode) throws IOException {
        String atualLine[] = null;
        String id_type[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String intid_type[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        int aux[] = {};
        int ver = 0;
        int cont = 0;
        int linha = 0;
        int escreva = 0;
        while (lerArq.ready()) {
            linha++;
            StringBuilder str = new StringBuilder();
            StringBuilder id = new StringBuilder();
            atualLine = getLine(lerArq);
            for (int i = 0; i < atualLine.length; i++) {
                str.append(atualLine[i]);
            }
            cont = 0;
            if (!str.toString().isEmpty() || !atualLine[cont].isEmpty()) {
                setLine("Linha " + linha + ":", gravarArq, arqOut);
                System.out.println("");
                System.out.println("l" + linha + ":");
                while (cont < atualLine.length) {
                    ver = 0;
                    //"< else_if >"
                    if ((atualLine.length - cont) >= 10 && (escreva != 2)) {
                        if (atualLine[cont].equals("w") && atualLine[cont + 1].equals("e") && atualLine[cont + 2].equals("n") && atualLine[cont + 3].equals("n") && atualLine[cont + 4].equals(" ") && atualLine[cont + 5].equals("n") && atualLine[cont + 6].equals("i") && atualLine[cont + 7].equals("c") && atualLine[cont + 8].equals("h") && atualLine[cont + 9].equals("t")) {
                            setLine("tk_else_if", gravarArq, arqOut);
                            System.out.println("tk_else_if");
                            cont = cont + 9;
                            ver = 1;
                        } else {
                            ver = 0;
                        }
                    }
                    //"< print >"
                    if ((atualLine.length - cont) >= 9 && (escreva != 2)) {
                        if (atualLine[cont].equals("s") && atualLine[cont + 1].equals("c") && atualLine[cont + 2].equals("h") && atualLine[cont + 3].equals("r") && atualLine[cont + 4].equals("e") && atualLine[cont + 5].equals("i") && atualLine[cont + 6].equals("b") && atualLine[cont + 7].equals("e") && atualLine[cont + 8].equals("n")) {
                            setLine("tk_escreva", gravarArq, arqOut);
                            System.out.println("tk_escreva");
                            cont = cont + 9;
                            ver = 1;
                            escreva = 1;
                        } else {
                            ver = 0;
                        }
                    }
                    //"< begin >"
                    if (((atualLine.length - cont) >= 8 && (escreva != 2))) {
                        if (atualLine[cont].equals("b") && atualLine[cont + 1].equals("e") && atualLine[cont + 2].equals("g") && atualLine[cont + 3].equals("i") && atualLine[cont + 4].equals("n") && atualLine[cont + 5].equals("n") && atualLine[cont + 6].equals("e") && atualLine[cont + 7].equals("n")) {
                            setLine("tk_begin", gravarArq, arqOut);
                            System.out.println("tk_begin");
                            cont = cont + 8;
                            ver = 1;
                        } else {
                            ver = 0;
                        }
                    }
                    //"< scan >"
                    if (((atualLine.length - cont) >= 7 && (escreva != 2))) {
                        if (atualLine[cont].equals("s") && atualLine[cont + 1].equals("c") && atualLine[cont + 2].equals("a") && atualLine[cont + 3].equals("n") && atualLine[cont + 4].equals("n") && atualLine[cont + 5].equals("e") && atualLine[cont + 6].equals("n")) {
                            setLine("tk_leia", gravarArq, arqOut);
                            System.out.println("tk_leia");
                            cont = cont + 7;
                            ver = 1;
                        } else {
                            ver = 0;
                        }
                    }

                    //"< else >, < while >"
                    if (((atualLine.length - cont) >= 5 && (escreva != 2))) {
                        if (atualLine[cont].equals("s") && atualLine[cont + 1].equals("o") && atualLine[cont + 2].equals("n") && atualLine[cont + 3].equals("s") && atualLine[cont + 4].equals("t")) {
                            setLine("tk_else", gravarArq, arqOut);
                            System.out.println("tk_else");
                            cont = cont + 5;
                            ver = 1;
                        } else if (atualLine[cont].equals("d") && atualLine[cont + 1].equals("u") && atualLine[cont + 2].equals("r") && atualLine[cont + 3].equals("c") && atualLine[cont + 4].equals("h")) {
                            setLine("tk_while", gravarArq, arqOut);
                            System.out.println("tk_while");
                            cont = cont + 5;
                            ver = 1;
                        } else {
                            ver = 0;
                        }
                    }

                    //"< end >, < if >, < || >"
                    if (((atualLine.length - cont) >= 4 && (escreva != 2))) {
                        if (atualLine[cont].equals("e") && atualLine[cont + 1].equals("n") && atualLine[cont + 2].equals("d") && atualLine[cont + 3].equals("e")) {
                            setLine("tk_end", gravarArq, arqOut);
                            System.out.println("tk_end");
                            cont = cont + 4;
                            ver = 1;
                        } else if (atualLine[cont].equals("w") && atualLine[cont + 1].equals("e") && atualLine[cont + 2].equals("n") && atualLine[cont + 3].equals("n")) {
                            setLine("tk_if", gravarArq, arqOut);
                            System.out.println("tk_if");
                            cont = cont + 4;
                            ver = 1;
                        } else if (atualLine[cont].equals("o") && atualLine[cont + 1].equals("d") && atualLine[cont + 2].equals("e") && atualLine[cont + 3].equals("r")) {
                            setLine("tk_or", gravarArq, arqOut);
                            System.out.println("tk_or");
                            cont = cont + 4;
                            ver = 1;
                        } else {
                            ver = 0;
                        }
                    }

                    //"< var >, < for >, < do >, < && >"
                    if (((atualLine.length - cont) >= 3 && (escreva != 2))) {
                        if (atualLine[cont].equals("v") && atualLine[cont + 1].equals("a") && atualLine[cont + 2].equals("r")) {
                            setLine("tk_var", gravarArq, arqOut);
                            System.out.println("tk_var");
                            cont = cont + 3;
                            ver = 1;
                        } else if (atualLine[cont].equals("z") && atualLine[cont + 1].equals("u") && atualLine[cont + 2].equals("m")) {
                            setLine("tk_for", gravarArq, arqOut);
                            System.out.println("tk_for");
                            cont = cont + 3;
                            ver = 1;
                        } else if (atualLine[cont].equals("v") && atualLine[cont + 1].equals("o") && atualLine[cont + 2].equals("n")) {
                            setLine("tk_do", gravarArq, arqOut);
                            System.out.println("tk_do");
                            cont = cont + 3;
                            ver = 1;
                        } else if (atualLine[cont].equals("u") && atualLine[cont + 1].equals("n") && atualLine[cont + 2].equals("d")) {
                            setLine("tk_and", gravarArq, arqOut);
                            System.out.println("tk_and");
                            cont = cont + 3;
                            ver = 1;
                        } else {
                            ver = 0;
                        }
                    }
                    //"< ++ >, < -- >, < = >, < \<= >, < \>= >, < \<\> >, < -\> >, < \<- >"
                    if (((atualLine.length - cont) >= 2 && (escreva != 2))) {
                        if (atualLine[cont].equals("+") && atualLine[cont + 1].equals("+")) {
                            setLine("tk_inc", gravarArq, arqOut);
                            System.out.println("tk_inc");
                            cont = cont + 2;
                            ver = 1;
                        } else if (atualLine[cont].equals("-") && atualLine[cont + 1].equals("-")) {
                            setLine("tk_dec", gravarArq, arqOut);
                            System.out.println("tk_dec");
                            cont = cont + 2;
                            ver = 1;
                        } else if (atualLine[cont].equals("<") && atualLine[cont + 1].equals("-")) {
                            setLine("tk_recebe", gravarArq, arqOut);
                            System.out.println("tk_recebe");
                            cont = cont + 2;
                            ver = 1;
                        } else if (atualLine[cont].equals("<") && atualLine[cont + 1].equals("=")) {
                            setLine("tk_menor_igual", gravarArq, arqOut);
                            System.out.println("tk_menor_igual");
                            cont = cont + 2;
                            ver = 1;
                        } else if (atualLine[cont].equals(">") && atualLine[cont + 1].equals("=")) {
                            setLine("tk_maior_igual", gravarArq, arqOut);
                            System.out.println("tk_maior_igual");
                            cont = cont + 2;
                            ver = 1;
                        } else if (atualLine[cont].equals("<") && atualLine[cont + 1].equals(">")) {
                            setLine("tk_inc", gravarArq, arqOut);
                            System.out.println("tk_inc");
                            cont = cont + 2;
                            ver = 1;
                        } else if (atualLine[cont].equals("-") && atualLine[cont + 1].equals(">")) {
                            setLine("tk_leva", gravarArq, arqOut);
                            System.out.println("tk_leva");
                            cont = cont + 2;
                            ver = 1;
                        } else {
                            ver = 0;
                        }
                    }

                    //"< : >, < , >, < ; >, < + >, < - >, < * >, < / >, < | >, < " >, < ( >, < ) >, < { >, < } >, < vazio >"
                    if (((atualLine.length - cont) >= 1) && (escreva != 2)) {
                        if (atualLine[cont].equals(" ")) {
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("\t")) {
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals(":")) {
                            setLine("tk_dp", gravarArq, arqOut);
                            System.out.println("tk_dp");
                            cont = cont + 1;
                            ver = 0;
                        } else if (atualLine[cont].isEmpty()) {
                            cont = cont + 1;
                            ver = 0;
                        } else if (atualLine[cont].equals(",")) {
                            setLine("tk_virgula", gravarArq, arqOut);
                            System.out.println("tk_virgula");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals(";")) {
                            setLine("tk_pv", gravarArq, arqOut);
                            System.out.println("tk_pv");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("+")) {
                            setLine("tk_soma", gravarArq, arqOut);
                            System.out.println("tk_soma");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("-")) {
                            setLine("tk_diferenca", gravarArq, arqOut);
                            System.out.println("tk_diferenca");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("*")) {
                            setLine("tk_produto", gravarArq, arqOut);
                            System.out.println("tk_produto");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("/")) {
                            setLine("tk_razao", gravarArq, arqOut);
                            System.out.println("tk_razao");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("<")) {
                            setLine("tk_menor", gravarArq, arqOut);
                            System.out.println("tk_menor");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals(">")) {
                            setLine("tk_maior", gravarArq, arqOut);
                            System.out.println("tk_maior");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("=")) {
                            setLine("tk_igual", gravarArq, arqOut);
                            System.out.println("tk_igual");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("(")) {
                            setLine("tk_abreparenteses", gravarArq, arqOut);
                            System.out.println("tk_abreparenteses");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals(")")) {
                            setLine("tk_fechaparenteses", gravarArq, arqOut);
                            System.out.println("tk_fechaparenteses");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("{")) {
                            setLine("tk_abrechaves", gravarArq, arqOut);
                            System.out.println("tk_abrechaves");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("}")) {
                            setLine("tk_fechachaves", gravarArq, arqOut);
                            System.out.println("tk_fechachaves");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("\"")) {
                            setLine("tk_aspas", gravarArq, arqOut);
                            System.out.println("tk_aspas");
                            cont = cont + 1;
                            ver = 1;
                        } else if (atualLine[cont].equals("|")) {
                            setLine("tk_traco", gravarArq, arqOut);
                            System.out.println("tk_traco");
                            cont = cont + 1;
                            ver = 1;
                        } else {
                            ver = 0;
                        }
                    }
                    //"<String ou inteiro>"
                    if (ver == 0) {
                        aux = CheckID(escreva, 0, id, cont, atualLine, intid_type, id_type, gravarArq, arqOut);
                        cont = aux[0];
                        escreva = aux[1];
                    }
                }
                setLine("", gravarArq, arqOut);
            }
        }

        closeLine(arqOut);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        do {
            StringBuilder pathCode = new StringBuilder();

            String code = null;
            String ArrayCode[] = {};
            int ver = 0;
            int ver2 = 0;
            int correct[] = {0, 0, 0};
            System.out.println("");
            System.out.println("SOPHIA 1.15_beta");
            System.out.println("");

            code = ler.nextLine();
            ArrayCode = code.split("");

            while (ver < ArrayCode.length) {
                if ((ArrayCode.length - ver) >= 6) {
                    if (ArrayCode[ver].equals("s") && ArrayCode[ver + 1].equals("o") && ArrayCode[ver + 2].equals("p") && ArrayCode[ver + 3].equals("h") && ArrayCode[ver + 4].equals("i") && ArrayCode[ver + 5].equals("a")) {
                        ver = ver + 6;
                        correct[0] = 1;
                        correct[2] = 1;
                    }
                }
                if ((ArrayCode.length - ver) >= 1) {
                    if (ArrayCode[ver].equals(" ")) {
                        ver = ver + 1;
                    } else if (ArrayCode[ver].equals("\"")) {
                        ver = ver + 1;
                        while (ArrayCode.length > ver) {
                            pathCode.append(ArrayCode[ver]);
                            ver++;
                            if (ArrayCode[ver].equals("\"")) {
                                correct[1] = 1;
                                correct[2] = 1;
                                break;
                            }
                        }
                    }
                }
                if (correct[2] == 0) {
                    ver++;
                }
                correct[2] = 0;
            }
            FileReader arqIn;
            try {
                arqIn = new FileReader(pathCode.toString());
                FileWriter arqOut = new FileWriter(pathOut);
                BufferedReader lerArq = new BufferedReader(arqIn);
                PrintWriter gravarArq = new PrintWriter(arqOut);
                if (correct[0] == 1 && correct[1] == 1) {
                    Check(pathOut, lerArq, gravarArq, arqOut, pathCode);
                }
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            } finally {
                continue;
            }
        } while (true);
    }
}
