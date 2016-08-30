/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.EquipamentoControle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modelo.Equipamento;

/**
 *
 * @author 4360486
 */
public class EquipamentoVisao {
    
    public static void exibirFormularioCadastroEquipamento() {
        Scanner entrada = new Scanner (System.in);
        System.out.println("==== TELA DE CADASTRO DE EQUIPAMENTO ====");
        String nome, patrimonio;
        Date dataAquisicao, dataTerminoGarantia;
        float valor;
        
        System.out.println("Informe o nome: ");
        nome = entrada.nextLine();
        System.out.println("Informe o numero do patrimonio: ");
        patrimonio = entrada.nextLine();
        System.out.println("Informe a data de aquisisição: ");
        SimpleDateFormat formatadorData = new SimpleDateFormat ("dd/MM/yyyy");
        formatadorData.setLenient(false);
        do{
            try{
                dataAquisicao = formatadorData.parse(entrada.nextLine());
                break;
            }catch(Exception e){
                System.out.println("Data invalida");
            }
        }while(true);
        System.out.println("Informe a data de término da garantia: ");
        do{
            try{
                dataTerminoGarantia = formatadorData.parse(entrada.nextLine());
                if (dataTerminoGarantia.after(dataAquisicao)){
                    break;
                }else{
                    System.out.println("Data de termino da garantia deve ser posteriar a data de aquisicao");
                }
            }catch(Exception e){
                System.out.println("Data invalida");
            }
        }while(true);
        System.out.println("Informe o valor: ");
        do{
            try{
                valor = Float.parseFloat(entrada.nextLine());
                break;
            }catch(Exception e){
                System.out.println("Valor indalido");
            }
        }while (true);
            EquipamentoControle.receberDadosCadastroEquipamento(nome, patrimonio, dataAquisicao, dataTerminoGarantia, valor);
            Menu.exibirMenu();
    }
    
    public static void exibirListagemEquipamentos(){
        System.out.println("==== TELA DE LISTAGEM DE EQUIPAMENTOS ====  ");
        
        System.out.println("Nome \t NUMERO PATRIMONIO \t NUMERO MANUTENÇôES");
        
//        ArrayList<Equipamento> lista= EquipamentoControle.obterListaEquipamentos();
//        for (int i=0; i < lista.size(); i++){
//            System.out.println(lista.get(i).getNome()+" \t"+lista.get(i).getDataAquisicao());
//        }
        
        for(Equipamento obj : EquipamentoControle.obterListaEquipamentos()){
            System.out.println(obj.getNome()+"\t "+obj.getDataAquisicao()+"\t "+obj.getlistaManutencoes().size());
        }
        System.out.println("O que deseja fazer?");
        System.out.println("0) Voltar ao menu");
        System.out.println("Numero patrimonio) Cadastrar manutençao para o equipamento");
        Scanner entrada = new Scanner (System.in);
        String valorDigitado = entrada.nextLine();
        if (entrada.equals("0")){
            Menu.exibirMenu();
        }else{
           Equipamento encontrado = EquipamentoControle.obterEquipamentoPeloNumeroDoPatrimonio(valorDigitado);
           if (encontrado==null){
               System.out.println("ERRO: Nao encontrei");
               Menu.exibirMenu();
           }else{
               
           }
        }
    }

}