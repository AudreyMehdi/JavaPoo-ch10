package co.simplon.poo.ch10.tp1.model;

import co.simplon.poo.ch10.tp1.model.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor

public class Product extends BaseEntity{
	
	@NonNull
	private String login;
	@NonNull
	private Integer prix;
}
