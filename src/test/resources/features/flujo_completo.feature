# language: es
# language: es

Característica: Flujo completo en OrangeHRM

  Escenario: Login exitoso
    Dado que el usuario se encuentra en la pantalla de login
    Cuando inicia sesión con usuario "Admin" y contraseña "admin123"
    Entonces debería visualizar el dashboard

  Escenario: Buscar empleado
    Dado que el usuario se encuentra en la pantalla de login
    Cuando inicia sesión con usuario "Admin" y contraseña "admin123"
    Y navega al módulo PIM
    Y busca el empleado "John"
    Entonces debería visualizar resultados de la búsqueda

  Escenario: Flujo completo E2E
    Dado que el usuario se encuentra en la pantalla de login
    Cuando inicia sesión con usuario "Admin" y contraseña "admin123"
    Y navega al módulo PIM
    Y busca el empleado "John"
    Y cierra sesión
    Entonces debería visualizar la pantalla de login