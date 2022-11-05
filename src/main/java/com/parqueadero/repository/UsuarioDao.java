package com.parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parqueadero.model.Usuario;


@Repository
public interface UsuarioDao extends JpaRepository<Usuario, String>{
	
	Usuario findByCedula (String cedula);

}
