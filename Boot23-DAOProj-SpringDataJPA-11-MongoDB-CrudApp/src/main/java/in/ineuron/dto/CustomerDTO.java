package in.ineuron.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class CustomerDTO {

	private Integer cno;

	private String cname;

	private Float billAmt;

	private String cadd;

	private Long mobileNo;
}
