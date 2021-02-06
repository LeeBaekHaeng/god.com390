package jmapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString(of = { "id", "sourceField" })

@NoArgsConstructor
@AllArgsConstructor

@Builder
public class Source {
	private String id;
	private String sourceField;
	private String other;

	// getters and setters...
}
