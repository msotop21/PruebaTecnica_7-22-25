import React, { useState } from 'react';
import axios from 'axios';

export default function ClienteForm() {
  const [cliente, setCliente] = useState({
    nombre: '',
    email: '',
    telefono: '',
    direcciones: [{ calle: '', ciudad: '', pais: '' }]
  });

  const handleChange = (e, index = null, field = null) => {
    const { name, value } = e.target;
    if (index !== null) {
      const direcciones = [...cliente.direcciones];
      direcciones[index][field] = value;
      setCliente({ ...cliente, direcciones });
    } else {
      setCliente({ ...cliente, [name]: value });
    }
  };

  const agregarDireccion = () => {
    setCliente({
      ...cliente,
      direcciones: [...cliente.direcciones, { calle: '', ciudad: '', pais: '' }]
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/clientes', cliente)
      .then(() => alert('Cliente guardado'))
      .catch(() => alert('Error al guardar cliente'));
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Registrar Cliente</h2>
      <input name="nombre" value={cliente.nombre} onChange={handleChange} placeholder="Nombre" />
      <input name="telefono" value={cliente.telefono} onChange={handleChange} placeholder="Telefono" />
      <input name="email" value={cliente.email} onChange={handleChange} placeholder="Email" />
      <h4>Direcciones</h4>
      {cliente.direcciones.map((dir, idx) => (
        <div key={idx}>
          <input value={dir.calle} onChange={e => handleChange(e, idx, 'calle')} placeholder="Calle" />
          <input value={dir.ciudad} onChange={e => handleChange(e, idx, 'ciudad')} placeholder="Ciudad" />
          <input value={dir.pais} onChange={e => handleChange(e, idx, 'pais')} placeholder="País" />
        </div>
      ))}
      <button type="button" onClick={agregarDireccion}>+ Dirección</button>
      <br />
      <button type="submit">Guardar Cliente</button>
    </form>
  );
}
