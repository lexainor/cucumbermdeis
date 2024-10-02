Feature: Página de inicio de la aplicación
  Esta característica trata con todos los componentes de la página de inicio de su aplicación
  Scenario: Verificar la funcionalidad de "Olvidé la contraseña" en la página de inicio
    Given que navego a la página de inicio de la aplicación
    When el usuario hace clic en el enlace Forgot Password
    Then se debe mostrar un formulario para restablecer la contraseña
