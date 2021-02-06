package lombok;

@Getter
@Setter

@ToString(of = { "id", "name" })

@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

//@Builder
public class GodLombokV1 {
	private Long id;
	private String name;
	private String exclude;
}
