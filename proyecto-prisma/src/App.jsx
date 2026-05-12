import React, { useEffect } from 'react';
import './App.css';

function App() {

  // Lógica para el control de audios (pausar otros al dar play)
  useEffect(() => {
    const todosLosAudios = document.querySelectorAll('audio');
    todosLosAudios.forEach(a => {
      a.addEventListener('play', () => {
        todosLosAudios.forEach(otro => { if (otro !== a) otro.pause(); });
      });
    });
  }, []);

  // Variable inteligente para la función enviarWhatsApp
const [enviado, setEnviado] = React.useState(false);

  // ... Enviar mensaje a whatsApp y MySQL ...

  const enviarWhatsApp = async (e) => {
    e.preventDefault();

    // 1. Capturamos los valores
    const nombre = e.target.oyente.value;
    const franja = e.target.nombre_franja.value;
    const cancion = e.target.cancion.value;
    const mensaje = e.target.contenido.value;
    const telefono = "573233647337";

    // 2. Paquete de datos para Java
    const datosPedido = {
      oyente: nombre,      // Java espera 'oyente'
      mensaje: mensaje,    // Java espera 'mensaje'
      cancion_pedida: cancion,    // Java espera 'cancion'
      programa: franja   // Java espera 'programa'
   };

   try {
      // 3. Enviamos a Java
      const respuesta = await fetch('http://localhost:8090/radio/radio/api', { 
  method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(datosPedido)
      });

      if (respuesta.ok) {
        setEnviado(true);
        e.target.reset();
        setTimeout(() => setEnviado(false), 5000);
      }
    } catch (error) {
      console.error("❌ Error:", error);
    }

   // ... Envío a WhatsApp ---
    const texto = `*NUEVO PEDIDO - PRISMA STEREO*%0A%0A*Nombre:* ${nombre}%0A*Canción:* ${cancion}%0A*Mensaje:* ${mensaje}`;
    window.open(`https://wa.me/${telefono}?text=${texto}`, '_blank');
  }; // Aquí termina enviarWhatsApp correctamente

  // AQUÍ YA NO DEBE HABER NADA MÁS ANTES DEL RETURN
       
return (
  <div className="App">
    <header id="inicio">
      <div className="container menu">
        <a href="#inicio" className="logo-link">
          <img src="/Imagenes/Logo Borde blanco.png" alt="Prisma Stereo" className="logo-img" />
        </a>
        <nav className="navbar">
          <ul>
            <li><a href="#inicio">Inicio</a></li>
            <li><a href="#programacion">Programación</a></li>
            <li><a href="#top5">Top 5</a></li>
            <li><a href="#staff">Panelistas</a></li>
            <li><a href="#contacto">Contacto</a></li>
          </ul>
        </nav>
      </div>
    </header>

    <div className="player-bar" id="barra-reproductor">
      <div className="container player-flex">
        <div className="status-container">
          <span className="en-vivo-text">EN VIVO</span>
        </div>
        <audio controls className="audio-player">
          <source src="https://play14.tikast.com:20097/stream?type=http&nocache=68" type="audio/mpeg" />
        </audio>
      </div>
    </div>

    <section className="hero">
      <div className="hero-overlay">
        <div className="container"> {/* El contenedor mantiene todo en su sitio */}
          <div className="hero-content" style={{ textAlign: 'center' }}>
            <h1 style={{ fontSize: '53px', color: '#ee700a', textTransform: 'uppercase' }}>
              ¡Sintoniza Prisma Stereo Online!
            </h1>
            <p style={{ fontSize: '25px', color: '#f0f0f0', marginBottom: '35px' }}>
              Somos la mejor opción para acompañar tu día con música variada y los programas más entretenidos.
            </p>
            <a href="#programacion" className="btn-info">Ver Programación</a>
          </div>
        </div>
      </div>
    </section>

    <section id="programacion" className="programacion-container">
      <div className="container">
        <h2 className="titulo-seccion text-center">Nuestra Programación</h2>
        <div className="grid-programas">
          <div className="card-programa"><span>08:00 - 1:00</span><h3>Mañana Prisma</h3><p>Los éxitos del momento para iniciar el día.</p></div>
          <div className="card-programa"><span>1:00 pm - 2:00 pm</span><h3>Programa el Fogon</h3><p>Política al rojo vivo.</p></div>
          <div className="card-programa"><span>2:00 - 23:00</span><h3>Prisma Hit</h3><p>Relájate con los mejores clásicos.</p></div>
        </div>
      </div>
    </section>

    {/* SECCIÓN PUBLICIDAD IMAGENES TOP 5 */}
    <section className="publicidad-container">
      <div className="container">
        <div className="grid-publicidad">
          <div className="item-publicidad"><img src="/Imagenes/C123.png" alt="Publicidad 1" /></div>
          <div className="item-publicidad"><img src="/Imagenes/CR103.png" alt="Publicidad 2" /></div>
          <div className="item-publicidad"><img src="/Imagenes/MATEO102.png" alt="Publicidad 3" /></div>
          <div className="item-publicidad"><img src="/Imagenes/CAMBIO RADICAL.png" alt="Publicidad 4" /></div>
        </div>
      </div>
    </section>

    {/* TOP 5 COMPLETO CANSIONES */}
    <section id="top5" className="top5-section">
      <div className="container">
        <h2 className="titulo-seccion">Top 5 de Prisma</h2>
        <div className="top5-list">
          {[
            { r: "01", t: "ABCD", a: "Daddy Yankee", img: "Puesto_01.png", mp3: "01 Daddy Yankee ABCD  Feat. Alex Zurdo puesto 01.mp3" },
            { r: "02", t: "La Villa", a: "Ryan Castro", img: "Puesto_02.png", mp3: "02 Ryan Castro, Kapo, Gangsta - LA VILLA puesto 02.mp3" },
            { r: "03", t: "Ahí Voy", a: "Playa Limbo", img: "Puesto_03.png", mp3: "03 Playa Limbo - Ahí Voy puesto 03.mp3" },
            { r: "04", t: "Me Gustas", a: "Mike Bahía", img: "Puesto_04.png", mp3: "04 Mike Bahía, Nanpa Básico -  ME GUSTAS puesto 04.MP3" },
            { r: "05", t: "Hasta que me enamoro", a: "Maria Becerra", img: "Puesto_05.png", mp3: "05 Maria Becerra, TINI - HASTA QUE ME ENAMORO puesto 05.mp3" }
          ].map((item) => (
            <div className="top-item" key={item.r}>
              <span className="rank">{item.r}</span>
              <div className="top-img-container"><img src={`/Imagenes/${item.img}`} className="top-img" alt={item.t} /></div>
              <div className="top-info">
                <h4>{item.t}</h4><p>{item.a}</p>
                <audio controls className="mini-player"><source src={`/Musica/${item.mp3}`} type="audio/mpeg" /></audio>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>

    {/* STAFF */}
    <section id="staff" className="staff-section">
      <div className="container">
        <h2 className="titulo-seccion">Nuestros Panelistas</h2>
        <div className="staff-grid">
          <div className="staff-card">
            <div className="staff-img-container"><img src="/Imagenes/VeniceAI_wSxK38S.jpeg" alt="Alexander" /></div>
            <div className="staff-info">
              <h3>Alexander Plaza</h3><p>Director Creativo</p>
              <audio controls className="mini-player"><source src="/Musica/Prisma stereo.mp3" type="audio/mpeg" /></audio>
            </div>
          </div>
          <div className="staff-card">
            <div className="staff-img-container"><img src="/Imagenes/foto fogon.jpeg" alt="Lorenzo" /></div>
            <div className="staff-info">
              <h3>Programa el Fogón</h3><p>Panelistas y Contenido</p>
              <audio controls className="mini-player"><source src="/Musica/El Fogón.mp3" type="audio/mpeg" /></audio>
            </div>
          </div>
        </div>
      </div>
    </section>

    {/* CONTACTO */}
    <section id="contacto" className="contacto-section container">
      <h2 className="titulo-seccion">Contacto</h2>
      <div className="contacto-wrapper">
        <form onSubmit={enviarWhatsApp} className="contacto-form">
  <input type="text" name="oyente" placeholder="Tu nombre" required />

  <select name="nombre_franja" required>
    <option value="">¿Para qué programa escribes?</option>
    <option value="1">Mañanas Prisma</option>
    <option value="2">El Fogón</option>
    <option value="3">Tardes Prisma</option>
    <option value="4">Noches Románticas</option>
  </select>

  <input type="text" name="cancion" placeholder="Canción que quieres pedir" />
  <textarea name="contenido" placeholder="Tu mensaje..." rows="4" required></textarea>

  <button type="submit" className="btn-info">Enviar Pedido</button>

  {/* Mensaje de confirmación que aparece solo al enviar */}
  {enviado && (
    <p style={{ color: '#4CAF50', fontWeight: 'bold', textAlign: 'center', marginTop: '10px' }}>
      ¡Pedido enviado correctamente! 🎙️
    </p>
  )}
</form>
      </div>
    </section>

    {/* CONTACTO (Última sección de contenido) */}
    <section id="contacto" className="contacto-section">
      {/* ... tu código del formulario ... */}
    </section>

    {/* REDES SOCIALES (Va aquí, antes del footer) */}
    <div className="social-media-bar">
      <a href="https://www.facebook.com/prismastereo" target="_blank" rel="noreferrer">
        <img src="/Imagenes/facebook.png" alt="Facebook" />
      </a>
      <a href="https://www.youtube.com/@prismastereo" target="_blank" rel="noreferrer">
        <img src="/Imagenes/youtube.png" alt="YouTube" />
      </a>
      <a href="https://www.instagram.com/prismastereo" target="_blank" rel="noreferrer">
        <img src="/Imagenes/instagram.png" alt="Instagram" />
      </a>
      <a href="https://wa.me/573233647337?text=Hola%20amigos%20de%20Prisma%20Stereo!" target="_blank" rel="noreferrer">
        <img src="/Imagenes/whatsapp.png" alt="WhatsApp" />
      </a>
    </div>

    {/* FOOTER (El cierre de la página) */}
    <footer>
      <div className="container">
        <p>&copy; 2026 Prisma Stereo Online. Alexander Plaza Padilla.</p>
      </div>
    </footer>
     </div>
  ); // Cierra el return
} // Cierra la función App

export default App;