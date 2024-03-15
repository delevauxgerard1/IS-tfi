
  Feature: Se prueba endpoint de artículos
    Scenario: Se debería retornar los artículos que coincidan con la descripción
      Given existen artículos en la base de datos con descripción "Remera"
      When se hace una petición al endpoint con la descripción "Remera"
      Then se devuelve en el body de la respuesta los artículos que coiciden con la descripción "Remera"