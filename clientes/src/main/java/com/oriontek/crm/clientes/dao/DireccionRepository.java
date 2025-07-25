package com.oriontek.crm.clientes.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oriontek.crm.clientes.dto.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Serializable> {

}
