package pe.com.arland.cliente1.registro.entity.factory;
import pe.com.arland.cliente1.registro.entity.VehiculoAutomovilBase;
import pe.com.arland.cliente1.registro.entity.VehiculoScooterBase;

public interface IFabricaVehiculo 
{ 
  VehiculoAutomovilBase creaAutomovil(String modelo, String color, 
    int potencia, double espacio); 
 
  VehiculoScooterBase creaScooter(String modelo, String color, int 
    potencia); 
} 
 
 
