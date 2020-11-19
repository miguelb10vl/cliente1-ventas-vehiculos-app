package pe.com.arland.cliente1.registro.entity.factory;
import pe.com.arland.cliente1.registro.entity.VehiculoAutomovilBase;
import pe.com.arland.cliente1.registro.entity.AutomovilGasolinaEntity;
import pe.com.arland.cliente1.registro.entity.VehiculoScooterBase;
import pe.com.arland.cliente1.registro.entity.ScooterGasolinaEntity;

public class FabricaVehiculoGasolina implements IFabricaVehiculo 
{ 
  public VehiculoAutomovilBase creaAutomovil(String modelo, String 
    color, int potencia, double espacio) 
  { 
    return new AutomovilGasolinaEntity(modelo, color, 
      potencia, espacio); 
  } 
 
  public VehiculoScooterBase creaScooter(String modelo, String 
    color, int potencia) 
  { 
    return new ScooterGasolinaEntity(modelo, color, potencia); 
  } 
}
