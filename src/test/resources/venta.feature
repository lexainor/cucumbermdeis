
Feature: Registro de Venta

  Scenario: Completar correctamente el producto, observaciones y descuento en la venta
    Given Ingresar al formulario de registro de venta en la aplicación
    When seleccionar el producto "Dell Gaming"
    And completar los campos de detalle del producto
    And completar observaciones con "Venta especial"
    And ingresar descuento global de "100"
    And presionar el botón de registrar venta
    Then El sistema debe mostrar registro exitoso
