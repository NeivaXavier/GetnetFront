Feature: Buscar Boleto na Central de Ajuda

  Scenario: Verificar modal de boleto
    Given que eu acesso o site "https://site.getnet.com.br/"
    When eu clico em "Ajuda" no menu
    And eu clico em "Central de Ajuda"
    And eu busco por "Boleto"
    And eu seleciono a opção "Eu concluí a negociação, de que forma receberei meu boleto?"
    Then eu verifico se a modal foi aberta com a mensagem explicativa
