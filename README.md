# Estructura-MVC
Aquí tienes un README más visual y “hecho a mano”, con colores, emojis y un toque animado. Pégalo en tu `README.md` de GitHub y verás cómo cobra vida:

````markdown
<p align="center">
  <img src="https://media.giphy.com/media/3oEduSbSGpGaRX2Vri/giphy.gif" alt="🎉" width="200"/>
</p>

<h1 align="center" style="color:#4A90E2;">
  📚 Registro de Estudiantes
</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-☕-orange"/>
  <img src="https://img.shields.io/badge/MySQL-🐬-blue"/>
  <img src="https://img.shields.io/badge/MVC-✅-green"/>
  <img src="https://img.shields.io/badge/Validación-✔️-brightgreen"/>
</p>

---

## ✨ ¿Qué hace esta app?

- 💾 **CRUD completo** de estudiantes: guardar, listar, modificar y eliminar.  
- 🛂 **Validación de cédula ecuatoriana**: ¡el último dígito siempre cuadra!  
- 📝 **Nombres reales** y sin duplicados.  
- 🔒 Después de guardar, **todo se bloquea** hasta que pulses **“Nuevo”**.  
- ❗ Al eliminar, **pregunta de confirmación** para no borrar por accidente.

---

## 🚀 Cómo arrancar

1. **Clona** el repo  
   ```bash
   git clone https://github.com/tu-usuario/registro-estudiantes.git
   cd registro-estudiantes
````

2. **Abre** en NetBeans (o tu IDE favorito).
3. **Asegúrate** de tener:

   * Java 8+
   * MySQL con la BD `estudiantes_notas` y tabla `estudiantes`
   * MySQL Connector/J en el classpath
4. **Configura** tus credenciales en `conexion/conexion.java`

   ```java
   private static final String USER = "root";
   private static final String PASSWORD = "tu_password";
   ```
5. **Ejecuta** la clase principal

   ```bash
   mvn compile exec:java -Dexec.mainClass="estudiante_notas.Estudiante_Notas"
   ```

---

## 🗂 Estructura de carpetas

```text
├── conexion/
│   └── conexion.java       ← Conexión JDBC silenciosa
├── modelo/
│   └── Estudiante.java     ← POJO solo datos
├── controlador/
│   └── ControladorEstudiantes.java  ← Lógica y BD 
└── vista/
    └── Estudiantes_Registro.java   ← Interfaz Swing
```

---

## 🎨 Toques de color y animación

* **GIFs** en la cabecera para dar vida al proyecto.
* **Badges** coloridos al centro para tecnologías y estado.
* Texto en **HTML** (`<h1 style="color:#4A90E2">`) para títulos en azul.

---

## 🤝 Contribuciones

Siéntete libre de mejorar el proyecto:

1. Abre un **issue** o **pull request**.
2. Añade tus **mejoras** (paginación, filtros, temas oscuros…).
3. ¡Hagámoslo crecer juntos! 🚀

---

<p align="center">
  <img src="https://media.giphy.com/media/l0MYt5jPR6QX5pnqM/giphy.gif" alt="❤️" width="100"/>
</p>
```

> **Tip:** GitHub renderiza HTML limitado dentro de Markdown, así que los estilos en línea y las etiquetas `<img>` funcionan de maravilla para color y animación. ¡Disfrútalo!
