/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Arthu
 */
public class CaminhaoDTO {
    
    private int idVeic;
    private String modVeic, anoVeic, placaVeic;
    
    //Construtor

    public CaminhaoDTO(int idVeic, String modVeic, String anoVeic, String placaVeic) {
        this.idVeic = idVeic;
        this.modVeic = modVeic;
        this.anoVeic = anoVeic;
        this.placaVeic = placaVeic;
    }
    
    

    public CaminhaoDTO(String modVeic, String anoVeic, String placaVeic) {
        this.modVeic = modVeic;
        this.anoVeic = anoVeic;
        this.placaVeic = placaVeic;
    }
    
    //GET AND SET

    public int getIdVeic() {
        return idVeic;
    }

    public void setIdVeic(int idVeic) {
        this.idVeic = idVeic;
    }
    
    

    public String getModVeic() {
        return modVeic;
    }

    public void setModVeic(String modVeic) {
        this.modVeic = modVeic;
    }

    public String getAnoVeic() {
        return anoVeic;
    }

    public void setAnoVeic(String anoVeic) {
        this.anoVeic = anoVeic;
    }

    public String getPlacaVeic() {
        return placaVeic;
    }

    public void setPlacaVeic(String placaVeic) {
        this.placaVeic = placaVeic;
    }
    
    
    
    
    
    
    
}
