package co.simplon.poo.ch10.tp1.model.common;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data

public abstract class BaseEntity  {	
	
	@Setter(value = AccessLevel.NONE)	
	private String id = UUID.randomUUID().toString();
}
