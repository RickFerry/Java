package br.com.ferry.apipessoa.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.ferry.apipessoa.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

	@Enumerated(EnumType.STRING)
	private PhoneType type;

	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;
}
