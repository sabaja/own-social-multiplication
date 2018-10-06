package microservice.book.socialmultiplication.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LombokModel {

	
	private @NonNull String example;
	private @NonNull Integer one;
	
	public LombokModel() {
		
	}
	
	
	public static void main(String[] args) {
		LombokModel lombokModel = new LombokModel();
		lombokModel.setExample("aa");
		lombokModel.setOne(111);
		System.out.println(lombokModel);

	}

}
