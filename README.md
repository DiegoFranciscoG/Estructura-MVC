# Estructura-MVC

## ✨ ¿Qué hace esta app?

- 💾 **CRUD completo** de estudiantes: guardar, listar, modificar y eliminar.  
- 🛂 **Validación de cédula ecuatoriana**: ¡el último dígito siempre cuadra!  
- 📝 **Nombres reales** y sin duplicados.  
- 🔒 Después de guardar, **todo se bloquea** hasta que pulses **“Nuevo”**.  
- ❗ Al eliminar, **pregunta de confirmación** para no borrar por accidente.

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

## 🤝 Contribuciones

Siéntete libre de mejorar el proyecto

---

<p align="center">
  <img src="https://i.pinimg.com/originals/53/c4/8e/53c48e6081e628bd024b2b9589b393c5.png" alt="❤️" width="100"/>
</p>
```

> **Tip:** GitHub renderiza HTML limitado dentro de Markdown, así que los estilos en línea y las etiquetas `<img>` funcionan de maravilla para color y animación. ¡Disfrútalo!
