Feature: Manejo de pestañas en DemoQA

  Scenario: Abrir nueva pestaña y volver a la original
    Given el usuario abre la web de DemoQA Browser Windows
    When hace click en el boton New Tab
    Then cambia a la nueva pestaña y valida que existe el texto "This is a sample page"
    And regresa a la pestaña original

