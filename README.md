## Paradigmas de Programación
# Laboratorio 3 "Conecta 4" en Java

Implementación del clásico juego **Conecta 4** en lenguaje **Java**, desarrollado como laboratorio en el ramo de Paradigmas de Programación.

---

## 🔧 Instalación y Uso

### Requisitos previos

- **Java Development Kit (JDK)** (versión 11 o superior)
- **Gradle** (versión 7.0 o superior)
- Editor de texto o IDE compatible con Java (IntelliJ IDEA, Eclipse, VS Code + Extension Pack for Java, etc.)

### 📚 Estructura del proyecto

```
Lab3_210821481_Vergara/
├── src/main/java/org/proyecto/
│   ├── Class/
│   │   ├── TDgameClass_210821481_VergaragoCodoy.java
│   │   ├── TDAPlayerClass_210821481_VergaragoCodoy.java
│   │   ├── TDAboardClass_210821481_VergaragoCodoy.java
│   │   └── ...
│   ├── Interface/
│   │   ├── TDgameInterface_210821481_VergaragoCodoy.java
│   │   ├── TDAPlayerInterface_210821481_VergaragoCodoy.java
│   │   ├── TDAboardInterface_210821481_VergaragoCodoy.java
│   │   └── ...
│   └── Main.java
├── gradle/wrapper/
├── build.gradle
├── settings.gradle
├── .gitignore
└── README.md
```

### Configuración inicial

**Clonar o descargar el repositorio:**
```bash
git clone https://github.com/Friedemmm/Conecta4_Java.git
cd Lab3_210821481_Vergara
```

### Inicializar una partida

**Desde la terminal con Gradle:**
```bash
gradle run
```

**O usando el wrapper de Gradle:**
```bash
./gradlew run
```

**Desde tu IDE (IntelliJ IDEA, Eclipse, etc.):**
1. Abre el proyecto
2. Localiza la clase `Main.java`
3. Haz clic derecho → **Run** (o presiona `Shift + F10` en IntelliJ)

---

## ✨ Características principales

- 🎯 **Lógica de juego completa**: Inserción de piezas, validación de movimientos y detección de ganadores.
- 👥 **Soporte para 2 jugadores**: Turnos alternados entre jugadores.
- 🔴🟡 **Sistema de piezas por color**: Diferenciación visual mediante colores (rojo y amarillo).
- 📋 **Tablero dinámico**: Creación flexible de tableros con dimensiones personalizables.
- ✅ **Validación de dominios**: Todas las funciones respetan restricciones de dominio para funcionamiento correcto.
- 🏆 **Detección de victoria**: Identifica ganadores por línea horizontal, vertical o diagonal.

---

*© 2024 · Universidad de Santiago de Chile*
