/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author Eduardo
 */

//calse para mensaje con descunetos a credito patron de diseño de comportamiento
public class DescuentoCredito implements DescuentoStrategy {

    @Override
    public String obtenerMensaje() {
        return "Compra realizada a crédito";
    }
}
