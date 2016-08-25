/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
                System.out.println("Data invelida");
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
            }catch(Exception e){
                System.out.println("Valor indalido");
            }
        }while (true);
        
        
    }
            
    
}
