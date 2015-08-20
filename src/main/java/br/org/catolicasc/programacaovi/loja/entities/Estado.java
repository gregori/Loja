/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.programacaovi.loja.entities;

/**
 *
 * @author rodrigo
 */
public enum Estado {
    Acre("AC"), Alagoas("AL"), Amapa("AP"), Amazonas("AM"), Bahia("BA"), 
    Ceara("CE"), DistritoFederal("DF"), EspiritoSanto("ES"), Goias("GO"), 
    Maranhao("MA"), MatoGrosso("MT"), MatoGrossoDoSul("MS"), 
    Minas_Gerais("MG"), Para("PA"), Paraiba("PB"), Parana("PR"), 
    Pernambuco("PB"), RioDeJaneiro("RJ"), RioGrandeDoNorte("RN"),
    RioGrandeDoSul("RS"), Rondonia("RO"), Roraima("RR"), 
    SantaCatarina("SC"), SaoPaulo("SP"), Sergipe("SE"), Tocantins("TO");
    
    private final String estado;
    
    private Estado(String estado) {
        this.estado = estado;
    }
    
    public String getValue() {
        return estado;
    }
}
