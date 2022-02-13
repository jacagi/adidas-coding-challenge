package com.jacagi.subscriptionservicemodel.repository;

import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionRepository {

	  private JdbcTemplate plantilla;
	  
	  public SubscriptionRepository(JdbcTemplate plantilla) {
	    this.plantilla = plantilla;
	  }
	  
	  @Transactional
	  public void insertar(Persona persona) {
	  plantilla.update("insert into Personas values (?,?,?)", persona.getNombre(), persona.getApellidos(),
	        persona.getEdad());
	  }
	
}
