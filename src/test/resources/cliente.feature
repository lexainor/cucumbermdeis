Feature: Página de Creación de Cliente
  Esta característica registra un cliente en la aplicación
  Scenario: Registrar un nuevo cliente con datos validos
    Given Ingresar al formulario de registro de cliente en la  aplicación
    When completar todos los campos requeridos
    And Verificar que los datos cumplan con las validaciones de ci, nit y email
    And presionar el botón de registrar cliente
    Then El sistema debe mostrar un mensaje de registro exitoso
