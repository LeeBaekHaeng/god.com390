package jmapper;

import com.googlecode.jmapper.annotations.JMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString(of = { "id", "destinationField" })

@NoArgsConstructor
@AllArgsConstructor

@Builder

//@JGlobalMap
public class Destination {
	@JMap
	private String id;
	@JMap("sourceField")
	private String destinationField;
	private String other;

	// getters and setters...
}
